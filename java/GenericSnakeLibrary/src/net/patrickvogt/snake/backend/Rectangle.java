package net.patrickvogt.snake.backend;

public abstract class Rectangle extends AbstractFigure
{
	/// <summary>
    /// the dimension of the rectangle (width and height)
    /// </summary>
    protected Vector _v;

    /// <summary>
    /// initializes the rectangle with foot, dimension and speed
    /// </summary>
    /// <param name="f">the foot of the figure (top-left corner)</param>
    /// <param name="d">the speed of the figure</param>
    /// <param name="v">the dimension of the figure</param>
    public Rectangle(Vector f, Vector d, Vector v) 
    {
    	super(f,d);
	    this._v = v;
    }

    /// <summary>
    /// gets the dimension of the rectangle
    /// </summary>
    public Vector getDimension()
    {
    	return this._v;
    }

    public abstract void paint(IPainter p);

    /// <summary>
    /// gets the current BoundingBox of the rectangle
    /// </summary>
    public BoundingBox getBoundingBox()
    {
    	return new BoundingBox(this._f, this._v);
    }
}
