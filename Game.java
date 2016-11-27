//Brandon Wlazelek Computer Science 221
//Adam
//11/25/2016

package com.brandonwlazelek.game.main;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game {
	JFrame frame = new JFrame(); //Creating a JFrame

	public Game() {
		Container pane = frame.getContentPane();
		frame.setLayout(new BorderLayout());
		JPanel jp = new JPanel(); //Creating a base Panel
		jp.setFocusable(false);   //Set Focus to base Panel
		pane.add(jp, BorderLayout.CENTER); //Adding base Panel to the Container
		MainMenu mm = new MainMenu(jp); //Creating a Main Menu JPanel To start and Quit
		mm.setBounds(0, 0, 1000, 600); //Setting the bounds of the Panel
		jp.add(mm); //Adding the panel to the base panel
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(1000, 600); //Setting the dimensions of the JFrame
		frame.setVisible(true); //JFrame visible

	}
	
	//This just runs the code above^
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Game();
			}
		});
	}

}
