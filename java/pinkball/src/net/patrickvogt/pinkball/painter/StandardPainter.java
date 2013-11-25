package net.patrickvogt.pinkball.painter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import net.patrickvogt.pinkball.geom.Ball;
import net.patrickvogt.pinkball.geom.BlackHole;
import net.patrickvogt.pinkball.geom.BlowUpBlock;
import net.patrickvogt.pinkball.geom.BrokenBlock;
import net.patrickvogt.pinkball.geom.OutputHole;
import net.patrickvogt.pinkball.geom.PaintedLine;
import net.patrickvogt.pinkball.geom.SelectiveWall;
import net.patrickvogt.pinkball.geom.ShrinkingBlock;
import net.patrickvogt.pinkball.geom.SolidBlock;

public final class StandardPainter implements IPainter
{
    private static IPainter _instance = null;
    private Graphics _g = null;

    private StandardPainter()
    {

    }
    
    public final static IPainter getInstance()
    {
        if(null == StandardPainter._instance)
        {
            StandardPainter._instance = new StandardPainter();
        }
        return StandardPainter._instance;
    }
    
    @Override
    public final void setGraphicsContext(final Graphics _g)
    {
        this._g = _g;
    }

    @Override
    public final void paint(final Ball b)
    {
        final int x = b.getXAsInt();
        final int y = b.getYAsInt();
        final int width = b.getWidthAsInt();
        
        this._g.setColor(b.getColor());
        this._g.fillOval(x, y, width, width);
        this._g.setColor(Color.black);
        this._g.drawOval(x, y, width, width);
    }

    @Override
    public final void paint(final BlackHole bh)
    {
        final int one_padding = 2;
        final int two_padding = 2*one_padding;
        
        final int x = bh.getXAsInt();
        final int y = bh.getYAsInt();
        final int width = bh.getWidthAsInt();
        final int height = bh.getHeightAsInt();
        final int x_out = x-one_padding;
        final int y_out = y-one_padding;
        final int width_out = width+two_padding;
        final int height_out = height+two_padding;
        
        this._g.setColor(bh.getColor());
        this._g.fillRect(x_out, y_out, width_out, height_out);
        this._g.setColor(Color.black);
        this._g.drawRect(x_out, y_out, width_out, height_out);
        
        this._g.fillOval(x, y, width, height);
    }

    @Override
    public final void paint(final BlowUpBlock bub)
    {
        final int x = bub.getXAsInt();
        final int y = bub.getYAsInt();
        final int width = bub.getWidthAsInt();
        final int height = bub.getHeightAsInt();
        
        this._g.setColor(bub.getColor());
        this._g.fillRect(x, y, width, height);
        this._g.setColor(Color.white);
        this._g.fillOval(x, y, width, width);
        
        this._g.setColor(Color.black);
        this._g.drawRect(x, y, width, height);
        this._g.drawOval(x, y, width, width);
    }

    @Override
    public final void paint(final BrokenBlock bb)
    {
        final int x = bb.getXAsInt();
        final int y = bb.getYAsInt();
        final int width = bb.getWidthAsInt();
        final int height = bb.getHeightAsInt();
        
        final int x_left = x;
        final int x_right = x + width;
        final int y_top = y;
        final int y_bottom = y + height;
        
        final Color c = bb.getColor();
        final Color contour = (c == Color.black) ? Color.white : Color.black;
        
        this._g.setColor(c);
        this._g.fillRect(x, y, width, height);
        this._g.setColor(contour);
        this._g.drawRect(x, y, width, height);
        this._g.drawLine(x_left, y_top, x_right, y_bottom);
        this._g.drawLine(x_left, y_bottom, x_right, y_top);
    }

    @Override
    public final void paint(final OutputHole oh)
    {
        final int x = oh.getXAsInt();
        final int y = oh.getYAsInt();
        final int width = oh.getWidthAsInt();
        final int height = oh.getHeightAsInt();
        
        final int diameter = width/4;
        final int x_left = x + 1;
        final int x_right = x + width - diameter - 1;
        final int y_top = y + 1;
        final int y_bottom = y + height - diameter - 1;

        this._g.setColor(Color.gray);
        this._g.drawRect(x, y, width, height);
        
        this._g.setColor(oh.getColor());
        this._g.fillOval(x + width/4, y + width/4, width/2, width/2);
        
        this._g.setColor(Color.red);
        this._g.fillOval(x_left, y_top, diameter, diameter);
        this._g.fillOval(x_right, y_top, diameter, diameter);
        this._g.fillOval(x_left, y_bottom, diameter, diameter);
        this._g.fillOval(x_right, y_bottom, diameter, diameter);
        
//        this._g.setColor(Color.black);
//        this._g.drawOval(x_left, y_top, diameter, diameter);
//        this._g.drawOval(x_right, y_top, diameter, diameter);
//        this._g.drawOval(x_left, y_bottom, diameter, diameter);
//        this._g.drawOval(x_right, y_bottom, diameter, diameter);
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
        final int x = sw.getXAsInt();
        final int y = sw.getYAsInt();
        final int width = sw.getWidthAsInt();
        final int height = sw.getHeightAsInt();
        
        final int in_width = (width > height) ? (width/2) : width;
        final int in_height = (width > height) ? height : (height/2);
        final int in_x = (width > height) ? (x + width/4) : x;
        final int in_y = (width > height) ? y : (y + height/4);

        this._g.setColor(Color.gray);
        this._g.fillRect(x, y, width, height);
        
        this._g.setColor(sw.getColor());
        this._g.fillRect(in_x, in_y, in_width, in_height);
        
        this._g.setColor(Color.black);
        this._g.drawRect(x, y, width, height);
        this._g.drawRect(in_x, in_y, in_width, in_height);
    }

    @Override
    public final void paint(final ShrinkingBlock sb)
    {
        final int x = sb.getXAsInt();
        final int y = sb.getYAsInt();
        final int width = sb.getWidthAsInt();
        final int height = sb.getHeightAsInt();
        
        final int in_x = x + width/4;
        final int in_y = y + width/4;
        final int in_width = width/2;
        
        this._g.setColor(sb.getColor());
        this._g.fillRect(x, y, width, height);
        this._g.setColor(Color.white);
        this._g.fillOval(in_x, in_y, in_width, in_width);
        
        this._g.setColor(Color.black);
        this._g.drawRect(x, y, width, height);
        this._g.drawOval(in_x, in_y, in_width, in_width);
    }

    @Override
    public final void paint(final SolidBlock sb)
    {
        final int x = sb.getXAsInt();
        final int y = sb.getYAsInt();
        final int width = sb.getWidthAsInt();
        final int height = sb.getHeightAsInt();
        
        this._g.setColor(sb.getColor());
        this._g.fillRect(x, y, width, height);
        this._g.setColor(Color.black);
        this._g.drawRect(x, y, width, height);
    }

}
