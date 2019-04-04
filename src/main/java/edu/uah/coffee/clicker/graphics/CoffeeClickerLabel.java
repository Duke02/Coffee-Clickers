package edu.uah.coffee.clicker.graphics;

import javax.swing.*;
import java.awt.*;

public class CoffeeClickerLabel extends JLabel {

	private Dimension relativeSize;
	private Point relativeLocation;

	public CoffeeClickerLabel () {
		setLayout( null );
		this.relativeLocation = new Point();
		this.relativeSize = new Dimension();
	}

	public void setRelativeLocation ( double x, double y ) {// sets the location relative to the parent
		this.relativeLocation.x = ( int ) ( x * getParent().getSize().getWidth() );
		this.relativeLocation.y = ( int ) ( y * getParent().getSize().getHeight() );
		setLocation( this.relativeLocation );
	}

	public void setRelativeSize ( double x, double y ) {
		this.relativeSize.width = ( int ) ( x * getParent().getSize().getWidth() );
		this.relativeSize.height = ( int ) ( y * getParent().getSize().getHeight() );
		setSize( this.relativeSize );
	}

	public Dimension getRelativeSize () {
		return this.relativeSize;
	}

	public Point getRelativeLocation () {
		return this.relativeLocation;
	}
}