package edu.uah.coffee.clicker.graphics;

import javax.swing.*;

/**
 * A panel to provide whitespace in the GUI for BorderLayouts.
 */
public class SpacePanel extends JPanel {

	/*
	 * constructor for the SpacePanel
	 */
	public SpacePanel(int width, int height) {
		super();
		this.add(Box.createHorizontalStrut(width));
		this.add(Box.createVerticalStrut(height));
	}
}
