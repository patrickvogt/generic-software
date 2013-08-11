package net.patrickvogt.snake.backend;

public class Barrier extends Rectangle
{
	/// <summary>
    /// initializes the barrier with the given foot and the given dimension
    /// </summary>
    /// <param name="f">the foot of the barrier (the top-left corner)</param>
    /// <param name="v">the dimension of the barrier (width and height)</param>
    public Barrier(Vector f, Vector v) 
    {
    	super(f, new Vector(1, 0), v);
    }

    public void paint(IPainter p)
    {
        p.paint(this);
    }
}
