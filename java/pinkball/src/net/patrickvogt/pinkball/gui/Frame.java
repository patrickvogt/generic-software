package net.patrickvogt.pinkball.gui;

/*
 * Frame.java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import net.patrickvogt.pinkball.exceptions.*;
import net.patrickvogt.pinkball.level.*;

/**
 * implementiert einen Frame, in dem das Spielfeld, Menueleiste, HeadUpDisplay (Score und Zeit) etc.
 * angezeigt werden soll
 * 
 * @author Patrick Vogt
 *
 */
public class Frame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * beschriebt die Breite des Boards/Spielfelds
	 */
	private final int WIDTH=800;
	
	/**
	 * beschreibt die Hoehe des Boards/Spielfelds
	 */
    private final int HEIGHT=600;
    
    /**
     * beschreibt die Verzoegerungszeit (in ms) des Timers
     */
    private final int delay=30;
    
    /**
     * beschreibt die Breite/Hoehe der Randsteine an der linken, oberen, rechten und unteren Seite
     */
	private final int borderStoneWidth=25;
    
	/**
	 * beschreibt die aktuelle Punktzahl des Spielers
	 */
    private int myScore=0;
    
    /**
     * beschreibt das HeadUpDisplay, in dem die Zeit und der Score angezeigt werden
     */
    private HeadUpDisplay hud;
    
    /**
     * Spielfeld in dem alle LevelInhalte gezeichnet werden sollen
     */
	private Board b;
	
	/**
	 * interner Clock/Taktgeber
	 */
	private javax.swing.Timer timer;
	
	/**
	 * beschreibt, in welchem Level sich der SPieler gerade befindet
	 */
	private int currentLevel=1;
	
	/**
	 * erzeugt eine neue Instanz von <code>Frame</code> und initialisiert diesen
	 */
	public Frame() {
		//Kontruktor der Oberklasse mit dem String der HeadLeiste aufrufen
		super("PInkBall");
		//FrameContent (Level, Board, Timer, Score) intialisieren
		this.init();
		//fuege dem Frame mein KeyListener hinzu
		this.addKeyListener(new MyKeyListener());
	}
	
	/**
	 * <p>reinitialisiert den Frame neu</p>
	 * <p>(Board, Timer, Score werden geloescht und neu initialisiert)</p>
	 */
	public void reinit() {
		//nulle den Score
		this.myScore=0;
		//loesche das Board
		this.b.setVisible(false);
		this.b=null;
		//loesche das HeadUpDisplay
		this.hud.setVisible(false);
		this.hud=null;
		//loesche den Timer
		if(this.timer!=null && this.timer.isRunning()) {
			this.timer.stop();
		}
		this.timer=null;
		//reinitialisiere den FrameInhalt
		this.init();
	}
	
	/**
	 * initialisiert den Frame mit den aktuellen Einstellungen, Level etc.
	 */
	public void init() {
		Level thisLevel;
		
		//Welches Level soll gespielt werden
		switch(this.currentLevel) {
			case 0: thisLevel = new Demo(); break;
			case 1: thisLevel = new Level1(); break;
			case 2: thisLevel = new Level2(); break;
			case 3: thisLevel = new Level3(); break;
			case 4: thisLevel = new Level4(); break;
			case 5: thisLevel = new Level5(); break;
			default: thisLevel = new Level1(); break;
		}
		//Neues Board mit dem LevelCOntent des aktuellen Levels erzeugen
		this.b = new Board(thisLevel.getLevelContent(), this.WIDTH, this.HEIGHT);
		//Neues HeadUpDisplay (Uhr und Punktestand) erzeugen
		this.hud = new HeadUpDisplay(this.WIDTH+2*this.borderStoneWidth, this.borderStoneWidth, this.delay);
			
		//Neuen timer erzeugen mit dem angegeben Delay (in ms) und dem folgenden AcionListener
		this.timer = new javax.swing.Timer(this.delay, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	try {
            		//Board bzw. dessen Inhalt auf Kollision pruefen
            		b.checkCollision();
            	}
            	catch(NextLevelException e) {
            		//fange eine eventuell geworfene NextLevelException
            		if(currentLevel<5) {
            			//Wenn nicht Level 5 dann erhoehe den LevelCounter um 1
            			currentLevel++;
            		}
            		else {
            			//Wenn auch Level 5 geschafft wurde, dann setze den LevelCounter auf 0
            			//Spieler bekommt als Belohnung die MassCollisionDemo zu sehen
            			currentLevel=0;
            		}
            		//reinitialisere den Inhalt des Frame neu
            		reinit();
            	}
            	catch(GameOverException e) {
            		//fange eine eventuell geworfene GameOverException
            		
            		//zeige dem Spieler den GameOverDialog
            		showGameOverDialog();
            		//beende das Spiel
       				endGame();
            	}
            	catch(RaiseScoreException e) {
            		//fange eine eventuell geworfene RaiseScoreException
            		
            		//loesche die Elemente, die nun nicht mehr zum Spiel gehoeren
            		b.emptyDestroyThat();
            		//erhoehe den Score um 20 Punkte
            		myScore=myScore+20;
            		//aktualisiere den Score im HeadUpDisplay
            		hud.setScore(myScore);
            	}
            	//bewege alle Elemente einen Schritt weiter (abhaengig vom Speed-Vektor im jeweiligen GeometricObject)
	        	b.moveObjects();
	        	//zeichne das Spielfeld neu
	            b.repaint();
	            //zeichne das HeadUpDisplay neu -> damit Score und Zeitanzeige aktualisiert werden
	            hud.repaint();
            }  
        });
		//fuege dem Frame meine MenueLeiste hinzu
		this.setJMenuBar(new MyMenuBar());
		
		//setze das Layout auf BorderLayout und fuelle dann die 5 Teile des Layouts
		this.setLayout(new BorderLayout());
		//oben -> HeadUpDisplay
		this.add(this.hud, BorderLayout.NORTH);
		//rechts -> Vertikaler Rand aus mehreren grauen Steinen
		this.add(new RightVerticalBorder(this.HEIGHT, this.borderStoneWidth), BorderLayout.EAST);
		//unten -> Horizontaler Rand aus mehreren grauen Steinen
		this.add(new BottomHorizontalBorder(this.WIDTH+2*this.borderStoneWidth, this.borderStoneWidth), BorderLayout.SOUTH);
		//links -> Vertikaler Rand aus mehreren grauen Steinen
		this.add(new LeftVerticalBorder(this.HEIGHT, this.borderStoneWidth), BorderLayout.WEST);
		//mitte -> Spielfeld
		this.add(this.b, BorderLayout.CENTER);
		
		//Groesse soll nicht veraenderbar sein
		this.setResizable(false);
		//Klick auf das X rechts oben soll das Programm beenden
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Frame soll fokusierbar sein -> wichtig bpsw. fuer die Reaktion auf Tastendrucks
		this.setFocusable(true);
		//finde deine PreferredSize
		this.pack();
		
		//starte den Timer -> Spiel beginnt
        this.timer.start();
	}
	
	/**
	 * Zugriffsmethode um den Timer des Frames zu bekommen
	 * 
	 * @return den Timer des Frames
	 * 
	 */
	public javax.swing.Timer getTimer() {
		return(this.timer);
	}
	
	/**
	 * reagiert auf die Aktion 'Pausuere das Spiel'
	 */
	public void reactOnPauseGame() {
		//gibt es noch einen Timer
		if(this.getTimer()!=null) {
			//WENN dieser aktiv ist
        	if(this.getTimer().isRunning()) {
        		//DANN stoppe den Timer
        		this.getTimer().stop();
        	}
        	else {
        		//ANDERNFALLS aktiviere den Timer wieder
        		this.getTimer().start();
        	}
    	}
	}
	
	/**
	 * beendet das Spiel indem der Timer gestoppt und auf <code>null</code> gesetzt wird
	 */
	public void endGame() {
		//Gibt es noch einen Timer AND laeuft dieser noch
		if(timer!= null && timer.isRunning()) {
			//WENN ja DANN stoppe den Timer und setzt ihn auf null
			timer.stop();
			timer=null;
		}
	}
	
	/**
	 * erzeugt ein neuen GameOverDialog und setzt diesen direkt auf <code>visible</code>
	 */
	public void showGameOverDialog() {
		new GameOverDialog(this.WIDTH+2*this.borderStoneWidth, 
				this.HEIGHT+2*this.borderStoneWidth).setVisible(true);
	}
	
	/**
	 * erzeugt eine neue AboutBox und setzt diese direkt auf <code>visible</code>
	 */
	public void showAboutBox() {
		new AboutBox(WIDTH+2*borderStoneWidth, 
				HEIGHT+2*borderStoneWidth).setVisible(true);
    }
	
	/**
	 * interne Klasse, die einen KeyListener implementiert	 * 
	 * 
	 * @author Patrick Vogt
	 *
	 */
	//MyKeyListener ist eine Unterklasse von KeyAdapter
	private class MyKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent evt) {
			if(evt.getKeyCode() == KeyEvent.VK_P) {
				//bei 'P'-Tastendruck entweder Spiel pausieren oder
				//Spiel aus dem PauseZustand wieder 'entpausieren'
				reactOnPauseGame();
			}
			else if(evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
				//bei ESC-Tastendruck -> Spiel beenden
				System.exit(0);
			}
		}
	}
	
	/**
	 * interne Klasse die eine Menueleiste implementiert, mit der das Spiel konfigueriert werden kann
	 * 
	 * @author Patrick Vogt
	 *
	 */
	private class MyMenuBar extends JMenuBar {
		
		private static final long serialVersionUID = 1L;

		/**
		 * erzeugt eine neue Instanz von <code>MyMenuBar</code> mit einem 'Game'-Menue,
		 * einem 'Level'-Menue und einem 'Help'-Menue
		 */
		public MyMenuBar() {
			super();
			
			//Game-Menue erzeugen mit den entsprechenden Items und
			//den entsprechenden ActionCommands
		    JMenu gameMenu = new JMenu("Game");
		    JMenuItem newGameItem = new JMenuItem("New");
		    gameMenu.add(newGameItem);
		    newGameItem.setActionCommand("NEW");
		    JMenuItem pauseGameItem = new JMenuItem("Pause (P)");
		    gameMenu.add(pauseGameItem);
		    pauseGameItem.setActionCommand("PAUSE");
		    JMenuItem quitGameItem = new JMenuItem("Quit (ESC)");
		    gameMenu.add(quitGameItem);
		    quitGameItem.setActionCommand("QUIT");
		    //Game-Menu der Menueleiste hinzufuegen
		    this.add(gameMenu);
			
		    //Level-Menue erzeugen mit den entsprechenden Items und
			//den entsprechenden ActionCommands
		    JMenu levelMenu = new JMenu("Level");
		    JMenuItem demo = new JMenuItem("Demo");
	        levelMenu.add(demo);
	        demo.setActionCommand("DEMO");
	        JMenuItem level1 = new JMenuItem("Level 1");
	        levelMenu.add(level1);
	        level1.setActionCommand("NEW");
	        JMenuItem level2 = new JMenuItem("Level 2");
	        levelMenu.add(level2);
	        level2.setActionCommand("LEVEL2");
	        JMenuItem level3 = new JMenuItem("Level 3");
	        levelMenu.add(level3);
	        level3.setActionCommand("LEVEL3");
	        JMenuItem level4 = new JMenuItem("Level 4");
	        levelMenu.add(level4);
	        level4.setActionCommand("LEVEL4");
	        JMenuItem level5 = new JMenuItem("Level 5");
	        levelMenu.add(level5);
	        level5.setActionCommand("LEVEL5");
	        //Level-Menue der Menueleiste hinzufuegen
	        this.add(levelMenu);
		    
	        //Help-Menue erzeugen mit den entsprechenden Items und
			//den entsprechenden ActionCommands
	        JMenu helpMenu = new JMenu("Help");
	        JMenuItem aboutItem = new JMenuItem("About");
	        helpMenu.add(aboutItem);
	        aboutItem.setActionCommand("ABOUT");
	        //Help-Menue der Menueleiste hinzufuegen
	        this.add(helpMenu);
	        
	        //MyMenuActionListener erzeugen und den entsprechenden Items hinzufuegen
	        MyMenuActionListener ml = new MyMenuActionListener();	        
	        newGameItem.addActionListener(ml);
	        pauseGameItem.addActionListener(ml);
	        quitGameItem.addActionListener(ml);
	        demo.addActionListener(ml);
	        level1.addActionListener(ml);
	        level2.addActionListener(ml);
	        level3.addActionListener(ml);
	        level4.addActionListener(ml);
	        level5.addActionListener(ml);
	        aboutItem.addActionListener(ml);
		}
		
		/**
		 * interne Klasse, die einen MenuActionListener implementiert,
		 * der auf die verschiedenen Items in der MenuBar unterschiedlich reagieren soll
		 * 
		 * @author Patrick Vogt
		 *
		 */
		public class MyMenuActionListener implements ActionListener {
	       
			/**
	         * reagiert auf Klicks in der Menueleiste
	         */
			@Override
	        public void actionPerformed(ActionEvent evt) {
	        	if(evt.getActionCommand().equals("DEMO")) {
	        		//WENN 'Demo' angeklickt wurde,
	        		//DANN starte die Demo
	            	currentLevel=0;
	            	//reInitialisiere das Board fuer das neue Level
	            	reinit();
	            }
	        	if(evt.getActionCommand().equals("NEW")) {
	        		//WENN 'New' angeklickt wurde,
	        		//DANN starte Level1
	            	currentLevel=1;
	            	//reInitialisiere das Board fuer das neue Level
	            	reinit();
	            }
	            if(evt.getActionCommand().equals("LEVEL2")) {
	            	//WENN 'Level 2' angeklickt wurde,
	        		//DANN starte Level2
	            	currentLevel=2;
	            	//reInitialisiere das Board fuer das neue Level
	            	reinit();
	            }
	            if(evt.getActionCommand().equals("LEVEL3")) {
	            	//WENN 'Level 3' angeklickt wurde,
	        		//DANN starte Level3
	            	currentLevel=3;
	            	//reInitialisiere das Board fuer das neue Level
	            	reinit();
	            }
	            if(evt.getActionCommand().equals("LEVEL4")) {
	            	//WENN 'Level 4' angeklickt wurde,
	        		//DANN starte Level4
	            	currentLevel=4;
	            	//reInitialisiere das Board fuer das neue Level
	            	reinit();
	            }
	            if(evt.getActionCommand().equals("LEVEL5")) {
	            	//WENN 'Level 5' angeklickt wurde,
	        		//DANN starte Level5
	            	currentLevel=5;
	            	//reInitialisiere das Board fuer das neue Level
	            	reinit();
	            }
	            if(evt.getActionCommand().equals("PAUSE")) {
	            	//WENN 'Pause' angeklickt wurde,
	        		//DANN reagiere auf diese Pausierung mit der Funktion
	            	//reactOnPauseGame (Diese Funktion entscheidet, ob 'paused' oder 'continued' wird)
	            	reactOnPauseGame();
	            }
	            if(evt.getActionCommand().equals("QUIT")) {
	            	//WENN 'Quit' angeklickt wurde,
	        		//DANN beende das Spiel
	            	System.exit(0);
	            }
	            if(evt.getActionCommand().equals("ABOUT")) {
	            	//WENN 'About' angeklickt wurde,
	        		//DANN zeige die AboutBox
	            	showAboutBox();
	            }
	        }
	    }
	}
}
