package edu.uah.coffee.clicker.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class NewsPanel extends AbstractPanel {
	private BufferedImage background;
	
	private CoolLabel title;
	private CoolLabel body;

	public NewsPanel() {
		setRelativeLocation(0, 0);
		setRelativeSize(0.6, 0.1);
		
		background = readImage(new File("res/temporaryBackground2.png"));

		title = new CoolLabel();
		this.add(title);
		title.setLayout(null);
		title.setRelativeSize(1, 0.2);
		title.setRelativeLocation(0.01, 0.05);
		title.setText("N E W S");
		title.setVisible(true);

		body = new CoolLabel();
		this.add(body);
		body.setLayout(null);
		body.setRelativeSize(1, 0.2);
		body.setRelativeLocation(0.01, 0.25);
		body.setText("yeeter beeter");
		body.setVisible(true);
		
		repaint();
	}

	public void setNewsText(String newText) {// call this to set the displayed news story
		body.setText(newText);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();

		g2.drawImage(background, 0, 0, getSize().width, getSize().height, this);
		
		g2.dispose();
	}
}