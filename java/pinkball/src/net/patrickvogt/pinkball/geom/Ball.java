package net.patrickvogt.pinkball.geom;

import java.awt.Color;

import net.patrickvogt.pinkball.painter.IPainter;
import net.patrickvogt.pinkball.util.Moveable;
import net.patrickvogt.pinkball.vector.Coordinate;
import net.patrickvogt.pinkball.vector.Dimension2D;
import net.patrickvogt.pinkball.vector.Speed;

/*
 * Ball.java
 */


/**
 * implementiert eine farbige Kugel, die sich auf dem Spielfeld bewegen und mit anderen
 * Objekten kollidieren kann
 * 
 * @author Patrick Vogt
 *
 */
//Ball ist eine Unterklasse von GeometricObject
public class Ball extends GeometricObject implements Moveable {
	
	/**
	 * Kontante, welche die maximale Geschwindigkeit (x- und y-Richtung) einer Kugel beschreibt, um zu
	 * verhindern, dass die Kugel zu schnell wird
	 */
	private final float maxSpeed=1.0f;
	
	/**
	 * Konstante, die beschreibt, wie stark eine zu schnelle Kugel abgebremst werden soll
	 */
	private final float brakeConst=0.4f;
	
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
		this.mySpeed=new Speed((float)(Math.random()*maxSpeed), (float)(Math.random()*maxSpeed));
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>Ball</code>
	 * 
	 * @param _diameter der Durchmesser des zu erzeugenden Objekts
	 * 
	 */
	public Ball(float _diameter) {
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
	public Ball(float _diameter, Color _myColor) {
		//oberen Konstruktor aufrufen
		this(new Dimension2D(_diameter,_diameter), _myColor);
	}
	
	/**
	 * Zugriffsmethode um den Durchmesser des Objekts zu bekommen
	 * 
	 * @return Durchmesser des Objekts
	 * 
	 */
	public float getDiameter() {
		return(this.getDimension().getWidth());
	}
	
	/**
	 * Zugriffsmethode um den Durchmesser des Objekts auf einen gegebenen Wert zu setzen
	 * 
	 * @param _diameter neuer Durchmesser des Objekts
	 * 
	 */
	public void setDiameter(float _diameter) {
		this.setDimension(new Dimension2D(_diameter, _diameter));
	}
	
	/**
	 * Zugriffsmethode um den aktuellen Radius des Objekts zu bekommen
	 * 
	 * @return Radius des Objekts
	 * 
	 */
	public float getRadius() {
		//Radius anhand der getDiameter-Methode bekommen/zurueckgeben
		//Radius ist der halbe Durchmesser
		return(this.getDiameter()/2);
	}
	
	@Override
	public boolean hasWithin(Coordinate p) {
	    final float xx = p.getX() - this.getCenter().getX();
	    final float yy = p.getY() - this.getCenter().getY();
	    final float rr = this.getRadius();
	    
	    if(super.hasWithin(p))
	    {
	        return xx*xx+yy*yy <= rr*rr;
	    }
	    return false;
	}
	
	/**
	 * Zugriffsmethode um den Radius auf einen gegebenen Wert zu setzen
	 * 
	 * @param _radius neuer Radius des aktuellen Objekts
	 * 
	 */
	public void setRadius(float _radius) {
		//Radius anhand der setDiameter-Methode setzen
		//Durchmesser ist 2*Radius
		this.setDiameter(2.0f*_radius);
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
	
	public void paint(IPainter p)
	{
	    p.paint(this);
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
//			//Kollision zwischen zwei Kugeln
//			//Adaption von 'Kollision zweier Kugeln 2D' -> http://www.softgames.de/forum/frage119566.html
//			//Winkel zwischen den beiden Kugeln
//			double w;
//			//Kraftbetrag
//			double f=Math.sqrt((this.getSpeed().getDX()*this.getSpeed().getDX())
//					+this.getSpeed().getDY()*this.getSpeed().getDY())*this.getArea(); 
//			if(this.getSpeed().getDX()==0) {
//				w=Math.PI/2;
//			} 
//			else { 
//				w=Math.atan2(this.getSpeed().getDY(),this.getSpeed().getDX());
//			} 
//			if (this.getSpeed().getDX()<0) {
//				w=13*Math.PI/8+w;
//			} 
//			//neue Geschwindigkeit von this-Kugel und that-Kugel setzen
//			this.getSpeed().setDX((float)(f/this.getArea()*Math.cos(w+Math.PI))); 
//			this.getSpeed().setDY((float)(f/this.getArea()*Math.sin(w+Math.PI))); 
//			that.getSpeed().setDX((float)(that.getSpeed().getDX()+f/((Ball)that).getArea()*Math.cos(w))); 
//			that.getSpeed().setDY((float)(that.getSpeed().getDY()+f/((Ball)that).getArea()*Math.sin(w))); 
//			
//			//beide Kugeln ein Schritt weiterbewegen
//			this.move();
//			((Ball)that).move();
//			
//			//verhindern, dass die Geschwindigkeit beider Kugeln zu gross wird
//			while(this.maxSpeed>1-this.brakeConst && this.getSpeed().getDX()>this.maxSpeed 
//					|| this.maxSpeed>1-this.brakeConst && this.getSpeed().getDY()>this.maxSpeed) {
//				this.getSpeed().setDX(this.getSpeed().getDX()/(this.maxSpeed+this.brakeConst));
//				this.getSpeed().setDY(this.getSpeed().getDY()/(this.maxSpeed+this.brakeConst));
//			}
//			while(this.maxSpeed>1-this.brakeConst && that.getSpeed().getDX()>this.maxSpeed 
//					|| this.maxSpeed>1-this.brakeConst && that.getSpeed().getDY()>this.maxSpeed) {
//				that.getSpeed().setDX(that.getSpeed().getDX()/(this.maxSpeed+this.brakeConst));
//				that.getSpeed().setDY(that.getSpeed().getDY()/(this.maxSpeed+this.brakeConst));
//			}
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
				double dist = Math.sqrt(c.getX()*c.getX()+c.getY()*c.getY());
				
				//WENN Distanz < Radius der beiden Kugeln miteinander addiert
				if(dist <= this.getRadius()+((Ball)that).getRadius()){
					//DANN beruehren sich die beiden Kugeln
				    
				    //http://stackoverflow.com/questions/345838/ball-to-ball-collision-detection-and-handling
			        // get the mtd
//			        Vector2d delta = (position.subtract(ball.position));
//			        float r = getRadius() + ball.getRadius();
//			        float dist2 = delta.dot(delta);
//
//			        if (dist2 > r*r) return; // they aren't colliding


			        float d = c.length();

			        Coordinate mtd = new Coordinate(c);
			        if (d != 0.0f)
			        {
		            mtd.mult((float)(((getRadius() + ((Ball) that).getRadius())-d)/d)); // minimum translation distance to push balls apart after intersecting
			        }
//			        else // Special case. Balls are exactly on top of eachother.  Don't want to divide by zero.
//			        {
//			            d = ball.getRadius() + getRadius() - 1.0f;
//			            delta = new Vector2d(ball.getRadius() + getRadius(), 0.0f);
//
//			            mtd = delta.multiply(((getRadius() + ball.getRadius())-d)/d);
//			        }

			        // resolve intersection
			        double im1 = 1 / this.getArea(); // inverse mass quantities
			        double im2 = 1 / ((Ball) that).getArea();

//			        // push-pull them apart
//			        position = position.add(mtd.multiply(im1 / (im1 + im2)));
//			        ball.position = ball.position.subtract(mtd.multiply(im2 / (im1 + im2)));

			        // impact speed
			        Speed v = new Speed(this.getSpeed());
			        v.sub(that.getSpeed());
			        Coordinate mtd_n = new Coordinate(mtd);
			        mtd_n.normalize();
			        float vn = v.dot(mtd_n);

			        // sphere intersecting but moving away from each other already
			        if (vn > 0.0f) return true;
			        float restitution = 1;

			        // collision impulse
			        float i = (float)((-(1.0f + restitution) * vn) / (im1 + im2));
			        Coordinate impulse= new Coordinate(mtd_n);
			        impulse.mult(i);
			        
			        Speed this_speed_new = new Speed(this.getSpeed());
			        Speed this_speed_add = new Speed(impulse);
			        this_speed_add.mult((float)im1);
			        this_speed_new.add(this_speed_add);
			        
			        //Impuls ausschalten
			        this_speed_new.normalize();
			        this_speed_new.mult(this.getSpeed().length());
			        this.setSpeed(this_speed_new);
			        
			        
			        Speed that_speed_new = new Speed(that.getSpeed());
                    Speed that_speed_sub = new Speed(impulse);
                    that_speed_sub.mult((float)im2);
                    that_speed_new.sub(that_speed_sub);
                    
                    // impuls ausschalten
                    that_speed_new.normalize();
                    that_speed_new.mult(that.getSpeed().length());
                    that.setSpeed(that_speed_new);

	
					return true;
				}
			}
		}
		return false;
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
