//Brandon Wlazelek
//LAST UPDATE: 11/26/2016

package com.brandonwlazelek.game.main;

import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;
	public static boolean isRunning = false; // Checks if timer is running

	private Thread thread; // Creates a Thread

	JLabel numLivesLabel; // Create JLabel to print lives
	
	private int FPS = 60; // 60 Frame per second
	private long targetTime = 1000 / FPS;
	
	private MainGamePanel mp; // Creating MainGamePanel
	private JPanel jp; // Creating a instance variable of the base panel
	private GamePanel gp; // Creating instance GamePanel

	public GamePanel(JPanel j) {
		jp = j;
		gp = this;
		jp.setFocusable(true);
		jp.requestFocusInWindow();
		jp.addKeyListener(this);
		Label(); //calls Label method
		start(); // Calls Start Method

	}
	
	//Creates the JLabel;
	public void Label() {
		numLivesLabel = new JLabel("Number of lives: 3");
		numLivesLabel.setBounds(450, 0, 150, 50);
		numLivesLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		add(numLivesLabel);
	}

	//This method subtracts 1 live every time you get hit by a bullet
	public void loseLife(int lives) {
		//Updates JLabel
		remove(numLivesLabel);
		numLivesLabel = new JLabel("Number of lives: " + lives); 
		numLivesLabel.setBounds(450, 0, 150, 50);
		numLivesLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		add(numLivesLabel);
		if (lives == 0) {
			isRunning = false;
		}
	}

	// initializes Thread and isRunning
	public void start() {

		isRunning = true;
		thread = new Thread(this);
		thread.start();

	}

	// Method needed for Runnable which is the timer
	public void run() {
		long start, elapsed, wait;

		mp = new MainGamePanel(this);

		while (isRunning) {

			start = System.nanoTime();

			update();
			repaint();

			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 10000000;
			if (wait <= 0) {
				wait = 5;
			}

			try {
				Thread.sleep(wait);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (isRunning == false) { // switches panels
			jp.remove(gp);
			System.out.println("GAME OVER");
			GameOverPanel gop = new GameOverPanel(jp);
			gop.setBounds(0, 0, 1000, 600);
			jp.add(gop);
			jp.repaint();
		}
	}

	// Updates 60 frame per second
	public void update() {
		mp.update();

	}

	// Paints Graphics 60 Frame per second
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// g.clearRect(0, 0 , WIDTH, HEIGHT);

		mp.draw(g);

	}

	// Checks for key presses
	public void keyPressed(KeyEvent e) {
		mp.keyPressed(e.getKeyCode());

	}

	// Checks for key releases
	public void keyReleased(KeyEvent e) {
		mp.keyReleased(e.getKeyCode());

	}

	// No need for this method
	public void keyTyped(KeyEvent e) {
	}

}