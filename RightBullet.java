package com.brandonwlazelek.game.main;

//Brandon Wlazelek
//Adam
//LAST UPDATE: 11/26/2016


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RightBullet {
	/**
	 * 
	 */
	private Player player; // Creates a player
	private int x; // Bullet x position
	private int y; // Bullet y position
	private int WIDTH = 30; // Bullet width
	private int HEIGHT = 30; // Bullet height
	private BufferedImage rightBullet; // Creates image from folder
	private int velocity; // Creates velocity for bullet
	private boolean isHit = false; // check if bullet hits something

	// Constructor
	public RightBullet(Player p) {
		player = p;
		this.x = 1000;

		this.y = (int) (Math.random() * 291) + 100; // Random y between 100 and
													// 390
		velocity = (int) (Math.random() * 6) + 3; // Random velocity between 3
													// and 8
		try {
			rightBullet = ImageIO.read(new File("assets/RightBullet.png")); // Grabs
																			// the
																			// picture
																			// in
																			// the
																			// assetsS
																			// folder

		} catch (IOException ex) {
			System.out.println("Image failed to loaded."); // Prints if no image
		}
	}

	// Updates 60 frame per second
	public void update() {
		// Resets bullet when moves through Frame and also if it hits the player
		if ((x + WIDTH ) <= 0 || TestCollision()) {
			this.x = 1000;
			this.y = (int) (Math.random() * 291) + 100;
			velocity = (int) (Math.random() * 6) + 3;
			isHit = false;
		}
		x -= velocity; // Moves bullet to the left
		// TestCollision();
	}

	// Draws 60 frames per second
	public void draw(Graphics g) {
		g.drawImage(rightBullet, x, y, WIDTH, HEIGHT, null);
	}

	// Checks collision
	public boolean TestCollision() {
		// checks x position of player and bullet
		if ((player.getX() + player.getWidth() - 4) >= x && player.getX() <= (x + WIDTH - 4)) {
			// checks y position of player and bullet
			if ((player.getY() + player.getHeight() - 4) >= y && player.getY() <= (y + HEIGHT - 4) && !(isHit)) {
				// Makes a box collision around bullet
				player.loseLife(); // causes a life to be lost
				return true;
			}
		}
		return false;
	}

	public void keyPressed(int k) {
	}

	public void keyReleased(int k) {
	}

}
