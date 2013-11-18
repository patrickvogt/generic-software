package net.patrickvogt.pinkball.level;

/*
 * Level4.java
 */

import java.awt.Color;

import net.patrickvogt.pinkball.geom.*;
import net.patrickvogt.pinkball.vector.Dimension2D;

/**
 * implementiert das 4. Level bzw. fuellt die LevelContent-Liste mit den entsprechenden 
 * <code>GeometricObject</code>s
 * 
 * @author Patrick Vogt
 *
 */
public class Level4 extends Level {

	/**
	 * erzeugt die entsprechenden <code>GeometricObject</code>s fuer das 4.Level und fuegt
	 * diese der LevelContent-Liste hinzu
	 */
	public Level4() {
		Dimension2D d = this.getDefaultGridDimension();
		this.add(new OutputHole(this.getGridCoordinate(0, 0), d));
		for(int i=0; i<5; i++) {
			this.add(new Ball(d));
		}
		for(int i=0; i<5; i++) {
			this.add(new Ball(d, Color.ORANGE));
		}
		this.add(new BrokenBlock(this.getGridCoordinate(31,1), d, Color.BLUE));
		this.add(new BrokenBlock(this.getGridCoordinate(31,3), d, Color.BLUE));
		this.add(new BrokenBlock(this.getGridCoordinate(31,5), d, Color.BLUE));
		this.add(new BrokenBlock(this.getGridCoordinate(33,1), d, Color.BLUE));
		this.add(new BrokenBlock(this.getGridCoordinate(35,1), d, Color.BLUE));
		this.add(new BrokenBlock(this.getGridCoordinate(35,3), d, Color.BLUE));
		this.add(new BrokenBlock(this.getGridCoordinate(35,5), d, Color.BLUE));
		this.add(new BrokenBlock(this.getGridCoordinate(33,1), d, Color.BLUE));
		this.add(new BrokenBlock(this.getGridCoordinate(33,5), d, Color.BLUE));
		this.add(new BlackHole(this.getGridCoordinate(33, 3), d, Color.ORANGE));
		this.add(new BrokenBlock(this.getGridCoordinate(31,24), d, Color.ORANGE));
		this.add(new BrokenBlock(this.getGridCoordinate(31,26), d, Color.ORANGE));
		this.add(new BrokenBlock(this.getGridCoordinate(31,28), d, Color.ORANGE));
		this.add(new BrokenBlock(this.getGridCoordinate(33,24), d, Color.ORANGE));
		this.add(new BrokenBlock(this.getGridCoordinate(35,24), d, Color.ORANGE));
		this.add(new BrokenBlock(this.getGridCoordinate(35,26), d, Color.ORANGE));
		this.add(new BrokenBlock(this.getGridCoordinate(35,28), d, Color.ORANGE));
		this.add(new BrokenBlock(this.getGridCoordinate(31,28), d, Color.ORANGE));
		this.add(new BrokenBlock(this.getGridCoordinate(33,28), d, Color.ORANGE));
		this.add(new BlackHole(this.getGridCoordinate(33, 26), d, Color.BLUE));
	}
}