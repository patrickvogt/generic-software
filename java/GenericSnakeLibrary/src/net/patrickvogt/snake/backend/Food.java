package net.patrickvogt.snake.backend;
import java.util.Random;


public class Food extends Rectangle
{
	/// <summary>
    /// initializes the food element with no speed and the standard width and height of a snake element
    /// </summary>
    public Food()
    {
    	super(new Vector(0,0), new Vector(0, 0), new Vector(SnakeElem.WIDTH, SnakeElem.HEIGHT));
    }

    /// <summary>
    /// resets the food to a pixel between left and maxWidth-left in x direction 
    /// and top and maxHeight-top in y direction
    /// 
    /// </summary>
    /// <param name="left">the minimium value of the food foot in x direction</param>
    /// <param name="top">the minimium value of the food foot in y direction</param>
    /// <param name="maxWidth">the max value of the food foot in x direction</param>
    /// <param name="maxHeight">the max value of the food foot in y direction</param>
    public void reset(int left, int top, int maxWidth, int maxHeight) 
    {
        //set the food foot to a random pixel
	    Random generator = new Random();

	    int randomX = (int)(generator.nextDouble() * (maxWidth-4*SnakeElem.WIDTH)+2*SnakeElem.WIDTH);
	    int randomY = (int)(generator.nextDouble() * (maxHeight-4*SnakeElem.HEIGHT)+2*SnakeElem.HEIGHT);
	    
	    randomX = randomX - randomX % (SnakeElem.WIDTH+Snake.PADDING);
	    randomY = randomY - randomY % (SnakeElem.HEIGHT+Snake.PADDING);
	    

	    this._f = new Vector(randomX, randomY);
    }

    public void paint(IPainter p)
    {
        p.paint(this);
    }
}
