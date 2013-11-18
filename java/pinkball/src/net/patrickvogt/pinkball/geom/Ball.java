package net.patrickvogt.pinkball.geom;

/*
 * Ball.java
 */

import java.awt.*;

import net.patrickvogt.pinkball.vector.*;

/**
 * implementiert eine farbige Kugel, die sich auf dem Spielfeld bewegen und mit anderen
 * Objekten kollidieren kann
 * 
 * @author Patrick Vogt
 *
 */
//Ball ist eine Unterklasse von GeometricObject
public class Ball extends GeometricObject {
	
	/**
	 * Kontante, welche die maximale Geschwindigkeit (x- und y-Richtung) einer Kugel beschreibt, um zu
	 * verhindern, dass die Kugel zu schnell wird
	 */
	private final double maxSpeed=3;
	
	/**
	 * Konstante, die beschreibt, wie stark eine zu schnelle Kugel abgebremst werden soll
	 */
	private final double brakeConst=0.4;
	
	/**
	 * speichert ob sich die Kugel derzeit in einem schwarzen Loch befindet, damit
	 * bspw. keine Kollisionen innerhalb von schwarzen Loechern stattfinden koennen
	 */
	private boolean isInBlackHole=false;	
	
	/**
	 * erzeugt eine neue Instanz von <code>Ball</code>
	 * 
	 * @param _myDimension die Dimension des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public Ball(Dimension2D _myDimension, Color _myColor) {
		//super-Konstruktor (von GeometricObject) aufrufen
		super(new Coordinate(0,0), _myDimension, _myColor);
		//Geschwindigkeit mit random-Werten setzen
		this.mySpeed=new Speed(Math.random()*maxSpeed, Math.random()*maxSpeed);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>Ball</code>
	 * 
	 * @param _diameter der Durchmesser des zu erzeugenden Objekts
	 * 
	 */
	public Ball(double _diameter) {
		//oberen Konstruktor aufrufen
		//Blau ist die Standart-Farbe fuer eine Kugel
		this(new Dimension2D(_diameter,_diameter), Color.BLUE);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>Ball</code>
	 * 
	 * @param _myDimension die Dimension des zu erzeugenden Objekts
	 * 
	 */
	public Ball(Dimension2D _myDimension) {
		//oberen Konstruktor aufrufen
		//Blau ist die StandartFarbe fuer eine Kugel
		this(_myDimension, Color.BLUE);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>Ball</code>
	 * 
	 * @param _diameter der Durchmesser des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public Ball(double _diameter, Color _myColor) {
		//oberen Konstruktor aufrufen
		this(new Dimension2D(_diameter,_diameter), _myColor);
	}
	
	/**
	 * Zugriffsmethode um den Durchmesser des Objekts zu bekommen
	 * 
	 * @return Durchmesser des Objekts
	 * 
	 */
	public double getDiameter() {
		return(this.getDimension().getWidth());
	}
	
	/**
	 * Zugriffsmethode um den Durchmesser des Objekts auf einen gegebenen Wert zu setzen
	 * 
	 * @param _diameter neuer Durchmesser des Objekts
	 * 
	 */
	public void setDiameter(double _diameter) {
		this.setDimension(new Dimension2D(_diameter, _diameter));
	}
	
	/**
	 * Zugriffsmethode um den aktuellen Radius des Objekts zu bekommen
	 * 
	 * @return Radius des Objekts
	 * 
	 */
	public double getRadius() {
		//Radius anhand der getDiameter-Methode bekommen/zurueckgeben
		//Radius ist der halbe Durchmesser
		return(this.getDiameter()/2);
	}
	
	/**
	 * Zugriffsmethode um den Radius auf einen gegebenen Wert zu setzen
	 * 
	 * @param _radius neuer Radius des aktuellen Objekts
	 * 
	 */
	public void setRadius(double _radius) {
		//Radius anhand der setDiameter-Methode setzen
		//Durchmesser ist 2*Radius
		this.setDiameter(2*_radius);
	}
	
	/**
	 * <p>berechnet den Flaecheninhalt des aktuellen Objekts</p>
	 * <p>Flaeche dient fuer die spaetere Impulsberechnung (Kollision zwischen 2 Kugeln) als
	 * PSEUDO-Masse (je groesser der Flaecheninhalt, desto groesser der uebertragende Impuls)</p>
	 * 
	 * @return Flaecheninhalt des aktuellen Objekts
	 * 
	 */
	public double getArea() {
		return(Math.PI*this.getDiameter());
	}
	
	/**
	 * kehrt den Wert von dem Attribut <code>isInBlackHole</code> um
	 */
	public void toggleIsInBlackHole() {
		this.isInBlackHole=!isInBlackHole;
	}
	
	/**
	 * Zugriffsmethode um den aktuellen Zustand des Attributs <code>isInBlackHole</code> zu bekommen
	 * 
	 * @return ob sich das Objekt in einem schwarzen Loch befindet
	 * 
	 */
	public boolean getIsInBalckHole() {
		return(this.isInBlackHole);
	}
	
	/**
	 * zeichnet das Objekt auf dem uebergebenen Graphik-Kontext
	 * 
	 * @param g der Graphik-Kontext, auf dem das Objekt gezeichnet werden soll
	 * 
	 */
	@Override
	public void paintMeTo(Graphics g) {
		//farbigen Kreis zeichnen
		g.setColor(this.getColor());
		g.fillOval((int)this.getPosition().getX(), (int)this.getPosition().getY(), 
				(int) this.getDiameter(), (int) this.getDiameter());
		//schwarze Kontur zeichnen -> 
		//da sich die Kugel mittlerweile weiterbewegt hat, mit Durchmesser-1
		g.setColor(Color.BLACK);
		g.drawOval((int)this.getPosition().getX(), (int)this.getPosition().getY(), 
				(int) this.getDiameter()-1, (int) this.getDiameter()-1);
	}
	
	/**
	 * reagiert auf eine Kollision zwischen <code>Ball</code> und <code>Ball</code>
	 * 
	 * @param that das Objekt, welches das this-Objekt beruehrt
	 * 
	 */
	@Override
	public void handleCollision(GeometricObject that) {
		//ist that eine Kugel? (Nur Kugeln koennen sich im Spiel bewegen)
		if(that instanceof Ball) {
			//Kollision zwischen zwei Kugeln
			//Adaption von 'Kollision zweier Kugeln 2D' -> http://www.softgames.de/forum/frage119566.html
			//Winkel zwischen den beiden Kugeln
			double w;
			//Kraftbetrag
			double f=Math.sqrt((this.getSpeed().getDX()*this.getSpeed().getDX())
					+this.getSpeed().getDY()*this.getSpeed().getDY())*this.getArea(); 
			if(this.getSpeed().getDX()==0) {
				w=Math.PI/2;
			} 
			else { 
				w=Math.atan2(this.getSpeed().getDY(),this.getSpeed().getDX());
			} 
			if (this.getSpeed().getDX()<0) {
				w=13*Math.PI/8+w;
			} 
			//neue Geschwindigkeit von this-Kugel und that-Kugel setzen
			this.getSpeed().setDX(f/this.getArea()*Math.cos(w+Math.PI)); 
			this.getSpeed().setDY(f/this.getArea()*Math.sin(w+Math.PI)); 
			that.getSpeed().setDX(that.getSpeed().getDX()+f/((Ball)that).getArea()*Math.cos(w)); 
			that.getSpeed().setDY(that.getSpeed().getDY()+f/((Ball)that).getArea()*Math.sin(w)); 
			
			//beide Kugeln ein Schritt weiterbewegen
			this.move();
			((Ball)that).move();
			
			//verhindern, dass die Geschwindigkeit beider Kugeln zu gross wird
			while(this.maxSpeed>1-this.brakeConst && this.getSpeed().getDX()>this.maxSpeed 
					|| this.maxSpeed>1-this.brakeConst && this.getSpeed().getDY()>this.maxSpeed) {
				this.getSpeed().setDX(this.getSpeed().getDX()/(this.maxSpeed+this.brakeConst));
				this.getSpeed().setDY(this.getSpeed().getDY()/(this.maxSpeed+this.brakeConst));
			}
			while(this.maxSpeed>1-this.brakeConst && that.getSpeed().getDX()>this.maxSpeed 
					|| this.maxSpeed>1-this.brakeConst && that.getSpeed().getDY()>this.maxSpeed) {
				that.getSpeed().setDX(that.getSpeed().getDX()/(this.maxSpeed+this.brakeConst));
				that.getSpeed().setDY(that.getSpeed().getDY()/(this.maxSpeed+this.brakeConst));
			}
		}
	}
	
	/**
	 * prueft und reagiert auf eine Kollision zwischen einer Kugel und den Raendern des Spielfelds
	 * 
	 * @param BOARD_WIDTH die Weite des Spielfelds
	 * 
	 * @param BOARD_HEIGHT die Hoehe des Spielfelds
	 * 
	 */
	@Override
	public void checkCollisionOnBorder(int BOARD_WIDTH, int BOARD_HEIGHT) {
		if(this.getPosition().getX() < 0 && this.getSpeed().getDX() < 0) {
			this.getSpeed().setDX(-1*this.getSpeed().getDX());
        }
        if(this.getPosition().getX()+this.getDimension().getWidth() > BOARD_WIDTH && this.getSpeed().getDX() > 0) {
        	this.getSpeed().setDX(-1*this.getSpeed().getDX());
        }
        if(this.getPosition().getY() < 0 && this.getSpeed().getDY() < 0) {
        	this.getSpeed().setDY(-1*this.getSpeed().getDY());
        }
        if(this.getPosition().getY()+this.getDimension().getHeight() > BOARD_HEIGHT && this.getSpeed().getDY() > 0) {
        	this.getSpeed().setDY(-1*this.getSpeed().getDY());
        }
        this.move();
	}
	
	/**
	 * prueft, ob sich das this- und that-Objekt beruehren
	 * 
	 * @param that das Objekt mit dem ueberprueft werden soll, ob es das this-Objekt beruehrt 
	 * 
	 * @return ob sich das this- und that-Objekt beruehren
	 * 
	 */
	@Override
	public boolean touches(GeometricObject that) {
		//ist that eine Kugel? (Nur Kugeln koennen sich im Spiel bewegen)
		if(that instanceof Ball) {
			//beruehren sich die Bounding Boxen der beiden Objekte?
			//AND beide Kugeln befinden sich nicht in schwarzen Loechern
			if(super.touches(that) && !this.getIsInBalckHole() && !((Ball)that).getIsInBalckHole()) {
				//Vektor zwischen den beiden Kugeln bestimmen
				Coordinate c = new Coordinate((this.getCenter().getX()+this.getSpeed().getDX())
						-(that.getCenter().getX()+that.getSpeed().getDX()),
						(this.getCenter().getY()+this.getSpeed().getDY())
						-(that.getCenter().getY()+that.getSpeed().getDY()));
				
				//Distanz/Betrag des Vektors bestimmen
				double d = Math.sqrt(c.getX()*c.getX()+c.getY()*c.getY());
				
				//WENN Distanz < Radius der beiden Kugeln miteinander addiert
				if(d < this.getRadius()+((Ball)that).getRadius()){
					//DANN beruehren sich die beiden Kugeln
					return(true);
				}
				else {
					//ANSONSTEN beruehren sie sich nicht
					return(false);
				}
			}
			else {
				//Objekte beruehren sich nicht
				return(false);
			}
		}
		else {
			//Objekte beruehren sich nicht
			return(false);
		}
	}
	
	/**
	 * bewegt das Objekt um die im Speed-Vektor gespeicherte Geschwindigkeit in x- und y-Richtung
	 */
	@Override
	public void move() {
        this.getPosition().move(new Coordinate(
        			this.getSpeed().getDX(), this.getSpeed().getDY()));
    }
}
