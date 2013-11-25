package net.patrickvogt.pinkball.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import net.patrickvogt.pinkball.geom.Ball;
import net.patrickvogt.pinkball.geom.GeometricObject;
import net.patrickvogt.pinkball.geom.OutputHole;
import net.patrickvogt.pinkball.geom.PaintedLine;
import net.patrickvogt.pinkball.level.DebugLevel;
import net.patrickvogt.pinkball.level.Demo;
import net.patrickvogt.pinkball.level.Level1;
import net.patrickvogt.pinkball.level.Level2;
import net.patrickvogt.pinkball.level.Level3;
import net.patrickvogt.pinkball.painter.DebugPainter;
import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.painter.StandardPainter;
import net.patrickvogt.pinkball.vector.Coordinate;

public class Board extends JPanel
{

    private final GraphicsConfiguration gfxConf = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getDefaultScreenDevice()
            .getDefaultConfiguration();

    private BufferedImage offImg;
    
    private boolean isGameOver = false;

    private Graphics g2;

    private static final long serialVersionUID = 1L;

    private final int WIDTH;

    private final int HEIGHT;

    private final int gridWidth = 20;
    
    /**
     * beschreibt die aktuelle Punktzahl des Spielers
     */
    private int myScore=0;
    
    /**
     * beschreibt, in welchem Level sich der SPieler gerade befindet
     */
    private int currentLevel=1;

    private final boolean isBackgroundOn = true;

    private int releaseWait = 0;

    private GeometricObject myBeginning;

    private java.util.List<GeometricObject> myObjects;

    private java.util.List<PaintedLine> myLastNPaintedLines = new ArrayList<PaintedLine>();

   public static java.util.List<GeometricObject> destroyThat = new LinkedList<GeometricObject>();

    private PaintedLine myCurrentLine;

    IPainter _p = null;
    
    MyMouseMotionListener ml = null;

    private java.util.List<GeometricObject> myMoveableObjectsToRelease = new LinkedList<GeometricObject>();
    
    public void init()
    {
      //nulle den Score
        this.myScore=0;
        
     // Liste aufteilen in Kugel-Objekte und NichtKugel-Objekte
        for(GeometricObject that : this.myObjects)
        {
            // die KugelObjekte sollen spaeter erst nach und nach ueber das
            // sogenannte
            // OutputHole freigelassen werden

            // ist that eine Kugel?
            if(that instanceof Ball)
            {
                // fuege die Kugel der NochFreilassen-Listehinzu
                this.myMoveableObjectsToRelease.add(that);
                // loesche sie aus der myObjects-Liste
                // Element kann nicht direkt aus der myObjects Liste geloescht
                // werden,
                // da ueber diese gerade iteriert wird
//                this.destroyThat.add(that);
            }
            if(that instanceof OutputHole)
            {
                // merke dir das OutputHole im aktuellen Level
                this.myBeginning = that;
            }
        }
        for(GeometricObject g : this.destroyThat)
        {
            this.myObjects.remove(g);
        }
        this.destroyThat.clear();
    }

    public Board(java.util.List<GeometricObject> _myObjects, int _width,
            int _height)
    {
        super();

        // this-Felder setzen
        this.WIDTH = _width;
        this.HEIGHT = _height;
        offImg = gfxConf.createCompatibleImage(this.WIDTH, this.HEIGHT);
        g2 = offImg.createGraphics();
        _p = DebugPainter.getInstance();
//        _p = StandardPainter.getInstance();
        _p.setGraphicsContext(g2);
        // this.myLastPaintedLine=new PaintedLine(this.WIDTH, this.HEIGHT);
        
        this.myObjects = new Demo().getLevelContent();
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

    /**
     * Kernmethode des Spiels, welche feststellt ob ein Objekt den SpielfeldRand
     * berueht, ob sich zwei Objekte gegenseitig beruehren, ob ein Objekt vom
     * Spielfeld geloescht werden soll, ob der Punktestand der Spielers
     * hochgezaehlt werden soll ob zum neachsten Level gesprungen werden soll
     * oder ob das Spiel verloren wurde
     * 
     * @throws RaiseScoreException
     *             wenn der Spielstand des Spielers hochgezaehlt werden soll
     * 
     * @throws GameOverException
     *             wenn das Spiel verloren wurde
     * 
     * @throws NextLevelException
     *             wenn zum naechsten Level gesprungen werden soll
     * 
     */
    public void checkCollision() 
    {
        // loesche die destroyThat-Liste
//        this.emptyDestroyThat();
        // lasse eventuell noch bestehende Kugeln frei
        this.releaseNextMoveableObject();
        // Variable um festzustellen wie viele Kugeln sich noch auf dem
        // Spielfeld befinden
        int numberBallObjects = 0;
        // fuer jedes Element in der myObjects Liste
        for(int i=0; i<this.myObjects.size(); i = i+1)
                //GeometricObject that : this.myObjects)
        {
            GeometricObject that = this.myObjects.get(i);
            
            if(that instanceof Ball)
            {
                numberBallObjects++;
                that.checkCollisionOnBorder(this.WIDTH, this.HEIGHT);
            }
            else if (that instanceof OutputHole)
            {
                continue;
            }
            
            for(int j=i+1; j<this.myObjects.size(); j = j+1)
            {
               GeometricObject go = this.myObjects.get(j);
                     
                   GeometricObject toDestroy = null;
               
           
                   // beruehrt das Objekt that ein anderes GeometricObject go
                   if(that.touches(go))
                   {
//                       destroyThat.add(toDestroy);
                   }
     
                   if(go.touches(that))
                   {
//                       destroyThat.add(toDestroy);
                   }
                       // WENN ja DANN versuche auf diese Beruehrung zu reagieren
//                       try
//                       {
//                           that.handleCollision(go);
//                       }
//                       catch(DestroyThatException e)
                       {
                           // fange eine eventuell geworfene DestroyThat-Exception
                           // auf, wenn bspw. eine blaue Kugel in ein
                           // blaues BlackHole faellt und dann die Kugel vom
                           // Spielfeld geloescht werden muss

                           // fuege das Element welches geloescht werden muss der
                           // destroyThat-Liste hinzu
                           // Element kann nicht direkt von der myObjects-Liste
                           // (bzw. dem Spielfeld) geloescht werden,
                           // da ueber diese Liste noch derzeit iteriert wird ->
                           // java.util.ConcurrentModificationException
//                           this.destroyThat.add(e.getElementToDestroy());
//                           if(this.myLastNPaintedLines.contains(e
//                                   .getElementToDestroy()))
//                           {
//                               this.myLastNPaintedLines.remove(e
//                                       .getElementToDestroy());
//                           }
                           // muss der Punktestand des Spielers hochgeahlt werden?
                           
                       }
                   
            }
        }
        
        if(this.destroyThat.contains(this.myCurrentLine))
        {
            this.ml.resetIsDragged();
        }
        
        for(GeometricObject g : this.destroyThat)
        {
            this.myObjects.remove(g);
        }
        this.destroyThat.clear();
        
        if(numberBallObjects == 0)
        {
            // wenn es keine Kugeln mehr auf dem Spielfeld gibt, dann werfe eine
            // NextLevelException,
            // die dann zum naechsten Level springen kann
//            throw new NextLevelException();
            this.myObjects = new Level2().getLevelContent();
            this.init();
        }
    }

    /**
     * loescht die Liste in der alle Elemente gespeichert wurden, die seit dem
     * letzen Aufruf der Methode <code>checkCollision</code> als 'vom Spielfeld
     * zu loeschen' festgestellt wurden
     */
    public void emptyDestroyThat()
    {
        // SOLANGE die Liste destroyThat noch nicht leer
        while(!this.destroyThat.isEmpty())
        {
            // loesche das erste Element vom Spielfeld...
            this.myObjects.remove(this.destroyThat.get(0));
            // und loesche das Element aus der destroyThat-Liste
            this.destroyThat.remove(this.destroyThat.get(0));
        }
    }

    /**
     * laesst in bestimmten Abstaenden die noch nicht freigesetzten Kugeln auf
     * dem Spielfeld frei
     */
    public void releaseNextMoveableObject()
    {
        
        if(false && this.myMoveableObjectsToRelease != null)
        {
            // muessen noch Kugeln auf dem Spielfeld freigelassen werden?
            if(this.myMoveableObjectsToRelease.isEmpty())
            {
                this.myMoveableObjectsToRelease = null;
            }
            else
            {
                // ist das OutputHole derzeit von einer anderen Kugel blockiert?
                // AND ist zwischen der letzten Kugel-'Freilassung' schon genug
                // Zeit vergangen
                if(!((OutputHole) this.myBeginning).isBlocked(this.myObjects)
                        && releaseWait % 70 == 0)
                {
                    // WENN ja DANN speichere dir die naechste Kugel aus der
                    // 'myMoveableObjectsToRelease'-
                    // Liste zwischen
                    GeometricObject releaseThis = this.myMoveableObjectsToRelease
                            .get(0);
                    // loesche sie direkt aus dieser Liste
                    this.myMoveableObjectsToRelease.remove(0);
                    // setze die Koordinaten der Kugel auf die Koordinaten der
                    // OutputHole
                    releaseThis.moveTo(this.myBeginning.getPosition());
                    // fuege die Kugel dem SPielfeld hinzu
                    this.myObjects.add(releaseThis);
                }
            }
            // releaseZeit hochzaehlen
            this.releaseWait++;
        }
    }

    public void moveObjects()
    {
        for(GeometricObject that : this.myObjects)
        {
            if(that instanceof Ball)
            {
                ((Ball)that).move();
            }
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

    public boolean isGameOver()
    {
        return this.isGameOver;
    }
}
