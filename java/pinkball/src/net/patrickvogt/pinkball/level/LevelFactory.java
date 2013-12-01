package net.patrickvogt.pinkball.level;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import net.patrickvogt.pinkball.geom.Ball;
import net.patrickvogt.pinkball.geom.BlackHole;
import net.patrickvogt.pinkball.geom.BlowUpBlock;
import net.patrickvogt.pinkball.geom.BrokenBlock;
import net.patrickvogt.pinkball.geom.GeometricObject;
import net.patrickvogt.pinkball.geom.OutputHole;
import net.patrickvogt.pinkball.geom.SelectiveWall;
import net.patrickvogt.pinkball.geom.ShrinkBlock;
import net.patrickvogt.pinkball.geom.SolidBlock;
import net.patrickvogt.pinkball.util.Constants;

public final class LevelFactory
{
    private static final String _NODE_BALL = "ball";
    private static final String _NODE_OUTPUT_HOLE = "output-hole";
    private static final String _NODE_BLACK_HOLE = "black-hole";
    private static final String _NODE_BROKEN_BLOCK = "broken-block";
    private static final String _NODE_SOLID_BLOCK = "solid-block";
    private static final String _NODE_SELECTIVE_WALL = "selective-wall";
    private static final String _NODE_BLOW_UP_BLOCK = "blow-up-block";
    private static final String _NODE_SHRINK_BLOCK = "shrink-block";
    private static final String _NODE_LEVEL = "level";

    private static final String _ATTRIBUTE_POSITION = "position";
    private static final String _ATTRIBUTE_DIAMETER = "diameter";
    private static final String _ATTRIBUTE_WIDTH = "width";
    private static final String _ATTRIBUTE_HEIGHT = "height";
    private static final String _ATTRIBUTE_COLOUR = "colour";

    private static final int _X_INDEX = 0;
    private static final int _Y_INDEX = 1;

    private static Map<String, Color> _colour_map = null;
    private static final int _GRID_DIMENSION = Constants.GRID_DIMENSION;

    static
    {
        _colour_map = new TreeMap<String, Color>();

        _colour_map.put("blue", Color.blue);
        _colour_map.put("orange", Color.orange);
        _colour_map.put("red", Color.red);
    }

    public static final class Level
    {
        private List<GeometricObject> _level_content = null;;
        private List<Ball> _balls = null;
        private OutputHole _outputHole = null;
        
        private int _width = 0;
        private int _height = 0;

        public Level()
        {
            this._level_content = new LinkedList<GeometricObject>();
            this._balls = new LinkedList<Ball>();
        }

        public final void add(final GeometricObject __go)
        {
            if(__go instanceof Ball)
            {
                this._balls.add((Ball) __go);
            }
            else if(__go instanceof OutputHole)
            {
                this._outputHole = (OutputHole) __go;
            }
            else
            {
                this._level_content.add(__go);
            }
        }

        public final List<GeometricObject> getLevelContent()
        {
            return this._level_content;
        }

        public final OutputHole getOutputHole()
        {
            return this._outputHole;
        }

        public final List<Ball> getBalls()
        {
            return this._balls;
        }
        
        public final int getWidth()
        {
            return this._width;
        }
        
        public final int getHeight()
        {
            return this._height;
        }
        
        final void setWidth(final int __width)
        {
            this._width = __width;
        }
        
        final void setHeight(final int __height)
        {
            this._height = __height;
        }
    }

    private LevelFactory()
    {
        super();
    }

    private static final float parseCoordinate(final Node __n, final int __index)
    {
        final String positionString = __n.getAttributes()
                .getNamedItem(LevelFactory._ATTRIBUTE_POSITION).getNodeValue();

        final String trimmedString = positionString.replace('(', ' ')
                .replace(')', ' ').trim();
        final String[] coords = trimmedString.split(",");

        return Float.parseFloat(coords[__index]) * LevelFactory._GRID_DIMENSION;
    }

    private static final float parsePositionX(final Node __n)
    {
        return parseCoordinate(__n, LevelFactory._X_INDEX);
    }

    private static final float parsePositionY(final Node __n)
    {
        return parseCoordinate(__n, LevelFactory._Y_INDEX);
    }

    private static final float parseWidth(final Node __n)
    {
        final String widthString = __n.getAttributes()
                .getNamedItem(LevelFactory._ATTRIBUTE_WIDTH).getNodeValue();

        return Float.parseFloat(widthString.trim())
                * LevelFactory._GRID_DIMENSION;
    }

    private static final float parseHeight(final Node __n)
    {
        final String heightString = __n.getAttributes()
                .getNamedItem(LevelFactory._ATTRIBUTE_HEIGHT).getNodeValue();

        return Float.parseFloat(heightString.trim())
                * LevelFactory._GRID_DIMENSION;
    }

    private static final float parseDiameter(final Node __n)
    {
        final String radiusString = __n.getAttributes()
                .getNamedItem(_ATTRIBUTE_DIAMETER).getNodeValue();

        return Float.parseFloat(radiusString.trim())
                * LevelFactory._GRID_DIMENSION;
    }

    private static final Color parseColour(final Node __n)
    {
        final String colourString = __n.getAttributes()
                .getNamedItem(LevelFactory._ATTRIBUTE_COLOUR).getNodeValue();
        
        final Color colour = _colour_map.get(colourString.trim());

        return null == colour ? Color.gray : colour;
    }

    private static final void handleNode(final Node __n,
            final LevelFactory.Level __level)
    {
        float pos_x = 0.0f;
        float pos_y = 0.0f;
        float diameter = 0.0f;
        float width = 0.0f;
        float height = 0.0f;
        Color colour = null;

        if(__n.getNodeName().equals(LevelFactory._NODE_LEVEL))
        {
            width = LevelFactory.parseWidth(__n);
            height = LevelFactory.parseHeight(__n);
            __level.setWidth((int)width);
            __level.setHeight((int)height);
        }
        else if(__n.getNodeName().equals(LevelFactory._NODE_BALL))
        {
            diameter = LevelFactory.parseDiameter(__n);
            colour = LevelFactory.parseColour(__n);
            __level.add(new Ball(diameter, colour));
        }
        else if(__n.getNodeName().equals(LevelFactory._NODE_OUTPUT_HOLE))
        {
            pos_x = LevelFactory.parsePositionX(__n);
            pos_y = LevelFactory.parsePositionY(__n);
            width = LevelFactory.parseWidth(__n);
            height = LevelFactory.parseHeight(__n);

            __level.add(new OutputHole(pos_x, pos_y, width, height));
        }
        else if(__n.getNodeName().equals(LevelFactory._NODE_BLACK_HOLE))
        {
            pos_x = LevelFactory.parsePositionX(__n);
            pos_y = LevelFactory.parsePositionY(__n);
            width = LevelFactory.parseWidth(__n);
            height = LevelFactory.parseHeight(__n);
            colour = LevelFactory.parseColour(__n);

            __level.add(new BlackHole(pos_x, pos_y, width, height, colour));
        }
        else if(__n.getNodeName().equals(LevelFactory._NODE_SELECTIVE_WALL))
        {
            pos_x = LevelFactory.parsePositionX(__n);
            pos_y = LevelFactory.parsePositionY(__n);
            width = LevelFactory.parseWidth(__n);
            height = LevelFactory.parseHeight(__n);
            colour = LevelFactory.parseColour(__n);

            __level.add(new SelectiveWall(pos_x, pos_y, width, height, colour));
        }
        else if(__n.getNodeName().equals(LevelFactory._NODE_BLOW_UP_BLOCK))
        {
            pos_x = LevelFactory.parsePositionX(__n);
            pos_y = LevelFactory.parsePositionY(__n);
            width = LevelFactory.parseWidth(__n);
            height = LevelFactory.parseHeight(__n);
            colour = LevelFactory.parseColour(__n);

            __level.add(new BlowUpBlock(pos_x, pos_y, width, height, colour));
        }
        else if(__n.getNodeName().equals(LevelFactory._NODE_SHRINK_BLOCK))
        {
            pos_x = LevelFactory.parsePositionX(__n);
            pos_y = LevelFactory.parsePositionY(__n);
            width = LevelFactory.parseWidth(__n);
            height = LevelFactory.parseHeight(__n);
            colour = LevelFactory.parseColour(__n);

            __level.add(new ShrinkBlock(pos_x, pos_y, width, height, colour));
        }
        else if(__n.getNodeName().equals(LevelFactory._NODE_SOLID_BLOCK))
        {
            pos_x = LevelFactory.parsePositionX(__n);
            pos_y = LevelFactory.parsePositionY(__n);
            width = LevelFactory.parseWidth(__n);
            height = LevelFactory.parseHeight(__n);
            colour = LevelFactory.parseColour(__n);

            __level.add(new SolidBlock(pos_x, pos_y, width, height, colour));
        }
        else if(__n.getNodeName().equals(LevelFactory._NODE_BROKEN_BLOCK))
        {
            pos_x = LevelFactory.parsePositionX(__n);
            pos_y = LevelFactory.parsePositionY(__n);
            width = LevelFactory.parseWidth(__n);
            height = LevelFactory.parseHeight(__n);
            colour = LevelFactory.parseColour(__n);

            __level.add(new BrokenBlock(pos_x, pos_y, width, height, colour));
        }
    }

    private static final void traverseXMLTree(final Node __n,
            final LevelFactory.Level __level)
    {
        handleNode(__n, __level);

        final NodeList children = __n.getChildNodes();

        for(int i = 0; i < children.getLength(); i = i + 1)
        {
            traverseXMLTree(children.item(i), __level);
        }
    }

    private static final void parseXML(final InputStream __is,
            final LevelFactory.Level __level)
    {
        final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try
        {
            final DocumentBuilder db = dbf.newDocumentBuilder();
            final Document d = db.parse(__is);

            traverseXMLTree(d, __level);
        }
        catch(final ParserConfigurationException ex)
        {
            ex.printStackTrace();
        }
        catch(final SAXException ex)
        {
            ex.printStackTrace();
        }
        catch(final IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static final LevelFactory.Level parseLevel(final String __xmlPath)
    {
        try
        {
            final LevelFactory.Level level = new LevelFactory.Level();

            final InputStream is = LevelFactory.class
                    .getResourceAsStream(__xmlPath);

            LevelFactory.parseXML(is, level);

            is.close();

            return level;
        }
        catch(final IOException ex)
        {
            ex.printStackTrace();
        }

        return null;
    }
}
