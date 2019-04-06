package edu.uah.coffee.clicker;

import java.util.Observable;

/**
 * The base class for all models within the project.
 */
public abstract class CoffeeClickerModel extends Observable {

	/**
	 * The name for the model, to be used as a key for maps tracking the model.
	 */
	protected String modelName;

	/**
	 * The base constructor of the model class.
	 *
	 * @param modelName the name for the model.
	 */
	public CoffeeClickerModel ( String modelName ) {
		super();
		this.modelName = modelName;
	}

	/**
	 * Gets the name for the model that is to be used as a key for maps keeping track of the
	 * model.
	 *
	 * @return the name for the model.
	 */
	public String getModelName () {
		return this.modelName;
	}

	/**
	 * Sets the name of the model.
	 *
	 * @param name the name of the model to be used.
	 */
	public void setModelName ( String name ) {
		this.modelName = name;
	}
}
