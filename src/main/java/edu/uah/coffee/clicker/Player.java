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
	}

}
