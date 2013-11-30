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

public interface IPainter
{
    public void setGraphicsContext(final Graphics __g);
    public void paint(final Ball __b);
    public void paint(final BlackHole __bh);
    public void paint(final BlowUpBlock __bub);
    public void paint(final BrokenBlock __bb);
    public void paint(final OutputHole __oh);
    public void paint(final PaintedLine __pl);
    public void paint(final SelectiveWall __sw);
    public void paint(final ShrinkBlock __sb);
    public void paint(final SolidBlock __sb);
}
