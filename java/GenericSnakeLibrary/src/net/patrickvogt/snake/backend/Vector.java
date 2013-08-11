package net.patrickvogt.snake.backend;

public class Vector 
{
	/// <summary>
    /// the first component of the vector
    /// </summary>
    private int _x;

    /// <summary>
    /// the second component of the vector
    /// </summary>
    private int _y;

    /// <summary>
    /// gets the first component of the vector
    /// </summary>
    public int getX()
    {
    	return this._x;
    }

    /// <summary>
    /// gets the second component of the vector
    /// </summary>
    public int getY()
    {
    	return this._y;
    }

    /// <summary>
    /// initializes the vector with (0,0)
    /// </summary>
    public Vector()
    {
    	this(0,0);
    }

    /// <summary>
    /// initializes the vector with the given values for x and y
    /// </summary>
    /// <param name="x">the new first component of the vector</param>
    /// <param name="y">the new second component of the vector</param>
    public Vector(int x, int y) 
    {
        this._x = x;
        this._y = y;
    }

    /// <summary>
    /// adds the given vector to the this-vector and returns the result (the this vector is not affected by this method)
    /// </summary>
    /// <param name="that">the vector which should be added to the this vector</param>
    /// <returns>the given vector added to the this vector</returns>
    public Vector add(Vector that) 
    {
        return new Vector(this._x + that._x, this._y + that._y);
    }
}
