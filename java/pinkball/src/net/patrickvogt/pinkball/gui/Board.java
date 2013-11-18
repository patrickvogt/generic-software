package net.patrickvogt.pinkball.gui;

/*
 * Board.java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import net.patrickvogt.pinkball.exceptions.*;
import net.patrickvogt.pinkball.util.*;
import net.patrickvogt.pinkball.geom.*;

/**
 * implementiert ein Spielfeld mit verschiedenen ActionListenern und einer
 * 'Zeichen'-Methode, einer 'Bewegungs-Methode und einer Methode die ueberprueft, ob
 * verschiedene Objekte kollidieren
 * 
 * @author Patrick Vogt
 *
 */
public class Board extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * beschreibt die Weite des Spielfelds
	 */	
	private final int WIDTH;
	
	/**
	 * beschreibt die Hoehe des Spielfelds
	 */
    private final int HEIGHT;
    
    /**
     * beschreibt die Groesser der Gitterfelder im Background
     */
    private final int gridWidth=20;
    
    /**
     * beschreibt die Anzahl der maximalen gezeichneten Linien
     * die maxNumberOfPaintedLines+1. gezeichnete Linie verdraengt die derzeit aelteste gezeichnete
     * Linie vom Spielfeld
     */
    private final int maxNumberOfPaintedLines=4;
    
    /**
     * boolsche Konstante, die festlegt, ob der Hintergrund die Giternetzlinien gezeichnet werden sollen
     */
    private final boolean isBackgroundOn=true;
    
    /**
     * regelt das zwischen dem Freilassen der mehreren Kugeln eine bestimmte Zeit vergeht
     */
    private int releaseWait=0;
    
    /**
     * bestimmt, wo der Anfang/Beginn der Kugeln liegt
     */
    private GeometricObject myBeginning;
	
    /**
     * Liste, die alle Objekte enthaelt, die zum Spielfeld gehoeren
     */
    private java.util.List<GeometricObject> myObjects;
	
	/**
	 * Liste welche die N zuletzt gezeichneten Linien enthaelt
	 */
	private java.util.List<PaintedLine> myLastNPaintedLines=new LinkedList<PaintedLine>();
	
	/**
	 * <p>enthaelt alle seit dem letzten Aufruf der <code>checkCollision</code>-Methode 
	 * als 'vom Spielfeld zu loeschen' festgestellten Elemente</p>
	 * <p>Da ueber die <code>myObjects</code>-Liste iteriert wird, koennen Elemente aus dieser Liste erst 
	 * danach (nachdem die Liste 'durch'-iteriert wurde) geloescht werden</p>
	 *  
	 */
	private java.util.List<GeometricObject> destroyThat=new LinkedList<GeometricObject>();
	
	/**
	 * speichert die zuletzt gezeichnete Linie zwischen
	 */
	private PaintedLine myLastPaintedLine;
	
	/**
	 * Liste, in der am Anfang eines Levels alle Kugeln abgespeichert sind und diese
	 * nach und nach in das Spielfeld integriert werden
	 */
	private java.util.List<GeometricObject>myMoveableObjectsToRelease=new LinkedList<GeometricObject>();
	
	/**
	 * erzeugt eine neue Instanz von <code>Board</code> mit der Weite _width, der Hoehe _height
	 * und dee Liste _myObjects, die alle Elemente enthaelt, die auf dem Spielfeld dargestellt werden
	 * sollen
	 * 
	 * @param _myObjects enthaelt alle Elemente die zum Spielfeld gehoeren
	 * 
	 * @param _width die Weite des Spielfelds
	 * 
	 * @param _height die Hoehe des Spielfelds
	 * 
	 */
	public Board(java.util.List<GeometricObject> _myObjects, int _width, int _height) {
		super();
		//this-Felder setzen
		this.WIDTH=_width;
		this.HEIGHT=_height;
		this.myLastPaintedLine=new PaintedLine(this.WIDTH, this.HEIGHT);
		
		//Liste aufteilen in Kugel-Objekte und NichtKugel-Objekte
		for(GeometricObject that:_myObjects) {
			//die KugelObjekte sollen spaeter erst nach und nach ueber das sogenannte 
			//OutputHole freigelassen werden
			
			//ist that eine Kugel?
			if(that instanceof Ball) {
				//fuege die Kugel der NochFreilassen-Listehinzu
				this.myMoveableObjectsToRelease.add(that);
				//loesche sie aus der myObjects-Liste
				//Element kann nicht direkt aus der myObjects Liste geloescht werden,
				//da ueber diese gerade iteriert wird
				this.destroyThat.add(that);
			}
			if(that instanceof OutputHole) {
				//merke dir das OutputHole im aktuellen Level
				this.myBeginning=that;
			}
		}
		//fuege die RestListe der this-myObjects-Liste hinzu
		this.myObjects=_myObjects;
		
		//MouseListener und MouseMotionListener dem Board hinzufuegen
		this.addMouseMotionListener(new MyMouseMotionListener());
		this.addMouseListener(new MyMouseListener());
	}
	
	/**
	 * gibt die bevorzugte Dimension des Boards zurueck
	 */
	@Override 
    public Dimension getPreferredSize() {
        return(new Dimension(this.WIDTH,this.HEIGHT));
    }
	
	/**
	 * Kernmethode des Spiels, welche feststellt 
	 * ob ein Objekt den SpielfeldRand berueht, 
	 * ob sich zwei Objekte gegenseitig beruehren,
	 * ob ein Objekt vom Spielfeld geloescht werden soll,
	 * ob der Punktestand der Spielers hochgezaehlt werden soll
	 * ob zum neachsten Level gesprungen werden soll 
	 * oder ob das Spiel verloren wurde
	 * 
	 * @throws RaiseScoreException wenn der Spielstand des Spielers hochgezaehlt werden soll
	 * 
	 * @throws GameOverException wenn das Spiel verloren wurde
	 * 
	 * @throws NextLevelException wenn zum naechsten Level gesprungen werden soll
	 * 
	 */
	public void checkCollision() throws RaiseScoreException, GameOverException, NextLevelException {
		//loesche die destroyThat-Liste
		this.emptyDestroyThat();
		//lasse eventuell noch bestehende Kugeln frei
		this.releaseNextMoveableObject();
		//Variable um festzustellen wie viele Kugeln sich noch auf dem Spielfeld befinden
		int numberBallObjects=0;
		//fuer jedes Element in der myObjects Liste
        for(GeometricObject that:this.myObjects) { 
        	//zaehle die Anzahl der Kugeln auf dem Spielfeld
        	//wichtig um festzustellen, ob das Level erfolgreich absolviert wurde
        	if(that instanceof Ball) {
        		numberBallObjects++;
        	}
        	//beruert das Objekt that den SpielfeldRand
            that.checkCollisionOnBorder(this.WIDTH, this.HEIGHT);
        	for(GeometricObject go:this.myObjects) {
        		//beruehrt das Objekt that ein anderes GeometricObject go
                if(that != go && that.touches(go)) {
                	//WENN ja DANN versuche auf diese Beruehrung zu reagieren
                	try {
            			that.handleCollision(go);
                	}
                	catch(DestroyThatException e) {
                		//fange eine eventuell geworfene DestroyThat-Exception auf, wenn bspw. eine blaue Kugel in ein
                		//blaues BlackHole faellt und dann die Kugel vom Spielfeld geloescht werden muss
                		
                		//fuege das Element welches geloescht werden muss der destroyThat-Liste hinzu
                		//Element kann nicht direkt von der myObjects-Liste (bzw. dem Spielfeld) geloescht werden,
                		//da ueber diese Liste noch derzeit iteriert wird -> java.util.ConcurrentModificationException
                		this.destroyThat.add(e.getElementToDestroy());
                		if(this.myLastNPaintedLines.contains(e.getElementToDestroy())) {
                			this.myLastNPaintedLines.remove(e.getElementToDestroy());
                		}
                		//muss der Punktestand des Spielers hochgeahlt werden?
                		if(e.getRaiseScore()) {
                			//WENN ja DANN werfe eine RaiseScoreException
                			throw new RaiseScoreException();
                		}
                	}
                	catch(GameOverException e) {
                		//fange eine eventuell geworfene GameOverException auf, wenn das Spiel verloren wurde
                		//(bspw. dadurch, dass eine blaue Kugel in ein gelbes BlackHole gefallen ist
                		throw new GameOverException();
                	}
                }
            }
        }
        if(numberBallObjects==0) {
        	//wenn es keine Kugeln mehr auf dem Spielfeld gibt, dann werfe eine NextLevelException,
        	//die dann zum naechsten Level springen kann
        	throw new NextLevelException();
        }
    }
	
	/**
	 * loescht die Liste in der alle Elemente gespeichert wurden, die seit dem letzen Aufruf der 
	 * Methode <code>checkCollision</code> als 'vom Spielfeld zu loeschen' festgestellt wurden
	 */
	public void emptyDestroyThat() {
		//SOLANGE die Liste destroyThat noch nicht leer
		while(!this.destroyThat.isEmpty()) {
			//loesche das erste Element vom Spielfeld...
        	this.myObjects.remove(this.destroyThat.get(0));
        	//und loesche das Element aus der destroyThat-Liste
        	this.destroyThat.remove(this.destroyThat.get(0));
        }
	}
	
	/**
	 * laesst in bestimmten Abstaenden die noch nicht freigesetzten Kugeln auf dem Spielfeld frei 
	 */
	public void releaseNextMoveableObject() {
		if(this.myMoveableObjectsToRelease!=null) { 
			//muessen noch Kugeln auf dem Spielfeld freigelassen werden?
			if(this.myMoveableObjectsToRelease.isEmpty()) {
				this.myMoveableObjectsToRelease=null;
			}
			else {
				//ist das OutputHole derzeit von einer anderen Kugel blockiert?
				//AND ist zwischen der letzten Kugel-'Freilassung' schon genug Zeit vergangen
				if(!((OutputHole)this.myBeginning).isBlocked(this.myObjects)
				&& releaseWait%70==0) {
					//WENN ja DANN speichere dir die naechste Kugel aus der 'myMoveableObjectsToRelease'-
					//Liste zwischen
					GeometricObject releaseThis=this.myMoveableObjectsToRelease.get(0);
					//loesche sie direkt aus dieser Liste
					this.myMoveableObjectsToRelease.remove(0);
					//setze die Koordinaten der Kugel auf die Koordinaten der OutputHole
					releaseThis.moveTo(this.myBeginning.getPosition());
					//fuege die Kugel dem SPielfeld hinzu
					this.myObjects.add(releaseThis);
				}
			}
		//releaseZeit hochzaehlen
		this.releaseWait++;
		}
	}
	
	/**
	 * 'Bewegungs'-Methode die jedes Objekt in der <code>myObjects</code>-Liste um den
	 * im <code>Speed</code>-Vektor gespeicherten Werten in x und y bewegt
	 * 
	 */
	public void moveObjects() {
	    for(GeometricObject that:this.myObjects) {
	    	//Da sich nur Kugeln auf dem Spielfeld bewegen, muessen auch nur diese
	    	//von dieser Methode verschoben/bewegt werden
	    	if(that instanceof Ball) {
	    		that.move();
	    	}
	    }
	}
	
	/**
	 * 'Zeichen'-Methode, die alle sich in der <code>myObjects</code>-Liste befindlichen 
	 * <code>GeometricObject</code>s auf dem uebergebenen Graphik-Kontext zeichnet
	 * 
	 * @param g Graphik-Kontext auf dem die Komponenten gezeichnet werden sollen
	 * 
	 */
	@Override
    public void paintComponent(Graphics g) { 
		//Bildschirm leeren
		g.clearRect(0, 0, this.WIDTH, this.HEIGHT);
		//WENN der Hintergrund angeschaltet wurde
		if(this.isBackgroundOn) {
			//DANN zeichne die Gitternetzlinien
			g.setColor(Color.LIGHT_GRAY);
			for(int i=this.gridWidth; i<this.HEIGHT; i=i+this.gridWidth) {
				g.drawLine(0, i, this.WIDTH, i);
			}
			for(int j=this.gridWidth; j<this.WIDTH; j=j+this.gridWidth) {
				g.drawLine(j, 0, j, this.HEIGHT);
			}
		}
		//fuer jedes Objekt in der myObjects-Liste
        for(Paintable that:this.myObjects) {
        	//zeichne dich selbst auf dem uebergebenen Graphik-Kontext
            that.paintMeTo(g);
        }
    }
	
	/**
	 * interne Unterklasse von MouseMotionAdapter, die die einen MouseMotionListener
	 * implementiert um die Bewegung der Maus zu ueberwachen
	 * 
	 * @author Patrick Vogt
	 *
	 */
	//MyMouseMotionListener ist eine Unterklasse von MouseMotionAdapter
	private class MyMouseMotionListener extends MouseMotionAdapter {
		/**
		 * ueberwacht die Mausbewegung wenn eine der Maustasten gedrueckt wird und
		 * ueber den Bildschirm gezogen wird
		 * 
		 * @param evt <p><code>MouseEvent</code> welches die Ausfuehrung der Methode <code>mouseDragged</code>
		 * angeregt hat</p>
		 * <p>Durch dieses <code>MouseEvent</code> laesst sich bpsw. der aktuelle Ort der Maus feststellen etc.)
		 * 
		 */
		@Override
		public void mouseDragged(MouseEvent evt) {
			//befindet sich der Mauszeiger noch im Spielfeld (sichtbarer Bereich)?
			if(evt.getX()>0 && evt.getX()<WIDTH && evt.getY()<HEIGHT && evt.getY()>0) {
				//ist schon eine Linie vorhanden?
				if(myLastPaintedLine==null) {
					//WENN nicht DANN erzeuge eine neue Linie
					myLastPaintedLine=new PaintedLine(WIDTH, HEIGHT);
				}
				//fuege die aktuelle Position des Mauszeigers zur 'Roh'-Linie hinzu,
				//indem ledigliech gespeichert wird, welche Pixel durch den Mauszeiger
				//'angeschaltet' wurden
				myLastPaintedLine.setFieldInIsDotOnArray(evt.getY(), evt.getX());
				myLastPaintedLine.setNextFieldInPosInLineArray(evt.getY(), evt.getX());
			}
			else {
				//WENN sich die Linie nicht mehr im sichtbaren Bereich befindet
				if(myLastPaintedLine!=null) {
					//DANN beende die Linie an diesem Punkt
					
					//'Roh'-Linie wie sie von der Methode mouseDragged (MouseMotionListener)
					//aufgezeichnet wurde verbessern (bspw. Aufloesung verbessern), 
					//damit man besser eine Kollision zwischen Linie und Kugel pruefen kann
					myLastPaintedLine.prepareMyLineForGraphicalOutput();
					//verfeinerte Linie dem Spielfeld hinzufuegen bzw. der Liste 
					//mit den GeometricObjects
					myObjects.add(myLastPaintedLine);
					//muss eine aeltere Linie vom Spielfeld geloescht werden?
					//Verdraengunsstrategie -> LRP (least recently painted)
					if(myLastNPaintedLines.size()>=maxNumberOfPaintedLines) {
						//WENN ja DANN die aelteste Linie vom Spielfeld...
						myObjects.remove(myLastNPaintedLines.get(0));
						//...und der Liste mit den N zuletzt gezeichneten Linien loeschen
						myLastNPaintedLines.remove(0);
					}
					//die zuletzt gezeichnete Linie der Liste mit den letzten N Linien
					//hinzufuegen
					myLastNPaintedLines.add(myLastPaintedLine);
					
					//PROBLEM: mouseDragged kann den Endpunkt nicht auserhalb des Spielfeld setzen
					//Besteht die Linie aus mehr als einem Punkt?
					if(myLastPaintedLine.getLine().getLast() != myLastPaintedLine.getLine().getFirst()) {
						//WENN ja DANN beende Linie slebst bis zum Rand des Spielfeld
						myLastPaintedLine.finishLine();
					}
					else {
						//ANDERNFALLS 'Linie' ist unbrauchbar => loesche die Linie
						myObjects.remove(myLastPaintedLine);
					}
					//temporaer gespiecherte Linie kann jetzt geloescht werden bzw. auf
					//null gesetzt werden
					myLastPaintedLine=null;
				}
			}
		}
	}

	/**
	 * interne Unterklasse von MouseAdapter, die einen Mouse Listener implementiert
	 * und feststellen soll, wenn die eine der Maustasten losgelassen wurde bzw.
	 * die Linie zu  Ende gezeichnet wurde
	 * 
	 * @author Patrick Vogt
	 *
	 */
	//MyMouseListener ist eine Unterklasse von MouseAdapter
	private class MyMouseListener extends MouseAdapter {
		
		/**
		 * erkennt, wenn eine der Maustasten losgelassen (engl. released) wird und somit
		 * die Linie vom Spieler zu Ende gezeichnet wurde und nun zum Spielfeld hinzugefuegt,
		 * sowie auf eine Kollision mit einer Kugel reagieren muss 		 
		 * 
		 * @param evt aktuelles <code>MouseEvent</code> bei dem die Maustaste losgelassen wurde
		 * 
		 */
		@Override
		public void mouseReleased(MouseEvent evt) {
			if(myLastPaintedLine!=null) {
				//'Roh'-Linie wie sie von der Methode mouseDragged (MouseMotionListener)
				//aufgezeichnet wurde verbessern (bspw. Aufloesung verbessern), 
				//damit man besser eine Kollision zwischen Linie und Kugel pruefen kann
				myLastPaintedLine.prepareMyLineForGraphicalOutput();
				//verfeinerte Linie dem Spielfeld hinzufuegen bzw. der Liste 
				//mit den GeometricObjects
				myObjects.add(myLastPaintedLine);
				//muss eine aeltere Linie vom Spielfeld geloescht werden?
				//Verdraengunsstrategie -> LRP (least recently painted)
				if(myLastNPaintedLines.size()>=maxNumberOfPaintedLines) {
					//WENN ja DANN die aelteste Linie vom Spielfeld...
					myObjects.remove(myLastNPaintedLines.get(0));
					//...und der Liste mit den N zuletzt gezeichneten Linien loeschen
					myLastNPaintedLines.remove(0);
				}
				//die zuletzt gezeichnete Linie der Liste mit den letzten N Linien
				//hinzufuegen
				myLastNPaintedLines.add(myLastPaintedLine);
				//temporaer gespiecherte Linie kann jetzt geloescht werden bzw. auf
				//null gesetzt werden
				myLastPaintedLine=null;
			}
		} 
	}
}

