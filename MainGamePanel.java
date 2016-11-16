package com.brandonwlazelek.game.main;
import com.brandonwlazelek.game.player.Player;
import java.awt.Graphics;



public class MainGamePanel extends GameState{
	private Player player;
	
	public MainGamePanel(GameManager gm) {
		super(gm);
		// TODO Auto-generated constructor stub
	}
	 
	public void init() {
		player = new Player();

	}
	
	@Override
	public void update() {
		player.update();
		
	}

	@Override
	public void keyPressed(int k) {
		player.keyPressed(k);
		
		
	}

	@Override
	public void keyReleased(int k) {
		player.keyReleased(k);
		
	}

	@Override
	public void draw(Graphics g) {
		player.draw(g);
		
		
	}

	

}
