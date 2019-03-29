package edu.uah.coffee.clicker.controller;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.Player;
import edu.uah.coffee.clicker.graphics.GamePanel;

import java.beans.PropertyChangeEvent;
import java.util.Observable;

/**
 * Controller that interface with the player model and the necessary views.
 */
public class PlayerController extends Controller {

	public PlayerController () {
		super( Constants.PLAYER_CONTROLLER_NAME );
	}


	public void update ( Observable o, Object arg ) {
		Player player;

		if ( ! ( ( Player ) o ).getModelName().equals( Constants.PLAYER_MODEL_NAME ) ) {
			return;
		}
		player = ( Player ) o;

		GamePanel gamePanel = ( GamePanel ) this.getView( Constants.GAME_PANEL_NAME );
		gamePanel.setCurrentNumberOfCoffeeBeans( player.getCoffeeBeans() );

	}

	public void propertyChange ( PropertyChangeEvent evt ) {

	}
}
