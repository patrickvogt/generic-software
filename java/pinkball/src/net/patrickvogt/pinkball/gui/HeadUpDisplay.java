package net.patrickvogt.pinkball.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

import net.patrickvogt.pinkball.geom.GeometricObject;
import net.patrickvogt.pinkball.geom.SolidBlock;
import net.patrickvogt.pinkball.util.Constants;

/*
 * HeadUpDisplay.java
 */

/**
 * implementiert ein HeadUpDisplay, welches zum Beispiel den aktuellen
 * Punktestand anzeigen soll und am oberen Rand des Hauptfensters eingehangen
 * wird
 * 
 * @author Patrick Vogt
 * 
 */
public class HeadUpDisplay extends JPanel
{

    private static final long serialVersionUID = 1L;

    private int WIDTH;
    private int HEIGHT;
    private int _score = 0;

    private java.util.List<GeometricObject> myObjects;

    private String _time = "00:00";

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
            this.myObjects.add(new SolidBlock(_width > _height ? i * min
                    : min_x, _width > _height ? min_y : i * min, min, min,
                    Color.gray));
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

        final int infoWidth = 3 * Constants.GRID_DIMENSION;
        final int fontSize = 14;
        final int padding_x = 3;

        g.setFont(new Font("Arial", Font.BOLD, fontSize));

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, infoWidth, infoWidth);
        g.fillRect(WIDTH - infoWidth, 0, infoWidth, infoWidth);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(this._score), infoWidth
                - g.getFontMetrics().stringWidth(String.valueOf(this._score))
                - padding_x, fontSize);
        g.drawString(
                this._time,
                WIDTH
                        - g.getFontMetrics().stringWidth(
                                String.valueOf(this._time)) - padding_x,
                fontSize);

    }

    public void setScore(int __score)
    {
        this._score = __score;
    }

    public void setTime(final String time)
    {
        this._time = time;
    }
}
