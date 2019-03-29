package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.Constants;

import javax.swing.*;
import java.awt.*;

public class NewsPanel extends CoffeeClickerPanel {
	private JLabel label;

	public NewsPanel () {
		super( Constants.NEWS_PANEL_NAME );
		setLayout( new BorderLayout() );
		//setSize( 1000, 1000 );
		label = new JLabel();
		label.setPreferredSize( new Dimension( 200, 100 ) );
		label.setText( "News Update:" );
		label.setVisible( true );
		this.add( label, BorderLayout.CENTER );
	}
}
