package edu.uah.coffee.clicker.graphics;

import javax.swing.*;
import java.awt.*;

public class CoffeeClickerButton extends JButton {

	protected Point relativeLocation;
	protected Dimension relativeSize;

	/**
	 * Constructor for the CoffeeClicerButton
	 */
	public CoffeeClickerButton() {
		setLayout(null);
		this.relativeLocation = new Point();
		this.relativeSize = new Dimension();
	}
	/**
	 * Sets the location by by percentage (0-1) rather than by pixel
	 * @param x The new x-position (0-1)
	 * @param y The new t-position (0-1)
	 */
	public void setRelativeLocation(double x, double y) {// sets the location relative to the parent
		setLocation((int) (x * getParent().getSize().getWidth()), (int) (y * getParent().getSize().getHeight()));
	}
	/**
	 * Sets the size by by percentage (0-1) rather than by pixel
	 * @param x The new width (0-1)
	 * @param y The new height (0-1)
	 */
	public void setRelativeSize(double x, double y) {// sets the size relative to the parent
		setSize((int) (x * getParent().getSize().getWidth()), (int) (y * getParent().getSize().getHeight()));
	}

	public Dimension getRelativeSize() {
		return this.relativeSize;
	}

	public Point getRelativeLocation() {
		return this.relativeLocation;
	}
}