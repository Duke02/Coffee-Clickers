package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class View implements Runnable {
	private static final Toolkit TOOLKIT = Toolkit.getDefaultToolkit();
	private static final int SCREEN_WIDTH = ( int ) ( ( double ) TOOLKIT.getScreenSize().width * 0.9 );
	private static final int SCREEN_HEIGHT = ( int ) ( ( double ) TOOLKIT.getScreenSize().height * 0.9 );

	private JFrame frame;
	private JScrollPane buildingScrollPane;

	private Map< String, CoffeeClickerPanel > panels;

	public View () {
		frame = new JFrame();
		frame.setSize( SCREEN_WIDTH, SCREEN_HEIGHT );
		frame.setLayout( new BorderLayout() );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setTitle( "Coffee Clickers" );

		this.panels = new HashMap<>();

		this.addPanel( new NewsPanel(), BorderLayout.NORTH );
		this.addPanel( new GamePanel(), BorderLayout.WEST );
		this.addPanel( new BuildingsPanel(), BorderLayout.CENTER );

		this.buildingScrollPane = new JScrollPane( this.getPanel( Constants.BUILDING_PANEL_NAME ), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		this.buildingScrollPane.setBorder( null );
		this.frame.add( this.buildingScrollPane );

		frame.setVisible( true );
	}

	public void run () {
	}

	private void addPanel ( CoffeeClickerPanel panel, String placement ) {

		this.panels.put( panel.getName(), panel );
		if ( ! ( panel instanceof BuildingsPanel ) ) {
			this.frame.add( panel, placement );
		}
		panel.setVisible( true );
	}

	public void setController ( String panelName, Controller controller ) {
		this.panels.get( panelName ).addController( controller );
	}

	public CoffeeClickerPanel getPanel ( String name ) {
		return this.panels.get( name );
	}
}