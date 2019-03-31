package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.controller.Controller;

public class StorePanel extends CoffeeClickerPanel {
	protected Controller controller;

	public StorePanel ( String name ) {
		super( name );
	}

	public void setController ( Controller controller ) {
		this.controller = controller;
	}

}
