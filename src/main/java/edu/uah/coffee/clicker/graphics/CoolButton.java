package edu.uah.coffee.clicker.graphics;

import javax.swing.JButton;

public class CoolButton extends JButton {

	public CoolButton() {
		setLayout(null);
	}

	public void setRelativeLocation(double x, double y) {// sets the location relative to the parent
		setLocation((int) (x * getParent().getSize().getWidth()), (int) (y * getParent().getSize().getHeight()));
	}

	public void setRelativeSize(double x, double y) {// sets the size relative to the parent
		setSize((int) (x * getParent().getSize().getWidth()), (int) (y * getParent().getSize().getHeight()));
	}

}
