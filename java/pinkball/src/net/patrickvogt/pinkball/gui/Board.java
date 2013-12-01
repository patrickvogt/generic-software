package net.patrickvogt.pinkball.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Calendar;
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
import net.patrickvogt.pinkball.util.Constants;

public class Board extends JPanel
{
    private static final long serialVersionUID = 1L;

    private final GraphicsConfiguration _gfxConf = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getDefaultScreenDevice()
            .getDefaultConfiguration();

    private BufferedImage _buffImg = null;

    private Graphics _gImg = null;

    private int _width = 0;
    private int _height = 0;

    private int _score = 0;

    private int _currentLevel = 1;

    private int _waitForRelease = 0;

    private java.util.List<GeometricObject> _objects = null;

    private List<Ball> _balls = null;
    private List<Ball> _releasedBalls = new LinkedList<Ball>();
    private OutputHole _outputHole = null;

    private PaintedLine _currentLine = null;

    private MouseClickAndMotionListener _mouseListener = null;

    IPainter _painter = null;

    HeadUpDisplay _hud = null;

    private long _startTime;

    public Board()
    {
        super();

        this._painter = StandardPainter.getInstance();
        this._mouseListener = new MouseClickAndMotionListener();

        this.setLevel(1);

        // MouseListener und MouseMotionListener dem Board hinzufuegen
        this.addMouseMotionListener(this._mouseListener);
        this.addMouseListener(this._mouseListener);
    }

    public void setHud(HeadUpDisplay __hud)
    {
        this._hud = __hud;
    }

    public void updateTimeDisplay()
    {
        long now = Calendar.getInstance().getTimeInMillis();
        long secondsPassed = (now - this._startTime) / 1000;
        long minutesPassed = 0;
        if(secondsPassed >= 60)
        {
            minutesPassed = secondsPassed / 60;
            secondsPassed = secondsPassed - minutesPassed*60;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%02d", minutesPassed));
        sb.append(":");
        sb.append(String.format("%02d", secondsPassed));
        this._hud.setTime(sb.toString());
    }

    public void init()
    {
        // nulle den Score
        this._score = 0;

        this._buffImg = this._gfxConf.createCompatibleImage(this._width,
                this._height);
        this._gImg = this._buffImg.createGraphics();
        this._painter.setGraphicsContext(this._gImg);
        this._painter.applyAntiAliasing();

        this._releasedBalls.clear();
    }

    /**
     * gibt die bevorzugte Dimension des Boards zurueck
     */
    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(this._width, this._height));
    }

    @Override
    public int getWidth()
    {
        return _width;
    }

    @Override
    public int getHeight()
    {
        return _height;
    }

    private void checkBallBorderCollision()
    {
        for(int i = 0; i < this._releasedBalls.size(); i = i + 1)
        {
            Ball that = this._releasedBalls.get(i);

            that.checkCollisionOnBorder(this._width, this._height);
        }
    }

    private void checkBallObjectCollision(List<GeometricObject> __allToDelete)
            throws GameOverException
    {
        GeometricObject toDelete = null;

        for(int i = 0; i < this._objects.size(); i = i + 1)
        {
            GeometricObject that = this._objects.get(i);

            for(int j = 0; j < this._releasedBalls.size(); j = j + 1)
            {
                GeometricObject go = this._releasedBalls.get(j);

                if(that.touches(go))
                {
                    toDelete = that.handleCollision(go);
                    if(null != toDelete)
                    {
                        __allToDelete.add(toDelete);
                    }
                }
            }
        }
    }

    private void checkBallBallCollision() throws GameOverException
    {
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
    }

    private void updateGameContent(List<GeometricObject> __allToDelete)
    {
        for(GeometricObject g : __allToDelete)
        {
            if(this._releasedBalls.contains(g))
            {
                if(Color.gray != g.getColor())
                {
                    this._score = this._score + Constants.SCORE_UNIT;
                    this._hud.setScore(this._score);
                }
                this._releasedBalls.remove(g);
            }
            else if(this._objects.contains(g))
            {
                this._objects.remove(g);
            }
        }
    }

    public void gameLoop() throws GameOverException
    {
        List<GeometricObject> allToDelete = new LinkedList<GeometricObject>();

        this.checkBallBorderCollision();

        this.checkBallObjectCollision(allToDelete);

        this.checkBallBallCollision();

        if(allToDelete.contains(this._currentLine))
        {
            this._mouseListener.resetIsDragged();
        }

        this.updateGameContent(allToDelete);

        allToDelete = null;

        this.moveObjects();
        this.repaint();

        this.releaseNextMoveableObject();

        if(0 == this._releasedBalls.size() && null == this._balls)
        {
            this.setLevel(this._currentLevel + 1);
        }
        this.updateTimeDisplay();
    }

    public void setLevel(final int __newLevel)
    {
        final StringBuffer xmlPath = new StringBuffer("/levels/level");

        this._currentLevel = __newLevel;

        xmlPath.append(this._currentLevel);
        xmlPath.append(".xml");

        LevelFactory.Level level = LevelFactory.parseLevel(xmlPath.toString());

        if(null != level)
        {
            this._objects = level.getLevelContent();
            this._balls = level.getBalls();
            this._outputHole = level.getOutputHole();
            this._width = level.getWidth();
            this._height = level.getHeight();
            this.init();
        }
        this._startTime = Calendar.getInstance().getTimeInMillis();
        if(null!=_hud)
            {_hud.setScore(0);}
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
                        && this._waitForRelease % 70 == 0)
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
                    this._waitForRelease = 1;
                }
            }
            // releaseZeit hochzaehlen
            this._waitForRelease = this._waitForRelease + 1;
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

        _gImg.setColor(Color.lightGray);
        _gImg.fillRect(0, 0, this._width, this._height);

        _gImg.setColor(Color.GRAY);
        for(int i = Constants.GRID_DIMENSION; i < this._height; i = i
                + Constants.GRID_DIMENSION)
        {
            _gImg.drawLine(0, i, this._width, i);
        }
        for(int j = Constants.GRID_DIMENSION; j < this._width; j = j
                + Constants.GRID_DIMENSION)
        {
            _gImg.drawLine(j, 0, j, this._height);
        }

        for(GeometricObject that : this._objects)
        {
            that.paint(_painter);
        }

        this._outputHole.paint(_painter);
        for(GeometricObject that : this._releasedBalls)
        {
            that.paint(_painter);
        }

        g.drawImage(_buffImg, 0, 0, this);

        this._hud.repaint();
    }

    public final void setPainter(IPainter instance)
    {
        _painter = instance;
        _painter.setGraphicsContext(_gImg);
        _painter.applyAntiAliasing();
    }

    public final void toggleAntiAliasing()
    {
        _painter.toggleAntiAliasing();
        _painter.applyAntiAliasing();
    }

    private final class MouseClickAndMotionListener extends MouseInputAdapter
    {
        private boolean is_dragged = false;

        @Override
        public void mouseDragged(MouseEvent evt)
        {
            if(!is_dragged)
            {
                _currentLine = new PaintedLine();
                Board.this._objects.add(_currentLine);
                is_dragged = true;
            }
            else
            {
                _currentLine.addPoint(evt.getX(), evt.getY());
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
}
