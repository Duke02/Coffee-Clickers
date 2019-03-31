package edu.uah.coffee.clicker.controller;

import edu.uah.coffee.clicker.CoffeeClickerModel;
import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.graphics.BuildingPanel;
import edu.uah.coffee.clicker.graphics.BuildingsPanel;
import edu.uah.coffee.clicker.improvements.Building;
import edu.uah.coffee.clicker.improvements.BuildingManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.Observable;

/**
 * The controller for handling communication between all of the BuildingPanels
 * and BuildingManager.
 */
public class BuildingController extends Controller implements ActionListener {
	public BuildingController () {
		super( Constants.BUILDING_CONTROLLER_NAME );
	}

	public void update ( Observable o, Object arg ) {

		if ( ( o instanceof Building ) ) {
			Building building = ( Building ) o;
			BuildingsPanel buildingsContainerPanel = ( BuildingsPanel ) this.getView( Constants.BUILDING_PANEL_NAME );
			buildingsContainerPanel.updateBuilding( building );
		} else if ( o instanceof BuildingManager ) {
			BuildingManager buildingManager = ( BuildingManager ) o;
			BuildingsPanel buildingsContainerPanel = ( BuildingsPanel ) this.getView( Constants.BUILDING_PANEL_NAME );
			for ( Building building : buildingManager.getBuildings() ) {
				buildingsContainerPanel.updateBuilding( building );
			}
		}


	}

	public void propertyChange ( PropertyChangeEvent evt ) {

	}

	@Override
	public void addModel ( CoffeeClickerModel model ) {
		super.addModel( model );
		// Have all of the buildings put into the building panel view.
		if ( model instanceof BuildingManager ) {
			BuildingManager buildingManager = ( BuildingManager ) model;
			BuildingsPanel buildingsContainerPanel = ( BuildingsPanel ) this.getView( Constants.BUILDING_PANEL_NAME );

			for ( Building building : buildingManager.getBuildings() ) {
				buildingsContainerPanel.updateBuilding( building );
			}
		}
	}

	public void actionPerformed ( ActionEvent e ) {
		System.out.println( "Action performed." );
		if ( e.getActionCommand().equals( "buy" ) ) {
			BuildingPanel panel = ( BuildingPanel ) ( ( JButton ) e.getSource() ).getParent();
			BuildingManager buildingManager = ( ( BuildingManager ) this.getModel( Constants.BUILDING_MANAGER_NAME ) );
			buildingManager.buyBuilding( panel.getBuildingId(), 1 );
		}
	}
}
