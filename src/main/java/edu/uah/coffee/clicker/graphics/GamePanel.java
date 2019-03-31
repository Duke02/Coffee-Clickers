package edu.uah.coffee.clicker.graphics;

public class GamePanel extends AbstractPanel {
	private CoolButton countButton;// a button a day keeps the label away

	public GamePanel() {// contructor!
		setRelativeLocation(0, 0.2);// bottom left
		setRelativeSize(0.5, 0.7);// kinda big
		countButton = new CoolButton();// coffee button!
		this.add(countButton);// add first so that relatives can be calculated
		countButton.setRelativeSize(0.2, 0.1);// size
		countButton.setText("coffee");// how else would you know what this button did?
		countButton.setVisible(true);// an invisible button is a sad button
	}// bracket!

	public void update(double time) {// very cool
		countButton.setRelativeLocation(Math.sin(time) / 5 + 0.5, Math.cos(time) / 5 + 0.5);
		// location is animated to move in a counterclockwise circle
	}// very cool bracket!

}// regular bracket
