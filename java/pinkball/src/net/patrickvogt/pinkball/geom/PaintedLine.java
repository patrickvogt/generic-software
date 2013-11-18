package net.patrickvogt.pinkball.geom;

/*
 * PaintedLine.java
 */

import java.awt.*;
import java.util.*;

import net.patrickvogt.pinkball.vector.*;
import net.patrickvogt.pinkball.exceptions.*;

/**
 * implementiert eine gezeichnete Linie, die sich selbst verfeinern (hoehere Aufloesung),
 * die beruehrt und mit anderen Objekte kollidieren kann
 * 
 * @author Patrick Vogt
 *
 */
//PaintedLine ist eine Unterklasse von GeometricObject
public class PaintedLine extends GeometricObject {
	
	/**
	 * beschreibt die maximale Groesse des Abstand zwischen zwei Punken (x- oder y-Abstand)
	 */
	private final int gap=1;
	
	/**
	 * beschreibt die Weite des Spielfelds
	 */
	private final int WIDTH;
	
	/**
	 * beschreibt die Hoehe des Spielfelds
	 */
	private final int HEIGHT;
	
	/**
	 * <p>beschreibt wie viele Punkte der Linie fuer die Methode <code>touches</code> ueberprueft werden</p>
	 * <p>Bsp: bei <code>checkEveryNPoints=1</code> wird jede Koordinate der Linie ueberprueft </p>
	 * <p>Bsp: bei <code>checkEveryNPoints=2</code> wird hingegen nur jede 2. Koordinate ueberprueft</p>
	 */
	private final int checkEveryNPoints=10;
	
	/**
	 * speichert alle Koordinaten die von mouseDragged aufgezeichnet werden
	 */
	private boolean[][] isDotOn;
	
	/**
	 * merkt sich die Reihenfolge/Position der Koordinaten innerhalb der Linie, die von mouseDragged
	 * aufgezeichnet werden
	 */
    private int[][] posInLine;
    
    /**
     * interner Counter, der die Position innerhalb der Linie hochzaehlt
     */
    private int posCount=0;
    
    /**
     * eigentliche Linie, die spaeter zum zeichnen und fuer die Beruehrungsfunktion benoetigt wird
     */
    private LinkedList<Coordinate> line=new LinkedList<Coordinate>();
    
    /**
     * speichert den Beruehrpunkt zwischen Linie und Kugel 
     * (die wie vielte Position/Koordinate innerhab der Linie)
     */
    private int lastTouchPoint;

    /**
     * erzeugt eine neue Instanz von <code>PaintedLine</code>
     * 
     * @param _width die Weite des Spielfelds
     * 
     * @param _height die Hiehe des Spielfelds
     * 
     */
	public PaintedLine(int _width, int _height) {
		//PSEUDO-GeometricObject erzeugen
		super(0.0,0.0,0.0,0.0);
		//this-Felder setzen
		this.WIDTH = _width;
		this.HEIGHT = _height;
		
		//die beiden Arrays initialisieren
		isDotOn=new boolean[_height][_width];
	    posInLine=new int[_height][_width];
	}
	
	/**
	 * Zugriffsmethode um das Array zu bekommen, in dem alle von mouseDragged aufgezeichneten 
	 * Pixel gespeichert wurden
	 * 
	 * @return das Array in dem die von mouseDragged aufgezeichneten Pixel gespeichert wurden
	 * 
	 */
	public boolean[][] getIsDotOnArray() {
		return(this.isDotOn);
	}
	
	/**
	 * setzt den Wert einer bestimmten Zelle in einem 2-dimensionalen Array auf <code>true</code>
	 * 
	 * @param _i y-Koordinate des Pixels, welches gesetzt werden soll
	 * 
	 * @param _j x-Koordinate des Pixels, welches gesetzt werden soll
	 * 
	 */
	public void setFieldInIsDotOnArray(int _i, int _j) {
		this.isDotOn[_i][_j] = true;
	}
	
	/**
	 * Zugriffsmethode um das Array zu bekommen, in dem alle von mouseDragged aufgezeichneten
	 * Pixel abgespeichert wurden
	 * 
	 * @return Array, in dem alle von mouseDragged aufgezeichneten Pixel abgespeichert wurden
	 * 
	 */
	public int[][] getPosInLineArray() {
		return(this.posInLine);
	}
	
	/**
	 * mekrt sich Position (innerhalb der Linie) zu einer uebergebenen Koordinate
	 * 
	 * @param _i y-Koordinate des aufgezeichneten Pixels
	 * 
	 * @param _j x-Koordinate des aufgezeichneten Pixels
	 * 
	 */
	public void setNextFieldInPosInLineArray(int _i, int _j) {
		this.posInLine[_i][_j] = this.getPosCount();
		//PositionsZaehler inkrementieren
		this.increasePosCount();
	}
	
	/**
	 * Zugriffsmethode um den Wert des Positionszaehlers zu bekommen
	 * 
	 * @return die wie vielte Position in der Linie als naechstes abgespeichert werden soll
	 * 
	 */
	public int getPosCount() {
		return(this.posCount);
	}
	
	/**
	 * inkrementiert den Wert von dem PositionsZaehler um 1 
	 */
	private void increasePosCount() {
		this.posCount++;
	}
	
	/**
	 * Zugriffsmethode um die Konstante zu bekommen, die den maximalen Abstand zwischen zwei Punkten
	 * in einer Linie beschreibt
	 * 
	 * @return die Konstante, die den maximalen Abstand zwischne zwei Punkten
	 * in einer Linie beschreibt
	 * 
	 */
	public int getGap() {
		return(this.gap);
	}
	
	/**
	 * Zugriffsmethode um die Liste zu bekommen in dem die eigentliche Linie bzw. deren Koordinaten 
	 * abgespeichert wurden
	 * 
	 * @return die eigentliche Linie bzw. eine Liste von Koordinaten
	 * 
	 */
	public LinkedList<Coordinate> getLine() {
		return(this.line);
	}
	
	/**
	 * Zugriffsmethode um die Linie (List<Coordinate>) auf eine uebergenene Linie (List<Coordinate>) zu setzen
	 * 
	 * @param _line neue Linie
	 */
	public void setLine(LinkedList<Coordinate> _line) {
		this.line = _line;
	}
	
	/**
	 * zeichnet das Objekt auf dem uebergebenen Graphik-Kontext
	 * 
	 * @param g der Graphik-Kontext, auf dem das Objekt gezeichnet werden soll
	 * 
	 */
	@Override
	public void paintMeTo(Graphics g) {	
		int i=checkEveryNPoints;
		g.setColor(Color.BLACK);
		//SOLANGE die Linie nicht zu Ende ist (bzw. bis zum vorletzten Punkt)
		while(this.getLine()!= null && i<this.getLine().size() && this.getLine().get(i) != null) {
			//Zeichne eine TeilLinie von der aktuellen Koordinate der Linie 
			//bis zur naechsten Koordinate der Linie
			g.drawLine((int) this.getLine().get(i-checkEveryNPoints).getX(), (int) this.getLine().get(i-checkEveryNPoints).getY(), 
					(int) this.getLine().get(i).getX(), (int) this.getLine().get(i).getY());
			i=i+checkEveryNPoints;
		}
	}

	/**
	 * prueft ob sich das this-Objekt und das uebergebene Objekt beruehren
	 * 
	 * @param that das mit dem this-Objekt zu ueberpruefende Objekt
	 * 
	 * @return ob sich this- und that Objekt beruehren
	 * 
	 */
	@Override
	public boolean touches(GeometricObject that) {
		//ist that eine Kugel= (Nur Kugeln koennen sich im Spiel bewegen)
		if(that instanceof Ball) {
			int i=0;
			//SOLANGE die Linie noch nicht zu Ende ist
	        while(this.getLine() != null && i<this.getLine().size()-1 && this.getLine().get(i)!=null) {
	            //besitzt das that-Objekt die aktuelle Koordinate der Linie?
	            if(that.hasWithin(new Coordinate(this.getLine().get(i).getX(),this.getLine().get(i).getY()))==true) {
	            	//WENN ja DANN speichere dir diesen Beruehrpunkt
	            	this.lastTouchPoint=i;
	            	//und gib zurueck, dass this- und that-Objekt sich beruehren
	            	return(true);
	            }
	            //gehe zum naeschten zu ueberpruefenden Punkt
	            i=i+this.checkEveryNPoints;
	        }
		}
		//this- und that-Objekt beruehren sich nicht
        return(false);
	}
	
	/**
	 * reagiert auf eine Kollision zwischen <code>PaintedLine</code> und <code>Ball</code>
	 * 
	 * @param that das Objekt, welches das this-Objekt (die Linie) beruehrt
	 * 
	 * @throws DestroyThatException wenn die Linie mit einer Kugel kollidiert ist und nun die
	 * Linie vom Spielfeld geloescht werden soll
	 * 
	 */
	@Override
	public void handleCollision(GeometricObject that) throws DestroyThatException {
		//ist that eine Kugel? (nur Kugeln koennen sich im Spiel bewegen)
		if(that instanceof Ball) {
			java.util.List<Coordinate> tmpLine=this.getLine();
			//der Punkt, an dem eine Beruehrung festgestellt wurde
			int i=this.lastTouchPoint;
			
			double deltaX;
	        double deltaY;
	        double relAlpha;
	        
	        //Winkel der Linie (und dessen Umgebung) feststellen
	        
	        if(i<this.getLine().size()-1 && tmpLine.get(i+1)!=null) {
	            if(i>0) {
	            	//BeruehrKooridinate hat einen linken und rechten Nachbarn
	            	//nutze beide um den Abstand der Koordinaten festzustellen
	                deltaX=tmpLine.get(i+1).getX()-tmpLine.get(i-1).getX();
	                deltaY=tmpLine.get(i+1).getY()-tmpLine.get(i-1).getY();
	            }
	            else {
	            	//BeruehrKoordinate befindet sich ganz am Anfang der Linie 
	            	//-> Koordinate hat nur einen rechten Nachbarn
	            	//nutze diesen rechten Nachbarn um den Abstand der Koordinaten festzustellen
	                deltaX=tmpLine.get(i+1).getX()-tmpLine.get(i).getX();
	                deltaY=tmpLine.get(i+1).getY()-tmpLine.get(i).getY();
	            }
	        }
	        else {
	            if(i>0) {
	            	//BeruehrKoordinate befindet sich ganz am Ende der Linie 
	            	//-> Koordinate hat nur einen linken Nachbarn
	            	//nutze diesen linken Nachbarn um den Abstand der Koordinaten festzustellen
	                deltaX=tmpLine.get(i).getX()-tmpLine.get(i-1).getX();
	                deltaY=tmpLine.get(i).getY()-tmpLine.get(i-1).getY();
	            }
	            else {
	                //Linie besteht nur aus einem Pixel -> einfach irgendwie abprallen
	                deltaX=1.0;
	                deltaY=-1.0;
	            }
	        }
	        //temporaeren Vektor erzeugen
	        Coordinate r = new Coordinate(that.getSpeed().getDX(), that.getSpeed().getDY());
	        
	        //den Geschwindigkeitsvektor um 180 Grad (PI) drehen -> siehe pdf
	        that.getSpeed().setDX(Math.cos(Math.PI)*r.getX()-Math.sin(Math.PI)*r.getY());
	        that.getSpeed().setDY(Math.sin(Math.PI)*r.getX()+Math.cos(Math.PI)*r.getY());
	        
	        r = new Coordinate(that.getSpeed().getDX(), that.getSpeed().getDY());
	        Coordinate s = new Coordinate(deltaX, deltaY);
	        //Winkel beta der Linie bestimmen
	        double beta = Math.atan2(s.getY(),s.getX());
	       
	        //relAlpha ist der Winkel zwischen der Kugel und der Linie -> siehe pdf
	        relAlpha = Math.atan2(r.getY(),r.getX())-beta;
	        
	        //Drehwinkel, um den der Geschwindigkeitsvektor der Kugel gedreht werden muss
	        //ist 180 Grad (PI) - 2* dem Winkel zwischen Linie und Kugel -> siehe pdf
	        double turnAngle = Math.PI-2*relAlpha;
	        
	        //Geschwindigkeitsvektor um den Drehwinkel drehen
	        that.getSpeed().setDX(Math.cos(turnAngle)*r.getX()-Math.sin(turnAngle)*r.getY());
	        that.getSpeed().setDY(Math.sin(turnAngle)*r.getX()+Math.cos(turnAngle)*r.getY());
	        
	        //Linie loeschen
	        this.setLine(null);	 
	        //Linie vom Spielfeld loeschen
	        throw new DestroyThatException(this, false);
		}
		
	}
	
	/**
	 * bereitet die Linie auf das Zeichnen und die Erkennung, sowie die Reaktion auf das Kollidieren vor
	 */
	public void prepareMyLineForGraphicalOutput() {
		//temporaeres Array initialisieren
		Coordinate[] tmpArray=new Coordinate[this.WIDTH*this.HEIGHT];
		//isDotOn-Array durchgehen, in dem alle Pixel gespeichert wurden, die die Funktion
		//mouseDragged aufgezeichnet hat
		for(int i=0; i<this.getIsDotOnArray().length; i++) {
			for(int j=0; j<this.getIsDotOnArray()[0].length; j++) {
				if(this.getIsDotOnArray()[i][j]==true) {
					//aktuelle Koordinate in das temporaere Array an der richtigen Stelle/Position kopieren
					tmpArray[this.getPosInLineArray()[i][j]] = new Coordinate(j,i);
				}
			}
		}
		//Koordinaten aus dem temporaeren Array in eine List umkopieren
		for(int i=0; i<tmpArray.length && tmpArray[i]!=null; i++) {
			this.getLine().add(tmpArray[i]);
		}
		//temporaeres Array loeschen
		tmpArray=null;
		//Linie verfeinern
        this.reResolutionizePaintedLine();
	}

	/**
	 * <p>verfeinert eine von mouseDragged aufgezeichnete Linie</p>
	 * 
	 * <p>nach Abarbeitung dieser Methode hat die Linie mindestens alle gap (siehe oben) Punkte eine
	 * weitere Koordinate</p>
	 */
	private void reResolutionizePaintedLine() {		
		//die von mouseDragged aufgezeichnete Linie
		LinkedList<Coordinate> tmpLine=this.getLine();
		
		//die optimierte/verfeinerte Linie
		LinkedList<Coordinate> optiLine=new LinkedList<Coordinate>();
		
		//ersten Punkt der Linie manuell setzen
        optiLine.add(new Coordinate(this.getLine().get(0).getX(),
        		this.getLine().get(0).getY()));
        int j=1;
        int i=1;
        //SOLANGE die Linie noch nicht zu Ende ist
        while(j<tmpLine.size()) {
        		//Abstaende feststellen
                double xDifference = tmpLine.get(j).getX()-tmpLine.get(j-1).getX();
                double yDifference = tmpLine.get(j).getY()-tmpLine.get(j-1).getY();
                //groesseren Abstand herausfinden
                double maxDifference = Math.abs(xDifference) > Math.abs(yDifference) ? 
                		Math.abs(xDifference) : Math.abs(yDifference);
                boolean again=true;
                //SOLANGE again noch true AND maximaler Abstand groesser gleich der Kosntante gap
                while(again==true && maxDifference >= this.getGap()) {
                	//einen weiteren Punkt im Abstand gap (siehe oben) zur Linie hinzufuegen
                        optiLine.add(new Coordinate(optiLine.get(i-1).getX()+(this.getGap()*xDifference)/(maxDifference),
                        		optiLine.get(i-1).getY()+(this.getGap()*yDifference)/(maxDifference)));
                             
                        //feststellen ob die Linie bis zum naechsten Punkt schon fein genug ist
                        //dazu muss die Richtung der Linie (in wlechem Quadrant sie sich befindet
                        //festgestellt werden
                        if(xDifference>0) {
                            if(yDifference>0) {
                            	 //Linie verlaeuft in diesem Abschnit von links oben nach rechts unten
                                 again = optiLine.get(i).getX() <= tmpLine.get(j).getX()
                                 && optiLine.get(i).getY() <= tmpLine.get(j).getY();
                             }
                             else {
                            	 //Linie verlaeuft in diesem Abschnit von links unten nach rechts oben
                                 again = optiLine.get(i).getX() <= tmpLine.get(j).getX()  
                                 &&  optiLine.get(i).getY() >= tmpLine.get(j).getY();
                             }
                         }
                         else {
                             if(yDifference>0) {
                            	//Linie verlaeuft in diesem Abschnit von rechts unten nach links oben
                                 again = optiLine.get(i).getX() >= tmpLine.get(j).getX() 
                                 &&  optiLine.get(i).getY() <= tmpLine.get(j).getY();
                             }
                             else {
                            	//Linie verlaeuft in diesem Abschnit von rechts oben nach links unten
                                 again = optiLine.get(i).getX() >= tmpLine.get(j).getX() 
                                 &&  optiLine.get(i).getY() >= tmpLine.get(j).getY();
                             }
                         }
                        i++;
                }
                j++;
        }
        //optimierteLinie alsgezeichnete Linie setzen
        this.setLine(optiLine);
        //temporaeres Array (in dem die aufgezeichneten mouseDragged-Pixel gespeichert wurden) loeschen
        isDotOn=null;
        //temporaeres Array (in dem die Reihenfolge der aufgezeichneten Pixel gespeichert wurden) loeschen
	    posInLine=null;
	}
	
	/**
	 * beendet die Linie bis zum Rand des Spielfelds
	 */
	public void finishLine() {
		//Abstaende feststelen
		double deltaX=this.getLine().getLast().getX()-
		this.getLine().get(this.getLine().indexOf(this.getLine().getLast())-1).getX();
		double deltaY=this.getLine().getLast().getY()-
		this.getLine().get(this.getLine().indexOf(this.getLine().getLast())-1).getY();
		//aktuelle Position feststellen
		double currX=this.getLine().getLast().getX();
		double currY=this.getLine().getLast().getY();
		
		//SOLANGE sich die Linie noch innerhalb des Spielfelds befindet
		while(currX+deltaX < WIDTH && currY+deltaY < HEIGHT && currX+deltaX > 0 && currY+deltaY > 0) {
			//aktualisiere die derzeitige Position der Linie
			currX=currX+deltaX;
			currY=currY+deltaY;
			//fuege der Linie einen weiteren Punkt im gleichen Abstand
			//(wie der Abstand der vorherigen Punkte) hinzu
			this.getLine().add(new Coordinate(currX, currY));
		}
	}
}
