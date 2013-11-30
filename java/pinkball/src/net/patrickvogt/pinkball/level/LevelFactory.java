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
    private static final String NODE_BALL = "ball";
    private static final String NODE_OUTPUT_HOLE = "output-hole";
    private static final String NODE_BLACK_HOLE = "black-hole";
    private static final String NODE_BROKEN_BLOCK = "broken-block";
    private static final String NODE_SOLID_BLOCK = "solid-block";
    private static final String NODE_SELECTIVE_WALL = "selective-wall";
    private static final String NODE_BLOW_UP_BLOCK = "blow-up-block";
    private static final String NODE_SHRINK_BLOCK = "shrink-block";

    private static final String ATTRIBUTE_POSITION = "position";
    private static final String ATTRIBUTE_DIAMETER = "diameter";
    private static final String ATTRIBUTE_WIDTH = "width";
    private static final String ATTRIBUTE_HEIGHT = "height";
    private static final String ATTRIBUTE_COLOUR = "colour";

    private static final int X_INDEX = 0;
    private static final int Y_INDEX = 1;

    private static Map<String, Color> colour_map = null;
    private static final int _GRID_DIMENSION = Constants.GRID_DIMENSION;

    static
    {
        colour_map = new TreeMap<String, Color>();

        colour_map.put("blue", Color.blue);
        colour_map.put("orange", Color.orange);
    }

    public static final class Level
    {
        private List<GeometricObject> _level_content;
        private List<Ball> _balls;
        private OutputHole _outputHole;

        public Level()
        {
            this._level_content = new LinkedList<GeometricObject>();
            this._balls = new LinkedList<Ball>();
        }

        public final void add(GeometricObject go)
        {
            if(go instanceof Ball)
            {
                this._balls.add((Ball) go);
            }
            else if(go instanceof OutputHole)
            {
                this._outputHole = (OutputHole) go;
            }
            else
            {
                this._level_content.add(go);
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
    }

    private LevelFactory()
    {
        super();
    }

    private static final float parseCoordinate(final Node n, int index)
    {
        final String positionString = n.getAttributes()
                .getNamedItem(LevelFactory.ATTRIBUTE_POSITION).getNodeValue();

        final String trimmedString = positionString.replace('(', ' ')
                .replace(')', ' ').trim();
        final String[] coords = trimmedString.split(",");

        return Float.parseFloat(coords[index]) * LevelFactory._GRID_DIMENSION;
    }

    private static final float parsePositionX(final Node n)
    {
        return parseCoordinate(n, LevelFactory.X_INDEX);
    }

    private static final float parsePositionY(final Node n)
    {
        return parseCoordinate(n, LevelFactory.Y_INDEX);
    }

    private static final float parseWidth(final Node n)
    {
        final String widthString = n.getAttributes()
                .getNamedItem(LevelFactory.ATTRIBUTE_WIDTH).getNodeValue();

        return Float.parseFloat(widthString.trim())
                * LevelFactory._GRID_DIMENSION;
    }

    private static final float parseHeight(final Node n)
    {
        final String heightString = n.getAttributes()
                .getNamedItem(LevelFactory.ATTRIBUTE_HEIGHT).getNodeValue();

        return Float.parseFloat(heightString.trim())
                * LevelFactory._GRID_DIMENSION;
    }

    private static final float parseDiameter(final Node n)
    {
        final String radiusString = n.getAttributes()
                .getNamedItem(ATTRIBUTE_DIAMETER).getNodeValue();

        return Float.parseFloat(radiusString.trim())
                * LevelFactory._GRID_DIMENSION;
    }

    private static final Color parseColour(final Node n)
    {
        final String colourString = n.getAttributes()
                .getNamedItem(ATTRIBUTE_COLOUR).getNodeValue();

        return colour_map.get(colourString.trim());
    }

    private static final void handleNode(final Node n,
            final LevelFactory.Level level)
    {
        float pos_x = 0.0f;
        float pos_y = 0.0f;
        float diameter = 0.0f;
        float width = 0.0f;
        float height = 0.0f;
        Color colour = null;

        if(n.getNodeName().equals(LevelFactory.NODE_BALL))
        {
            diameter = LevelFactory.parseDiameter(n);
            colour = LevelFactory.parseColour(n);
            level.add(new Ball(diameter, colour));
        }
        else if(n.getNodeName().equals(LevelFactory.NODE_OUTPUT_HOLE))
        {
            pos_x = LevelFactory.parsePositionX(n);
            pos_y = LevelFactory.parsePositionY(n);
            width = LevelFactory.parseWidth(n);
            height = LevelFactory.parseHeight(n);

            level.add(new OutputHole(pos_x, pos_y, width, height));
        }
        else if(n.getNodeName().equals(LevelFactory.NODE_BLACK_HOLE))
        {
            pos_x = LevelFactory.parsePositionX(n);
            pos_y = LevelFactory.parsePositionY(n);
            width = LevelFactory.parseWidth(n);
            height = LevelFactory.parseHeight(n);
            colour = LevelFactory.parseColour(n);

            level.add(new BlackHole(pos_x, pos_y, width, height, colour));
        }
        else if(n.getNodeName().equals(LevelFactory.NODE_SELECTIVE_WALL))
        {
            pos_x = LevelFactory.parsePositionX(n);
            pos_y = LevelFactory.parsePositionY(n);
            width = LevelFactory.parseWidth(n);
            height = LevelFactory.parseHeight(n);
            colour = LevelFactory.parseColour(n);

            level.add(new SelectiveWall(pos_x, pos_y, width, height, colour));
        }
        else if(n.getNodeName().equals(LevelFactory.NODE_BLOW_UP_BLOCK))
        {
            pos_x = LevelFactory.parsePositionX(n);
            pos_y = LevelFactory.parsePositionY(n);
            width = LevelFactory.parseWidth(n);
            height = LevelFactory.parseHeight(n);
            colour = LevelFactory.parseColour(n);

            level.add(new BlowUpBlock(pos_x, pos_y, width, height, colour));
        }
        else if(n.getNodeName().equals(LevelFactory.NODE_SHRINK_BLOCK))
        {
            pos_x = LevelFactory.parsePositionX(n);
            pos_y = LevelFactory.parsePositionY(n);
            width = LevelFactory.parseWidth(n);
            height = LevelFactory.parseHeight(n);
            colour = LevelFactory.parseColour(n);

            level.add(new ShrinkBlock(pos_x, pos_y, width, height, colour));
        }
        else if(n.getNodeName().equals(LevelFactory.NODE_SOLID_BLOCK))
        {
            pos_x = LevelFactory.parsePositionX(n);
            pos_y = LevelFactory.parsePositionY(n);
            width = LevelFactory.parseWidth(n);
            height = LevelFactory.parseHeight(n);
            colour = LevelFactory.parseColour(n);

            level.add(new SolidBlock(pos_x, pos_y, width, height, colour));
        }
        else if(n.getNodeName().equals(LevelFactory.NODE_BROKEN_BLOCK))
        {
            pos_x = LevelFactory.parsePositionX(n);
            pos_y = LevelFactory.parsePositionY(n);
            width = LevelFactory.parseWidth(n);
            height = LevelFactory.parseHeight(n);
            colour = LevelFactory.parseColour(n);

            level.add(new BrokenBlock(pos_x, pos_y, width, height, colour));
        }
    }

    private static final void traverseXMLTree(final Node n,
            final LevelFactory.Level level)
    {
        handleNode(n, level);

        final NodeList children = n.getChildNodes();

        for(int i = 0; i < children.getLength(); i = i + 1)
        {
            traverseXMLTree(children.item(i), level);
        }
    }

    private static final void parseXML(final InputStream is,
            final LevelFactory.Level level)
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse(is);

            traverseXMLTree(d, level);
        }
        catch(final ParserConfigurationException ex)
        {
            ex.printStackTrace();
        }
        catch(SAXException ex)
        {
            ex.printStackTrace();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static final LevelFactory.Level parseLevel(final String xmlPath)
    {
        try
        {
            final LevelFactory.Level level = new LevelFactory.Level();

            final InputStream is = LevelFactory.class
                    .getResourceAsStream(xmlPath);

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
