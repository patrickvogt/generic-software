package net.patrickvogt.pinkball.main;

import javax.swing.UIManager;

import net.patrickvogt.pinkball.gui.Frame;

public final class Main
{
    public static final void main(final String[] args)
    {
        try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception ex)
        {
            
        }

        new Frame().setVisible(true);
    }
}
