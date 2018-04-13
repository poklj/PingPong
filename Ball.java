package PingPong;

import java.awt.Graphics2D;
import java.util.Random;

public class Ball extends Movable_Package {
	
	static Random Rand = new Random();
	public Ball() {
		this.setX(300);
		this.setY(300);
		this.setSize_X(20);
		this.setSize_Y(20);
		this.setType("Ball");
		this.Vel_X = Rand.nextInt(10) -5 ; //Create a random number between -5 and 5 (Favor Y axis for hits)
		
		if (Rand.nextBoolean()) { // fire Up
				this.Vel_Y = Rand.nextInt(5) + 5; //Speed from 5 to 10
		} else { // fire down
			this.Vel_Y = Rand.nextInt(5) - 10; // Speed from 5 to 10
		}
		
	}
	
	/**
	 * Do one ball tick
	 * 
	 * This tick moves the ball in its velocity and if it collides with a Wall will cause it to ricochet
	 */
	public void ballTick() {
		boolean hit = false;
		if(this.getX() + this.getVel_X() <= 0
			|| this.getX() + getVel_X() >= 580 + 10 && !hit ) {
				this.setVel_X(-this.getVel_X());
				System.out.println(this.getVel_X() +" " +this.getX());
				hit = true;
		} else {
			hit = false;
		}
		this.setX(this.getX() + this.getVel_X());
		this.setY(this.getY() + this.getVel_Y());
		
		
	}
	private void randomDirection() {
		if (Rand.nextBoolean()) { // fire Up
			this.Vel_Y = Rand.nextInt(5) + 5; //Speed from 5 to 10
		} else { // fire down
			this.Vel_Y = Rand.nextInt(5) - 10; // Speed from 5 to 10
		}
	}
	
	/**
	 * Collide Event
	 * 
	 * Cause the ball to reverse it's direction changing it's X velocity randomly in the process
	 */
	@Override
	public void doCollision() {
		this.setVel_Y(-this.getVel_Y());
		this.setVel_X(this.getVel_X() - (Rand.nextInt(10) - 5)); // Cause the ball to ping off in a random direction
	}

	@Override
	public void paint(Graphics2D g2d) {
		g2d.setColor(java.awt.Color.BLACK);
		g2d.fillOval(X, Y, getSize_X(), getSize_Y());
		this.ballTick();
	}

	@Override
	public int doType() {
		int PlayerSide = 0;
		if (this.getY() < 0 || this.getY() > 800) {
			if (this.getY() < 0) {
				PlayerSide = 1;
			}
			if (this.getY() > 800) {
				PlayerSide = 2;
			}
			this.setX(300);
			this.setY(300);
			this.randomDirection();
			System.out.print(PlayerSide);
			return PlayerSide;
		} else {
			return 0;
		}
	}
	
}
