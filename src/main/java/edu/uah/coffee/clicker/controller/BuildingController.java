package edu.uah.coffee.clicker.controller;

import edu.uah.coffee.clicker.Constants;

import java.beans.PropertyChangeEvent;
import java.util.Observable;

/**
 * The controller for handling communication between all of the BuildingPanels
 * and BuildingManager.
 */
public class BuildingController extends Controller {
	public BuildingController () {
		super( Constants.BUILDING_CONTROLLER_NAME );
	}

	public void update ( Observable o, Object arg ) {

	}

	public void propertyChange ( PropertyChangeEvent evt ) {

	}
}
