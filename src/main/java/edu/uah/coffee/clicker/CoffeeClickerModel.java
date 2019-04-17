package edu.uah.coffee.clicker;


import java.io.Serializable;
import java.util.Observable;

public abstract class CoffeeClickerModel extends Observable implements Serializable {

	protected String modelName;

	public CoffeeClickerModel ( String modelName ) {
		super();
		this.modelName = modelName;
	}

	public String getModelName () {
		return this.modelName;
	}

	public void setModelName ( String name ) {
		this.modelName = name;
	}
}
