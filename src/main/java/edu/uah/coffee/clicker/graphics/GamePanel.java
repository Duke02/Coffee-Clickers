package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.controller.Controller;
import edu.uah.coffee.clicker.controller.PlayerController;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends CoffeeClickerPanel {
	private JButton countButton;

	private JLabel currentCoffeeBeans;

	public GamePanel () {
		super( Constants.GAME_PANEL_NAME );
		setLayout( new BorderLayout( 250, 250 ) );
		//setPreferredSize( new Dimension( 500, 500 ) );

		this.add( new SpacePanel( 500, 100 ), BorderLayout.EAST );
		this.add( new SpacePanel( 500, 100 ), BorderLayout.WEST );
		this.add( new SpacePanel( 100, 500 ), BorderLayout.SOUTH );

		countButton = new JButton();
		countButton.setLayout( null );
		//countButton.setPreferredSize( new Dimension( 200, 100 ) );
		countButton.setText( "More Coffee!" );
		countButton.setName( "coffeeButton" );
		countButton.setVisible( true );
		this.add( countButton, BorderLayout.CENTER );

		currentCoffeeBeans = new JLabel();
		currentCoffeeBeans.setText( "Coffee Beans: 0" );
		this.add( currentCoffeeBeans, BorderLayout.NORTH );


	}

	public void addController ( Controller controller ) {
		super.addController( controller );
		if ( controller.getName().equals( Constants.PLAYER_CONTROLLER_NAME ) ) {
			currentCoffeeBeans.addPropertyChangeListener( "coffeeBeans", controller );
			countButton.addMouseListener( ( PlayerController ) controller );
		}
	}

	public void setCurrentNumberOfCoffeeBeans ( int numberOfCoffeeBeans ) {
		this.currentCoffeeBeans.setText( String.format( "Coffee Beans: %d", numberOfCoffeeBeans ) );
	}
}
