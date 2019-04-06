package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class View implements Runnable {
	private static final Toolkit TOOLKIT = Toolkit.getDefaultToolkit();
	public static final int SCREEN_WIDTH = ( int ) ( ( double ) TOOLKIT.getScreenSize().width * 0.9 );
	public static final int SCREEN_HEIGHT = ( int ) ( ( double ) TOOLKIT.getScreenSize().height * 0.9 );

	private JFrame frame;

	private Map< String, CoffeeClickerPanel > panels;

	public View () {
		frame = new JFrame();
		frame.setSize( SCREEN_WIDTH, SCREEN_HEIGHT );
		frame.setLayout( null );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setTitle( "Coffee Clickers" );

		this.panels = new HashMap<>();

		this.addPanel( new NewsPanel() );
		this.addPanel( new GamePanel() );
		this.addPanel( new BuildingsPanel() );

		frame.setVisible( true );
	}

	public void run () {
	}

	private void addPanel ( CoffeeClickerPanel panel ) {

		this.panels.put( panel.getName(), panel );
		this.frame.add( panel );
		panel.setVisible( true );
	}

	public void setController ( String panelName, Controller controller ) {
		this.panels.get( panelName ).addController( controller );
	}

	public CoffeeClickerPanel getPanel ( String name ) {
		return this.panels.get( name );
	}
}