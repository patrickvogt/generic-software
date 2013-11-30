package net.patrickvogt.pinkball.main;

import javax.swing.UIManager;

import net.patrickvogt.pinkball.gui.Frame;

public final class Main
{
    public static final void main(final String[] __args)
    {
        try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(final Exception ex)
        {
            ex.printStackTrace();
        }

        new Frame().setVisible(true);
    }
}
