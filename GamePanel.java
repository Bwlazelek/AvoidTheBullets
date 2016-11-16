package com.brandonwlazelek.game.main;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable, KeyListener{
	private static final long serialVersionUID = 1L;
	private int WIDTH = 1000;
	private int HEIGHT = 600;
	private boolean isRunning = false;
	private Thread thread;
	
	private int FPS = 60;
	private long targetTime = 1000/FPS;
	private GameManager gm;

	public GamePanel() {
		setFocusable(true);
		requestFocusInWindow();
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		addKeyListener(this);
		start();
	

	}
	public void start(){
		isRunning = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public void run(){
		long start, elapsed, wait;
		
		gm = new GameManager();
		
		while(isRunning){
			start = System.nanoTime();
			
			update();
			repaint();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 10000000;
			
			if(wait <= 0 ){
				wait = 5;
			}
			
			try{
				Thread.sleep(wait);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public void update(){
		gm.update();
		
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//g.clearRect(0, 0 , WIDTH, HEIGHT);
		
		gm.draw(g);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		gm.keyPressed(e.getKeyCode());
		
	}
	
	public void keyReleased(KeyEvent e) {
		gm.keyReleased(e.getKeyCode());
		
	}
	
	public void keyTyped(KeyEvent e) {}
	
}