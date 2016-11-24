import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Player {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map m;
	private int x = 50;
	private int y = 380;
	private int WIDTH = 20;
	private int HEIGHT = 20;

	private final int GRAVITY = 6;
	private final int TERMINAL_VELOCITY = 0;
	private final int VERTICAL_VELOCITY = 7;

	private double vertical_speed = 7;
	private int velocity = 5;
	private double acceleration = 0;

	private boolean isRight = false;
	private boolean isLeft = false;
	private boolean isGround = false;
	private boolean isJumping = false;

	public Player(Map map) {
		m = map;
	}

	public void update() {
		if (isRight && x <= (980 - WIDTH)) {
			x += velocity;
		}
		if (isLeft && x >= 5) {
			x -= velocity;
		}
		playerGround();
		jump();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, WIDTH, HEIGHT);

	}

	public void jump() {

		if (isJumping) {
			vertical_speed = vertical_speed - (acceleration + 0.2);
			if ((int) vertical_speed == TERMINAL_VELOCITY) {
				vertical_speed = TERMINAL_VELOCITY;
				isJumping = false;
				isGround = false;
			}

			y = y - (int) vertical_speed;
		}
		if (isGround == false) {
			acceleration = acceleration + 0.2;
			if ((int) acceleration == GRAVITY)
				acceleration = GRAVITY;
			y = y + (int) acceleration;

		}

	}

	public void playerGround() {

		if ((y + HEIGHT) >= m.getY()) {
			isGround = true;
			acceleration = 0;
			vertical_speed = VERTICAL_VELOCITY;
		}
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_A) {
			isLeft = true;
		}
		if (k == KeyEvent.VK_D) {
			isRight = true;
		}

		if (k == KeyEvent.VK_W && isGround) {
			isJumping = true;
		}

	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_A) {
			isLeft = false;
		}
		if (k == KeyEvent.VK_D) {
			isRight = false;
		}
	}

}
