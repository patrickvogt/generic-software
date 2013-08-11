package net.patrickvogt.snake.backend;

public interface IPainter 
{
	void paint(Barrier b);
	void paint(FigureCollection fc);
	void paint(Food f);
	void paint(Rectangle r);
	void paint(Snake s);
	void paint(SnakeElem e);
	void paint(SnakeHead h);
	void reset();
}
