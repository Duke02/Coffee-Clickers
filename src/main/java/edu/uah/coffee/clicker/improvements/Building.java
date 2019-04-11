package edu.uah.coffee.clicker.improvements;

import edu.uah.coffee.clicker.CoffeeClickerModel;

/**
 * @author trystanmay
 */
public class Building extends CoffeeClickerModel implements Improvement {

	private int id;
	private double beansPerSecond;
	private String name;
	private int numberBought;
	private int costCoefficient;
	private int initialCost;
	private String imageFileName;

	/**
	 * Creates a new building with the given parameters.
	 *
	 * @param name            the name of the building.
	 * @param id              the id of the building to be specific to this type of building.
	 * @param beansPerSecond  the number of beans each building is to generate
	 * @param cost            the cost of buying the first building of this type.
	 * @param costCoefficient the increase in cost with each new purchase of this type of building.
	 * @param filename        the filename for the building's image.
	 */
	public Building ( String name, int id, double beansPerSecond, int cost, int costCoefficient, String filename ) {
		super( "building-" + id );
		this.name = name;
		this.id = id;
		this.beansPerSecond = beansPerSecond;
		this.numberBought = 0;
		this.costCoefficient = costCoefficient;
		this.initialCost = cost;
		this.imageFileName = filename;
	}

	/**
	 * Default constructor for parsing json files.
	 */
	public Building () {
		this( "", - 1, - 1, - 1, - 1, "" );
	}

	/**
	 * Copy constructor.
	 *
	 * @param building the building to be copied from.
	 */
	public Building ( Building building ) {
		this( building.getName(), building.getId(), building.getBeansPerSecond(),
				building.initialCost, building.costCoefficient, building.getImageFileName() );
	}

	/**
	 * Gets the image file name for the building to be used for displaying.
	 *
	 * @return The image file name for the building.
	 */
	public String getImageFileName () {
		return this.imageFileName;
	}

	/**
	 * Sets the id for the building that is to be used within BuildingManager.
	 *
	 * @param id the new id.
	 * @see BuildingManager
	 */
	public void setId ( int id ) {
		this.id = id;
	}

	/**
	 * Sets the amount the building should increase in cost upon each purchase.
	 *
	 * @param costCoefficient the new cost coefficient.
	 */
	public void setCostCoefficient ( int costCoefficient ) {
		this.costCoefficient = costCoefficient;
	}

	/**
	 * Sets the initial cost of the building before the player has bought any of this building.
	 *
	 * @param initialCost the new initdial cost.
	 */
	public void setInitialCost ( int initialCost ) {
		this.initialCost = initialCost;
	}

	/**
	 * Gets the total number of buildings the player has bought so far.
	 *
	 * @return the total number of buildings purchased.
	 */
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

		int costOfPurchase = 0;
		for ( int i = 0; i < amount; i++ ) {
			costOfPurchase += this.getCost( this.numberBought + i + 1 );
		}

		this.numberBought += amount;

		this.setChanged();
		this.notifyObservers();
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
		return this.costCoefficient * ( x - 1 ) + this.initialCost;
	}

	/**
	 * @return the cost of buying another of this building.
	 */
	public int getCost () {
		return this.getCost( this.numberBought );
	}

	/**
	 * @return the id of the building that is specific to this building.
	 */
	public int getId () {
		return id;
	}

	/**
	 * @return the beans per second of the building.
	 */
	public double getBeansPerSecond () {
		return beansPerSecond;
	}

	/**
	 * Changes the beans per second of the building.
	 *
	 * @param beansPerSecond
	 */
	public void setBeansPerSecond ( double beansPerSecond ) {
		this.beansPerSecond = beansPerSecond;
		this.setChanged();
	}


	/**
	 * @return the name of this building (not model name)
	 */
	public String getName () {
		return name;
	}

	/**
	 * Gives the building a new name.
	 *
	 * @param name the new name.
	 */
	public void setName ( String name ) {
		this.name = name;
		this.setChanged();
	}

	/**
	 * @return how much the building increases in cost with each new purchase.
	 */
	public int getCostCoefficient () {
		return this.costCoefficient;
	}

	/**
	 * Sets the building's image filename to be used in displaying the building.
	 *
	 * @param filename the new filename.
	 */
	public void setImageFileName ( String filename ) {
		this.imageFileName = filename;
		this.setChanged();
	}
}
