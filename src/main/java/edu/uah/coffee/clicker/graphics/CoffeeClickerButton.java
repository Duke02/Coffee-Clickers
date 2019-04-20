package edu.uah.coffee.clicker.graphics;

import javax.swing.*;
import java.awt.*;

public class CoffeeClickerButton extends JButton {

	protected Point relativeLocation;
	protected Dimension relativeSize;

	/*
	 * constructor for the CoffeeClicerButton
	 */
	public CoffeeClickerButton() {
		setLayout(null);
		this.relativeLocation = new Point();
		this.relativeSize = new Dimension();
	}
	/*
	 * sets the location by by percentage (0-1) rather than by pixel
	 * @param x and y and values 0-1
	 */
	public void setRelativeLocation(double x, double y) {// sets the location relative to the parent
		setLocation((int) (x * getParent().getSize().getWidth()), (int) (y * getParent().getSize().getHeight()));
	}
	/*
	 * sets the size by by percentage (0-1) rather than by pixel
	 * @param x and y and values 0-1
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