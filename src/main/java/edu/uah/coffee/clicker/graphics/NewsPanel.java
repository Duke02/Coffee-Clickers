package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.Constants;

import javax.swing.*;
import java.awt.*;

public class NewsPanel extends CoffeeClickerPanel {
	private JLabel newsHeadingLabel;
	private JLabel currentNewsLabel;

	public NewsPanel () {
		super( Constants.NEWS_PANEL_NAME );
		setRelativeLocation( 0, 0 );
		setRelativeSize( 0.6, 0.1 );

		setLayout( new BorderLayout() );
		//setSize( 1000, 1000 );
		newsHeadingLabel = new JLabel();
		//newsHeadingLabel.setPreferredSize( new Dimension( , 100 ) );
		newsHeadingLabel.setText( "News Update:" );
		newsHeadingLabel.setVisible( true );
		this.add( newsHeadingLabel, BorderLayout.NORTH );

		this.currentNewsLabel = new JLabel();
		currentNewsLabel.setText( "" );
		currentNewsLabel.setVisible( true );
		this.add( currentNewsLabel, BorderLayout.CENTER );
	}

	public void setNews ( String text ) {
		this.currentNewsLabel.setText( text );
	}
}
