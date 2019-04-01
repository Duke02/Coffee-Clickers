package edu.uah.coffee.clicker.graphics;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class AbstractPanel extends JPanel {
	private static final Toolkit TOOLKIT = Toolkit.getDefaultToolkit();
	private static final int SCREEN_WIDTH = TOOLKIT.getScreenSize().width;
	private static final int SCREEN_HEIGHT = (int) (TOOLKIT.getScreenSize().height * 0.95);

	public AbstractPanel() {
		setLayout(null);// this will be useful. DO NOT DELETE
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public void setRelativeLocation(double x, double y) {// sets the location of the panel relative to the size of the
															// screen
		setLocation((int) (x * SCREEN_WIDTH), (int) (y * SCREEN_HEIGHT));
	}

	public void setRelativeSize(double x, double y) {// sets the size of the panel relative to the size of the screen
		setSize((int) (x * SCREEN_WIDTH), (int) (y * SCREEN_HEIGHT));
	}

	public BufferedImage readImage(File file) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
