package com.brandonwlazelek.game.main;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Game {
	/**
	 * 
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setTitle("Dodge The Bullet");
		frame.setSize(1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		MainMenu mm = new MainMenu(1000,600);
		frame.add(new GamePanel());
		frame.pack();
		frame.setVisible(true);

	}

}
