package PingPong;

import java.awt.Graphics2D;

public interface Movable {
	
	public enum Shape {
		CIRCLE, RECTANGLE, TRIANGLE
	}
	public enum Color {
		RED, BLUE
	}
	
	void check_if_collision(Movable Collider);
	
	public void run();
		
	int getVel_Y();

	int getVel_X();

	int getY();

	int getX();
	
	Shape getShape();
	
	void setVel_Y(int Vel_Y);
	
	void setVel_X(int Vel_X);
	
	void setY(int Y);
	
	void setX(int X);
	
	void setShape(Shape shape);
	
	abstract void paint(Graphics2D g2d);
	
	abstract void doCollision();
}
