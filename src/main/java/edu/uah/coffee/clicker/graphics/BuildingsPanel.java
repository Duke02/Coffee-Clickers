package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.controller.Controller;
import edu.uah.coffee.clicker.improvements.Building;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class BuildingsPanel extends CoffeeClickerPanel {

	Map< Integer, BuildingPanel > buildingPanels;


	public BuildingsPanel () {
		super( Constants.BUILDING_PANEL_NAME );

		setRelativeLocation( 0.6, 0 );
		setRelativeSize( 0.2, 1 );

		this.buildingPanels = new HashMap<>();
		setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );

	}

	public void updateBuilding ( Building building ) {
		BuildingPanel buildingPanel;
		boolean wasIn = this.buildingPanels.containsKey( building.getId() );
		if ( ! wasIn ) {
			buildingPanel = new BuildingPanel();
		} else {
			buildingPanel = this.buildingPanels.get( building.getId() );
		}

		buildingPanel.setBuildingId( building.getId() );
		buildingPanel.setBuildingName( building.getName() );
		buildingPanel.setNumberBought( building.getNumberBought() );
		buildingPanel.setCost( building.getCost() + building.getCostCoefficient() );
		buildingPanel.setBuildingImage( building.getImageFileName() );
		buildingPanel.setBPS( ( int ) building.getBeansPerSecond() );

		if ( ! wasIn ) {
			this.add( buildingPanel );
			buildingPanel.addController( this.getController( Constants.BUILDING_CONTROLLER_NAME ) );
		}

		this.buildingPanels.put( building.getId(), buildingPanel );
	}

	@Override
	public void addController ( Controller controller ) {
		super.addController( controller );
		this.addControllerToPanels( controller );
	}

	private void addControllerToPanels ( Controller controller ) {
		for ( BuildingPanel buildingPanel : this.buildingPanels.values() ) {
			buildingPanel.addController( controller );
		}
	}
}
