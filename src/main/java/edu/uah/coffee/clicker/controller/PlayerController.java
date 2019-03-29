package edu.uah.coffee.clicker.controller;

import edu.uah.coffee.clicker.Player;

import java.util.Observable;

/**
 * Controller that interface with the player model and the necessary views.
 */
public class PlayerController extends Controller {

	Player player;

	public PlayerController ( String name ) {
		super( name );

	}


	public void update ( Observable o, Object arg ) {

	}
}
