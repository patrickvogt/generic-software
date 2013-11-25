package net.patrickvogt.pinkball.painter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import net.patrickvogt.pinkball.geom.Ball;
import net.patrickvogt.pinkball.geom.BlackHole;
import net.patrickvogt.pinkball.geom.BlowUpBlock;
import net.patrickvogt.pinkball.geom.BrokenBlock;
import net.patrickvogt.pinkball.geom.OutputHole;
import net.patrickvogt.pinkball.geom.PaintedLine;
import net.patrickvogt.pinkball.geom.SelectiveWall;
import net.patrickvogt.pinkball.geom.ShrinkingBlock;
import net.patrickvogt.pinkball.geom.SolidBlock;

public final class ImagePainter implements IPainter
{   
    private static IPainter _instance = null;
    private Graphics _g = null;
    
    private BufferedImage _blue_ball_img = null;
    
    private ImagePainter()
    {
        try {
            this._blue_ball_img = ImageIO.read(this.getClass().getResourceAsStream("/images/ball.jpg"));  
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static final IPainter getInstance()
    {
        if(null == ImagePainter._instance)
        {
            ImagePainter._instance = new ImagePainter();
        }
        return ImagePainter._instance;
    }
    
    @Override
    public final void setGraphicsContext(final Graphics _g)
    {
        this._g = _g;
    }
    
    @Override
    public final void paint(final Ball b)
    {
        final Color c = b.getColor();
        
        if(Color.blue == c)
        {
            this._g.drawImage(this._blue_ball_img, b.getPosition().getXAsInt(), b.getPosition().getYAsInt(), 
                    b.getDimension().getWidthAsInt(), b.getDimension().getHeightAsInt(), 
                    null);
        }
        
    }

    @Override
    public final void paint(final BlackHole bh)
    {
       
    }

    @Override
    public final void paint(final BlowUpBlock bub)
    {

    }

    @Override
    public final void paint(final BrokenBlock bb)
    {
 
    }

    @Override
    public final void paint(final OutputHole oh)
    {

    }

    @Override
    public final void paint(final PaintedLine pl)
    {
        final int numPoints = pl.getNumPoints();
        final int[] xPoints = new int[numPoints];
        final int[] yPoints = new int[numPoints];
        final Graphics2D g2d = ((java.awt.Graphics2D)this._g);
        final Stroke s = g2d.getStroke();
        
        pl.getPoints(xPoints, yPoints);
       
        this._g.setColor(Color.black);
        g2d.setStroke(new BasicStroke(4.0f));
        this._g.drawPolyline(xPoints, yPoints, (xPoints.length > yPoints.length) ? yPoints.length : xPoints.length);
        g2d.setStroke(s);
    }

    @Override
    public final void paint(final SelectiveWall sw)
    {

    }

    @Override
    public final void paint(final ShrinkingBlock sb)
    {

    }

    @Override
    public final void paint(final SolidBlock sb)
    {

    }

}
