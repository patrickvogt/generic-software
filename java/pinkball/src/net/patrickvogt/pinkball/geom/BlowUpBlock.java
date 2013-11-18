package net.patrickvogt.pinkball.geom;

/*
 * BlowUpBlock.java
 */

import java.awt.*;

import net.patrickvogt.pinkball.vector.*;

/**
 * implementiert einen Spielstein der alle Kugeln die darueberrollen aufblaest/vergroessert
 * 
 * @author Patrick Vogt
 *
 */
//BlowUpBlock ist eine Unterklasse von GeometricObject
public class BlowUpBlock extends GeometricObject {
	
	/**
	 * erzeugt eine neue Instanz von <code>BlowUpBlock</code>
	 * 
	 * @param _myPosition die Koordinate (der linken oberen Ecke) des zu erzeugenden Objekts
	 * 
	 * @param _myDimension die Dimension des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public BlowUpBlock(Coordinate _myPosition, Dimension2D _myDimension, Color _myColor) {
		//super-Konstruktor (von GeometricObject) aufrufen
		super(_myPosition, _myDimension, _myColor);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>BlowUpBlock</code>
	 * 
	 * @param _x die x-Position des zu erzeugenden Objekts
	 * 
	 * @param _y die y-Position des zu erzeugenden Objekts
	 * 
	 * @param _width die Weite (gleichzeitig Hoehe) des zu erzeugenden Objekts
	 * 
	 */
	public BlowUpBlock(double _x, double _y, double _width) {
		//oberen Konstruktor aufrufen
		this(new Coordinate(_x,_y), new Dimension2D(_width,_width), Color.GRAY);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>BlowUpBlock</code>
	 * 
	 * @param _myPosition die Koordinate des zu erzeugenden Objekts
	 * 
	 * @param _width die Weite (gleichzeitig Hoehe) des zu erzeugenden Objekts
	 * 
	 * @param _myColor die Farbe des zu erzeugenden Objekts
	 * 
	 */
	public BlowUpBlock(Coordinate _myPosition, double _width, Color _myColor) {
		//oberen Konstruktor aufrufen
		this(_myPosition, new Dimension2D(_width,_width), _myColor);
	}
	
	/**
	 * erzeugt eine neue Instanz von <code>BlowUpBlock</code>
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
	public BlowUpBlock(double _x, double _y, double _width, Color _myColor) {
		//oberen Konstruktor aufrufen
		this(new Coordinate(_x,_y), new Dimension2D(_width,_width), _myColor);
	}
	
	/**
	 * zeichnet das Objekt auf den uebergebenen Graphik-Kontext
	 * 
	 * @param g der Graphik-Kontext, auf dem das Objekt gezeichnet werden soll
	 * 
	 */
	@Override
	public void paintMeTo(Graphics g) {
		//farbiges Quadrat zeichnen
		g.setColor(this.getColor());
		g.fillRect((int) this.getPosition().getX(), (int) this.getPosition().getY(), 
				(int) this.getDimension().getWidth(), (int) this.getDimension().getHeight());
		//weissen Kreis zeichnen
		g.setColor(Color.WHITE);
		g.fillOval((int) this.getPosition().getX(), (int) this.getPosition().getY(), 
				(int) this.getDimension().getWidth()+1, (int) this.getDimension().getHeight()+1);
		//Konturen des Kreis und des Quadrats zeichnen
		g.setColor(Color.BLACK);
		g.drawOval((int) this.getPosition().getX(), (int) this.getPosition().getY(), 
				(int) this.getDimension().getWidth(), (int) this.getDimension().getHeight());
		g.drawRect((int) this.getPosition().getX(), (int) this.getPosition().getY(), 
				(int) this.getDimension().getWidth(), (int) this.getDimension().getHeight());
	}
	
	/**
	 * reagiert auf eine Kollision zwischen <code>BlowUpBlock</code> und Kugel
	 * 
	 * @param that das Objekt, welches das this-Objekt beruehrt
	 * 
	 */
	@Override
	public void handleCollision(GeometricObject that) {
		//ist that eine Kugel? (Nur Kugeln koennen sich im Spiel bewegen)
		if(that instanceof Ball) {
			//entspricht die Farbe des BlowUpBlock der Farbe der Kugel?
			if(this.getColor()==Color.GRAY || this.getColor()==that.getColor()) {
				//ist die Kugel kleiner als ein bestimmer Wert?
				//(das anderthalbfache des BlowUpBlocks)
				if(((Ball)that).getDiameter()<1.5*this.getDimension().getWidth()) {
					//WENN ja DANN vergoessere den Durchmesser der Kugel
					((Ball)that).setDiameter(((Ball)that).getDiameter()*1.01);
				}
			}
		}
	}
}
