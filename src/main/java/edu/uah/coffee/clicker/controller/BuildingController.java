package edu.uah.coffee.clicker.controller;

import edu.uah.coffee.clicker.CoffeeClickerModel;
import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.Player;
import edu.uah.coffee.clicker.graphics.BuildingPanel;
import edu.uah.coffee.clicker.graphics.BuildingsPanel;
import edu.uah.coffee.clicker.graphics.GamePanel;
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
public class BuildingController extends Controller implements ActionListener, Runnable {
	private Player Player;

	/**
	 * Creates a new building controller with the controller's name from Constants
	 *
	 * @see Constants#BUILDING_CONTROLLER_NAME
	 */
	public BuildingController () {
		super( Constants.BUILDING_CONTROLLER_NAME );
	}

	/**
	 * When a given Building or the Building Manager updates, the Building Controller will modify the view here.
	 *
	 * @param o   the model
	 * @param arg the arguments passed.
	 */
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

	/**
	 * Adds a model to the controller.
	 * <p>
	 * If the provided model is a BuildingManager, it has the BuildingsPanel update with the
	 * buildings that are within the BuildingManager.
	 *
	 * @param model the model to be added.
	 * @see BuildingsPanel
	 * @see BuildingManager
	 */
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

	/**
	 * If the user has selected to buy a specific building, this will buy one of those buildings.
	 *
	 * @param e the ActionEvent that comes from the BuildingPanel's buy button.
	 */
	public void actionPerformed ( ActionEvent e ) {
		if ( e.getActionCommand().equals( "buy" ) ) {
			
			
			
			BuildingPanel panel = ( BuildingPanel ) ( ( JButton ) e.getSource() ).getParent();
			BuildingManager buildingManager = ( ( BuildingManager ) this.getModel( Constants.BUILDING_MANAGER_NAME ) );
			boolean didBuy = buildingManager.buyBuilding( panel.getBuildingId(), 1 );
			if(didBuy) {
				GamePanel gamePanel = (GamePanel) this.getView(Constants.GAME_PANEL_NAME);
				gamePanel.addBuilding(panel.getBuildingImage());
			
			}
		}
	}

	/**
	 * Adds to the player's total bean count based on the total beans per second of the buildings.
	 *
	 * @see BuildingManager#getBeansPerSecond()
	 */
	public void run () {
		BuildingManager buildingManager = ( BuildingManager ) this.getModel( Constants.BUILDING_MANAGER_NAME );
		Player player = ( Player ) this.getModel( Constants.PLAYER_MODEL_NAME );
		player.addCoffeeBeans( buildingManager.getBeansPerSecond() );
	}
}
