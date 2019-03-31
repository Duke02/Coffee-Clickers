package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.controller.Controller;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public abstract class CoffeeClickerPanel extends JPanel {
	protected String name;

	protected Map< String, Controller > controllers;

	public CoffeeClickerPanel ( String name ) {
		this.name = name;
		this.controllers = new HashMap< String, Controller >();
	}

	protected Controller getController ( String name ) {
		return this.controllers.get( name );
	}

	public void addController ( Controller controller ) {
		this.controllers.put( controller.getName(), controller );
		this.addPropertyChangeListener( controller.getName(), controller );
	}

	public String getName () {
		return this.name;
	}
}
