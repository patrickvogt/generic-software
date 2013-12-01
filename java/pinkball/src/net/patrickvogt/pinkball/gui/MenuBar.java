package net.patrickvogt.pinkball.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import net.patrickvogt.pinkball.painter.ImagePainter;
import net.patrickvogt.pinkball.painter.StandardPainter;
import net.patrickvogt.pinkball.painter.WireFramePainter;
import net.patrickvogt.pinkball.test.DebugPainter;
import net.patrickvogt.pinkball.util.PropertiesProvider;

public final class MenuBar extends JMenuBar
{
    private static final long serialVersionUID = 1L;

    private static final String ACT_CMD_NEW = "NEW";
    private static final String ACT_CMD_PAUSE = "PAUSE";
    private static final String ACT_CMD_EXIT = "EXIT";

    private static final String ACT_CMD_DEMO = "DEMO";
    private static final String ACT_CMD_LEVEL2 = "LEVEL2";
    private static final String ACT_CMD_LEVEL3 = "LEVEL3";
    private static final String ACT_CMD_LEVEL4 = "LEVEL4";
    private static final String ACT_CMD_LEVEL5 = "LEVEL5";

    private static final String ACT_CMD_STANDARDPAINTER = "STANDARDPAINTER";
    private static final String ACT_CMD_WIREFRAMEPAINTER = "WIREFRAMEPAINTER";
    private static final String ACT_CMD_DEBUGPAINTER = "DEBUGPAINTER";
    private static final String ACT_CMD_IMAGEPAINTER = "IMAGEPAINTER";
    private static final String ACT_CMD_ANTIALIASING = "ANTIALIASING";

    private static final String ACT_CMD_ABOUT = "ABOUT";

    public MenuBar(Frame __parent, Board __board)
    {
        super();

        final PropertiesProvider pp = PropertiesProvider.getInstance();

        final MenuActionListener ml = new MenuActionListener(__parent, __board);

        JMenu menu = new JMenu(pp.get("main_menu", "Main"));
        menu.setMnemonic(KeyEvent.VK_I);

        JMenuItem menuItem = new JMenuItem(pp.get("new_menu_item", "New"));
        menuItem.setActionCommand(MenuBar.ACT_CMD_NEW);
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                ActionEvent.CTRL_MASK));
        menuItem.addActionListener(ml);
        menu.add(menuItem);

        menuItem = new JMenuItem(pp.get(
                "pause_menu_item", "Pause"));
        menuItem.setActionCommand(MenuBar.ACT_CMD_PAUSE);
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent
                .getKeyText(KeyEvent.VK_P)));
        menuItem.addActionListener(ml);
        menu.add(menuItem);

        menuItem = new JMenuItem(pp.get("exit_menu_item", "Exit"));
        menuItem.setActionCommand(MenuBar.ACT_CMD_EXIT);
        menuItem.setMnemonic(KeyEvent.VK_E);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
                ActionEvent.ALT_MASK));
        menuItem.addActionListener(ml);
        menu.add(menuItem);
        this.add(menu);

        menu = new JMenu(pp.get("level_menu", "Level"));
        menu.setMnemonic(KeyEvent.VK_L);

        menuItem = new JMenuItem(pp.get(
                "demo_menu_item", "Demo"));
        menuItem.setActionCommand(MenuBar.ACT_CMD_DEMO);
        menuItem.setMnemonic(KeyEvent.VK_D);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
                ActionEvent.CTRL_MASK));
        menuItem.addActionListener(ml);
        menu.add(menuItem);

        menu.addSeparator();

        menuItem = new JMenuItem(PropertiesProvider.getInstance()
                .get("level1_menu_item", "Level 1"));
        menuItem.setActionCommand(MenuBar.ACT_CMD_NEW);
        menuItem.setMnemonic(KeyEvent.VK_1);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
                ActionEvent.CTRL_MASK));
        menuItem.addActionListener(ml);
        menu.add(menuItem);

        menuItem = new JMenuItem(PropertiesProvider.getInstance()
                .get("level2_menu_item", "Level 2"));
        menuItem.setActionCommand(MenuBar.ACT_CMD_LEVEL2);
        menuItem.setMnemonic(KeyEvent.VK_2);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
                ActionEvent.CTRL_MASK));
        menuItem.addActionListener(ml);
        menu.add(menuItem);

        menuItem = new JMenuItem(PropertiesProvider.getInstance()
                .get("level3_menu_item", "Level 3"));
        menuItem.setActionCommand(MenuBar.ACT_CMD_LEVEL3);
        menuItem.setMnemonic(KeyEvent.VK_3);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,
                ActionEvent.CTRL_MASK));
        menuItem.addActionListener(ml);
        menu.add(menuItem);

        menuItem = new JMenuItem(PropertiesProvider.getInstance()
                .get("level4_menu_item", "Level 4"));
        menuItem.setActionCommand(MenuBar.ACT_CMD_LEVEL4);
        menuItem.setMnemonic(KeyEvent.VK_4);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,
                ActionEvent.CTRL_MASK));
        menuItem.addActionListener(ml);
        menu.add(menuItem);

        menuItem = new JMenuItem(PropertiesProvider.getInstance()
                .get("level5_menu_item", "Level 5"));
        menuItem.setActionCommand(MenuBar.ACT_CMD_LEVEL5);
        menuItem.setMnemonic(KeyEvent.VK_5);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5,
                ActionEvent.CTRL_MASK));
        menuItem.addActionListener(ml);
        menu.add(menuItem);
        this.add(menu);

        menu = new JMenu(pp.get("options_menu", "Options"));
        menu.setMnemonic(KeyEvent.VK_O);

        ButtonGroup level_group = new ButtonGroup();

        menuItem = new JRadioButtonMenuItem(pp.get("standardpainter", "Standard Style"));
        menuItem.setActionCommand(MenuBar.ACT_CMD_STANDARDPAINTER);
        menuItem.setMnemonic(KeyEvent.VK_S);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                ActionEvent.CTRL_MASK));
        menuItem.addActionListener(ml);
        ((JRadioButtonMenuItem)menuItem).setSelected(true);
        level_group.add(menuItem);
        menu.add(menuItem);
        this.add(menu);

        menuItem = new JRadioButtonMenuItem(pp.get("wireframepainter", "Wireframe Style"));
        menuItem.setActionCommand(MenuBar.ACT_CMD_WIREFRAMEPAINTER);
        menuItem.setMnemonic(KeyEvent.VK_E);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
                ActionEvent.CTRL_MASK));
        menuItem.addActionListener(ml);
        level_group.add(menuItem);
        menu.add(menuItem);
        this.add(menu);

        menuItem = new JRadioButtonMenuItem(pp.get("debugpainter", "Debug Style"));
        menuItem.setActionCommand(MenuBar.ACT_CMD_DEBUGPAINTER);
        menuItem.setMnemonic(KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,
                ActionEvent.CTRL_MASK));
        menuItem.addActionListener(ml);
        level_group.add(menuItem);
        menu.add(menuItem);
        this.add(menu);

        menuItem = new JRadioButtonMenuItem(pp.get("imagepainter", "Image Style"));
        menuItem.setActionCommand(MenuBar.ACT_CMD_IMAGEPAINTER);
        menuItem.setMnemonic(KeyEvent.VK_I);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
                ActionEvent.CTRL_MASK));
        menuItem.addActionListener(ml);
        level_group.add(menuItem);
        menu.add(menuItem);
        this.add(menu);
        
        menu.addSeparator();

        menuItem = new JCheckBoxMenuItem(pp.get("antialiasing", "Anti-Aliasing"));
        menuItem.setActionCommand(MenuBar.ACT_CMD_ANTIALIASING);
        menuItem.setMnemonic(KeyEvent.VK_A);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                ActionEvent.CTRL_MASK));
        menuItem.addActionListener(ml);
        menu.add(menuItem);
        this.add(menu);

        menu = new JMenu(pp.get("help_menu", "Help"));
        menu.setMnemonic(KeyEvent.VK_H);

        menuItem = new JMenuItem(pp.get("about_menu_item", "About"));
        menuItem.setActionCommand("ABOUT");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
                ActionEvent.CTRL_MASK));
        menuItem.addActionListener(ml);
        menu.add(menuItem);
        this.add(menu);
    }

    public final class MenuActionListener implements ActionListener
    {
        private Frame _parent = null;
        private Board _board = null;

        public MenuActionListener(Frame __parent, Board __board)
        {
            super();

            this._parent = __parent;
            this._board = __board;
        }

        @Override
        public final void actionPerformed(final ActionEvent evt)
        {
            if(evt.getActionCommand().equals(MenuBar.ACT_CMD_NEW))
            {
                this._board.setLevel(1);
                this._parent.newTimer();
                this._parent.init();
                this._parent.pack();
            }
            else if(evt.getActionCommand().equals(MenuBar.ACT_CMD_PAUSE))
            {
                this._parent.pauseGame();
            }
            else if(evt.getActionCommand().equals(MenuBar.ACT_CMD_EXIT))
            {
                System.exit(0);
            }
            else if(evt.getActionCommand().equals(MenuBar.ACT_CMD_DEMO))
            {
                this._board.setLevel(0);
                this._parent.pack();
            }
            else if(evt.getActionCommand().equals(MenuBar.ACT_CMD_LEVEL2))
            {
                this._board.setLevel(2);
                this._parent.pack();
            }
            else if(evt.getActionCommand().equals(MenuBar.ACT_CMD_LEVEL3))
            {
                this._board.setLevel(3);
                this._parent.pack();
            }
            else if(evt.getActionCommand().equals(MenuBar.ACT_CMD_LEVEL4))
            {
                this._board.setLevel(4);
                this._parent.pack();
            }
            else if(evt.getActionCommand().equals(MenuBar.ACT_CMD_LEVEL5))
            {
                this._board.setLevel(5);
                this._parent.pack();
            }
            else if(evt.getActionCommand().equals(
                    MenuBar.ACT_CMD_STANDARDPAINTER))
            {
                this._board.setPainter(StandardPainter.getInstance());
            }
            else if(evt.getActionCommand().equals(
                    MenuBar.ACT_CMD_WIREFRAMEPAINTER))
            {
                this._board.setPainter(WireFramePainter.getInstance());
            }
            else if(evt.getActionCommand().equals(MenuBar.ACT_CMD_DEBUGPAINTER))
            {
                this._board.setPainter(DebugPainter.getInstance());
            }
            else if(evt.getActionCommand().equals(MenuBar.ACT_CMD_IMAGEPAINTER))
            {
                this._board.setPainter(ImagePainter.getInstance());
            }
            else if(evt.getActionCommand().equals(MenuBar.ACT_CMD_ANTIALIASING))
            {
                this._board.toggleAntiAliasing();
            }
            else if(evt.getActionCommand().equals(MenuBar.ACT_CMD_ABOUT))
            {
                this._parent.showAboutBox();
            }
        }
    }
}
