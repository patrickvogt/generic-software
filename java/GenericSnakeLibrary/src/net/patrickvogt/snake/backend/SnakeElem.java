package net.patrickvogt.snake.backend;

public class SnakeElem extends Rectangle
{
	/// <summary>
    /// the width of a single snake element
    /// </summary>
    public static final int WIDTH = 20;
    
    /// <summary>
    /// the height of a single snake element
    /// </summary>
    public static final int HEIGHT = 20;

    /// <summary>
    /// initializes the snake element with the given foot and no speed
    /// </summary>
    /// <param name="f">the foot of the snake eleent (top-left corner)</param>
    public SnakeElem(Vector f) 
    {
    	this(f, new Vector (0,0));
    }

    /// <summary>
    /// initializes the snake element with the given foot and the given speed
    /// </summary>
    /// <param name="f">the foot of the snake element (top-left corner)</param>
    /// <param name="d">the speed of the snake element</param>
    protected SnakeElem(Vector f, Vector d)
    {
    	super(f, d, new Vector(SnakeElem.WIDTH,SnakeElem.HEIGHT));
    }

    public void paint(IPainter p)
    {
        p.paint(this);
    }
}
