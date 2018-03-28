package PingPong;

import java.awt.color.*;
import java.awt.Graphics2D;

public class Paddle extends Movable_Package implements Player {
	private Shape shape = Shape.RECTANGLE; // This is only to allow methods to get it's shape, This has zero Effect on
										  // the actual paint

	private int windowWidth;
	private int windowHeight;
	private int player;
	protected java.awt.Color Color;
	
	/**
	 * Paddle - Implements player
	 * 
	 * Should be passed through a Player List and a Movable list
	 * 
	 * @param xpos X Position
	 * @param ypos Y Position
	 * @param Size_X Size in X axis
	 * @param Size_Y Size in Y axis
	 * @param color Color (AWT)
	 * @param player Player associated
	 */
	public Paddle(int xpos, int ypos, int Size_X, int Size_Y, java.awt.Color color, int player) {
		this.setShape(shape);
		this.setVel_X(0);
		this.setVel_Y(0);
		this.setX(xpos);
		this.setY(ypos);
		this.setSize_X(Size_X);
		this.setSize_Y(Size_Y);
		this.Color = color;
		this.player = player;
		System.out.println(this.getSize_X() + this.getSize_Y() );
	}


	@Override
	public void paint(Graphics2D g2d) {
		int x = (int) this.getX(); //This allows subpixeling
		int y = (int) this.getY();
		int sY = (int) this.getSize_Y();
		int sX = (int) this.getSize_X();
		
		
		g2d.setColor(Color);
		//x, y, size x, size y
		//g2d.fill3DRect(x, y , 120, 20 , false);
		g2d.fill3DRect(x, y , sX, sY , false);
		this.setX(this.getX());
	}

	/**
	 * Move Paddle to the left
	 */
	@Override
	public void moveLeft() {
		if (this.getX() > 0) {
			this.setX(this.getX() - 10);
		}
	}

	/**
	 * Move Paddle to the Right
	 */
	@Override
	public void moveRight() {
		if (this.getX() + this.getSize_X() < 580) {
			this.setX(this.getX() + 10);
		}
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public void setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
	}
	public int getPlayer() {
		return player;
	}
	@Override
	public void doCollision() {

	}
}
