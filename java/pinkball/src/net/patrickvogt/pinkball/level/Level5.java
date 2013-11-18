package net.patrickvogt.pinkball.level;

/*
 * Level5.java
 */

import java.awt.Color;

import net.patrickvogt.pinkball.geom.*;
import net.patrickvogt.pinkball.vector.Dimension2D;

/**
 * implementiert das 5. Level bzw. fuellt die LevelContent-Liste mit den entsprechenden 
 * <code>GeometricObject</code>s
 * 
 * @author Patrick Vogt
 *
 */
public class Level5 extends Level {

	/**
	 * erzeugt die entsprechenden <code>GeometricObject</code>s fuer das 5.Level und fuegt
	 * diese der LevelContent-Liste hinzu
	 */
	public Level5() {
		Dimension2D d = this.getDefaultGridDimension();
		this.add(new SolidBlock(this.getGridCoordinate(0, 0), d, Color.BLUE));
		this.add(new SolidBlock(this.getGridCoordinate(39, 0), d, Color.BLUE));
		this.add(new SolidBlock(this.getGridCoordinate(0, 29), d, Color.BLUE));
		this.add(new SolidBlock(this.getGridCoordinate(39, 29), d, Color.BLUE));
		this.add(new OutputHole(this.getGridCoordinate(0, 15), d));
		this.add(new BlackHole(this.getGridCoordinate(19, 14), 2*this.getGridWidth(), Color.BLUE));
		for(int i=0; i<4; i++) {
			this.add(new Ball(d));
		}
		for(int i=0; i<12; i++) {
			this.add(new SolidBlock(this.getGridCoordinate(18-i, 13-i), d, Color.ORANGE));
		}
		for(int i=0; i<12; i++) {
			this.add(new SolidBlock(this.getGridCoordinate(21+i, 16+i), d, Color.ORANGE));
		}
		for(int i=0; i<12; i++) {
			this.add(new SolidBlock(this.getGridCoordinate(18-i, 16+i), d, Color.ORANGE));
		}
		for(int i=0; i<12; i++) {
			this.add(new SolidBlock(this.getGridCoordinate(21+i, 13-i), d, Color.ORANGE));
		}
		this.add(new SolidBlock(this.getGridCoordinate(18, 15), d, Color.ORANGE));
		this.add(new SolidBlock(this.getGridCoordinate(18, 14), d, Color.ORANGE));
		this.add(new SolidBlock(this.getGridCoordinate(21, 14), d, Color.ORANGE));
		this.add(new SolidBlock(this.getGridCoordinate(21, 15), d, Color.ORANGE));
		this.add(new ShrinkingBlock(this.getGridCoordinate(5, 15), d, Color.BLUE));
		this.add(new ShrinkingBlock(this.getGridCoordinate(34, 15), d, Color.BLUE));
	}
}