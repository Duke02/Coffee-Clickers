package edu.uah.coffee.clicker;

public class Player extends CoffeeClickerModel {


	int numberOfCoffeeBeans;

	public Player () {
		super( Constants.PLAYER_MODEL_NAME );
	}

	public int getCoffeeBeans () {
		return numberOfCoffeeBeans;
	}

	public void setCoffeeBeans ( int numberOfCoffeeBeans ) {
		this.numberOfCoffeeBeans = numberOfCoffeeBeans;
		this.setChanged();
	}

	public void addCoffeeBeans ( int i ) {
		this.numberOfCoffeeBeans += i;
		this.setChanged();
		this.notifyObservers();
	}

	public void loseBeans ( int cost ) throws IllegalArgumentException {
		if ( this.numberOfCoffeeBeans < cost ) {
			throw new IllegalArgumentException( "Cannot lost more beans than currently have." );
		}
		this.numberOfCoffeeBeans -= cost;
		this.setChanged();
		this.notifyObservers();
	}
}
