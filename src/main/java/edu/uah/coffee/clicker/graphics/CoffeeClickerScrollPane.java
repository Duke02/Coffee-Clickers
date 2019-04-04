package edu.uah.coffee.clicker.graphics;

import javax.swing.*;
import java.awt.*;

public class CoffeeClickerScrollPane extends JScrollPane {
	private Dimension relativeSize;
	private Point relativeLocation;

	public CoffeeClickerScrollPane () {
		super();
		this.relativeSize = new Dimension();
		this.relativeLocation = new Point();
	}

	public CoffeeClickerScrollPane ( CoffeeClickerPanel panel, int verticalScrollbar, int horizontalScrollbar ) {
		super( panel, verticalScrollbar, horizontalScrollbar );
		this.relativeSize = new Dimension();
		this.relativeLocation = new Point();
		this.setRelativeSize( panel.getRelativeSize() );
		this.setRelativeLocation( panel.getRelativeLocation() );
	}

	public void setRelativeSize ( Dimension size ) {
		this.setRelativeSize( size.width, size.height );
	}

	public void setRelativeLocation ( Point location ) {
		this.setRelativeLocation( location.x, location.y );
	}

	public void setRelativeLocation ( double x, double y ) {
		this.relativeLocation.x = ( int ) ( x * this.getParent().getSize().getWidth() );
		this.relativeLocation.y = ( int ) ( y * getParent().getSize().getHeight() );
		setLocation( this.relativeLocation );
	}

	public void setRelativeSize ( double x, double y ) {
		this.relativeSize.width = ( int ) ( x * View.SCREEN_WIDTH );
		this.relativeSize.height = ( int ) ( y * View.SCREEN_HEIGHT );
		setSize( relativeSize );
	}

	public Dimension getRelativeSize () {
		return this.relativeSize;
	}

	public Point getRelativeLocation () {
		return this.relativeLocation;
	}

}
