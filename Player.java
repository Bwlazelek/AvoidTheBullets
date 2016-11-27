//Brandon Wlazelek
//LAST UPDATE: 11/26/2016

package com.brandonwlazelek.game.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.brandonwlazelek.game.main.GamePanel;
import com.brandonwlazelek.game.map.Map;

public class Player {

	GamePanel gp;

	private int x = 500; // Players X
	private int y = 380; // Players Y
	private int WIDTH = 20; // Player Width
	private int HEIGHT = 20; // Player Height
	private int lives = 3; // Number of lives

	private final int GRAVITY = 6; // Downward force
	private final int VERTICAL_VELOCITY = 7; // Upward speed

	private double vertical_speed = VERTICAL_VELOCITY; // Upward Speed
	private int velocity = 5; // X direction speed
	private double acceleration = 0; // upward acceleration

	private boolean isRight = false; // boolean for moving right
	private boolean isLeft = false; //boolean for moving left
	// private boolean isGround = false;
	private boolean isJumping = false; //boolean for jumping

	//Constructor
	public Player(GamePanel gp) {
		this.gp = gp;
	}

	//return x position of player
	public int getX() {
		return x;
	}

	//return y position of player
	public int getY() {
		return y;
	}

	//set y position of player
	public void setY(int y) {
		this.y = y;
	}

	//return width of player
	public int getWidth() {
		return WIDTH;
	}

	//return height of player
	public int getHeight() {
		return HEIGHT;
	}
	//Subtracts life from player
	public void loseLife() {
		lives--;
		gp.loseLife(lives);
	}
	
	//Update Method
	public void update() {
		//Check if player is off screen
		if (isRight && x <= (980 - WIDTH)) {
			x += velocity;
		}
		//Check if player is off screen
		if (isLeft && x >= 5) {
			x -= velocity;
		}
		jump(); //Calls jump method
	}

	//Draws Rectangle
	public void draw(Graphics g) {
		g.setColor(Color.RED); 
		g.fillRect(x, y, WIDTH, HEIGHT);

	}
	
	//Method that deals with jumping from user
	public void jump() {

		if (isJumping) { //Checks if Jumping is True

			vertical_speed = vertical_speed - 0.25; //Makes a gradual increment upward. Ex: 4,4,3,3,2,2,1,1,0,0  
			y = y - (int) vertical_speed; //Subtracts player y from vertical Speed 

			if (Math.round(vertical_speed) <= 0) { //Rounds it up and check when its 0
				vertical_speed = VERTICAL_VELOCITY; // Sets vertical velocity back to original
				acceleration = 0; //sets Acceleration back too 0
				isJumping = false; //Stop jumping since verical_speed is zero
				Map.isGround = false; //isGround is false because player just jumped
			}

		}
		if (Map.isGround == false) { //Checks if player is in the air
			acceleration = acceleration + 0.2; //Makes a gradual increment downward. Ex: 0,0,1,1,2,2,3,3,4,4 
			y = y + (int) acceleration; // Rounds down
			if ((int) acceleration == GRAVITY) { //Checks if downward acceleration equals gravity constant
				acceleration = GRAVITY; // Sets downward acceleration back to original
			}

		}

	}

	// Checks key presses
	public void keyPressed(int k) {
		// if user pressing A key isLeft true
		if (k == KeyEvent.VK_A) {
			isLeft = true;
		}
		// if user pressing D key isRight true
		if (k == KeyEvent.VK_D) {
			isRight = true;
		}
		// if user pressing W key then jumping
		if (k == KeyEvent.VK_W && Map.isGround) {
			isJumping = true;
		}

	}

	// Checks key releases
	public void keyReleased(int k) {
		// if user released A key isLeft false
		if (k == KeyEvent.VK_A) {
			isLeft = false;
		}
		// if user released D key isRight false
		if (k == KeyEvent.VK_D) {
			isRight = false;
		}
	}

}
