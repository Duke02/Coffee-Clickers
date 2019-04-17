package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.ResourceManager;
import edu.uah.coffee.clicker.controller.Controller;
import edu.uah.coffee.clicker.improvements.Building;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;

public class BuildingsPanel extends CoffeeClickerPanel {

	Map<Integer, BuildingPanel> buildingPanels;

	public BuildingsPanel() {
		super(Constants.BUILDING_PANEL_NAME);

		setRelativeLocation(0.8, 0);
		setRelativeSize(0.2, 1);

		buildingPanels = new HashMap<>();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		backgroundImage = readImage(ResourceManager.getFile("/images/background3.png"));
		repaint();
	}

	public void updateBuilding(Building building) {
		BuildingPanel buildingPanel;
		boolean wasIn = buildingPanels.containsKey(building.getId());
		double numOfBuildings = buildingPanels.size();
		if (!wasIn) {
			buildingPanel = new BuildingPanel();
			numOfBuildings++;
		} else {
			buildingPanel = buildingPanels.get(building.getId());
		}

		for (BuildingPanel panel : buildingPanels.values()) {
			panel.setRelativeSize(1.0, 1.0 / numOfBuildings);
		}

		buildingPanel.setRelativeSize(1.0, 1.0 / numOfBuildings);

		buildingPanel.setBuildingId(building.getId());
		buildingPanel.setBuildingName(building.getName());
		buildingPanel.setNumberBought(building.getNumberBought());
		buildingPanel.setCost(building.getCost() + building.getCostCoefficient());
		buildingPanel.setBuildingImage(building.getImageFileName());
		buildingPanel.setBPS((int) building.getBeansPerSecond());

		if (!wasIn) {
			add(buildingPanel);
			buildingPanel.addController(getController(Constants.BUILDING_CONTROLLER_NAME));
		}

		buildingPanels.put(building.getId(), buildingPanel);
	}

	@Override
	public void addController(Controller controller) {
		super.addController(controller);
		addControllerToPanels(controller);
	}

	private void addControllerToPanels(Controller controller) {
		for (BuildingPanel buildingPanel : buildingPanels.values()) {
			buildingPanel.addController(controller);
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();

		g2.drawImage(backgroundImage, 0, 0, getSize().width, getSize().height, this);
		
		g2.dispose();
	}
	
}
