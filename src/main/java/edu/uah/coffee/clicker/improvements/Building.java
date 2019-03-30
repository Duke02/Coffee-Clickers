package edu.uah.coffee.clicker.improvements;

import edu.uah.coffee.clicker.CoffeeClickerModel;

/**
 * @author trystanmay
 */
public class Building extends CoffeeClickerModel implements Improvement {

	protected int id;
	protected double cookiesPerSecond;
	protected String name;

	public Building ( String name, int id, double cookiesPerSecond ) {
		super( "building-" + id );
		this.name = name;
		this.id = id;
		this.cookiesPerSecond = cookiesPerSecond;
	}

	public int getId () {
		return id;
	}

	public double getCookiesPerSecond () {
		return cookiesPerSecond;
	}

	public void setCookiesPerSecond ( double cookiesPerSecond ) {
		this.cookiesPerSecond = cookiesPerSecond;
	}

	public void multiplyCookiesPerSecond ( double modifier ) {
		this.cookiesPerSecond *= modifier;
	}

	public void addCookiesPerSecond ( double addition ) {
		this.cookiesPerSecond += addition;
	}

	public String getName () {
		return name;
	}

	public void setName ( String name ) {
		this.name = name;
	}
}
