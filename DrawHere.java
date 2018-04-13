package PingPong;

//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("serial")
//public class DrawHere extends JPanel  {
	public class DrawHere extends JPanel implements ActionListener, KeyListener {

	Graphics2D g2d;
	java.util.ArrayList<Movable_Package> Movables = new java.util.ArrayList<Movable_Package>();
	java.util.ArrayList<Paddle> players = new java.util.ArrayList<Paddle>();
	java.util.ArrayList<Score> score = new java.util.ArrayList<Score>();
	// [false, false ,false, false]
	// Player 1 left, right | Player 2 left, right
	boolean[] keyArray = new boolean[4];
	//Paddle p2 = new Paddle(1, 1);
	public DrawHere(ArrayList<Movable_Package> moveableList, ArrayList<Paddle> PlayerList, ArrayList<Score> scoreList) {//ArrayList<Projectile> projectiles) {
 
		// Set up cat, start the thread
//		for (Projectile object : projectiles) {
//			object.start();
//			Projectiles.add(object);
//		}
		
		Arrays.fill(keyArray, Boolean.FALSE);
		
		for (Paddle object : PlayerList) {
			this.players.add(object);
		}
		for (Score object : scoreList) {
			this.score.add(object);
		}
		for (Movable_Package object : moveableList) {
			object.start();
			this.Movables.add(object);
		}
		
		
		addKeyListener(this);
		//p2.start();
		
		// c2 = new theCat("cat 2", 10, 190, Color.RED);
		// c2.start();

		// Set up key-pressed events onto cat object
		//this.addKeyListener(c1);
		//this.addKeyListener(c2);

		this.setFocusable(true);
		this.requestFocusInWindow();

	}
	
	/**
	 * KeyPressed event - Stores True in a Boolean array to track keys currently being pressed
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println("p"+key);
		
		
		//d 
		if (key == 68) {
			this.keyArray[1] = Boolean.TRUE;
		}
		
		if (key == 65 ) {
			this.keyArray[0] = Boolean.TRUE;
			
		}
		
		if (key == 39) {
			this.keyArray[3] = Boolean.TRUE;
		}
		
		if (key == 37) {
			this.keyArray[2] = Boolean.TRUE;
		}
		
	}
	
	/**
	 * KeyReleased event - Stores False in a Boolean array to track keys that were pressed
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println("r"+key);
		if (key == 68) {
			this.keyArray[1] = Boolean.FALSE;
		}
		if (key == 65) {
			this.keyArray[0] = Boolean.FALSE;
		}
		
		if(key == 39) {
			this.keyArray[3] = Boolean.FALSE;
		}
		if(key == 37) {
			this.keyArray[2] = Boolean.FALSE;
		}
	}

	
	public void paintComponent(Graphics g) {
		// System.out.println("width =" + this.getWidth() + "   "+
		// this.getHeight());
		// ^ This is to grab Height
		
		// Setup and clear the buffer
		BufferedImage bufferedImage = new BufferedImage(this.getWidth(),
				this.getHeight(), BufferedImage.TYPE_INT_BGR);
		g2d = bufferedImage.createGraphics();
		g2d.setColor(getBackground());
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight()); // fill with
																// background
																// color

		// Draw on the buffer
//		for (Projectile object : Projectiles) {
//			object.paint(g2d);
//		}
		// c2.Paint(g2d);
		//p2.paint(g2d);
		
	    for (Movable_Package object : this.Movables) {
            object.paint(g2d);
            for (Movable_Package coli : this.Movables) {
                if (!object.equals(coli)) {
                    object.check_if_collision(coli);
                    
                }
                
            }
            if (object.getType() == "Ball") {
            	int resul = object.doType();
            	if (resul != 0) {
            		if (resul == 1) {
            			if (score.get(0).getPlayer() == 1) {
            				score.get(0).IncrementScore(1);
            				System.out.println(score.get(0).getScore());
            			}
            		}
            		if (resul == 2) {
            			if (score.get(1).getPlayer() == 2) {
            				score.get(1).IncrementScore(1);
            				System.out.println(score.get(1).getScore());
            			}
            		}
            	}
            }
        }

		// Set the buffer to be visible
		Graphics2D g2dComponent = (Graphics2D) g;
		g2dComponent.drawImage(bufferedImage, null, 0, 0);
	}

	
	/**
	 * Used to Send the movement events from the Boolean array to the actual Paddles
	 * 
	 * These are in two bit pairs for Each player paddle, 0 and 1 being Player 1 
	 * 2 and 3 being player two and so forth
	 */
	private void playerHandle() {
		if (keyArray[0] == Boolean.TRUE) {
			players.get(0).moveLeft();
		}
		
		if(keyArray[1] == Boolean.TRUE) {
			players.get(0).moveRight();
		}
		
		if(keyArray[2] == Boolean.TRUE) {
			players.get(1).moveLeft();
		}
		if(keyArray[3] == Boolean.TRUE) {
			players.get(1).moveRight();
		}
		
	}
	

	/**
	 * This method is called when the timer fires The Timer sets off an
	 * "actionPerformed" event every so many milliseconds.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
		this.playerHandle();
		
		

		//Take focus if we don't have it
		if (!this.isFocusOwner()) {
			this.requestFocusInWindow();
		}
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public int getWindowWidth() {
		return this.getWidth();
	}
	
	public int getWindowHeight() {
		return this.getHeight();
	}
}
