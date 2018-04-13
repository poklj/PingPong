package PingPong;

import java.awt.Graphics2D;

public interface Score {
	
	public int getPlayer();
	
	public int getScore();
	
	public void IncrementScore(int x);
	
	public void setScore(int x);
	
	public void setPlayer(int x);
	
	public abstract void paint(Graphics2D g2d);
}
