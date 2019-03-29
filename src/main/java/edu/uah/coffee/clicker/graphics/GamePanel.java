package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends CoffeeClickerPanel {
	private JButton countButton;
	private Controller controller;

	private JLabel currentCoffeeBeans;

	public GamePanel () {
		super( Constants.GAME_PANEL_NAME );
		setLayout( new BorderLayout() );
		setPreferredSize( new Dimension( 1000, 1000 ) );

		countButton = new JButton();
		countButton.setLayout( null );
		countButton.setPreferredSize( new Dimension( 200, 100 ) );
		countButton.setText( "More Coffee!" );
		countButton.setVisible( true );
		this.add( countButton, BorderLayout.CENTER );

		currentCoffeeBeans = new JLabel();
		currentCoffeeBeans.setText( "Coffee Beans: 0" );
		this.add( currentCoffeeBeans, BorderLayout.NORTH );

	}

	public void setController ( Controller controller ) {
		this.controller = controller;
	}

	public void setCurrentNumberOfCoffeeBeans ( int numberOfCoffeeBeans ) {
		this.currentCoffeeBeans.setText( String.format( "Coffee Beans: %d", numberOfCoffeeBeans ) );
	}
}
