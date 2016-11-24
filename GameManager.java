import java.awt.Graphics;
import java.util.Stack;

public class GameManager {
	private Stack<GameState> states;
	
	public GameManager(){
		states = new Stack<GameState>();
		states.push(new MainGamePanel(this));
	}
	
	public void update(){
		states.peek().update();
	}
	
	public void draw(Graphics g){
		states.peek().draw(g);
	}
	
	public void keyPressed(int k){
		states.peek().keyPressed(k);
	}
	
	public void keyReleased(int k){
		states.peek().keyReleased(k);
	}
	
	
}
