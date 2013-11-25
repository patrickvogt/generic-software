package net.patrickvogt.pinkball.level;

/*
 * Demo.java
 */

import java.awt.Color;







import net.patrickvogt.pinkball.geom.Ball;
import net.patrickvogt.pinkball.geom.OutputHole;
import net.patrickvogt.pinkball.geom.PaintedLine;
import net.patrickvogt.pinkball.vector.Coordinate;
import net.patrickvogt.pinkball.vector.Dimension2D;
import net.patrickvogt.pinkball.vector.Speed;

/**
 * implementiert ein kleinen Test-Level fuer die Kollision von mehreren Kugeln
 * 
 * @author Patrick Vogt
 *
 */
public class DebugLevel extends Level {

	/**
	 * erzeugt 20 Kugeln (10 blaue und 10 orange) und fuegt diese der Liste fuer den LevelContent hinzu 
	 */
	public DebugLevel() {
		Dimension2D d = this.getDefaultGridDimension();
		
		// Ball rollt direkt auf ein Linienende zu
		Ball b1 = new Ball(40);
		b1.setPosition(new Coordinate(180,50));
		b1.setSpeed(new Speed(0.0f,0.05f));
		this.add(b1);
		
		PaintedLine pl = new PaintedLine();
		pl.addPoint(200, (int)(100+b1.getRadius()));
		pl.addPoint(600, (int)(100+b1.getRadius()));
		this.add(pl);
		
//		// Kugel rolle naufeinander zu 
//        Ball b2 = new Ball(40);
//        b2.setPosition(new Coordinate(200,200));
//        b2.setSpeed(new Speed(0.1f,0));
//        this.add(b2);
//        
//        Ball b3 = new Ball(40);
//        b3.setPosition(new Coordinate(300,200));
//        b3.setSpeed(new Speed(-0.1f,0));
//        this.add(b3);
//        
//        Ball b4 = new Ball(40);
//        b4.setPosition(new Coordinate(400,400));
//        b4.setSpeed(new Speed(0.1f,0.1f));
//        this.add(b4);
//        
//        Ball b5 = new Ball(40);
//        b5.setPosition(new Coordinate(500,500));
//        b5.setSpeed(new Speed(-0.1f,-0.1f));
//        this.add(b5);
//        
//        Ball b6 = new Ball(40);
//        b6.setPosition(new Coordinate(600,150));
//        b6.setSpeed(new Speed(0,0.1f));
//        this.add(b6);
//        
//        Ball b7 = new Ball(40);
//        b7.setPosition(new Coordinate(500,300));
//        b7.setSpeed(new Speed(0.1f,-0.1f));
//        this.add(b7);
        
//     // Ball rollt direkt auf ein Linienende zu
//        Ball b8 = new Ball(40);
//        b8.setPosition(new Coordinate(200,50));
//        b8.setSpeed(new Speed(0,0.1f));
//        this.add(b8);
//        
//     // Ball rollt direkt auf ein Linienende zu
//        Ball b9 = new Ball(40);
//        b9.setPosition(new Coordinate(300,50));
//        b9.setSpeed(new Speed(0.1f,0.1f));
//        this.add(b9);
	}
}
