package net.patrickvogt.pinkball.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import net.patrickvogt.pinkball.excpetion.GameOverException;
import net.patrickvogt.pinkball.painter.StandardPainter;
import net.patrickvogt.pinkball.util.PropertiesProvider;

public class Frame extends JFrame
{

    private static final long serialVersionUID = 1L;

    /**
     * beschreibt die Verzoegerungszeit (in ms) des Timers
     */
    private final int delay = 16;

    /**
     * beschreibt die Breite/Hoehe der Randsteine an der linken, oberen, rechten
     * und unteren Seite
     */
    // private final int borderStoneWidth=25;

    /**
     * beschreibt das HeadUpDisplay, in dem die Zeit und der Score angezeigt
     * werden
     */
    // private HeadUpDisplay hud;

    /**
     * Spielfeld in dem alle LevelInhalte gezeichnet werden sollen
     */
    private Board b;

    /**
     * interner Clock/Taktgeber
     */
    private javax.swing.Timer timer;

    /**
     * erzeugt eine neue Instanz von <code>Frame</code> und initialisiert diesen
     */
    public Frame()
    {
        // Kontruktor der Oberklasse mit dem String der HeadLeiste aufrufen
        super("PInkBall");
        // FrameContent (Level, Board, Timer, Score) intialisieren
        this.b = new Board();
        this.b.init();
        this.init();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width / 2 - this.getSize().width / 2,
                screenSize.height / 2 - this.getSize().height / 2);
    }

    /**
     * <p>
     * reinitialisiert den Frame neu
     * </p>
     * <p>
     * (Board, Timer, Score werden geloescht und neu initialisiert)
     * </p>
     */
    public void reinit()
    {
        b.init();
        // loesche das HeadUpDisplay
        // this.hud.setVisible(false);
        // this.hud=null;
        // loesche den Timer
        this.destroyTimer();
        // reinitialisiere den FrameInhalt
        this.init();
    }

    public void continueTimer()
    {
        if(null != this.timer)
        {
            if(!this.timer.isRunning())
            {
                this.timer.start();
            }
        }
    }

    public void stopTimer()
    {
        if(null != this.timer)
        {
            if(this.timer.isRunning())
            {
                this.timer.stop();
            }
        }
    }

    public void destroyTimer()
    {
        this.stopTimer();
        this.timer = null;
    }

    /**
     * initialisiert den Frame mit den aktuellen Einstellungen, Level etc.
     */
    public void init()
    {

        // Neues HeadUpDisplay (Uhr und Punktestand) erzeugen
        // this.hud = new HeadUpDisplay(this.WIDTH+2*this.borderStoneWidth,
        // this.borderStoneWidth, this.delay);

        // Neuen timer erzeugen mit dem angegeben Delay (in ms) und dem
        // folgenden AcionListener
        this.timer = new javax.swing.Timer(this.delay, new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                // System.out.println("hallo");

                // Board bzw. dessen Inhalt auf Kollision pruefen
                try
                {
                    b.gameLoop();
                }
                catch(final GameOverException ex)
                {
                    // beende das Spiel
                    endGame();
                    // zeige dem Spieler den GameOverDialog
                    showGameOverDialog();

                }

            }
        });
        // fuege dem Frame meine MenueLeiste hinzu
        this.setJMenuBar(new MyMenuBar());

        // setze das Layout auf BorderLayout und fuelle dann die 5 Teile des
        // Layouts
        this.setLayout(new BorderLayout());
        // oben -> HeadUpDisplay
        // this.add(this.hud, BorderLayout.NORTH);
        // rechts -> Vertikaler Rand aus mehreren grauen Steinen
        // this.add(new RightVerticalBorder(this.HEIGHT, this.borderStoneWidth),
        // BorderLayout.EAST);
        // //unten -> Horizontaler Rand aus mehreren grauen Steinen
        // this.add(new
        // BottomHorizontalBorder(this.WIDTH+2*this.borderStoneWidth,
        // this.borderStoneWidth), BorderLayout.SOUTH);
        // //links -> Vertikaler Rand aus mehreren grauen Steinen
        // this.add(new LeftVerticalBorder(this.HEIGHT, this.borderStoneWidth),
        // BorderLayout.WEST);
        // //mitte -> Spielfeld
        this.add(this.b, BorderLayout.CENTER);

        // Groesse soll nicht veraenderbar sein
        this.setResizable(false);
        // Klick auf das X rechts oben soll das Programm beenden
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Frame soll fokusierbar sein -> wichtig bpsw. fuer die Reaktion auf
        // Tastendrucks
        this.setFocusable(true);
        // finde deine PreferredSize
        this.pack();

        // starte den Timer -> Spiel beginnt
        this.timer.start();
    }

    /**
     * reagiert auf die Aktion 'Pausuere das Spiel'
     */
    public void reactOnPauseGame()
    {
        if(null != this.timer)
        {
            if(this.timer.isRunning())
            {
                this.timer.stop();
            }
            else
            {
                this.timer.start();
            }
        }
    }

    /**
     * beendet das Spiel indem der Timer gestoppt und auf <code>null</code>
     * gesetzt wird
     */
    public void endGame()
    {
        this.destroyTimer();
    }

    /**
     * erzeugt ein neuen GameOverDialog und setzt diesen direkt auf
     * <code>visible</code>
     */
    public void showGameOverDialog()
    {
        PropertiesProvider pp = PropertiesProvider.getInstance();

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
        PropertiesProvider pp = PropertiesProvider.getInstance();

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

        if(timer != null)
        {
            this.timer.stop();
        }
        JOptionPane.showMessageDialog(this, sb.toString(), about_title,
                JOptionPane.INFORMATION_MESSAGE);
        if(timer != null)
        {
            this.timer.start();
        }
    }

    /**
     * interne Klasse die eine Menueleiste implementiert, mit der das Spiel
     * konfigueriert werden kann
     * 
     * @author Patrick Vogt
     * 
     */
    private class MyMenuBar extends JMenuBar
    {

        private static final long serialVersionUID = 1L;

        /**
         * erzeugt eine neue Instanz von <code>MyMenuBar</code> mit einem
         * 'Game'-Menue, einem 'Level'-Menue und einem 'Help'-Menue
         */
        public MyMenuBar()
        {
            super();

            MyMenuActionListener ml = new MyMenuActionListener();

            JMenu menu = new JMenu(PropertiesProvider.getInstance().get(
                    "main_menu", "Main"));
            menu.setMnemonic(KeyEvent.VK_I);

            JMenuItem menuItem = new JMenuItem(PropertiesProvider.getInstance()
                    .get("new_menu_item", "New"));
            menuItem.setActionCommand("NEW");
            menuItem.setMnemonic(KeyEvent.VK_N);
            menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                    ActionEvent.CTRL_MASK));
            menuItem.addActionListener(ml);
            menu.add(menuItem);

            JCheckBoxMenuItem cbMenuItem = new JCheckBoxMenuItem(
                    PropertiesProvider.getInstance().get("pause_menu_item",
                            "Pause"));
            cbMenuItem.setActionCommand("PAUSE");
            cbMenuItem.setMnemonic(KeyEvent.VK_P);
            cbMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent
                    .getKeyText(KeyEvent.VK_P)));
            cbMenuItem.addActionListener(ml);
            menu.add(cbMenuItem);

            menuItem = new JMenuItem(PropertiesProvider.getInstance().get(
                    "exit_menu_item", "Exit"));
            menuItem.setActionCommand("EXIT");
            menuItem.setMnemonic(KeyEvent.VK_E);
            menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
                    ActionEvent.ALT_MASK));
            menuItem.addActionListener(ml);
            menu.add(menuItem);
            this.add(menu);

            menu = new JMenu(PropertiesProvider.getInstance().get("level_menu",
                    "Level"));
            menu.setMnemonic(KeyEvent.VK_L);

            ButtonGroup level_group = new ButtonGroup();

            JRadioButtonMenuItem rbMenuItem = new JRadioButtonMenuItem(
                    PropertiesProvider.getInstance().get("demo_menu_item",
                            "Demo"));
            rbMenuItem.setActionCommand("DEMO");
            rbMenuItem.setMnemonic(KeyEvent.VK_D);
            rbMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
                    ActionEvent.CTRL_MASK));
            rbMenuItem.addActionListener(ml);
            level_group.add(rbMenuItem);
            menu.add(rbMenuItem);

            menu.addSeparator();

            rbMenuItem = new JRadioButtonMenuItem(PropertiesProvider
                    .getInstance().get("level1_menu_item", "Level 1"));
            rbMenuItem.setActionCommand("NEW");
            rbMenuItem.setMnemonic(KeyEvent.VK_1);
            rbMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
                    ActionEvent.CTRL_MASK));
            rbMenuItem.addActionListener(ml);
            level_group.add(rbMenuItem);
            menu.add(rbMenuItem);

            rbMenuItem = new JRadioButtonMenuItem(PropertiesProvider
                    .getInstance().get("level2_menu_item", "Level 2"));
            rbMenuItem.setActionCommand("LEVEL2");
            rbMenuItem.setMnemonic(KeyEvent.VK_2);
            rbMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
                    ActionEvent.CTRL_MASK));
            rbMenuItem.addActionListener(ml);
            level_group.add(rbMenuItem);
            menu.add(rbMenuItem);

            rbMenuItem = new JRadioButtonMenuItem(PropertiesProvider
                    .getInstance().get("level3_menu_item", "Level 3"));
            rbMenuItem.setActionCommand("LEVEL3");
            rbMenuItem.setMnemonic(KeyEvent.VK_3);
            rbMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,
                    ActionEvent.CTRL_MASK));
            rbMenuItem.addActionListener(ml);
            level_group.add(rbMenuItem);
            menu.add(rbMenuItem);

            rbMenuItem = new JRadioButtonMenuItem(PropertiesProvider
                    .getInstance().get("level4_menu_item", "Level 4"));
            rbMenuItem.setActionCommand("LEVEL4");
            rbMenuItem.setMnemonic(KeyEvent.VK_4);
            rbMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,
                    ActionEvent.CTRL_MASK));
            rbMenuItem.addActionListener(ml);
            level_group.add(rbMenuItem);
            menu.add(rbMenuItem);

            rbMenuItem = new JRadioButtonMenuItem(PropertiesProvider
                    .getInstance().get("level5_menu_item", "Level 5"));
            rbMenuItem.setActionCommand("LEVEL5");
            rbMenuItem.setMnemonic(KeyEvent.VK_5);
            rbMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5,
                    ActionEvent.CTRL_MASK));
            rbMenuItem.addActionListener(ml);
            level_group.add(rbMenuItem);
            menu.add(rbMenuItem);
            this.add(menu);

            menu = new JMenu(PropertiesProvider.getInstance().get("help_menu",
                    "Help"));
            menu.setMnemonic(KeyEvent.VK_H);

            menuItem = new JMenuItem(PropertiesProvider.getInstance().get(
                    "about_menu_item", "About"));
            menuItem.setActionCommand("ABOUT");
            menuItem.setMnemonic(KeyEvent.VK_B);
            menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
                    ActionEvent.CTRL_MASK));
            menuItem.addActionListener(ml);
            menu.add(menuItem);
            this.add(menu);
        }

        public class MyMenuActionListener implements ActionListener
        {

            @Override
            public void actionPerformed(ActionEvent evt)
            {
                if(evt.getActionCommand().equals("DEMO"))
                {
                    b.setLevel(0);
                }
                if(evt.getActionCommand().equals("NEW"))
                {
                    b.setLevel(1);
                    init();
                }
                if(evt.getActionCommand().equals("LEVEL2"))
                {
                    b.setLevel(2);
                }
                if(evt.getActionCommand().equals("LEVEL3"))
                {
                    b.setLevel(3);
                }
                if(evt.getActionCommand().equals("LEVEL4"))
                {
                    b.setLevel(4);
                }
                if(evt.getActionCommand().equals("LEVEL5"))
                {
                    b.setLevel(5);
                }
                if(evt.getActionCommand().equals("PAUSE"))
                {
                    reactOnPauseGame();
                }
                if(evt.getActionCommand().equals("EXIT"))
                {
                    System.exit(0);
                }
                if(evt.getActionCommand().equals("ABOUT"))
                {
                    showAboutBox();
                }
            }
        }
    }
}
