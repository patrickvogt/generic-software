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
import net.patrickvogt.pinkball.geom.ShrinkBlock;
import net.patrickvogt.pinkball.geom.SolidBlock;

public final class ImagePainter extends AbstractPainter
{   protected static IPainter _instance = null;
    private BufferedImage _blue_ball_img = null;
    
    private ImagePainter()
    {
        super();
        
        try {
            this._blue_ball_img = ImageIO.read(this.getClass().getResourceAsStream("/images/ball.jpg"));  
        } catch (final Exception ex) {
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
    public final void setGraphicsContext(final Graphics __g)
    {
        this._g = __g;
    }
    
    @Override
    public final void paint(final Ball __b)
    {
        final Color c = __b.getColor();
        
        if(Color.blue == c)
        {
            this._g.drawImage(this._blue_ball_img, __b.getXAsInt(), __b.getYAsInt(), 
                    __b.getWidthAsInt(), __b.getHeightAsInt(), null);
        }
        
    }

    @Override
    public final void paint(final BlackHole __bh)
    {
       
    }

    @Override
    public final void paint(final BlowUpBlock __bub)
    {

    }

    @Override
    public final void paint(final BrokenBlock __bb)
    {
 
    }

    @Override
    public final void paint(final OutputHole __oh)
    {

    }

    @Override
    public final void paint(final PaintedLine __pl)
    {
        final int numPoints = __pl.getNumPoints();
        final int[] xPoints = new int[numPoints];
        final int[] yPoints = new int[numPoints];
        final Graphics2D g2d = ((Graphics2D)this._g);
        final Stroke s = g2d.getStroke();
        
        __pl.getPointsAsIntArrays(xPoints, yPoints);
       
        this._g.setColor(Color.black);
        g2d.setStroke(new BasicStroke(4.0f));
        this._g.drawPolyline(xPoints, yPoints, (xPoints.length > yPoints.length) ? yPoints.length : xPoints.length);
        g2d.setStroke(s);
    }

    @Override
    public final void paint(final SelectiveWall __sw)
    {

    }

    @Override
    public final void paint(final ShrinkBlock __sb)
    {

    }

    @Override
    public final void paint(final SolidBlock __sb)
    {

    }

}
