package edu.uah.coffee.clicker.graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private JButton countButton;
	
	public GamePanel() {
		setLayout(null);
		setSize(1000,1000);
		setLocation(0,200);
		countButton=new JButton();
		countButton.setLayout(null);
		countButton.setSize(200,100);
		countButton.setLocation(200,200);
		countButton.setText("coffee");
		countButton.setVisible(true);
		this.add(countButton);
	}
	
}
