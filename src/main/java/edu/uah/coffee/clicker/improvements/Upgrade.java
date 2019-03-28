package edu.uah.coffee.clicker.improvements;

/**
 * @author trystanmay
 */
public class Upgrade implements Improvement {

	private int id;
	private String name;


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
