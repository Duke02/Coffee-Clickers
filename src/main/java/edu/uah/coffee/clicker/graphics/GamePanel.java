package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.controller.Controller;
import edu.uah.coffee.clicker.controller.PlayerController;

import javax.swing.*;

public class GamePanel extends CoffeeClickerPanel {
	private CoffeeClickerButton countButton;

	private CoffeeClickerLabel currentCoffeeBeans;
	private CoffeeClickerLabel beansPerSecond;

	public GamePanel () {
		super( Constants.GAME_PANEL_NAME );
		setRelativeLocation( 0, 0.1 );
		setRelativeSize( 0.6, 0.9 );

		setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );

		currentCoffeeBeans = new CoffeeClickerLabel();
		currentCoffeeBeans.setText( "Coffee Beans: 0" );
		this.add( currentCoffeeBeans );

		beansPerSecond = new CoffeeClickerLabel();
		beansPerSecond.setText( "Beans/sec: 0" );
		this.add( beansPerSecond );

		// this.add( Box.createVerticalStrut( 50 ) );

		countButton = new CoffeeClickerButton();
		//countButton.setLayout( null );
//		countButton.setPreferredSize( new Dimension( 250, 150 ) );
		countButton.setText( "More Coffee!" );
		countButton.setName( "coffeeButton" );
		countButton.setVisible( true );
		this.add( countButton );
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

	public void setBeansPerSecond ( int beansPerSecond ) {
		this.beansPerSecond.setText( String.format( "Beans/second: %d", beansPerSecond ) );
	}
}
