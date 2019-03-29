package edu.uah.coffee.clicker.controller;

import edu.uah.coffee.clicker.graphics.CoffeeClickerPanel;

import java.util.*;

public abstract class Controller implements Observer, EventListener {
	protected String name;

	protected Map< String, CoffeeClickerPanel > views;
	protected Map< String, Observable > model;

	public Controller ( String name ) {
		this.name = name;
		this.views = new HashMap< String, CoffeeClickerPanel >();
	}

	protected CoffeeClickerPanel getView ( String name ) {
		return this.views.get( name );
	}

	protected void addView ( CoffeeClickerPanel view ) {
		this.views.put( view.getName(), view );
	}

	public String getName () {
		return this.name;
	}

	public abstract void update ( Observable o, Object arg );
}
