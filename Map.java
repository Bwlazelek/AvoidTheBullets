//Brandon Wlazelek
//LAST UPDATE: 11/25/2016

package com.brandonwlazelek.game.map;

import java.awt.Color;
import java.awt.Graphics;

import com.brandonwlazelek.game.player.Player;


public class Map {
	private int x = 0;
	private int y = 400;
	public static boolean isGround = false;
	private Player player;
	
	public Map(Player p) {
		player = p; //Puts player parameter into the class player
	}

	// Updates 60 frame per second
	public void update() {
		playerGround();
	}

	// returns the x position
	public int getX() {
		return x;
	}

	// returns the y position
	public int getY() {
		return y;
	}

	// returns if the player is on the ground
	public boolean isGround() {
		return isGround;
	}
	
	//checks if the play is on the ground
	public void playerGround() {
		//Checks if the player Y is touching ground
		if ((player.getY()) >= (y - player.getHeight())) { 
			player.setY(y - player.getHeight()); //sets players Y to minus the y of map so just in case it skips frames.
			isGround = true; //Sets isGround to true!
		}
	}

	// Paints 60 frame per second
	public void draw(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, 1000, 200);

	}

	// Not needed
	public void keyPressed(int k) {
	}

	// Not needed
	public void keyReleased(int k) {
	}

}
