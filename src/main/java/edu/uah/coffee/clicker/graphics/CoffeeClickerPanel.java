package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.controller.Controller;
import javafx.beans.Observable;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public abstract class CoffeeClickerPanel extends JPanel implements Observable {
	protected String name;

	protected Map< String, Controller > controllers;

	public CoffeeClickerPanel ( String name ) {
		this.name = name;
		this.controllers = new HashMap< String, Controller >();
	}

	protected Controller getController ( String name ) {
		return this.controllers.get( name );
	}

	protected void addController ( Controller controller ) {
		this.controllers.put( controller.getName(), controller );
	}

	public String getName () {
		return this.name;
	}

}
