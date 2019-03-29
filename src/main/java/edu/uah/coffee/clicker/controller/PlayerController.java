package edu.uah.coffee.clicker.controller;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.Player;

import java.beans.PropertyChangeEvent;
import java.util.Observable;

/**
 * Controller that interface with the player model and the necessary views.
 */
public class PlayerController extends Controller {


	Player player;

	public PlayerController () {
		super( Constants.PLAYER_CONTROLLER_NAME );

	}


	public void update ( Observable o, Object arg ) {

	}

	public void propertyChange ( PropertyChangeEvent evt ) {
		
	}
}
