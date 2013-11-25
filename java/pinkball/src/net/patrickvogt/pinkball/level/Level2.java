package net.patrickvogt.pinkball.level;

/*
 * Level2.java
 */

import java.awt.Color;







import net.patrickvogt.pinkball.geom.Ball;
import net.patrickvogt.pinkball.geom.BlackHole;
import net.patrickvogt.pinkball.geom.OutputHole;
import net.patrickvogt.pinkball.geom.PaintedLine;
import net.patrickvogt.pinkball.geom.SelectiveWall;
import net.patrickvogt.pinkball.vector.Dimension2D;

/**
 * implementiert das 2. Level bzw. fuellt die LevelContent-Liste mit den entsprechenden 
 * <code>GeometricObject</code>s
 * 
 * @author Patrick Vogt
 *
 */
public class Level2 extends Level {

	/**
	 * erzeugt die entsprechenden <code>GeometricObject</code>s fuer das 2.Level und fuegt
	 * diese der LevelContent-Liste hinzu
	 */
	public Level2() {
		Dimension2D d = this.getDefaultGridDimension();
		this.add(new OutputHole(this.getGridCoordinate(0, 0), d));
		PaintedLine pl =new PaintedLine();
		pl.addPoint(100, 100);
		pl.addPoint(500, 100);
		this.add(pl);
		for(int i=0; i<6; i++) {
			if(i%2==0) {
				this.add(new Ball(d));
			}
			else {
				this.add(new Ball(d, Color.ORANGE));
			}
		}
		for(int i=0; i<30; i=i+2) {
			if(i%4==0) {
				this.add(new SelectiveWall(this.getGridCoordinate(19, i), 
						this.getGridWidth()/2, 2*this.getGridWidth(), Color.BLUE));
			}
			else {
				this.add(new SelectiveWall(this.getGridCoordinate(20, i), 
						this.getGridWidth()/2, 2*this.getGridWidth(), Color.ORANGE));
			}
		}
		this.add(new SelectiveWall(this.getGridCoordinate(10, 10), 
                2*this.getGridWidth(), this.getGridWidth()/2, Color.ORANGE));
		this.add(new BlackHole(this.getGridCoordinate(36, 3), d, Color.ORANGE));
		this.add(new BlackHole(this.getGridCoordinate(36, 23), d, Color.BLUE));
	}
}