package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class View implements Runnable {
	private Controller controller;

	private static final Toolkit TOOLKIT = Toolkit.getDefaultToolkit();
	private static final int SCREEN_WIDTH = TOOLKIT.getScreenSize().width;
	private static final int SCREEN_HEIGHT = TOOLKIT.getScreenSize().height;

	private JFrame frame;
	private ImportantPanel importantPanel;
	private NewsPanel newsPanel;
	private GamePanel gamePanel;

	public View () {
		//test comment. Last commit and push failed and I can't try again without making a change.
		frame = new JFrame();
		frame.setSize( SCREEN_WIDTH, SCREEN_HEIGHT );
		frame.setLocation( 0, 0 );
		frame.setLayout( null );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setTitle( "CC" );

		importantPanel = new ImportantPanel();
		frame.add( importantPanel );
		newsPanel = new NewsPanel();
		frame.add( newsPanel );
		gamePanel = new GamePanel();
		frame.add( gamePanel );

		frame.setVisible( true );
	}

	public void setController ( Controller controller ) {
		this.controller = controller;
		this.importantPanel.setController( controller );
		this.gamePanel.setController( controller );
		this.newsPanel.setController( controller );
	}

	public void run () {

	}
}