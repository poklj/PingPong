package PingPong;

import java.awt.Graphics2D;

public class Score_container extends Movable_Package implements Score {
	
	private int Score;
	private int Player;
	
	public Score_container(int posX, int posY) {
		this.setX(posX);
		this.setY(posY);
	}

	@Override
	public int getPlayer() {
		// TODO Auto-generated method stub
		return Player;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return Score;
	}

	@Override
	public void setScore(int x) {
		this.Score =  x;
	}

	@Override
	public void setPlayer(int x) {
		this.Player = x;

	}

	@Override
	public void doCollision() {} // This is here from the Movable_Package, We're going to ignore this

	@Override
	public void paint(Graphics2D g2d) {
		
		g2d.drawString(Integer.toString(Score), this.getX(), this.getY());
		
	}

	@Override
	public void IncrementScore(int x) {
		this.setScore(this.getScore() + x);
	}

}
