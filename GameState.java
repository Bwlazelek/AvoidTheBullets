//Brandon Wlazelek
//11/25/2016

package com.brandonwlazelek.game.main;

import java.awt.Graphics;

//Abstract class
public abstract class GameState {

	public GameState() {

		init(); 
	}
	//Initializes everything 
	public abstract void init();
	
	//Updates 60 frame per second
	public abstract void update();
	
	//Paints 60 frame per second
	public abstract void draw(Graphics g);
	
	//Check for key presses
	public abstract void keyPressed(int k);

	//Check for key releases
	public abstract void keyReleased(int k);

	
}
