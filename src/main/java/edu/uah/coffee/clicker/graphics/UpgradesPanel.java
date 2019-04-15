package edu.uah.coffee.clicker.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class UpgradesPanel extends StorePanel {
	private BufferedImage background;
	
	public UpgradesPanel() {
		setRelativeLocation(0.8, 0);
		setRelativeSize(0.2, 1);
		
		background = readImage(new File("res/temporaryBackground4.png"));
		
		repaint();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();

		g2.drawImage(background, 0, 0, getSize().width, getSize().height, this);
		
		g2.dispose();
	}
}
