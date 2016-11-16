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

public class MainMenu extends JPanel{
	JButton btnStart = new JButton("Start");
	JButton btnExit = new JButton("Exit");
	JLabel lb;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainMenu(int width, int height){
		setPreferredSize(new Dimension(width,height));
		this.setBackground(Color.ORANGE);
		
		button();
		label();
		
		setLayout(new BorderLayout());
		
	}
	public void button(){
		btnStart.setBounds(450, 200, 100, 50);
		btnStart.addActionListener(new btnStart());
		
		btnExit.addActionListener(new btnExit());
		btnExit.setBounds(450, 300, 100, 50);
		
		add(btnExit);
		add(btnStart);
	}
	
	public void label(){
		lb = new JLabel("Dodge the bullet");
		lb.setBounds(350, 100, 400, 60);
		lb.setFont(new Font("Serif", Font.PLAIN, 48));
		add(lb);
	}
	
	private class btnStart implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		
		}
	}
	private class btnExit implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
