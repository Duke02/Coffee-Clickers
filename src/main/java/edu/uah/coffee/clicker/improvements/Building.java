package edu.uah.coffee.clicker.improvements;

import edu.uah.coffee.clicker.CoffeeClickerModel;

/**
 * @author trystanmay
 */
public class Building extends CoffeeClickerModel implements Improvement {

	private int id;
	private double cookiesPerSecond;
	private String name;
	private int numberBought;
	private int costCoefficient;
	private int initialCost;

	public Building ( String name, int id, double cookiesPerSecond, int cost, int costCoefficient ) {
		super( "building-" + id );
		this.name = name;
		this.id = id;
		this.cookiesPerSecond = cookiesPerSecond;
		this.numberBought = 0;
		this.costCoefficient = costCoefficient;
		this.initialCost = cost;
	}

	public int getNumberBought () {
		return numberBought;
	}

	/**
	 * Buy that number of buildings
	 *
	 * @param amount the amount to buy (assumes the amount is less than numberCanBuy)
	 * @return the total cost of the purchase.
	 */
	public int buy ( int amount ) {
		this.numberBought += amount;

		int costOfPurchase = 0;
		for ( int i = 0; i < amount; i++ ) {
			costOfPurchase += this.getCost( this.numberBought + i );
		}

		this.setChanged();
		return costOfPurchase;
	}

	/**
	 * Returns the number that an entity can buy.
	 *
	 * @param wallet The number of beans the entity has saved.
	 * @return the number of buildings that the entity can buy.
	 */
	public int numberCanBuy ( int wallet ) {
		// Subtract the current cost first of all to see if the entity
		// can first off buy the building at the current cost.
		int output = ( wallet - this.getCost() );
		if ( output <= 0 )
			return 0;
		// Divide for any future changes
		return output / this.costCoefficient;
	}

	/**
	 * Gets the cost of buying the xth building.
	 *
	 * @param x
	 * @return
	 */
	protected int getCost ( int x ) {
		return this.costCoefficient * x + this.initialCost;
	}

	/**
	 * @return the cost of buying another of this building.
	 */
	public int getCost () {
		return this.getCost( this.numberBought + 1 );
	}

	public int getId () {
		return id;
	}

	public double getCookiesPerSecond () {
		return cookiesPerSecond;
	}

	public void setCookiesPerSecond ( double cookiesPerSecond ) {
		this.cookiesPerSecond = cookiesPerSecond;
		this.setChanged();
	}

	public void multiplyCookiesPerSecond ( double modifier ) {
		this.cookiesPerSecond *= modifier;
		this.setChanged();
	}

	public void addCookiesPerSecond ( double addition ) {
		this.cookiesPerSecond += addition;
		this.setChanged();
	}

	public String getName () {
		return name;
	}

	public void setName ( String name ) {
		this.name = name;
		this.setChanged();
	}
}
