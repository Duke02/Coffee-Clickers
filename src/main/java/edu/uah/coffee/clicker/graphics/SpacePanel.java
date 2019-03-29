package edu.uah.coffee.clicker.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * A panel to provide whitespace in the GUI for BorderLayouts.
 */
public class SpacePanel extends JPanel {

	public SpacePanel ( int width, int height ) {
		super();
		this.setSize( new Dimension( width, height ) );
	}
}
