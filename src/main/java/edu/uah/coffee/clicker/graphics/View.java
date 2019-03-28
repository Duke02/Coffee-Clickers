package edu.uah.coffee.clicker.graphics;

import javax.swing.JFrame;

public class View implements Runnable {
	private JFrame frame;
	private NewsPanel newsPanel;
	private GamePanel gamePanel;

	public View() {
		frame = new JFrame();
		frame.setSize(1000, 1000);
		frame.setLocation(0, 0);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Coffee Clickers");

		newsPanel = new NewsPanel();
		frame.add(newsPanel);
		gamePanel = new GamePanel();
		frame.add(gamePanel);

		frame.setVisible(true);
	}

	public void run() {

	}
}