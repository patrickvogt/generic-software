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

public interface IPainter
{
    public void setGraphicsContext(final Graphics _g);
    public void paint(final Ball b);
    public void paint(final BlackHole bh);
    public void paint(final BlowUpBlock bub);
    public void paint(final BrokenBlock bb);
    public void paint(final OutputHole oh);
    public void paint(final PaintedLine pl);
    public void paint(final SelectiveWall sw);
    public void paint(final ShrinkingBlock sb);
    public void paint(final SolidBlock sb);
}
