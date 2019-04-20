package edu.uah.coffee.clicker.graphics;

import javax.swing.*;
import java.awt.*;

public class CoffeeClickerLabel extends JLabel {

	private Dimension relativeSize;
	private Point relativeLocation;

	/*
	 * Constructor for the CoffeeClickerLabel
	 */
	public CoffeeClickerLabel() {
		setLayout(null);
		this.relativeLocation = new Point();
		this.relativeSize = new Dimension();
	}

	/**
	 * Sets the location by by percentage (0-1) rather than by pixel
	 * @param x The new x-position (0-1)
	 * @param y The new t-position (0-1)
	 */
	public void setRelativeLocation(double x, double y) {
		this.relativeLocation.x = (int) (x * getParent().getSize().getWidth());
		this.relativeLocation.y = (int) (y * getParent().getSize().getHeight());
		setLocation(this.relativeLocation);
	}
	/**
	 * Sets the size by by percentage (0-1) rather than by pixel
	 * @param x The new width (0-1)
	 * @param y The new height (0-1)
	 */
	public void setRelativeSize(double x, double y) {
		this.relativeSize.width = (int) (x * getParent().getSize().getWidth());
		this.relativeSize.height = (int) (y * getParent().getSize().getHeight());
		setSize(this.relativeSize);
	}

	public Dimension getRelativeSize() {
		return this.relativeSize;
	}

	public Point getRelativeLocation() {
		return this.relativeLocation;
	}
}