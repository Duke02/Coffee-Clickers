package edu.uah.coffee.clicker.controller;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.Player;
import edu.uah.coffee.clicker.graphics.GamePanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.util.Observable;

/**
 * Controller that interface with the player model and the necessary views.
 */
public class PlayerController extends Controller implements MouseListener {

	public PlayerController () {
		super( Constants.PLAYER_CONTROLLER_NAME );
	}


	public void update ( Observable o, Object arg ) {
		Player player;

		if ( ! ( ( Player ) o ).getModelName().equals( Constants.PLAYER_MODEL_NAME ) ) {
			return;
		}
		player = ( Player ) o;

		this.updateModel( player );

		GamePanel gamePanel = ( GamePanel ) this.getView( Constants.GAME_PANEL_NAME );
		gamePanel.setCurrentNumberOfCoffeeBeans( player.getCoffeeBeans() );
	}

	public void propertyChange ( PropertyChangeEvent evt ) {

	}

	public void mouseClicked ( MouseEvent e ) {
		Component comp = e.getComponent();
		if ( ! comp.getName().equals( "coffeeButton" ) ) {
			return;
		}
		( ( Player ) this.getModel( Constants.PLAYER_MODEL_NAME ) ).addCoffeeBeans( 1 );
	}

	public void mousePressed ( MouseEvent e ) {

	}

	public void mouseReleased ( MouseEvent e ) {

	}

	public void mouseEntered ( MouseEvent e ) {

	}

	public void mouseExited ( MouseEvent e ) {

	}
}
