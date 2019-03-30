package edu.uah.coffee.clicker.graphics;

import javax.swing.*;
import java.awt.*;

public class NewsPanel extends JPanel {
	private JLabel label;

	public NewsPanel () {
		setLayout( new BorderLayout() );
		// setSize(1000,1000);
		setLocation( 0, 0 );
		label = new JLabel();
		label.setLayout( null );
		label.setSize( 200, 100 );
		// label.setLocation( 25, 0 );
		label.setText( "NEWS" );
		label.setVisible( true );
		this.add( label, BorderLayout.CENTER );
	}
}
