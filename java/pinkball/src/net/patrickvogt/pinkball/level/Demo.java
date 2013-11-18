package net.patrickvogt.pinkball.level;

/*
 * Demo.java
 */

import java.awt.Color;

import net.patrickvogt.pinkball.geom.*;
import net.patrickvogt.pinkball.vector.Dimension2D;

/**
 * implementiert ein kleinen Test-Level fuer die Kollision von mehreren Kugeln
 * 
 * @author Patrick Vogt
 *
 */
public class Demo extends Level {

	/**
	 * erzeugt 20 Kugeln (10 blaue und 10 orange) und fuegt diese der Liste fuer den LevelContent hinzu 
	 */
	public Demo() {
		Dimension2D d = this.getDefaultGridDimension();
		this.add(new OutputHole(this.getGridCoordinate(0, 0), d));
		for(int i=0; i<20; i++) {
			//jede 2. Kugel soll Blau sein (Blau ist die DefaultFarbe einer Kugel)
			if(i%2==0) {
				this.add(new Ball(d));
			}
			else {
				this.add(new Ball(d, Color.ORANGE));
			}
		}
	}
}
