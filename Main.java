package PingPong;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

import PingPong.Paddle;

public class Main {
	static Timer timer;
	public static void main(String[] args) {
		
		
		
		ArrayList<Movable_Package> MoveableList = new ArrayList<Movable_Package>();
		ArrayList<Paddle> PlayerList = new ArrayList<Paddle>();
		ArrayList<Score> ScoreList = new ArrayList<Score>();
		Paddle p1 = new Paddle(190, 10, 120, 20, java.awt.Color.RED, 1);
		Paddle p2 = new Paddle(190, 730, 120, 20,java.awt.Color.BLUE, 2);
		Ball b1 = new Ball();
		Score_container s1 = new Score_container(20,300);
		s1.setPlayer(1);
		Score_container s2 = new Score_container(500, 300);
		s2.setPlayer(2);
		ScoreList.add(s1);
		ScoreList.add(s2);
		MoveableList.add(p1);
		MoveableList.add(p2);
		MoveableList.add(b1);
		MoveableList.add(s1);
		MoveableList.add(s2);
	
		PlayerList.add(p1);
		PlayerList.add(p2);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,800);
        frame.setResizable(false); //Prevent Resize
        frame.setVisible(true);
        DrawHere d = new DrawHere(MoveableList, PlayerList, ScoreList);
        frame.setContentPane(d);
       
       
       
        
		
        timer = new Timer(50, d); // Set time, and this object gets event
		timer.setInitialDelay(100); // Initial wait
		timer.setCoalesce(true); // Don't stack up events
		timer.start(); // Start the timer object
	}

}
