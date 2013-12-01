package net.patrickvogt.pinkball.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.patrickvogt.pinkball.excpetion.GameOverException;
import net.patrickvogt.pinkball.util.Constants;
import net.patrickvogt.pinkball.util.PropertiesProvider;

public class Frame extends JFrame
{
    private static final long serialVersionUID = 1L;

    private Board _board = null;
    private javax.swing.Timer _timer = null;

    public Frame()
    {
        // Kontruktor der Oberklasse mit dem String der HeadLeiste aufrufen
        super("PInkBall");
        // FrameContent (Level, Board, Timer, Score) intialisieren
        this._board = new Board();

        // this.hud = new HeadUpDisplay(this.WIDTH+2*this.borderStoneWidth,
        // this.borderStoneWidth, this.delay);

        // Neuen timer erzeugen mit dem angegeben Delay (in ms) und dem
        // folgenden AcionListener
        this.newTimer();
        
        // fuege dem Frame meine MenueLeiste hinzu
        this.setJMenuBar(new MenuBar(this, this._board));

        this.add(this._board);

        // Groesse soll nicht veraenderbar sein
        this.setResizable(false);
        // Klick auf das X rechts oben soll das Programm beenden
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Frame soll fokusierbar sein -> wichtig bpsw. fuer die Reaktion auf
        // Tastendrucks
        this.setFocusable(true);
        
        this.init();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width / 2 - this.getSize().width / 2,
                screenSize.height / 2 - this.getSize().height / 2);
    }

    public void newTimer()
    {
        if(null!=this._timer)
        {
            this._timer.stop();
            this._timer = null;
        }
        
        this._timer = new javax.swing.Timer(Constants.TIMER_DELAY,
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                        // System.out.println("hallo");

                        // Board bzw. dessen Inhalt auf Kollision pruefen
                        try
                        {
                            _board.gameLoop();
                        }
                        catch(final GameOverException ex)
                        {
                            if(null!=Frame.this._timer)
                            {
                            // beende das Spiel
                            Frame.this._timer.stop();
                            Frame.this._timer = null;
                            // zeige dem Spieler den GameOverDialog
                            showGameOverDialog();
                            }

                        }

                    }
                });
    }
    
    /**
     * initialisiert den Frame mit den aktuellen Einstellungen, Level etc.
     */
    public void init()
    {
        // Neues HeadUpDisplay (Uhr und Punktestand) erzeugen
this._board.init();
        
        // finde deine PreferredSize
        this.pack();

        // starte den Timer -> Spiel beginnt
        this._timer.start();
    }

    /**
     * reagiert auf die Aktion 'Pausuere das Spiel'
     */
    public void pauseGame()
    {
        if(null != this._timer)
        {
            if(this._timer.isRunning())
            {
                this._timer.stop();
            }
            else
            {
                this._timer.start();
            }
        }
    }

    /**
     * erzeugt ein neuen GameOverDialog und setzt diesen direkt auf
     * <code>visible</code>
     */
    public void showGameOverDialog()
    {
        final PropertiesProvider pp = PropertiesProvider.getInstance();

        final String game_over_title = pp.get("game_over_title", "Game Over");
        final String game_over_msg = pp.get("game_over_msg",
                "A ball entered a hole of the wrong colour.");

        JOptionPane.showMessageDialog(this, game_over_msg, game_over_title,
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * erzeugt eine neue AboutBox und setzt diese direkt auf
     * <code>visible</code>
     */
    public void showAboutBox()
    {
        final PropertiesProvider pp = PropertiesProvider.getInstance();

        final String about_title = pp.get("about_title", "About");
        final String author_label = pp.get("author_label", "Author");
        final String website_label = pp.get("website_label", "Website");
        final String description_label = pp.get("description_label",
                "Description");
        final StringBuffer sb = new StringBuffer();

        sb.append("<html><body>");
        sb.append(author_label);
        sb.append(": Patrick Vogt<br />");
        sb.append(website_label);
        sb.append(": <a href=\"http://patrickvogt.net\">http://patrickvogt.net</a><br />");
        sb.append(description_label);
        sb.append(": &Pi;nkBall<br /></body></html>");

        pauseGame();   
        JOptionPane.showMessageDialog(this, sb.toString(), about_title,
                JOptionPane.INFORMATION_MESSAGE);
        pauseGame();
    }

}
