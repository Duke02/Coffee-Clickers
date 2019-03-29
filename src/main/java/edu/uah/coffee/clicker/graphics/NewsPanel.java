package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.Constants;

import javax.swing.*;

public class NewsPanel extends CoffeeClickerPanel {
	private JLabel label;

	public NewsPanel () {
		super( Constants.NEWS_PANEL_NAME );
		setLayout( null );
		setSize( 1000, 1000 );
		setLocation( 0, 0 );
		label = new JLabel();
		label.setLayout( null );
		label.setSize( 200, 100 );
		label.setLocation( 25, 0 );
		label.setText( "N E W S" );
		label.setVisible( true );
		this.add( label );
	}
}
