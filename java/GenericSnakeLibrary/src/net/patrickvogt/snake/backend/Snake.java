package net.patrickvogt.snake.backend;
import java.util.LinkedList;
import java.util.List;

public class Snake extends FigureCollection {
	// / <summary>
	// / distance between two snake elements in pixel
	// / </summary>
	public static final int PADDING = 5;

	private int _left = 0;
	private int _top = 0;

	// / <summary>
	// / enum for the two possible moving directions of the snake
	// / </summary>
	enum Direction {
		Horizontal, Vertical
	}

	// / <summary>
	// / the current direction of the snake
	// / </summary>
	private Direction dir = Direction.Horizontal;

	// / <summary>
	// / initializes the snake to the given foot (top left corner)
	// / </summary>
	// / <param name="left">the x component of the foot of the last snake
	// element</param>
	// / <param name="top">the y component of the foot of the last snake
	// element</param>
	public Snake(int left, int top) {
		_left = left;
		_top = top;

		Init();
	}

	private void Init() {
		List<IFigure> tmp = new LinkedList<IFigure>();

		Vector lastFP = new Vector(this._left, this._top);
		Vector lastV = new Vector();

		// add snake elements
		for (int i = 0; i < 3; i++) {
			SnakeElem e = new SnakeElem(new Vector(lastFP.getX() + lastV.getX(), lastFP.getY()));

			lastFP = new Vector(e.getFoot().getX()+ Snake.PADDING, e.getFoot().getY());
			lastV = e.getDimension();

			tmp.add(0, e);
		}

		// add snake head
		SnakeHead k = new SnakeHead(new Vector(lastFP.getX() + lastV.getX(), lastFP.getY()));
		tmp.add(0, k);

		for (IFigure f : tmp) {
			this._behaelter.add(f);
		}
	}

	// / <summary>
	// / gets and sets the foot of the snake head
	// / </summary>
	public Vector getFoot() {
		return this._behaelter.get(0).getFoot();
	}

	public void setFoot(Vector _f) {
		this._behaelter.get(0).setFoot(_f);
	}

	// / <summary>
	// / gets the dimension of the snake head
	// / </summary>
	public Vector getDimension() {

		return this._behaelter.get(0).getDimension();

	}

	// / <summary>
	// / gets and sets the speed of the snake head
	// / </summary>
	public Vector getSpeed() {

		return this._behaelter.get(0).getSpeed();
	}

	public void setSpeed(Vector _s) {
		this._behaelter.get(0).setSpeed(_s);
	}

	// / <summary>
	// / adds one snake element to the existing snake
	// / </summary>
	public void grow() {
		Vector lastFP = this._behaelter.get(this.size() - 1).getFoot();
		Vector prelastFP = this._behaelter.get(this.size() - 2).getFoot();

		// snake moves horizontally
		if (lastFP.getY() == prelastFP.getY()) {
			// snake moves left to right
			if (lastFP.getX() > prelastFP.getX()) {
				this._behaelter.add(new SnakeElem(new Vector(lastFP.getX()
						+ (Snake.PADDING + SnakeElem.WIDTH), lastFP.getY())));
			}
			// snake moves right to left
			else {
				this._behaelter.add(new SnakeElem(new Vector(lastFP.getX()
						- (Snake.PADDING + SnakeElem.WIDTH), lastFP.getY())));
			}
		}
		// snake moves vertically
		else if (lastFP.getX() == prelastFP.getX()) {
			// snake moves from top to bottom
			if (lastFP.getY() > prelastFP.getY()) {
				this._behaelter.add(new SnakeElem(new Vector(lastFP.getX(),
						lastFP.getY() + (Snake.PADDING + SnakeElem.HEIGHT))));
			}
			// snake moves from bottom to top
			else {
				this._behaelter.add(new SnakeElem(new Vector(lastFP.getX(),
						lastFP.getY() - (Snake.PADDING + SnakeElem.HEIGHT))));
			}
		}

	}

	// / <summary>
	// / pulls the tail one element to the snake head
	// / </summary>
	public void pullTail() {
		for (int i = this._behaelter.size() - 1; i > 0; i--) {
			this._behaelter.get(i)
					.setFoot(this._behaelter.get(i - 1).getFoot());
		}
	}

	public void reset() {
		Init();
		dir = Direction.Horizontal;
	}

	public void up() {
		if (dir == Direction.Horizontal) {
			this.setSpeed(new Vector(0, -SnakeHead.D_UNIT));
			dir = Direction.Vertical;
		}
	}

	public void right() {
		if (dir == Direction.Vertical) {
			this.setSpeed(new Vector(SnakeHead.D_UNIT, 0));
			dir = Direction.Horizontal;
		}
	}

	public void down() {
		if (dir == Direction.Horizontal) {
			this.setSpeed(new Vector(0, SnakeHead.D_UNIT));
			dir = Direction.Vertical;
		}
	}

	public void left() {
		if (dir == Direction.Vertical) {
			this.setSpeed(new Vector(-SnakeHead.D_UNIT, 0));
			dir = Direction.Horizontal;
		}
	}

	// / <summary>
	// / tests if the snake is in a game over situation
	// / </summary>
	// / <returns>if the snake touches one of its own snake elements</returns>
	public Boolean testGameOverSituation(int width, int height) {
		return this.getFoot().getX() < 0 || this.getFoot().getY() < 0
				|| this.tryMove().getX() > width
				|| this.tryMove().getY() > height || this.touchesSnake();
	}

	// / <summary>
	// / tests if the snake touches one of its own snake elements
	// / </summary>
	// / <returns>if the snake touches one of its own snake elements</returns>
	public Boolean touchesSnake() {
		for (int i = 0; i < this._behaelter.size(); i++) {
			for (int j = i + 1; j < this._behaelter.size(); j++) {
				if (this._behaelter.get(i).touches(this._behaelter.get(j))) {
					return true;
				}
			}
		}

		return false;
	}

	// / <summary>
	// / moves the snake head about the speed vector
	// / </summary>
	public void move() {
		this._behaelter.get(0).move();
	}

	// / <summary>
	// / returns the foot of the snake after moving one step (the actual foot is
	// not affected through this method)
	// / </summary>
	// / <returns>the foot of the snake after moving one step</returns>
	public Vector tryMove() {
		return this._behaelter.get(0).tryMove();
	}
}
