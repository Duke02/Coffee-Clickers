package edu.uah.coffee.clicker;

public class Player extends CoffeeClickerModel {


	int numberOfCoffeeBeans;

	/**
	 * Creates a new player model with the model name provided by Constants.
	 *
	 * @see Constants#PLAYER_MODEL_NAME
	 */
	public Player () {
		super( Constants.PLAYER_MODEL_NAME );
	}

	/**
	 * @return the number of acquired coffee beans.
	 */
	public int getCoffeeBeans () {
		return numberOfCoffeeBeans;
	}

	/**
	 * Adds the specified number of coffee beans to the mound the player has amassed.
	 *
	 * @param i the amount to add.
	 */
	public void addCoffeeBeans ( int i ) {
		this.numberOfCoffeeBeans += i;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Removes beans from the player's stash (usually in a purchase).
	 *
	 * @param cost the amount of beans to lose.
	 * @throws IllegalArgumentException if the number of beans the player has is less than the cost.
	 */
	public void loseBeans ( int cost ) throws IllegalArgumentException {
		if ( this.numberOfCoffeeBeans < cost ) {
			throw new IllegalArgumentException( "Cannot lost more beans than currently have." );
		}
		this.numberOfCoffeeBeans -= cost;
		this.setChanged();
		this.notifyObservers();
	}
}
