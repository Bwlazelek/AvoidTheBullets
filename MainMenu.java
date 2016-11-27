//Brandon Wlazelek
//LAST UPDATE: 11/26/2016

package com.brandonwlazelek.game.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel {
	JButton btnStart = new JButton("Start"); // Start button
	JButton btnExit = new JButton("Exit"); // Exit button
	JLabel lb = new JLabel(); // Title Label
	JLabel instructions1; // "You have 3 lives."
	JLabel instructions2; // "Survive waves of bullets in both directions"
	JLabel KeyBinds; // "Use A to move Left, Use D to move Right, and W to Jump"
	JPanel jp = new JPanel(); // Creates JPanel
	MainMenu mm; // Creates MainMenu
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Constructor
	public MainMenu(JPanel j) {
		setPreferredSize(new Dimension(1000, 600));
		this.setBackground(Color.ORANGE);
		requestFocusInWindow();
		jp = j;
		mm = this;
		button();
		label();

		setLayout(new BorderLayout());

	}

	// Creates Buttons and adds listeners
	public void button() {
		btnStart.setBounds(450, 300, 100, 50);
		btnStart.addActionListener(new btnStart());

		btnExit.addActionListener(new btnExit());
		btnExit.setBounds(450, 400, 100, 50);

		add(btnExit);
		add(btnStart);
	}

	// Creates JLabel for instructions and title
	public void label() {
		lb = new JLabel("Dodge the bullet");
		lb.setBounds(350, 50, 400, 60);
		lb.setFont(new Font("Serif", Font.PLAIN, 48));
		add(lb);

		instructions1 = new JLabel("You have 3 lives.");
		instructions2 = new JLabel("Survive waves of bullets in both directions");
		KeyBinds = new JLabel("Use A to move Left, Use D to move Right, and W to Jump");
		instructions1.setBounds(465, 200, 400, 60);
		instructions2.setBounds(400, 175, 400, 60);
		KeyBinds.setBounds(350, 150, 450, 60);
		add(instructions1);
		add(instructions2);
		add(KeyBinds);

	}

	// Checks if start button are being pressed
	private class btnStart implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			jp.remove(mm);
			GamePanel x = new GamePanel(jp);
			x.setBounds(0, 0, 1000, 600);
			jp.add(x);
		}
	}

	// Checks if exit button are being pressed
	private class btnExit implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
