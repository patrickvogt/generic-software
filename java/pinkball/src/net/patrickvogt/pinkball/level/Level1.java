package net.patrickvogt.pinkball.level;

/*
 * Level1.java
 */

import java.awt.Color;

import net.patrickvogt.pinkball.geom.*;
import net.patrickvogt.pinkball.vector.Dimension2D;

/**
 * implementiert das 1. Level bzw. fuellt die LevelContent-Liste mit den entsprechenden 
 * <code>GeometricObject</code>s
 * 
 * @author Patrick Vogt
 *
 */
public class Level1 extends Level {

	/**
	 * erzeugt die entsprechenden <code>GeometricObject</code>s fuer das 1.Level und fuegt
	 * diese der LevelContent-Liste hinzu
	 */
	public Level1() {
		Dimension2D d = this.getDefaultGridDimension();
		this.add(new OutputHole(this.getGridCoordinate(0, 0), d));
		for(int i=0; i<6; i++) {
			//jeder 2. Kugel soll Blau sein
			if(i%2==0) {
				this.add(new Ball(d));
			}
			else {
				this.add(new Ball(d, Color.ORANGE));
			}
		}
		this.add(new BlackHole(this.getGridCoordinate(36, 6), d, Color.ORANGE));
		this.add(new BlackHole(this.getGridCoordinate(36, 23), d, Color.BLUE));
	}
}
