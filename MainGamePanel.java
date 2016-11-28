//Brandon Wlazelek
//LAST UPDATE: 11/25/2016

package com.brandonwlazelek.game.main;

import com.brandonwlazelek.game.map.Map;


import java.awt.Graphics;

public class MainGamePanel extends GameState {
	private Player player; // Creates a player
	private GamePanel gp; // Creates gamePanel
	private Map map; // Creates the map
	RightBullet[] rb; // Creates multiple bullets
	LeftBullet[] lb; // Creates multiple bullets

	public MainGamePanel(GamePanel gp) {
		this.gp = gp;
		init();

	}

	// Initializes everything
	public void init() {
		player = new Player(gp);
		map = new Map(player);
		rb = new RightBullet[5];
		for (int x = 0; x < 5; x++) {
			// Creates 5 bullets in an array
			rb[x] = new RightBullet(player);
		}
		lb = new LeftBullet[5];
		for (int x = 0; x < 5; x++) {
			// Creates 5 bullets in an array
			lb[x] = new LeftBullet(player);
		}
	}

	@Override
	// Updates 60 frame per second
	public void update() {
		player.update(); // Calls players update method
		map.update();
		for (int x = 0; x < 5; x++) {
			// Calls bullet update method 5 times
			rb[x].update();
		}
		for (int x = 0; x < 5; x++) {
			// Calls bullet update method 5 times
			lb[x].update();
		}
	}

	@Override
	// Paints 60 frame per second
	public void draw(Graphics g) {
		player.draw(g); // Draws player
		map.draw(g); // Draws map
		for (int x = 0; x < 5; x++) {
			// Calls bullet draw method 5 times
			rb[x].draw(g);
		}

		for (int x = 0; x < 5; x++) {
			// Calls bullet draw method 5 times
			lb[x].draw(g);
		}

	}

	@Override
	// Check for key presses
	public void keyPressed(int k) {
		player.keyPressed(k); // Calls key pressed for player

	}

	@Override
	// Check for key releases
	public void keyReleased(int k) {
		player.keyReleased(k); // Calls key released for player

	}

}
