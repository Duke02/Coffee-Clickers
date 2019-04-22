package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.ResourceManager;
import edu.uah.coffee.clicker.controller.Controller;
import edu.uah.coffee.clicker.improvements.Building;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BuildingsPanel extends CoffeeClickerPanel {

	Map< Integer, BuildingPanel > buildingPanels;

	/**
	 * Constructor for the buildingPanel
	 */
	public BuildingsPanel () {
		super( Constants.BUILDING_PANEL_NAME );

		setRelativeLocation( 0.8, 0 );
		setRelativeSize( 0.2, 1 );
		setLayout( null );

		buildingPanels = new HashMap<>();

		backgroundImage = readImage( ResourceManager.getFile( "/images/background3.png" ) );
		repaint();
	}

	/**
	 * Updates the BuildingPanel for the provided Building and creates a new one if needed.
	 * <p>
	 * To be used when the BuildingController gets a new building to display.
	 *
	 * @param building the building that goes with the to be updated BuildingPanel
	 */
	public void updateBuilding ( Building building ) {
		BuildingPanel buildingPanel;
		boolean wasIn = buildingPanels.containsKey( building.getId() );
		if ( ! wasIn ) {
			buildingPanel = new BuildingPanel();
		} else {
			buildingPanel = buildingPanels.get( building.getId() );
		}

		buildingPanel.setBuildingId( building.getId() );
		buildingPanel.setBuildingName( building.getName() );
		buildingPanel.setNumberBought( building.getNumberBought() );
		buildingPanel.setCost( building.getCost() + building.getCostCoefficient() );
		buildingPanel.setBuildingImageLabel( building.getImageFileName() );
		buildingPanel.setBPS( ( int ) building.getBeansPerSecond() );
		buildingPanel.setBuildingImageLabel( building.getImageFileName() );

		if ( ! wasIn ) {
			for ( BuildingPanel panel : buildingPanels.values() ) {
				panel.setRelativeSize( 1.0, 1.0 / ( buildingPanels.size() + 1 ) );
			}

			add( buildingPanel );
			buildingPanel.setRelativeLocation( 0, ( double ) building.getId() * 0.15 );
			buildingPanel.setRelativeSize( 1.0, 1.0 / ( buildingPanels.size() + 1 ) );
			buildingPanel.addController( getController( Constants.BUILDING_CONTROLLER_NAME ) );
		}

		buildingPanels.put( building.getId(), buildingPanel );
	}

	/**
	 * In addition to the standard adding of controllers, this adds the passed in Controller to the component
	 * BuildingPanels.
	 *
	 * @param controller The controller to add.
	 */
	@Override
	public void addController ( Controller controller ) {
		super.addController( controller );
		addControllerToPanels( controller );
	}

	/**
	 * Adds the controller to all interior panels.
	 *
	 * @param controller the controller to be added.
	 */
	private void addControllerToPanels ( Controller controller ) {
		for ( BuildingPanel buildingPanel : buildingPanels.values() ) {
			buildingPanel.addController( controller );
		}
	}

	/**
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent ( Graphics g ) {
		super.paintComponent( g );
		Graphics2D g2 = ( Graphics2D ) g.create();

		g2.drawImage( backgroundImage, 0, 0, getSize().width, getSize().height, this );

		g2.dispose();
	}

}
