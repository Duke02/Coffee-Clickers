package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class View implements Runnable {
	private static final Toolkit TOOLKIT = Toolkit.getDefaultToolkit();
	/**
	 * The width of the window
	 */
	public static final int SCREEN_WIDTH = (int) ((double) TOOLKIT.getScreenSize().width * 0.9);
	/**
	 * The weight of the window
	 */
	public static final int SCREEN_HEIGHT = (int) ((double) TOOLKIT.getScreenSize().height * 0.9);

	private double time = 0;

	private JFrame frame;
	private GamePanel gamePanel;

	private Map<String, CoffeeClickerPanel> panels;

	/**
	 * Constructor for the view
	 */
	public View() {
		frame = new JFrame();
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Coffee Clickers");

		gamePanel = new GamePanel();

		panels = new HashMap<>();

		addPanel(gamePanel);
		addPanel(new NewsPanel());
		addPanel(new BuildingsPanel());

		frame.setVisible(true);
	}

	public void run() {
		time += ((double) 1 / 60);
		gamePanel.update(time);
	}

	private void addPanel(CoffeeClickerPanel panel) {

		panels.put(panel.getName(), panel);
		frame.add(panel);
		panel.setVisible(true);
	}

	public void pack() {
		for (CoffeeClickerPanel panel : this.panels.values()) {
			panel.validate();
		}
	}

	public void setController(String panelName, Controller controller) {
		panels.get(panelName).addController(controller);
	}

	public CoffeeClickerPanel getPanel(String name) {
		return panels.get(name);
	}
}