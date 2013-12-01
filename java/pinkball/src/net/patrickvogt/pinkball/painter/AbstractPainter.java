package net.patrickvogt.pinkball.painter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import net.patrickvogt.pinkball.util.Settings;

public abstract class AbstractPainter implements IPainter
{
    protected Graphics _g = null;
    
    @Override
    public void toggleAntiAliasing()
    {
        Settings.antiAliasingEnabled = !Settings.antiAliasingEnabled;
    }

    @Override
    public void applyAntiAliasing()
    {
        final Object antiAliasingSetting = 
                Settings.antiAliasingEnabled ? RenderingHints.VALUE_ANTIALIAS_ON
                : RenderingHints.VALUE_ANTIALIAS_OFF;

        ((Graphics2D) this._g).setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                antiAliasingSetting);
    }
}
