package com.brandonwlazelek.game.main;

import java.awt.Graphics;

public abstract class GameState {
	protected GameManager gm;
	
	public GameState(GameManager gm){
		this.gm = gm;
		init();
	}
	public abstract void init();
	public abstract void update();
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	public abstract void draw(Graphics g);
}
