package net.patrickvogt.pinkball.painter;

import java.awt.Graphics;

import net.patrickvogt.pinkball.geom.Ball;
import net.patrickvogt.pinkball.geom.BlackHole;
import net.patrickvogt.pinkball.geom.BlowUpBlock;
import net.patrickvogt.pinkball.geom.BrokenBlock;
import net.patrickvogt.pinkball.geom.OutputHole;
import net.patrickvogt.pinkball.geom.PaintedLine;
import net.patrickvogt.pinkball.geom.SelectiveWall;
import net.patrickvogt.pinkball.geom.ShrinkingBlock;
import net.patrickvogt.pinkball.geom.SolidBlock;

public final class WireFramePainter implements IPainter
{
    private static IPainter _instance = null;
    private Graphics _g = null;
    
    private WireFramePainter()
    {
        
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
    public final void setGraphicsContext(final Graphics _g)
    {
        this._g = _g;
    }
    
    @Override
    public final void paint(final Ball b)
    {
        this._g.drawOval(0, 0, 10, 10);
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
