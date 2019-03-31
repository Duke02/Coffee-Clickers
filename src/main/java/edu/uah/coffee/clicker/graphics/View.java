package edu.uah.coffee.clicker.graphics;

import javax.swing.*;
import java.awt.*;

public class View implements Runnable {
	private static final Toolkit TOOLKIT = Toolkit.getDefaultToolkit();
	private static final int SCREEN_WIDTH = TOOLKIT.getScreenSize().width;
	private static final int SCREEN_HEIGHT = TOOLKIT.getScreenSize().height;

	private JFrame frame;
	private NewsPanel newsPanel;
	private GamePanel gamePanel;

	public View () {
		frame = new JFrame();
		frame.setSize( SCREEN_WIDTH, SCREEN_HEIGHT );
		frame.setLocation( 0, 0 );
		frame.setLayout( new BorderLayout() );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setTitle( "Coffee Clickers" );

		newsPanel = new NewsPanel();
		frame.add( newsPanel, BorderLayout.NORTH );
		gamePanel = new GamePanel();
		frame.add( gamePanel, BorderLayout.CENTER );

		frame.setVisible( true );
	}

	public void run () {

	}
}