package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.ResourceManager;

import javax.swing.*;
import java.awt.*;

public class NewsPanel extends CoffeeClickerPanel {
	private JLabel newsHeadingLabel;
	private JLabel currentNewsLabel;

	public NewsPanel() {
		super(Constants.NEWS_PANEL_NAME);
		setRelativeLocation(0, 0);
		setRelativeSize(0.8, 0.1);

		setLayout(new BorderLayout());
		// setSize( 1000, 1000 );
		newsHeadingLabel = new JLabel();
		// newsHeadingLabel.setPreferredSize( new Dimension( , 100 ) );
		newsHeadingLabel.setText("News Update:");
		newsHeadingLabel.setVisible(true);
		add(newsHeadingLabel, BorderLayout.NORTH);

		currentNewsLabel = new JLabel();
		currentNewsLabel.setText("");
		currentNewsLabel.setVisible(true);
		add(currentNewsLabel, BorderLayout.CENTER);
		
		backgroundImage = readImage(ResourceManager.getFile("/images/background2.png"));
		repaint();
	}

	public void setNews(String text) {
		currentNewsLabel.setText(text);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();

		g2.drawImage(backgroundImage, 0, 0, getSize().width, getSize().height, this);
		
		g2.dispose();
	}
}
