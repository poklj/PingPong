package PingPong;

import java.awt.Graphics2D;

public abstract class Movable_Package extends Thread implements Movable {

	protected int Vel_Y;
	protected int Vel_X;
	protected int X;
	protected int Y;
	protected Shape shape;
	private int Size_X;
	private int Size_Y;
	private int Side; // 0 for top; 1 for bottom
	private String Type;
	
	public Movable_Package() {
		Vel_Y = 0;
		Vel_X = 0;
		X = 0;
		Y = 0;
		shape = Shape.CIRCLE;
	}
	public void run() {
		
	}
	
	/**
	 * Check against another Movable object to see if it's colliding with it
	 * 
	 * @param Collider Object that we're checking against
	 */
	@Override
	public void check_if_collision(Movable Collider) {
		//TODO: Make a proper collision detection
			if (Collider.getX() >= this.X 
					&& Collider.getX() <= this.X + this.Size_X 
					&& Collider.getY() >= this.Y 
					&& Collider.getY() <= this.Y + this.Size_Y)
			{
				Collider.doCollision();
				System.out.println("COLLIDE");
			}

	}
	
	public abstract int doType();

	/**
	 * get Y Velocity
	 * 
	 * @return Y Velocity 
	 */
	@Override
	public int getVel_Y() {
		return Vel_Y;
	}
	
	/**
	 * get X Velocity
	 * 
	 * @return X velocity
	 */
	@Override
	public int getVel_X() {

		return Vel_X;
	}

	/**
	 * 
	 * Get Y position
	 * 
	 * @return Y position
	 */
	@Override
	public int getY() {

		return Y;
	}

	/**
	 * 
	 * Get X position
	 * 
	 * @return X Position
	 */
	@Override
	public int getX() {

		return X;
	}

	@Override
	public Shape getShape() {

		return shape;
	}

	@Override
	public void setVel_Y(int Vel_Y) {

		this.Vel_Y = Vel_Y;
	}

	@Override
	public void setVel_X(int Vel_X) {

		this.Vel_X = Vel_X;
	}

	@Override
	public void setY(int Y) {

		this.Y = Y;
	}

	@Override
	public void setX(int X) {

		this.X = X;
	}

	@Override
	public void setShape(Shape shape) {
		this.shape = shape;

	}

	@Override
	public abstract void paint(Graphics2D g2d);

	public int getSize_Y() {
		return Size_Y;
	}

	public void setSize_Y(int size_Y) {
		Size_Y = size_Y;
	}

	public int getSize_X() {
		return Size_X;
	}

	public void setSize_X(int size_X) {
		Size_X = size_X;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}


}
