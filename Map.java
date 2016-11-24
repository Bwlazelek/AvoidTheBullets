import java.awt.Color;
import java.awt.Graphics;


public class Map {
	Player player;
	private int x = 0;
	private int y = 400;
	public Map(){
		
		
	}
	public void update() {}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 1000, 200);
	
		
	}

	public void keyPressed(int k) {}
	public void keyReleased(int k) {}

}
