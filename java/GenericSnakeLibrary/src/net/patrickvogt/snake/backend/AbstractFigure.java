package net.patrickvogt.snake.backend;

public abstract class AbstractFigure implements IFigure
{
	/// <summary>
    /// the foot (x,y) (top left corner of the figure) 
    /// </summary>
    protected Vector _f;

    /// <summary>
    /// the speed (dx and dy) of the figure
    /// </summary>
    protected Vector _d;

    /// <summary>
    /// initializes the abstract figure with the given foot (top left corner) and the given dimension (width and height)
    /// </summary>
    /// <param name="f">the foot of the figure (top left corner)</param>
    /// <param name="d">the speed of the figure</param>
    public AbstractFigure(Vector f, Vector d)
    {
        this._f = f;
        this._d = d;
    }

    /// <summary>
    /// gets and sets the foot of the figure specifies where the figure must be drawn (left-top corner of the figure)
    /// </summary>
    public Vector getFoot()
    {

            return this._f;
        }
    
    public void setFoot(Vector _f)
    {
            this._f = _f;
        
    }

    /// <summary>
    /// gets the dimension of the figure specifies the dimension of the figure (width and height)
    /// </summary>
    public abstract Vector getDimension();

    /// <summary>
    /// gets and sets the current speed of the figure (dx and dy)
    /// </summary>
    public Vector getSpeed()
    {

            return this._d;
        }
        
    
    public void setSpeed(Vector _s)
        {
            this._d = _s;
        }

    /// <summary>
    /// gets the current bounding box of the figure
    /// </summary>
    public abstract BoundingBox getBoundingBox();

    /// <summary>
    /// tests, wheter the two figures touches each other
    /// </summary>
    /// <param name="f">the figure which should be checked with the this-Figure</param>
    /// <returns>wheter the two figures touches each other</returns>
    public Boolean touches(IFigure f)
    {
        return this.getBoundingBox().touches(f.getBoundingBox());
    }

    public abstract void paint(IPainter p);

    /// <summary>
    /// moves the figure one step (x += dx and y += dy)
    /// </summary>
    public void move()
    {
        this._f = this._f.add(this._d);
    }

    /// <summary>
    /// moves the figure one step and returns the resulting vector of the foot (foot will not be affected by this call)
    /// </summary>
    /// <returns>the foot of the figure after doing one step</returns>
    public Vector tryMove()
    {
        return this._f.add(this._d);
    }
}
