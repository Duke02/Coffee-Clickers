package edu.uah.coffee.clicker.graphics;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class View implements Runnable {
	private static final Toolkit TOOLKIT = Toolkit.getDefaultToolkit();
	private static final int SCREEN_WIDTH = TOOLKIT.getScreenSize().width;
	private static final int SCREEN_HEIGHT = (int) (TOOLKIT.getScreenSize().height * 0.9);
	// note: * 0.9 is a temporary fix to prevent the window from leaning overthe
	// taskbar

	private double time = 0;// the clock is useful for animation

	private JFrame frame;
	private ImportantPanel importantPanel;
	private NewsPanel newsPanel;
	private GamePanel gamePanel;

	public View() {
		frame = new JFrame();
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setLocation(0, 0);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("CC");// for coffee clickers

		importantPanel = new ImportantPanel();
		frame.add(importantPanel);
		newsPanel = new NewsPanel();
		frame.add(newsPanel);
		gamePanel = new GamePanel();
		frame.add(gamePanel);

		frame.setVisible(true);
	}

	public void run() {// runnable!
		time += ((double) 1 / 60);// increment time by 1/60 every 1/60 of a second
		gamePanel.update(time);// update!
	}// bracket!
}// bracket?