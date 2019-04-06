package edu.uah.coffee.clicker.controller;

import edu.uah.coffee.clicker.CoffeeClickerModel;
import edu.uah.coffee.clicker.graphics.CoffeeClickerPanel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * The base class for all controllers.
 * <p>
 * Manages interactions between the specific internal views and models.
 */
public abstract class Controller implements Observer, PropertyChangeListener {
	/**
	 * The name of the controller to be used as a key within maps.
	 */
	protected String name;

	/**
	 * The internal views that are to be updated on changes to the models.
	 * <p>
	 * The keys are to be the view names.
	 *
	 * @see CoffeeClickerPanel#getName()
	 */
	protected Map< String, CoffeeClickerPanel > views;

	/**
	 * The internal models that are to be observed for any changes.
	 * <p>
	 * The keys are to be the model names.
	 *
	 * @see CoffeeClickerModel#getModelName()
	 */
	protected Map< String, CoffeeClickerModel > models;

	/**
	 * Base constructor for the controllers.
	 *
	 * @param name The name of the controllers.
	 */
	public Controller ( String name ) {
		this.name = name;
		this.views = new HashMap<>();
		this.models = new HashMap<>();
	}

	/**
	 * Gets the view with the given key.
	 *
	 * @param name The view name that is the key.
	 * @return The requested view.
	 */
	protected CoffeeClickerPanel getView ( String name ) {
		return this.views.get( name );
	}

	/**
	 * Adds the view to the internal storage of the views
	 * <p>
	 * Adds this controller to the view's internal storage of controllers.
	 *
	 * @param view The view to be added.
	 * @see CoffeeClickerPanel#addController(Controller)
	 * Uses the name of the view as the key for the view.
	 */
	public void addView ( CoffeeClickerPanel view ) {
		view.addController( this );
		this.views.put( view.getName(), view );
	}

	/**
	 * Gets the name of the controller. To be used as a key.
	 *
	 * @return the requested controller.
	 */
	public String getName () {
		return this.name;
	}

	/**
	 * Gets the model within the controller with the given key.
	 *
	 * @param name The name for the requested model.
	 * @return The requested model.
	 */
	protected CoffeeClickerModel getModel ( String name ) {
		return this.models.get( name );
	}

	/**
	 * Adds the model to the internal storage of models, using the model's name for the key.
	 *
	 * @param model the model to be added.
	 * @see CoffeeClickerModel#getModelName()
	 * @see Controller#models
	 */
	public void addModel ( CoffeeClickerModel model ) {
		model.addObserver( this );
		this.models.put( model.getModelName(), model );
	}

	/**
	 * Updates the model in the event of any changes to it.
	 * <p>
	 * Removes the model and adds it, assuming it was already in there.
	 *
	 * @param model the model to be updated.
	 */
	public void updateModel ( CoffeeClickerModel model ) {
		if ( ! this.models.containsKey( model.getModelName() ) ) {
			return;
		}
		this.models.remove( model.getModelName() );
		this.models.put( model.getModelName(), model );
	}

	/**
	 * Triggered when a model changes state.
	 *
	 * @param o   the model
	 * @param arg the arguments passed.
	 */
	public abstract void update ( Observable o, Object arg );

	/**
	 * Triggered when a view changes its properties.
	 *
	 * @param evt
	 */
	public abstract void propertyChange ( PropertyChangeEvent evt );
}
