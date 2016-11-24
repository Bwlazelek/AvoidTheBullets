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
	JLabel lb = new JLabel();
	JPanel jp = new JPanel();
	MainMenu mm;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainMenu(JPanel j){
		setPreferredSize(new Dimension(1000,600));
		this.setBackground(Color.ORANGE);
		requestFocusInWindow();
		jp = j;
		mm = this;
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
			jp.remove(mm);
			GamePanel x = new GamePanel(jp);
			x.setBounds(0,0, 1000, 600);
			jp.add(x);
		}
	}
	private class btnExit implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}

