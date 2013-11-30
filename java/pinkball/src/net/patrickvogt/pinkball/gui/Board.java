package net.patrickvogt.pinkball.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import net.patrickvogt.pinkball.excpetion.GameOverException;
import net.patrickvogt.pinkball.geom.Ball;
import net.patrickvogt.pinkball.geom.GeometricObject;
import net.patrickvogt.pinkball.geom.OutputHole;
import net.patrickvogt.pinkball.geom.PaintedLine;
import net.patrickvogt.pinkball.level.LevelFactory;
import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.painter.StandardPainter;
import net.patrickvogt.pinkball.test.DebugPainter;

public class Board extends JPanel
{

    private final GraphicsConfiguration gfxConf = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getDefaultScreenDevice()
            .getDefaultConfiguration();

    private BufferedImage offImg;

    private Graphics g2;

    private static final long serialVersionUID = 1L;

    private final int WIDTH;

    private final int HEIGHT;

    private final int gridWidth = 20;

    /**
     * beschreibt die aktuelle Punktzahl des Spielers
     */
    private int myScore = 0;

    /**
     * beschreibt, in welchem Level sich der SPieler gerade befindet
     */
    private int currentLevel = 1;

    private final boolean isBackgroundOn = true;

    private int releaseWait = 0;

    private GeometricObject myBeginning;

    private java.util.List<GeometricObject> myObjects;

    private List<Ball> _balls;
    private List<Ball> _releasedBalls = new LinkedList<Ball>();
    private OutputHole _outputHole;

    public static java.util.List<GeometricObject> destroyThat = new LinkedList<GeometricObject>();

    private PaintedLine myCurrentLine;

    IPainter _p = null;

    MyMouseMotionListener ml = null;

    public void init()
    {
        // nulle den Score
        this.myScore = 0;

        this._releasedBalls.clear();
    }

    public Board()
    {
        super();

        // this-Felder setzen
        this.WIDTH = 800;
        this.HEIGHT = 600;
        offImg = gfxConf.createCompatibleImage(this.WIDTH, this.HEIGHT);
        g2 = offImg.createGraphics();
        _p = StandardPainter.getInstance();
        // _p = StandardPainter.getInstance();
        _p.setGraphicsContext(g2);
        // this.myLastPaintedLine=new PaintedLine(this.WIDTH, this.HEIGHT);

        LevelFactory.Level level = LevelFactory
                .parseLevel("/levels/level1.xml");

        this.myObjects = level.getLevelContent();
        this._balls = level.getBalls();
        this._outputHole = level.getOutputHole();
        this.init();

        ml = new MyMouseMotionListener();

        // MouseListener und MouseMotionListener dem Board hinzufuegen
        this.addMouseMotionListener(ml);
        this.addMouseListener(ml);
    }

    /**
     * gibt die bevorzugte Dimension des Boards zurueck
     */
    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(this.WIDTH, this.HEIGHT));
    }

    public void gameLoop() throws GameOverException
    {
        GeometricObject toDelete = null;

        for(int i = 0; i < this._releasedBalls.size(); i = i + 1)
        {
            Ball that = this._releasedBalls.get(i);

            that.checkCollisionOnBorder(WIDTH, HEIGHT);
        }

        for(int i = 0; i < this.myObjects.size(); i = i + 1)
        {
            GeometricObject that = this.myObjects.get(i);

            for(int j = 0; j < this._releasedBalls.size(); j = j + 1)
            {
                GeometricObject go = this._releasedBalls.get(j);

                if(that.touches(go))
                {
                    toDelete = that.handleCollision(go);
                    if(null != toDelete)
                    {
                        destroyThat.add(toDelete);
                    }
                }
            }
        }

        for(int i = 0; i < this._releasedBalls.size(); i = i + 1)
        {
            GeometricObject that = this._releasedBalls.get(i);

            for(int j = i + 1; j < this._releasedBalls.size(); j = j + 1)
            {
                GeometricObject go = this._releasedBalls.get(j);

                if(that.touches(go))
                {
                    that.handleCollision(go);
                }
            }
        }

        if(this.destroyThat.contains(this.myCurrentLine))
        {
            this.ml.resetIsDragged();
        }

        for(GeometricObject g : this.destroyThat)
        {
            if(this._releasedBalls.contains(g))
            {
                if(Color.gray != g.getColor())
                {
                    // increase points
                }
                this._releasedBalls.remove(g);
            }
            else if(this.myObjects.contains(g))
            {
                this.myObjects.remove(g);
            }
        }
        this.destroyThat.clear();

        this.moveObjects();
        this.repaint();

        this.releaseNextMoveableObject();

        if(0 == this._releasedBalls.size() && null == this._balls)
        {
            this.setLevel(this.currentLevel + 1);
        }
    }

    public void setLevel(final int __newLevel)
    {
        final StringBuffer xmlPath = new StringBuffer("/levels/level");

        this.currentLevel = __newLevel;

        xmlPath.append(this.currentLevel);
        xmlPath.append(".xml");

        LevelFactory.Level level = LevelFactory.parseLevel(xmlPath.toString());
        this.myObjects = level.getLevelContent();
        this._balls = level.getBalls();
        this._outputHole = level.getOutputHole();
        this.init();
    }

    /**
     * laesst in bestimmten Abstaenden die noch nicht freigesetzten Kugeln auf
     * dem Spielfeld frei
     */
    public void releaseNextMoveableObject()
    {
        // System.out.println(_releasedBalls.size());

        if(this._balls != null)
        {
            // muessen noch Kugeln auf dem Spielfeld freigelassen werden?
            if(this._balls.isEmpty())
            {
                this._balls = null;
            }
            else
            {
                // ist das OutputHole derzeit von einer anderen Kugel blockiert?
                // AND ist zwischen der letzten Kugel-'Freilassung' schon genug
                // Zeit vergangen
                if(!(_outputHole.isBlocked(this._releasedBalls))
                        && releaseWait % 70 == 0)
                {
                    // WENN ja DANN speichere dir die naechste Kugel aus der
                    // 'myMoveableObjectsToRelease'-
                    // Liste zwischen
                    Ball releaseThis = this._balls.get(0);
                    // loesche sie direkt aus dieser Liste
                    this._balls.remove(0);
                    // setze die Koordinaten der Kugel auf die Koordinaten der
                    // OutputHole
                    releaseThis.moveTo(this._outputHole.getXAsInt(),
                            this._outputHole.getYAsInt());
                    // fuege die Kugel dem SPielfeld hinzu
                    this._releasedBalls.add(releaseThis);
                }
            }
            // releaseZeit hochzaehlen
            this.releaseWait++;
        }
    }

    public void moveObjects()
    {
        for(GeometricObject that : this._releasedBalls)
        {
            ((Ball) that).move();
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0, 0, this.WIDTH, this.HEIGHT);
        if(this.isBackgroundOn)
        {
            g2.setColor(Color.GRAY);
            for(int i = this.gridWidth; i < this.HEIGHT; i = i + this.gridWidth)
            {
                g2.drawLine(0, i, this.WIDTH, i);
            }
            for(int j = this.gridWidth; j < this.WIDTH; j = j + this.gridWidth)
            {
                g2.drawLine(j, 0, j, this.HEIGHT);
            }
        }

        for(GeometricObject that : this.myObjects)
        {
            that.paint(_p);
        }

        this._outputHole.paint(_p);
        for(GeometricObject that : this._releasedBalls)
        {
            that.paint(_p);
        }

        g.drawImage(offImg, 0, 0, this);
    }

    private class MyMouseMotionListener extends MouseInputAdapter
    {

        private boolean is_dragged = false;

        @Override
        public void mouseDragged(MouseEvent evt)
        {
            if(!is_dragged)
            {
                myCurrentLine = new PaintedLine();
                Board.this.myObjects.add(myCurrentLine);
                is_dragged = true;
            }
            else
            {
                myCurrentLine.addPoint(evt.getX(), evt.getY());
            }
        }

        public void resetIsDragged()
        {
            this.is_dragged = false;
        }

        @Override
        public void mouseReleased(MouseEvent evt)
        {
            this.resetIsDragged();
        }
    }

    public void setPainter(IPainter instance)
    {
        _p = instance;
        _p.setGraphicsContext(g2);
    }
}
