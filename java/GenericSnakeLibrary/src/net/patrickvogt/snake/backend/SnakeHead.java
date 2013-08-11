package net.patrickvogt.snake.backend;

public class SnakeHead extends SnakeElem
{
	/// <summary>
    /// the distance between two snake elements
    /// </summary>
    public static final int D_UNIT = SnakeElem.WIDTH+Snake.PADDING;

    /// <summary>
    /// initializes the snake head with the given foot
    /// </summary>
    /// <param name="f">the foot of the snake head (the top left corner)</param>
    public SnakeHead(Vector f)
    {
    	super(f, new Vector(SnakeHead.D_UNIT, 0));
    }

    public void paint(IPainter p)
    {
        p.paint(this);
    }
}
