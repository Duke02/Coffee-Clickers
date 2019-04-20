package edu.uah.coffee.clicker.graphics;

import javax.swing.*;
import java.awt.*;

public class CoffeeClickerLabel extends JLabel {

	private Dimension relativeSize;
	private Point relativeLocation;

	/*
	 * constructor for the CoffeeClickerLabel
	 */
	public CoffeeClickerLabel() {
		setLayout(null);
		this.relativeLocation = new Point();
		this.relativeSize = new Dimension();
	}

	/*
	 * sets the location by by percentage (0-1) rather than by pixel
	 * @param x and y and values 0-1
	 */
	public void setRelativeLocation(double x, double y) {
		this.relativeLocation.x = (int) (x * getParent().getSize().getWidth());
		this.relativeLocation.y = (int) (y * getParent().getSize().getHeight());
		setLocation(this.relativeLocation);
	}
	/*
	 * sets the size by by percentage (0-1) rather than by pixel
	 * @param x and y and values 0-1
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