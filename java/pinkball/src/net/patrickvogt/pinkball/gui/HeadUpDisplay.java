package net.patrickvogt.pinkball.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

import net.patrickvogt.pinkball.geom.GeometricObject;
import net.patrickvogt.pinkball.geom.SolidBlock;

/*
 * HeadUpDisplay.java
 */



/**
 * implementiert ein HeadUpDisplay, welches zum Beispiel den aktuellen Punktestand anzeigen soll
 * und am oberen Rand des Hauptfensters eingehangen wird
 * 
 * @author Patrick Vogt
 *
 */
//HeadUpDisplay ist eine Unterklasse von JPanel
public class HeadUpDisplay extends JPanel {

    private static final long serialVersionUID = 1L;

    private int WIDTH;
    private int HEIGHT;

    private java.util.List<GeometricObject> myObjects;

    public HeadUpDisplay(int _width, int _height)
    {
        // this-Felder setzen
        this.WIDTH = _width;
        this.HEIGHT = _height;

        int min = _width > _height ? _height : _width;
        int max = _width > _height ? _width : _height;
        int min_x = 0;
        int min_y = 0;

        this.myObjects = new LinkedList<GeometricObject>();
        for(int i = 0; i < max / min; i++)
        {
            this.myObjects.add(new SolidBlock(_width > _height ? i * min : min_x,
                    _width > _height ? min_y : i * min, min, min, Color.gray));
        }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(this.WIDTH, this.HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for(GeometricObject that : this.myObjects)
        {
            final int x = that.getXAsInt();
            final int y = that.getYAsInt();
            final int width = that.getWidthAsInt();
            final int height = that.getHeightAsInt();

            g.setColor(that.getColor());
            g.fillRect(x, y, width, height);
            g.setColor(Color.lightGray);
            g.drawRect(x, y, width, height);
        }
    }
//	
//	/**
//	 * beschreibt die Weite des oberen horizontalen Rand des Hauptfensters
//	 */
//	private final int WIDTH;
//	
//	/**
//	 * beschreibt die Hoehe des oberen horizontalen Rand des Hauptfensters
//	 */
//	private final int HEIGHT;
//	
//	/**
//	 * Konstante, die beschriebt wie breit die Zeitanzeige sein soll
//	 */
//	private final int timeWidth=2;
//	
//	/**
//	 * speichert den Inhalt des oberen horizontalen Rand des Hauptfensters, der zum Zeichnen benoetigt wird
//	 */
//	private java.util.List<GeometricObject> myObjects;
//	
//	/**
//	 * speichert den aktuellen Punktestand des Spielers
//	 */
//	private Score myScore;	
//	
//	/**
//	 * erzeugt eine neue Instanz von <code>HeadUpDisplay</code>
//	 * 
//	 * @param _width die Breite des oberen horizontalen Rand im Hauptfenster
//	 * 
//	 * @param stoneWidth gleichzeitig Hoehe des oberen Rand, sowie die Hoehe/Breite 
//	 * des einzelnen Steine im Rand
//	 * 
//	 */
//	public HeadUpDisplay(int _width, int stoneWidth, int _delay) {
//		//this-Felder setzen
//		this.WIDTH=_width;
//		this.HEIGHT=stoneWidth;	
//		//leere Liste erzeugen
//		this.myObjects=new LinkedList<GeometricObject>();
//		
//		//ganz links eine Zeit anzeigen
//		this.myObjects.add(new Time(_delay, 0, this.timeWidth*this.HEIGHT));
//		//dann bis zur Mitte Liste mit grauen Steinen fuellen
//		for(int i=this.timeWidth; i*stoneWidth<(this.WIDTH/2-this.HEIGHT); i++) {
//			this.myObjects.add(new SolidBlock(i*stoneWidth,0,stoneWidth));
//		}		
//		//Punktestand des Spielers "nullen"
//		this.myScore = new Score(0);
//		//DANN Liste mit Punktestand fuellen
//		this.myObjects.add(this.myScore);
//		//bis zum Ende mit grauen Steinen fuellen
//		for(int i=0; this.WIDTH/2+this.myScore.getDimension().getWidth()/2+i*stoneWidth<this.WIDTH; i++) {
//			this.myObjects.add(
//					new SolidBlock(this.WIDTH/2+this.myScore.getDimension().getWidth()/2+i*stoneWidth,0,stoneWidth));
//		}
//		//und ganz zum Schluss wieder die Zeit anzeigen
//		this.myObjects.add(new Time(_delay, this.WIDTH-this.timeWidth*this.HEIGHT, this.timeWidth*this.HEIGHT));
//	}
//	
//	/**
//	 * Zugriffsmethode um den aktuellen Punktestand des Spielers neu zu setzen
//	 * 
//	 * @param _myScore neuer Punktestand des Spielers
//	 * 
//	 */
//	public void setScore(int _myScore) {
//		this.myScore.setPoints(_myScore);
//	}
//	
//	/**
//	 * gibt die bevorzugte Dimension des oberen horizontalen Rand des Hauptfensters zurueck
//	 */
//	@Override
//	public Dimension getPreferredSize() {
//		return(new Dimension(this.WIDTH, this.HEIGHT+1));
//	}
//	
////	/**
////	 * zeichnet alle Komponenten in der myObjects-Liste auf dem uebergeben Graphik-Kontext
////	 */
////	@Override
////    public void paintComponent(Graphics g) {  
////        for(Paintable that:this.myObjects) {
////            that.paintMeTo(g);
////        }
////    }
//	
//	/**
//	 * interne Klasse die eine Zeitanzeige mit Aktualisierungs- und Zeichenmethode implementiert
//	 * 
//	 * @author Patrick Vogt
//	 *
//	 */
////	//Time ist eine Unterkasse von GeometricObject
////	private class Time extends GeometricObject {
////		
////		/**
////		 * beschriebt die aktuelle Anzahl der bisher vergangenen Minuten
////		 */
////		private double min=0;
////		
////		/**
////		 * beschreibt die Anzhal der vergangenen Sekunden seit der letzten Minute
////		 */
////		private double sec=0;
////		
////		/**
////		 * beschreibt die Verzoegerungszeit des Timers mit der u.a. bestimmt werden kann, 
////		 * wann eine Sekunde vergangen ist
////		 */
////		private double myDelay;
////		
////		/**
////		 * Konstante, die verhindern soll, dass die 60 bei der Sekundenanzahl angezeigt wird
////		 */
////		private final int switchMinutesConstant=21;
////		
////		/**
////		 * erzeugt eine neue Instanz von <code>Time</code> mit den uebergebenen Anfangswerten
////		 * 
////		 * @param _delay die Verzoegerungszeit des Timers um spaeter die aktuelle Sekundenanzahl zu berechnen
////		 * 
////		 * @param _x die x Poisition im HeadUpDisplay
////		 * 
////		 * @param _width die Weite der Zeitanzeige
////		 * 
////		 */
////		public Time(int _delay, int _x, int _width) {
////			super(_x, 0, _width, HEIGHT);
////			//this-Variable setzen
////			this.myDelay = _delay;
////		}
////		
////		/**
////		 * Zugriffsmethode um die Verzoegerungszeit des Timers zu bekommen
////		 * 
////		 * @return Verzoegerungszeit des Timers
////		 * 
////		 */
////		public double getDelay() {
////			return(this.myDelay);
////		}
////		
////		/**
////		 * Zugriffsmethode um die aktuelle Minutenanzahl (seit Levelbeginn) zu bekommen
////		 * 
////		 * @return ein String, der die aktuelle Minutenanzahl beschreibt
////		 * 
////		 */
////		public String getMin() {
////			return(new DecimalFormat("00").format(this.min));
////		}
////		
////		/**
////		 * Zugriffsmethode um die aktuelle Sekundenanzahl (seit Levelbeginn) zu bekommen
////		 * 
////		 * @return ein String, der die aktuelle Sekundenanzahl beschreibt
////		 * 
////		 */
////		public String getSec() {	
////			return(new DecimalFormat("00").format(this.sec));
////		}
////		
////		/**
////		 * aktualisiert die Zeit seit dem letzten Aufruf
////		 */
////		public void actTime() {
////			//ist schon wieder eine Minute vorbei?
////			if(this.sec+switchMinutesConstant*this.getDelay()/1000>=60) {
////				//WENN ja DANN 'nulle' die Sekunden und zaehle die Minuten eins hoch
////				this.sec=0;
////				this.min++;
////			}
////			else {
////				//ANSONSTEN zaehle einfach die delay ms zur aktuellen Zeit hinzu
////				//milli = 10^3 = 1000, deshalb wird hier durch 1000 geteilt
////				this.sec = this.sec+this.getDelay()/1000;
////			}
////		}
//		
////		/**
////		 * zeichnet die vergangene Zeit (seit Levelbeginn) mit der der <code>this</code>-Koordinate und der 
////		 * <code>this</code>-Dimension auf dem uebergebenen Graphik-Kontext
////		 * 
////		 * @param g GraphikKontext, auf dem die Zeitanzeige gezeichnet werden soll
////		 * 
////		 */
////		@Override
////		public void paintMeTo(Graphics g) {
////			//aktualisiere Zeit
////			this.actTime();
////			g.setColor(Color.BLACK);
////			//zeichne schwarzes Hintergrundkaestchen
////			g.fillRect((int) this.getPosition().getX(), (int) this.getPosition().getY(), 
////					(int) this.getDimension().getWidth(), (int) this.getDimension().getHeight()+1); 
////			g.setColor(Color.WHITE);
////			//Setze die Schriftart
////			g.setFont(new Font("Arial", Font.BOLD, 3*HEIGHT/4));
////			//Zeichne die Zeit, wobei Minuten und Sekunden mit ':' getrennt werden
////			g.drawString(String.valueOf(this.getMin()+":"+this.getSec()), 
////					(int) this.getPosition().getX()+2, (int) (this.getPosition().getY()+3*this.getDimension().getHeight()/4));
////		}
//	}
//	
//	/**
//	 * interne Klasse die den Punktestand (und dessen Position) beschreibt und eine spezielle Zeichenmethode
//	 * (engl. <code>paintMeTo</code>) besitzt
//	 * 
//	 * @author Patrick Vogt
//	 *
//	 */
//	//Score ist eine Unterklasse von GeometricObject
//	private class Score extends GeometricObject {
//		
//		/**
//		 * beschreibt den aktuellen Punktestand des Spielers 
//		 */
//		private int myPoints;
//		
//		/**
//		 * erzeugt eine neue Instanz von <code>HedUpDisplay</code> mit dem uebergebenen IntegerWert 
//		 * 
//		 * @param _myPoints Anfangspunktestand des Spielers
//		 * 
//		 */
//		public Score(int _myPoints) {
//			super(WIDTH/2-HEIGHT, 0, 2*HEIGHT, HEIGHT);
//			this.myPoints = _myPoints;
//		}
//		
//		/**
//		 * Zugriffsmethode um den aktuellen Punktestand des Spielers zu bekommen
//		 * 
//		 * @return aktueller Punktestand des Spielers
//		 * 
//		 */
//		public int getPoints() {
//			return(this.myPoints);
//		}
//		
//		/**
//		 * Zugriffsmethode um den aktuellen Punktestand des Spielers auf den uebergeben Wert zu setzen
//		 * 
//		 * @param _myPoints neuer Punktestand des Spielers
//		 * 
//		 */
//		public void setPoints(int _myPoints) {
//			this.myPoints=_myPoints;
//		}
//		
//		/**
//		 * Zeichenmethode die den aktuellen Punktestand des Spielers auf dem uebergebenen Graphik-Kontext
//		 * zeichnet
//		 * 
//		 * @param g der Graphik-Kontext auf dem der Punktestand gezeichnet werden soll
//		 * 
//		 */
//		@Override
//		public void paintMeTo(Graphics g) {
//			//aktuelle Farbe auf Schwarz setzen
//			g.setColor(Color.BLACK);
//			//Hintergrundfeld zeichnen
//			g.fillRect((int) this.getPosition().getX(), (int) this.getPosition().getY(), 
//					(int) this.getDimension().getWidth(), (int) this.getDimension().getHeight()+1); 
//			//aktuelle Farbe auf Weiss setzen
//			g.setColor(Color.WHITE);
//			//Schrift setzen
//			g.setFont(new Font("Arial", Font.BOLD, 3*HEIGHT/4));
//			//aktuellen Spielstand zeichnen
//			g.drawString(String.valueOf(this.getPoints()), 
//					(int) this.getPosition().getX()+5, (int) (this.getPosition().getY()+3*this.getDimension().getHeight()/4));
//		}
//
//        @Override
//        public void paint(IPainter p)
//        {
//            // TODO Auto-generated method stub
//            
//        }
//	}
}
