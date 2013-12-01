package net.patrickvogt.pinkball.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

import net.patrickvogt.pinkball.geom.GeometricObject;
import net.patrickvogt.pinkball.geom.SolidBlock;

public class Border extends JPanel
{
    private static final long serialVersionUID = 1L;

    private int WIDTH;
    private int HEIGHT;

    private java.util.List<GeometricObject> myObjects;

    public Border(int _width, int _height)
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
}
