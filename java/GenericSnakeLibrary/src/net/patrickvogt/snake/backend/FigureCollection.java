package net.patrickvogt.snake.backend;
import java.util.LinkedList;
import java.util.List;


public class FigureCollection implements IFigure
{
	/// <summary>
    /// the internal collection of the figures
    /// </summary>
    protected List<IFigure> _behaelter = new LinkedList<IFigure>();

    /// <summary>
    /// initializes the figure collection
    /// </summary>
    public FigureCollection()
    {
    }

    /// <summary>
    /// gets and sets the foot of the collection
    /// </summary>
    public Vector getFoot()
    {
            int minX = this._behaelter.get(0).getFoot().getX();
            int minY = this._behaelter.get(0).getFoot().getY();

            for(IFigure f : this._behaelter)
            {
                if (f.getFoot().getX() < minX)
                {
                    minX = f.getFoot().getX();
                }
                if (f.getFoot().getY() < minY)
                {
                    minY = f.getFoot().getY();
                }
            }

            return new Vector(minX, minY);
    }
        
    public void setFoot(Vector _f)
        {
            for(IFigure f : this._behaelter)
            {
                f.setFoot(_f);
            }
        }

    /// <summary>
    /// gets the dimension of the collection
    /// </summary>
    public Vector getDimension()
    {
            int minX = this._behaelter.get(0).getFoot().getX();
            int minY = this._behaelter.get(0).getFoot().getY();
            int maxX = this._behaelter.get(0).getFoot().getX();
            int maxY = this._behaelter.get(0).getFoot().getY();

            for (IFigure f : this._behaelter)
            {
                if (f.getFoot().getX() < minX)
                {
                    minX = f.getFoot().getX();
                }
                if (f.getFoot().getX() > maxX)
                {
                    maxX = f.getFoot().getX();
                }
                if (f.getFoot().getY() < minY)
                {
                    minY = f.getFoot().getY();
                }
                if (f.getFoot().getY() > maxY)
                {
                    maxY = f.getFoot().getY();
                }
            }

            return new Vector(maxX - minX, maxY - minY);
   
    }

    /// <summary>
    /// gets and sets the speed of the collection
    /// </summary>
    public Vector getSpeed()
    {

            Vector tmp = new Vector();
            for(IFigure f : this._behaelter)
            {
                tmp = tmp.add(f.getSpeed());
            }

            return new Vector(tmp.getX() / this._behaelter.size(), tmp.getY() / this._behaelter.size());
    }
    
    public void setSpeed(Vector _s)
        {
            for(IFigure f : this._behaelter)
            {
                f.setSpeed(_s);
            }
        }

    /// <summary>
    /// gets the bounding box for the collection
    /// </summary>
    public BoundingBox getBoundingBox()
    {

            return new BoundingBox(this.getFoot(), this.getDimension());

    }

    /// <summary>
    /// adds the given figure to the collection
    /// </summary>
    /// <param name="figur">the figure which should be added to the collection</param>
    public void add(IFigure figur)
    {
        this._behaelter.add(figur);
    }

    /// <summary>
    /// returns if the collection touches the given figure
    /// </summary>
    /// <param name="f">the figure which should be added to the collection</param>
    /// <returns>if the collection touches the given figure</returns>
    public Boolean touches(IFigure f)
    {
        return (this.getBoundingBox().touches(f.getBoundingBox()));
    }

    /// <summary>
    /// moves the collection
    /// </summary>
    public void move()
    {
        for(IFigure f : this._behaelter)
        {
            f.move();
        }
    }

    /// <summary>
    /// not implemented for the figure collection
    /// </summary>
    /// <returns></returns>
    public Vector tryMove()
    {
        return new Vector(-1, -1);
    }

    public void paint(IPainter p)
    {
        for(IFigure f : this._behaelter)
        {
            f.paint(p);
        }
    }

    /// <summary>
    /// returns the element at the given index
    /// </summary>
    /// <param name="index">specifies which element should be returned</param>
    /// <returns>the element at the given index</returns>
    public IFigure elementAt(int index)
    {
        return this._behaelter.get(index);
    }

    /// <summary>
    /// returns the current soze of the collection
    /// </summary>
    /// <returns>the current soze of the collection</returns>
    public int size()
    {
        return this._behaelter.size();
    }
}
