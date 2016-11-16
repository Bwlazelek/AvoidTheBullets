package com.brandonwlazelek.game.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player extends Rectangle {
	int x = 50;
	int y = 100;
	private int WIDTH = 30;
	private int HEIGHT = 30;
	private int velocity = 3;
	private boolean isJumping = false;
	private boolean isRight = false;
	private boolean isLeft = false;
	public Player() {
		setBounds(100, 100, WIDTH, HEIGHT);
	}

	public void update() {
		
		if(isRight){
			x += velocity;
		}
		if(isLeft){
			x -= velocity;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
	}

	public void keyPressed(int k) {
		if(k == KeyEvent.VK_A){
			isLeft = true;
		}
		if(k == KeyEvent.VK_D){
			isRight = true;
		}
	}

	public void keyReleased(int k) {
		if(k == KeyEvent.VK_A){
			isLeft = false;
		}
		if(k == KeyEvent.VK_D){
			isRight = false;
		}
	}

}
