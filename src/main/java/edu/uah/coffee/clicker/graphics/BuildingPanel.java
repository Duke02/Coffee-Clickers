package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.ResourceManager;
import edu.uah.coffee.clicker.controller.BuildingController;
import edu.uah.coffee.clicker.controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * Panel for displaying individual buildings.
 */
public class BuildingPanel extends CoffeeClickerPanel {
	private CoffeeClickerLabel numberBought;
	private CoffeeClickerLabel buildingName;
	private CoffeeClickerLabel cost;
	private CoffeeClickerLabel beansPerSecond;
	private CoffeeClickerLabel buildingImageLabel;
	private CoffeeClickerButton buyButton;
	private int buildingId;
	private String buildingImageFilePath;
	private BufferedImage buildingImage;

	/**
	 * Constructor for the BuildingPanel
	 */
	public BuildingPanel() {
		super(Constants.BUILDING_PANEL_NAME);

		setRelativeSize(0.1, 0.1);
		setLayout(new GridLayout(3, 2));
		setOpaque(false);

		buildingImageLabel = new CoffeeClickerLabel();
		buildingImageLabel.setVisible(true);
		add(buildingImageLabel);

		buildingName = new CoffeeClickerLabel();
		buildingName.setVisible(true);
		add(buildingName);

		numberBought = new CoffeeClickerLabel();
		numberBought.setText("Owned: 0");
		numberBought.setVisible(true);
		add(numberBought);

		beansPerSecond = new CoffeeClickerLabel();
		beansPerSecond.setText("Beans/sec: 0");
		beansPerSecond.setVisible(true);
		add(beansPerSecond);

		cost = new CoffeeClickerLabel();
		cost.setText("Cost: 0");
		cost.setVisible(true);
		add(cost);

		buyButton = new CoffeeClickerButton();
		buyButton.setName("buyBuilding");
		buyButton.setText("Buy!");
		buyButton.setVisible(true);
		buyButton.setActionCommand("buy");
		add(buyButton);

		// Set up initial building id.
		buildingId = -1;
	}

	public void setBuildingName(String name) {
		this.name = Constants.BUILDING_PANEL_NAME + name;
		buildingName.setText(name);
	}

	public void setNumberBought(int numBought) {
		this.numberBought.setText(String.format("Owned: %d", numBought));
	}

	public void setCost(int cost) {
		this.cost.setText(String.format("Cost: %d", cost));
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int id) {
		if (buildingId == -1) {
			// Ignore any changes to building id.
			buildingId = id;
		}
	}

	public void setBuildingImageLabel(String filename) {
		this.buildingImageFilePath = filename;
		Image icon = this.readImage(ResourceManager.getFile(filename));
		buildingImageLabel.setIcon(new ImageIcon(icon));
	}

	public BufferedImage getBuildingImage() {
		if (this.buildingImage == null) {
			try {
				InputStream is = ResourceManager.getInputStream(this.buildingImageFilePath);
				this.buildingImage = ImageIO.read(is);
			} catch (IOException e) {
				System.err.println("Could not find building image at filepath " + this.buildingImageFilePath + "!");
				e.printStackTrace();
			}
		}
		return this.buildingImage;
	}

	public void setBPS(int bps) {
		beansPerSecond.setText(String.format("Beans/sec: %d", bps));
	}

	@Override
	public void addController(Controller controller) {
		super.addController(controller);
		if (controller instanceof BuildingController) {
			buyButton.addActionListener((ActionListener) controller);
		}
	}

	/**
	 * (non-Javadoc)
	 * @see edu.uah.coffee.clicker.graphics.CoffeeClickerPanel#setRelativeSize(double, double)
	 */
	@Override
	public void setRelativeSize(double x, double y) {
		if (getParent() == null) {
			super.setRelativeSize(x, y);
		} else {
			Dimension parentSize = getParent().getSize();
			relativeSize = new Dimension((int) (parentSize.width * x), (int) (parentSize.height * y));
			setSize(relativeSize);
		}
	}
}
