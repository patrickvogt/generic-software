package net.patrickvogt.pinkball.geom;

/*
 * BlackHole.java
 */

import java.awt.*;

import net.patrickvogt.pinkball.exceptions.*;
import net.patrickvogt.pinkball.vector.*;

/**
 * implementiert ein schwarzes Loch, welches die Kugeln verschwinden lassen kann bzw. verschlucken kann
 * 
 * @author Patrick Vogt
 *
 */
//BlackHole ist eine Unterklasse von GeometricObject
public class BlackHole extends GeometricObject {
	
	/**
	 * erzeugt eine neue Instanz von <code>BlackHole</code>
	 * 
	 * @param _myPosition die Koordinate (der linken oberen Ecke) des zu erzeugenden Objekts
	 * 
	 * @param _myDimension die Dimension des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public BlackHole(Coordinate _myPosition, Dimension2D _myDimension, Color _myColor) {
		//super-Konstruktor (von GeometricObject) aufrufen
		super(_myPosition, _myDimension, _myColor);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>BlackHole</code>
	 * 
	 * @param _myPosition die Koordinate des zu erzeugenden Objekts
	 * 
	 * @param _width die Weite (gleichzeitig Hoehe) des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public BlackHole(Coordinate _myPosition, double _width, Color _myColor) {
		//oberen Konstruktor aufrufen
		this(_myPosition, new Dimension2D(_width,_width), _myColor);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>BlackHole</code>
	 * 
	 * @param _x die x-Position des zu erzeugenden Objekts
	 * 
	 * @param _y die y-Position des zu erzeugenden Objekts
	 * 
	 * @param _width die Weite (gleichzeitig Hoehe) des zu erzeugenden Objekts
	 * 
	 */
	public BlackHole(double _x, double _y, double _width) {
		//oberen Kosntruktor aufrufen
		this(new Coordinate(_x,_y), new Dimension2D(_width,_width), Color.GRAY);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>BlackHole</code>
	 * 
	 * @param _x die x-Position des zu erzeugenden Objekts
	 * 
	 * @param _y die y-Position des zu erzeugenden Objekts
	 * 
	 * @param _width die Weite (gleichzeitig Hoehe) des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public BlackHole(double _x, double _y, double _width, Color _myColor) {
		//oberen Konstruktor aufrufen
		this(new Coordinate(_x,_y), new Dimension2D(_width,_width), _myColor);
	}
	
	/**
	 * zeichnet das Objekt auf dem uebergebenen Graphik-Kontext
	 * 
	 * @param g der Graphik-Kontext, auf dem das Objekt gezeichnet werden soll
	 * 
	 */
	@Override
	public void paintMeTo(Graphics g) {
		//farbiges Quadrat zeichnen
		g.setColor(this.getColor());
		g.fillRect((int) this.getPosition().getX()-2, (int) this.getPosition().getY()-2, 
				(int) this.getDimension().getWidth()+3, (int) this.getDimension().getHeight()+3); 
		//schwarzes Loch zeichnen
		g.setColor(Color.BLACK);
		g.fillOval((int) this.getPosition().getX(), (int) this.getPosition().getY(), 
				(int) this.getDimension().getWidth(), (int) this.getDimension().getHeight());
		//Kontur zeichnen
		g.drawRect((int) this.getPosition().getX()-2, (int) (int) this.getPosition().getY()-2, 
				(int) this.getDimension().getWidth()+3, (int) this.getDimension().getHeight()+3);
	}
	
	/**
	 * prueft, ob sich this- und that-Objekt beruehren
	 * 
	 * @param that das mit dem this-Objekt zu ueberprufende Objekt
	 * 
	 * @return ob sich this- und that-Objekt beruehren
	 * 
	 */
	@Override
	public boolean touches(GeometricObject that) {
		//ist that eine Kugel? (Nur Kugeln koennen sich im Spiel bewegen)
		if(that instanceof Ball) {
			//beruehren sich die BoundingBoxen der beiden Objekte?
			if(super.touches(that)) {
				//Vektor zwischen Kugel und BlackHole bestimmen
				Coordinate c = new Coordinate(this.getCenter().getX()-that.getCenter().getX(),
						this.getCenter().getY()-that.getCenter().getY());
				
				//Distanz bzw. Betrag des Vektors bestimmen
				double d = Math.sqrt(c.getX()*c.getX()+c.getY()*c.getY());
				
				//liegt die Kugel schon im Black Hole?
				if(d < 3*this.getDimension().getWidth()/8+that.getDimension().getWidth()/2) {
					//WENN ja DANN beruehren sich Kugel und BlackHole
					return(true);
				}
				else {
					//ANSONSTEN beruehren sie sich nicht
					return(false);
				}
			}
			else {
				//die beiden Objekte beruehren sich nicht
				return(false);
			}
		}
		else {
			//die beiden Objekte beruehren sich nicht
			return(false);
		}
	}
	
	/**
	 * reagiert auf eine Kollision zwischen <code>BlackHole</code> und <code>Ball</code>
	 * 
	 * @param that das Objekt, welches das this-Objekt beruehrt
	 * 
	 * @throws GameOverException wenn das Spiel verloren wurde
	 * 
	 * @throws DestroyThatException wenn die Kugel vom Spielfeld geloescht werden soll
	 */
	@Override
	public void handleCollision(GeometricObject that) 
		throws GameOverException, DestroyThatException {
		//ist that eine Kugel? (Nur Kugeln koennen sich im Spiel bewegen)
		//AND passt die Kugel ueberhauot in dieses schwarze Loch
		if(that instanceof Ball && this.getDimension().getWidth() >= that.getDimension().getWidth()) {
			//Attribut isInBlackHole in Kugel setzen, um zu verhindern, dass die Kugeln 
			//innerhalb des schwarzen Lochs abprallen
			if(!((Ball)that).getIsInBalckHole()) {
				((Ball)that).toggleIsInBlackHole();
			}
			//Kugel soll sich geradewegs zum Zentrum des schwarzen Lochs weiterbewegen
			//entsprechend die Geschwindigkeitsvektoren setzen
			that.getSpeed().setDX(-0.2*(that.getCenter().getX()-this.getCenter().getX()));
			that.getSpeed().setDY(-0.2*(that.getCenter().getY()-this.getCenter().getY()));
			
			//Durchmesser der Kugeln verkleinern -> Effekt, dass die Kugel eingezogen wird, sich wegbewegt
       		if(((Ball)that).getDiameter()>0.5*this.getDimension().getWidth()) {
				((Ball)that).setDiameter(((Ball)that).getDiameter()*0.9);
       		}
       		
       		//befindet sich die Kugel im Zentrum des schwarzen Lochs?
	       	if(that.getCenter().equals(this.getCenter())) {
	       		//entspricht die Farbe der Kugel nicht der Farbe des schwarzen Lochs
	       		
	       		//(Grau ist in diesem Spiel eine neutrale Farbe)
	       		//Graue Kugeln koennen in alle BlackHoles fallen und 
	       		//alle Kugeln koennen in graue BlackHoles fallen (dies gibt jedoch keine Punkte)
	       		if(this.getColor()!=Color.GRAY && that.getColor()!=Color.GRAY && that.getColor()!=this.getColor()) {
       				//Spiel zu Ende
	       			
	       			//werfe eine GameOverException
	       			throw new GameOverException();
       			}
       			else {
       				//sind weder Kugel noch BlackHole Grau? 
       				if(this.getColor()!=Color.GRAY && that.getColor()!=Color.GRAY) {
       					//dann werfe eine DestroyThatException
       					//that soll vom LevelInhalt geloescht werden (1. Argument)
       					//und der Score soll erhoeht werden (2.Argument)
       					throw new DestroyThatException(that, true);
       				}
       				else {
       					//entweder Kugel oder BlackHole waren Grau
       					
       					//dann werfe eine DestroyThatException
       					//that soll vom LevelInhalt geloescht werden (1. Argument)
       					//und der Score soll NICHT erhoeht werden (2.Argument)
       					throw new DestroyThatException(that, false);
       				}
       			}
	       	}
		}
	}
}
