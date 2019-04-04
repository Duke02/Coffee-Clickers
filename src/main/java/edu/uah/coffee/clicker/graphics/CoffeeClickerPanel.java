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
	protected String name;
	protected Dimension relativeSize;
	protected Point relativeLocation;

	protected Map< String, Controller > controllers;

	public CoffeeClickerPanel ( String name ) {
		this.name = name;
		this.controllers = new HashMap<>();
		this.relativeSize = new Dimension();
		this.relativeLocation = new Point();
	}

	protected Controller getController ( String name ) {
		return this.controllers.get( name );
	}

	public void addController ( Controller controller ) {
		this.controllers.put( controller.getName(), controller );
		this.addPropertyChangeListener( controller.getName(), controller );
	}

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
