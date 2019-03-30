package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.improvements.Building;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BuildingsPanel extends StorePanel {

	Map< Integer, BuildingPanel > buildingPanels;

	public BuildingsPanel () {
		super( Constants.BUILDING_PANEL_NAME );
		this.buildingPanels = new HashMap< Integer, BuildingPanel >();
		setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
		this.setBackground( Color.BLACK );
	}

	public void addBuilding ( Building building ) {
		BuildingPanel buildingPanel = new BuildingPanel();

		buildingPanel.setBuildingId( building.getId() );
		buildingPanel.setBuildingName( building.getName() );
		buildingPanel.setNumberBought( building.getNumberBought() );
		buildingPanel.setCost( building.getCost() );

		this.add( buildingPanel );
		this.buildingPanels.put( building.getId(), buildingPanel );
	}

	public void updateBuilding ( Building building ) {
		if ( ! this.buildingPanels.containsKey( building.getId() ) ) {
			this.addBuilding( building );
			return;
		}

		BuildingPanel buildingPanel = this.buildingPanels.get( building.getId() );

		buildingPanel.setBuildingId( building.getId() );
		buildingPanel.setBuildingName( building.getName() );
		buildingPanel.setNumberBought( building.getNumberBought() );
		buildingPanel.setCost( building.getCost() );

		this.buildingPanels.put( building.getId(), buildingPanel );
	}
}
