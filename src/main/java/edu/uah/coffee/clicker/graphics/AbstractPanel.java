package edu.uah.coffee.clicker.graphics;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class AbstractPanel extends JPanel {// its the abstract panel!
	// these are technically in the view as well
	// passing them along to every panel would be cumbersome
	// and making making the View static or the values public would sacrifice
	// information hiding
	// so I declared them here too!
	private static final Toolkit TOOLKIT = Toolkit.getDefaultToolkit();// toolkit!
	private static final int SCREEN_WIDTH = TOOLKIT.getScreenSize().width;// screen width!
	private static final int SCREEN_HEIGHT = (int) (TOOLKIT.getScreenSize().height * 0.9);// screen height!

	public AbstractPanel() {// all panels will have these qualities by default (T H E M E)
		setLayout(null);// layouts are restrictive. We will be doing something special
		setBorder(BorderFactory.createLineBorder(Color.black));// borders are aesthetically pleasing
	}// bracket!

	public void setRelativeLocation(double x, double y) {// sets the location of the panel relative to the size of the
															// screen
		setLocation((int) (x * SCREEN_WIDTH), (int) (y * SCREEN_HEIGHT));// setSize!
	}// bracket bucko!

	public void setRelativeSize(double x, double y) {// sets the size of the panel relative to the size of the screen
		setSize((int) (x * SCREEN_WIDTH), (int) (y * SCREEN_HEIGHT));// setSize!
	}// bracket bucko!
}// bracket!
