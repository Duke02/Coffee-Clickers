package edu.uah.coffee.clicker.graphics;

import javax.swing.JButton;

public class CoolButton extends JButton {

	public CoolButton() {// all buttons will have these qualities by default (T H E M E)
		setLayout(null);// layouts are restrictive. We will be doing something special
	}// bracket!

	public void setRelativeLocation(double x, double y) {// sets the location relative to the parent
		setLocation((int) (x * getParent().getSize().getWidth()), (int) (y * getParent().getSize().getHeight()));// setSize!
	}// bracket bucko!

	public void setRelativeSize(double x, double y) {// sets the size relative to the parent
		setSize((int) (x * getParent().getSize().getWidth()), (int) (y * getParent().getSize().getHeight()));// setSize!
	}// bracket bucko!

}
