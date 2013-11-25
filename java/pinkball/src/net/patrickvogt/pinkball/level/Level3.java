package net.patrickvogt.pinkball.level;

/*
 * Level3.java
 */

import java.awt.Color;

import net.patrickvogt.pinkball.geom.Ball;
import net.patrickvogt.pinkball.geom.BlackHole;
import net.patrickvogt.pinkball.geom.BlowUpBlock;
import net.patrickvogt.pinkball.geom.OutputHole;
import net.patrickvogt.pinkball.geom.ShrinkingBlock;



/**
 * implementiert das 3. Level bzw. fuellt die LevelContent-Liste mit den entsprechenden 
 * <code>GeometricObject</code>s
 * 
 * @author Patrick Vogt
 *
 */
public class Level3 extends Level {

	/**
	 * erzeugt die entsprechenden <code>GeometricObject</code>s fuer das 3.Level und fuegt
	 * diese der LevelContent-Liste hinzu
	 */
	public Level3() {
		this.add(new OutputHole(this.getGridCoordinate(0, 0), 4*this.getGridWidth()));
		for(int i=0; i<3; i++) {
			this.add(new Ball(4.0f*this.getGridWidth()));
		}
		this.add(new BlowUpBlock(this.getGridCoordinate(16, 14), 2*this.getGridWidth(), Color.BLUE));
		this.add(new BlowUpBlock(this.getGridCoordinate(22, 14), 2*this.getGridWidth(), Color.BLUE));
		this.add(new ShrinkingBlock(this.getGridCoordinate(19, 11), 2*this.getGridWidth(), Color.BLUE));
		this.add(new ShrinkingBlock(this.getGridCoordinate(19, 17), 2*this.getGridWidth(), Color.BLUE));
		this.add(new BlackHole(this.getGridCoordinate(19, 14), 2*this.getGridWidth(), Color.BLUE));
	}
}