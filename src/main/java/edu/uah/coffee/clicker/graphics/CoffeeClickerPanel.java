package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class CoffeeClickerPanel extends JPanel {
	/**
	 * The name of the view to be used as a key.
	 */
	protected String name;
	/**
	 * The relative size of the view in terms of the main View size.
	 */
	protected Dimension relativeSize;
	/**
	 * The relative location of the view within the main View.
	 */
	protected Point relativeLocation;

	/**
	 * The internal storage of the controllers that connects with the view.
	 */
	protected Map< String, Controller > controllers;

	/**
	 * Constructor for base class for panels in the view.
	 *
	 * @param name The view name to be used as a key for Controller views.
	 */
	public CoffeeClickerPanel ( String name ) {
		this.name = name;
		this.controllers = new HashMap<>();
		this.relativeSize = new Dimension();
		this.relativeLocation = new Point();
	}

	/**
	 * Gets the controller with the given key name
	 *
	 * @param name the key of the controller
	 * @return the controller within the panel with the given name.
	 */
	protected Controller getController ( String name ) {
		return this.controllers.get( name );
	}

	/**
	 * Adds the controller to the internal storage of the view's controllers
	 *
	 * @param controller The controller to add.
	 */
	public void addController ( Controller controller ) {
		this.controllers.put( controller.getName(), controller );
		this.addPropertyChangeListener( controller.getName(), controller );
	}

	/**
	 * Gets the name of the view that is to be used as a key.
	 *
	 * @return the name of the view.
	 */
	public String getName () {
		return this.name;
	}

	public void setRelativeLocation ( double x, double y ) {
		setLocation( ( int ) ( x * View.SCREEN_WIDTH ), ( int ) ( y * View.SCREEN_HEIGHT ) );
	}

	public void setRelativeSize ( double x, double y ) {
		this.relativeSize = new Dimension( ( int ) ( x * View.SCREEN_WIDTH ), ( int ) ( y * View.SCREEN_HEIGHT ) );
		setSize( relativeSize );
	}

	public Dimension getRelativeSize () {
		return this.relativeSize;
	}

	public Point getRelativeLocation () {
		return this.relativeLocation;
	}

	public BufferedImage readImage ( File file ) {
		BufferedImage image = null;
		try {
			image = ImageIO.read( file );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return image;
	}
}
