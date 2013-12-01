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
import net.patrickvogt.pinkball.geom.ShrinkBlock;
import net.patrickvogt.pinkball.geom.SolidBlock;

public final class WireFramePainter extends AbstractPainter
{   protected static IPainter _instance = null;
    private WireFramePainter()
    {
        super();
    }
    
    public final static IPainter getInstance()
    {
        if(null == WireFramePainter._instance)
        {
            WireFramePainter._instance = new WireFramePainter();
        }
        return WireFramePainter._instance;
    }
    
    @Override
    public final void setGraphicsContext(final Graphics __g)
    {
        this._g = __g;
    }
    
    @Override
    public final void paint(final Ball __b)
    {
        final int x = __b.getXAsInt();
        final int y = __b.getYAsInt();
        final int width = __b.getWidthAsInt();

        this._g.setColor(__b.getColor());
        this._g.drawOval(x, y, width, width);
    }

    @Override
    public final void paint(final BlackHole __bh)
    {
        final int one_padding = 2;
        final int two_padding = 2 * one_padding;

        final int x = __bh.getXAsInt();
        final int y = __bh.getYAsInt();
        final int width = __bh.getWidthAsInt();
        final int height = __bh.getHeightAsInt();
        final int x_out = x - one_padding;
        final int y_out = y - one_padding;
        final int width_out = width + two_padding;
        final int height_out = height + two_padding;

        this._g.setColor(__bh.getColor());
        this._g.drawRect(x_out, y_out, width_out, height_out);
        this._g.setColor(Color.black);
        this._g.drawOval(x, y, width, height);
    }

    @Override
    public final void paint(final BlowUpBlock __bub)
    {
        final int x = __bub.getXAsInt();
        final int y = __bub.getYAsInt();
        final int width = __bub.getWidthAsInt();
        final int height = __bub.getHeightAsInt();

        this._g.setColor(__bub.getColor());
        this._g.drawRect(x, y, width, height);
        this._g.setColor(Color.white);
        this._g.drawOval(x, y, width, width);
    }

    @Override
    public final void paint(final BrokenBlock __bb)
    {
        final int x = __bb.getXAsInt();
        final int y = __bb.getYAsInt();
        final int width = __bb.getWidthAsInt();
        final int height = __bb.getHeightAsInt();

        final int x_left = x;
        final int x_right = x + width;
        final int y_top = y;
        final int y_bottom = y + height;

        final Color c = __bb.getColor();
        final Color contour = (c == Color.black) ? Color.white : Color.black;

        this._g.setColor(c);
        this._g.drawRect(x, y, width, height);
        this._g.setColor(contour);
        this._g.drawLine(x_left, y_top, x_right, y_bottom);
        this._g.drawLine(x_left, y_bottom, x_right, y_top);
    }

    @Override
    public final void paint(final OutputHole __oh)
    {
        final int x = __oh.getXAsInt();
        final int y = __oh.getYAsInt();
        final int width = __oh.getWidthAsInt();
        final int height = __oh.getHeightAsInt();

        final int diameter = width / 4;
        final int x_left = x + 1;
        final int x_right = x + width - diameter - 1;
        final int y_top = y + 1;
        final int y_bottom = y + height - diameter - 1;

        this._g.setColor(Color.gray);
        this._g.drawRect(x, y, width, height);

        this._g.setColor(__oh.getColor());
        this._g.drawOval(x + width / 4, y + width / 4, width / 2, width / 2);

        this._g.setColor(Color.black);
        this._g.drawRect(x_left+diameter/2, y_top+diameter/2, x_right-x_left, y_bottom-y_top);
        this._g.setColor(Color.red);
        this._g.drawOval(x_left, y_top, diameter, diameter);
        this._g.drawOval(x_right, y_top, diameter, diameter);
        this._g.drawOval(x_left, y_bottom, diameter, diameter);
        this._g.drawOval(x_right, y_bottom, diameter, diameter);
    }

    @Override
    public final void paint(final PaintedLine __pl)
    {
        final int numPoints = __pl.getNumPoints();
        final int[] xPoints = new int[numPoints];
        final int[] yPoints = new int[numPoints];
        final Graphics2D g2d = ((java.awt.Graphics2D) this._g);
        final Stroke s = g2d.getStroke();

        __pl.getPointsAsIntArrays(xPoints, yPoints);

        this._g.setColor(Color.black);
        g2d.setStroke(new BasicStroke(2.0f));
        this._g.drawPolyline(xPoints, yPoints,
                (xPoints.length > yPoints.length) ? yPoints.length
                        : xPoints.length);
        g2d.setStroke(s);
    }

    @Override
    public final void paint(final SelectiveWall __sw)
    {
        final int x = __sw.getXAsInt();
        final int y = __sw.getYAsInt();
        final int width = __sw.getWidthAsInt();
        final int height = __sw.getHeightAsInt();

        final int in_width = (width > height) ? (width / 2) : width;
        final int in_height = (width > height) ? height : (height / 2);
        final int in_x = (width > height) ? (x + width / 4) : x;
        final int in_y = (width > height) ? y : (y + height / 4);

        this._g.setColor(Color.darkGray);
        this._g.drawRect(x, y, width, height);

        this._g.setColor(__sw.getColor());
        this._g.drawRect(in_x, in_y, in_width, in_height);
    }

    @Override
    public final void paint(final ShrinkBlock __sb)
    {
        final int x = __sb.getXAsInt();
        final int y = __sb.getYAsInt();
        final int width = __sb.getWidthAsInt();
        final int height = __sb.getHeightAsInt();

        final int in_x = x + width / 4;
        final int in_y = y + width / 4;
        final int in_width = width / 2;

        this._g.setColor(__sb.getColor());
        this._g.drawRect(x, y, width, height);
        this._g.setColor(Color.white);
        this._g.drawOval(in_x, in_y, in_width, in_width);
    }

    @Override
    public final void paint(final SolidBlock __sb)
    {
        final int x = __sb.getXAsInt();
        final int y = __sb.getYAsInt();
        final int width = __sb.getWidthAsInt();
        final int height = __sb.getHeightAsInt();

        this._g.setColor(__sb.getColor());
        this._g.drawRect(x, y, width, height);
    }

}
