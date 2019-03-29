package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class View implements Runnable {
	private static final Toolkit TOOLKIT = Toolkit.getDefaultToolkit();
	private static final int SCREEN_WIDTH = TOOLKIT.getScreenSize().width;
	private static final int SCREEN_HEIGHT = TOOLKIT.getScreenSize().height;

	private JFrame frame;


	private Map< String, CoffeeClickerPanel > panels;

	public View () {
		//test comment. Last commit and push failed and I can't try again without making a change.
		frame = new JFrame();
		frame.setSize( SCREEN_WIDTH, SCREEN_HEIGHT );
		frame.setLocation( 0, 0 );
		frame.setLayout( null );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setTitle( "Coffee Clickers" );

		this.panels = new HashMap< String, CoffeeClickerPanel >();

		this.addPanel( new ImportantPanel() );
		this.addPanel( new NewsPanel() );
		this.addPanel( new GamePanel() );

		for ( CoffeeClickerPanel panel : this.panels.values() ) {
			this.frame.add( panel );
		}

		frame.setVisible( true );
	}

	protected void addPanel ( CoffeeClickerPanel panel ) {
		this.panels.put( panel.getName(), panel );
	}

	public void setController ( String panelName, Controller controller ) {
		this.panels.get( panelName ).addController( controller );
	}

	public void run () {

	}

	public CoffeeClickerPanel getPanel ( String name ) {
		return this.panels.get( name );
	}
}