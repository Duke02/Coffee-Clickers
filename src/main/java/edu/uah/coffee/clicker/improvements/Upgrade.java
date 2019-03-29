package edu.uah.coffee.clicker.improvements;

import edu.uah.coffee.clicker.CoffeeClickerModel;

/**
 * @author trystanmay
 */
public class Upgrade extends CoffeeClickerModel implements Improvement {

	private int id;
	private String name;

	public Upgrade ( String name, int id ) {
		super( name );
		this.name = name;
		this.id = id;
	}


	public int getId () {
		return this.id;
	}

	public String getName () {
		return this.name;
	}

	public void setName ( String name ) {
		this.name = name;
	}
}
