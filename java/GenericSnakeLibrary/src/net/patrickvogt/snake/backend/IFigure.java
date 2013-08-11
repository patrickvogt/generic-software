package net.patrickvogt.snake.backend;

public interface IFigure 
{
	 /// <summary>
    /// gets and sets the foot of the figure specifies where the figure must be drawn (left-top corner of the figure)
    /// </summary>
    public Vector getFoot();
    public void setFoot(Vector _f);

    /// <summary>
    /// gets the dimension of the figure specifies the dimension of the figure (width and height)
    /// </summary>
    public Vector getDimension();

    /// <summary>
    /// gets and sets the current speed of the figure (dx and dy)
    /// </summary>
    public Vector getSpeed();
    public void setSpeed(Vector _s);

    /// <summary>
    /// gets the current bounding box of the figure
    /// </summary>
    public BoundingBox getBoundingBox();

    /// <summary>
    /// moves the figure one step and returns the resulting vector of the foot (foot will not be affected by this call)
    /// </summary>
    /// <returns>the foot of the figure after doing one step</returns>
    public Vector tryMove();

    /// <summary>
    /// moves the figure one step (x += dx and y += dy)
    /// </summary>
    public void move();

    void paint(IPainter p);

    /// <summary>
    /// tests, wheter the two figures touches each other
    /// </summary>
    /// <param name="f">the figure which should be checked with the this-Figure</param>
    /// <returns>wheter the two figures touches each other</returns>
    public Boolean touches(IFigure f);
}
