package edu.uah.coffee.clicker.graphics;

import javax.swing.JLabel;

public class NewsPanel extends AbstractPanel {
	private JLabel label;// labels are cools

	public NewsPanel() {// constructor!
		setRelativeLocation(0, 0);// top-left
		setRelativeSize(0.5, 0.2);// kinda small
		label = new JLabel();// todo" coolLabel
		label.setLayout(null);
		label.setSize(200, 100);
		label.setLocation(25, 0);
		label.setText("N E W S");
		label.setVisible(true);
		this.add(label);
	}
}
