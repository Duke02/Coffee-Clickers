package edu.uah.coffee.clicker.graphics;

import javax.swing.*;
import java.awt.*;

public class CoffeeClickerButton extends JButton {

	protected Point relativeLocation;
	protected Dimension relativeSize;

	public CoffeeClickerButton() {
		setLayout(null);
		this.relativeLocation = new Point();
		this.relativeSize = new Dimension();
	}

	public void setRelativeLocation(double x, double y) {// sets the location relative to the parent
		setLocation((int) (x * getParent().getSize().getWidth()), (int) (y * getParent().getSize().getHeight()));
	}

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