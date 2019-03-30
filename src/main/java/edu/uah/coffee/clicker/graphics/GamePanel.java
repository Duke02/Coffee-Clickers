package edu.uah.coffee.clicker.graphics;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
	private JButton countButton;

	public GamePanel () {
		setLayout( new BorderLayout( 250, 250 ) );
		// setSize( 1000, 1000 );
		// setLocation( 0, 200 );
		countButton = new JButton();
		countButton.setLayout( null );
		countButton.setMaximumSize( new Dimension( 200, 100 ) );
		//countButton.setLocation( 200, 200 );
		countButton.setText( "coffee" );
		countButton.setVisible( true );
		this.add( countButton, BorderLayout.CENTER );
	}

}
