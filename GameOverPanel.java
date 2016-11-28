//11/27/2016

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

public class GameOverPanel extends JPanel {
	JButton btnPlayAgain = new JButton("Try Again"); // Play Again button
	JButton btnExit = new JButton("Exit"); // Exit button
	JLabel lb = new JLabel(); // Title Label
	JPanel jp = new JPanel(); // Creates JPanel
	JPanel gameoverpanel; //Creates gameoverpanel this
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Constructor
	public GameOverPanel(JPanel j) {
		setPreferredSize(new Dimension(1000, 600));
		this.setBackground(Color.GRAY);
		requestFocusInWindow();
		jp = j;
		gameoverpanel = this;
		button();
		label();

		setLayout(new BorderLayout());

	}

	// Creates Buttons and adds listeners
	public void button() {
		btnPlayAgain.setBounds(450, 200, 100, 50);
		btnPlayAgain.addActionListener(new btnPlayAgain());

		btnExit.addActionListener(new btnExit());
		btnExit.setBounds(450, 300, 100, 50);

		add(btnExit);
		add(btnPlayAgain);
	}

	// Creates JLabel for instructions and title
	public void label() {
		lb = new JLabel("GAME OVER!");
		lb.setBounds(350, 50, 400, 60);
		lb.setFont(new Font("Serif", Font.PLAIN, 48));
		add(lb);

	}

	// Checks if Play Again button are being pressed
	private class btnPlayAgain implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			jp.remove(gameoverpanel);
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

