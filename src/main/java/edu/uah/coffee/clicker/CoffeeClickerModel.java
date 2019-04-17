package edu.uah.coffee.clicker;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Observable;

public abstract class CoffeeClickerModel extends Observable implements Serializable{

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
