package edu.uah.coffee.clicker.controller;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.Player;
import edu.uah.coffee.clicker.graphics.GamePanel;
import edu.uah.coffee.clicker.improvements.BuildingManager;

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


		if ( o instanceof Player ) {
			Player player = ( Player ) o;

			this.updateModel( player );

			GamePanel gamePanel = ( GamePanel ) this.getView( Constants.GAME_PANEL_NAME );
			gamePanel.setCurrentNumberOfCoffeeBeans( player.getCoffeeBeans() );
		} else if ( o instanceof BuildingManager ) {
			BuildingManager buildingManager = ( BuildingManager ) o;
			GamePanel gamePanel = ( GamePanel ) this.getView( Constants.GAME_PANEL_NAME );
			gamePanel.setBeansPerSecond( buildingManager.getBeansPerSecond() );
		}
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
