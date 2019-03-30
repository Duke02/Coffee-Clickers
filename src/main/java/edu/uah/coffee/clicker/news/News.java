package edu.uah.coffee.clicker.news;

import edu.uah.coffee.clicker.CoffeeClickerModel;

public class News extends CoffeeClickerModel {

	protected String text;

	public News ( String text ) {
		super( "news" );
		this.text = text;
	}

	public String getText () {
		return this.text;
	}
}
