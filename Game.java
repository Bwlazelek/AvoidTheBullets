import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game{
	JFrame frame = new JFrame();
	

	public Game() {
		Container pane = frame.getContentPane();
		frame.setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		jp.setFocusable(false);
		pane.add(jp, BorderLayout.CENTER);
		MainMenu mm = new MainMenu(jp);
		mm.setBounds(0, 0, 1000, 600);
		jp.add(mm);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(1000, 600);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				new Game();
			}
		});
	}

}
