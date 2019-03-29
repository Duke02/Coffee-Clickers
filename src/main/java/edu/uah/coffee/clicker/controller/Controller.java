package edu.uah.coffee.clicker.controller;

import edu.uah.coffee.clicker.CoffeeClickerModel;
import edu.uah.coffee.clicker.graphics.CoffeeClickerPanel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public abstract class Controller implements Observer, PropertyChangeListener {
	protected String name;

	protected Map< String, CoffeeClickerPanel > views;
	protected Map< String, CoffeeClickerModel > models;

	public Controller ( String name ) {
		this.name = name;
		this.views = new HashMap< String, CoffeeClickerPanel >();
		this.models = new HashMap< String, CoffeeClickerModel >();
	}

	protected CoffeeClickerPanel getView ( String name ) {
		return this.views.get( name );
	}

	public void addView ( CoffeeClickerPanel view ) {
		view.addController( this );
		this.views.put( view.getName(), view );
	}

	public String getName () {
		return this.name;
	}

	protected CoffeeClickerModel getModel ( String name ) {
		return this.models.get( name );
	}

	public void addModel ( CoffeeClickerModel model ) {
		this.models.put( model.getModelName(), model );
	}

	public abstract void update ( Observable o, Object arg );

	public abstract void propertyChange ( PropertyChangeEvent evt );
}
