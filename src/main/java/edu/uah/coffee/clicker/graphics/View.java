package edu.uah.coffee.clicker.graphics;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class View implements Runnable {
	private static final Toolkit TOOLKIT = Toolkit.getDefaultToolkit();
	private static final int SCREEN_WIDTH = TOOLKIT.getScreenSize().width;
	private static final int SCREEN_HEIGHT = (int) (TOOLKIT.getScreenSize().height * 0.95);

	private double time = 0;

	private JFrame frame;
	private NewsPanel newsPanel;
	private GamePanel gamePanel;
	private BuildingsPanel buildingsPanel;
	private UpgradesPanel upgradesPanel;

	public View() {
		frame = new JFrame();
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setLocation(0, 0);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("CC");// for coffee clickers

		newsPanel = new NewsPanel();
		frame.add(newsPanel);
		gamePanel = new GamePanel();
		frame.add(gamePanel);
		buildingsPanel = new BuildingsPanel();
		frame.add(buildingsPanel);
		upgradesPanel = new UpgradesPanel();
		frame.add(upgradesPanel);

		frame.setVisible(true);
	}

	public void run() {
		time += ((double) 1 / 60);// increment time by 1/60 every 1/60 of a second
		gamePanel.update(time);
	}
}