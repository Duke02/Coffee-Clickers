package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.ResourceManager;
import edu.uah.coffee.clicker.controller.Controller;
import edu.uah.coffee.clicker.controller.PlayerController;
import edu.uah.coffee.clicker.controller.SaveGameController;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends CoffeeClickerPanel {
	private double time = 0;

	private CoffeeClickerButton countButton;
	private CoffeeClickerButton saveButton;

	private CoffeeClickerLabel currentCoffeeBeans;
	private CoffeeClickerLabel beansPerSecond;

	private ArrayList<BufferedImage> buildings = new ArrayList<BufferedImage>();

	public GamePanel() {
		super(Constants.GAME_PANEL_NAME);
		setRelativeLocation(0, 0.1);
		setRelativeSize(0.8, 0.9);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		currentCoffeeBeans = new CoffeeClickerLabel();
		currentCoffeeBeans.setText("Coffee Beans: 0");
		add(currentCoffeeBeans);

		beansPerSecond = new CoffeeClickerLabel();
		beansPerSecond.setText("Beans/sec: 0");
		add(beansPerSecond);

		countButton = new CoffeeClickerButton();
		countButton.setText("More Coffee!");
		countButton.setName("coffeeButton");
		countButton.setVisible(true);
		add(countButton);

		saveButton = new CoffeeClickerButton();
		saveButton.setText("Save Game!");
		saveButton.setName("saveButton");
		saveButton.setActionCommand("saveGame");
		saveButton.setVisible(true);
		add(saveButton);

		backgroundImage = readImage(ResourceManager.getFile("/images/background.png"));
		repaint();
	}

	public void addController(Controller controller) {
		super.addController(controller);
		if (controller.getName().equals(Constants.PLAYER_CONTROLLER_NAME)) {
			currentCoffeeBeans.addPropertyChangeListener("coffeeBeans", controller);
			countButton.addMouseListener((PlayerController) controller);
		} else if (controller.getName().equals(Constants.SAVE_GAME_CONTROLLER_NAME)) {
			saveButton.addActionListener((SaveGameController) controller);
		}
	}

	public void setCurrentNumberOfCoffeeBeans(int numberOfCoffeeBeans) {
		currentCoffeeBeans.setText(String.format("Coffee Beans: %d", numberOfCoffeeBeans));
	}

	public void setBeansPerSecond(int beansPerSecond) {
		this.beansPerSecond.setText(String.format("Beans/second: %d", beansPerSecond));
	}

	public void addBuilding(BufferedImage image) {
		buildings.add(image);
	}

	public void update(double time) {
		this.time = time;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();

		g2.drawImage(backgroundImage, 0, 0, getSize().width, getSize().height, this);

		for (int i = 0; i < buildings.size(); ++i) {
			int x = (int) ((Math.sin((1.8 + i * 70.05)) / 2.5 + 0.4) * getSize().width);
			int y = (int) ((Math.cos((1.2 + i * 64.05)) / 7.5 + 0.575) * getSize().height);
			g2.drawImage(buildings.get(i), x, y, getSize().width / 5, getSize().width / 5, this);
		}

	}
}
