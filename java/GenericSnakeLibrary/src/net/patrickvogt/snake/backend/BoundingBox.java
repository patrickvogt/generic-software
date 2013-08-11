package net.patrickvogt.snake.backend;

public class BoundingBox 
{
	/// <summary>
    /// the foot of the bounding box
    /// </summary>
    private Vector _f;
    /// <summary>
    /// the dimension of the bounding box
    /// </summary>
    private Vector _v;

    public BoundingBox(Vector f, Vector v)
    {
        //fix possible invalid foot and dimension
        int minX = Math.min(f.getX(), f.add(v).getX());
        int maxX = Math.max(f.getX(), f.add(v).getX());
        int minY = Math.min(f.getY(), f.add(v).getY());
        int maxY = Math.max(f.getY(), f.add(v).getY());

        this._f = new Vector(minX, minY);
        this._v = new Vector(maxX - minX, maxY - minY);
    }

    /// <summary>
    /// gets the foot of the bounding box
    /// </summary>
    public Vector getFoot()
    {
            return this._f;
        
    }

    /// <summary>
    /// gets the dimension of the bounding box
    /// </summary>
    public Vector getDimension()
    {

            return this._v;

    }

    /// <summary>
    /// tests if the this boundingbox is left of the given bounding box
    /// </summary>
    /// <param name="b">the bounding box which should be tested</param>
    /// <returns>if the this boundingbox is left of the given bounding box</returns>
    private Boolean _IsLeftOf(BoundingBox b)
    {
        return this.getFoot().getX() > b.getFoot().add(b.getDimension()).getX();
    }

    /// <summary>
    /// tests if the this boundingbox is below the given bounding box
    /// </summary>
    /// <param name="b">the bounding box which should be tested</param>
    /// <returns>if the this boundingbox is below the given bounding box</returns>
    public Boolean _IsBelow(BoundingBox b)
    {
        return b.getFoot().getY() > this.getFoot().add(this.getDimension()).getY();
    }

    /// <summary>
    /// tests if the this bounding box and the given bounding box touches each other
    /// </summary>
    /// <param name="bb">the bounding box which should be tested for the collision</param>
    /// <returns>if the this bounding box and the given bounding box touches each other</returns>
    public Boolean touches(BoundingBox bb)
    {
        return !(this._IsLeftOf(bb) || bb._IsLeftOf(this) || this._IsBelow(bb)
            || bb._IsBelow(this));
    }
}
