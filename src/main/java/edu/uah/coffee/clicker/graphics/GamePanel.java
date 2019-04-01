package edu.uah.coffee.clicker.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class GamePanel extends AbstractPanel {
	private double time = 0;
	private BufferedImage background;
	private ArrayList<BufferedImage> buildings = new ArrayList<BufferedImage>();

	private CoolButton countButton;
	private CoolLabel countLabel;

	public GamePanel() {
		setRelativeLocation(0, 0.1);
		setRelativeSize(0.6, 0.9);

		background = readImage(new File("res/temporaryBackground.png"));
		ArrayList<File> files = new ArrayList<File>(Arrays.asList(new File("res/buildings").listFiles()));
		for (File file : files) {
			buildings.add(readImage(file));
		}

		countButton = new CoolButton();
		this.add(countButton);// add first so that relatives can be calculated
		countButton.setRelativeLocation(0.4, 0.45);
		countButton.setRelativeSize(0.2, 0.1);
		countButton.setText("coffee");
		countButton.setVisible(true);

		countLabel = new CoolLabel();
		this.add(countLabel);// add first so that relatives can be calculated
		countLabel.setRelativeLocation(0.01, 0);
		countLabel.setRelativeSize(0.1, 0.1);
		countLabel.setText("coffees: 0");
		countLabel.setVisible(true);
	}

	public void setCoffeeCountText(String newText) {// call this to set the displayed coffee count story
		countLabel.setText(newText);
	}

	public void update(double time) {
		this.time = time;
		repaint();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();

		g2.drawImage(background, 0, 0, getSize().width, getSize().height, this);

		for (int i = 0; i < buildings.size(); ++i) {
			int x = (int) ((Math.sin(time * (1.8 + i * 0.05)) / 2.5 + 0.4) * getSize().width);
			int y = (int) ((Math.cos(time * (1.2 + i * 0.05)) / 7.5 + 0.575) * getSize().height);
			g2.drawImage(buildings.get(i), x, y, getSize().width / 5, getSize().width / 5, this);
		}
		g2.dispose();
	}
}
