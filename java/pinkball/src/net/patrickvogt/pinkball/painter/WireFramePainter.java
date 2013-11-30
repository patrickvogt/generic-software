package net.patrickvogt.pinkball.painter;

import java.awt.Graphics;

import net.patrickvogt.pinkball.geom.Ball;
import net.patrickvogt.pinkball.geom.BlackHole;
import net.patrickvogt.pinkball.geom.BlowUpBlock;
import net.patrickvogt.pinkball.geom.BrokenBlock;
import net.patrickvogt.pinkball.geom.OutputHole;
import net.patrickvogt.pinkball.geom.PaintedLine;
import net.patrickvogt.pinkball.geom.SelectiveWall;
import net.patrickvogt.pinkball.geom.ShrinkBlock;
import net.patrickvogt.pinkball.geom.SolidBlock;

public final class WireFramePainter implements IPainter
{
    private static IPainter _instance = null;
    private Graphics _g = null;
    
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
        this._g.drawOval(0, 0, 10, 10);
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
