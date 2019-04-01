package edu.uah.coffee.clicker.graphics;

public class NewsPanel extends AbstractPanel {
	private CoolLabel title;
	private CoolLabel body;

	public NewsPanel() {
		setRelativeLocation(0, 0);
		setRelativeSize(0.6, 0.1);

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
	}

	public void setNewsText(String newText) {// call this to set the displayed news story
		body.setText(newText);
	}
}
