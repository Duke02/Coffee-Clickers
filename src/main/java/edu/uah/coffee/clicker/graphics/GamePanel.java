package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.controller.Controller;

import javax.swing.*;

public class GamePanel extends CoffeeClickerPanel {
	private JButton countButton;
	private Controller controller;

	public GamePanel () {
		super( Constants.GAME_PANEL_NAME );
		setLayout( null );
		setSize( 1000, 1000 );
		setLocation( 0, 200 );
		countButton = new JButton();
		countButton.setLayout( null );
		countButton.setSize( 200, 100 );
		countButton.setLocation( 200, 200 );
		countButton.setText( "coffee" );
		countButton.setVisible( true );
		this.add( countButton );
	}

	public void setController ( Controller controller ) {
		this.controller = controller;
	}
}
