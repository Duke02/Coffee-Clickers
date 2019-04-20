package edu.uah.coffee.clicker.news;

import edu.uah.coffee.clicker.CoffeeClickerModel;

public class News extends CoffeeClickerModel {

	protected String text;

	/**
	 * Creates a new News object with the provided text.
	 *
	 * @param text the text to be displayed.
	 */
	public News ( String text ) {
		super( "news" );
		this.text = text;
	}

	/**
	 * @return the text to be displayed on the view.
	 */
	public String getText () {
		return this.text;
	}
}
