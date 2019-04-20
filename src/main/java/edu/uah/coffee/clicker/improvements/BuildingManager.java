package edu.uah.coffee.clicker.improvements;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.Player;
import edu.uah.coffee.clicker.ResourceManager;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.*;

public class BuildingManager extends AbstractManager {
	private Map< Integer, Building > buildings;
	protected Player player;

	private static final long serialVersionUID = 999L;

	/**
	 * Creates a new building manager with the given model name from Constants.
	 *
	 * @see Constants#BUILDING_MANAGER_NAME
	 */
	public BuildingManager () {
		super( Constants.BUILDING_MANAGER_NAME );

		this.buildings = new HashMap<>();
	}

	/**
	 * Sets the player to be used when purchasing a building.
	 *
	 * @param player
	 */
	public void setPlayer ( Player player ) {
		this.player = player;
	}

	/**
	 * @param buildingId the desired building's id
	 * @return the requested building if it exists. Throws an exception otherwise.
	 */
	public Building getBuilding ( int buildingId ) {
		return this.buildings.get( buildingId );
	}

	/**
	 * Parses the provided data file to load in the buildings that it contains.
	 *
	 * @param filename the path to the data file to be parsed.
	 */
	public void parseJsonFile ( String filename ) {
		Reader file = ResourceManager.getReader( filename );
		Type buildingListType = new TypeToken< List< Building > >() {
		}.getType();
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter( BuildingManager.class, new BuildingTypeAdapter() );
		Gson gson = gsonBuilder.create();

		List< Building > temporaryBuildings = gson.fromJson( file, buildingListType );
		for ( Building building : temporaryBuildings ) {
			addBuilding( building );
		}

	}

	/**
	 * Buys the desired building the provided number of times.
	 *
	 * @param buildingId the id of the building to be purchased.
	 * @param amount     the amount of the building to be purchased.
	 */
	public boolean buyBuilding ( int buildingId, int amount ) {
		Building buildingToBuy = this.getBuilding( buildingId );
		int wallet = this.player.getCoffeeBeans();
		int numCanBuy = buildingToBuy.numberCanBuy( wallet );
		if ( numCanBuy <= 0 ) {
			return false;
		}
		if ( numCanBuy < amount ) {
			amount = numCanBuy;
		}
		int cost = buildingToBuy.buy( amount );
		this.player.loseBeans( cost );
		this.setChanged();
		this.notifyObservers();
		return true;
	}

	/**
	 * Adds the observer to this object and all internal building objects.
	 *
	 * @param observer the new observer
	 */
	@Override
	public void addObserver ( Observer observer ) {
		super.addObserver( observer );
		for ( Building building : this.buildings.values() ) {
			try {
				building.addObserver( observer );
			} catch ( NullPointerException ex ) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Adds the building into the building manager.
	 *
	 * @param building the building to be added.
	 */
	public void addBuilding ( Building building ) {
		this.buildings.put( building.getId(), building );
	}

	/**
	 * Gets the list of buildings that are stored within the manager.
	 *
	 * @return an ArrayList of the stored buildings.
	 */
	public List< Building > getBuildings () {
		return new ArrayList< Building >( this.buildings.values() );
	}

	/**
	 * @return the total number of beans to be generated every second based on each purchased building.
	 */
	public int getBeansPerSecond () {
		int out = 0;
		for ( Building building : this.getBuildings() ) {
			out += building.getNumberBought() * building.getBeansPerSecond();
		}
		return out;
	}

	/**
	 * Returns the player. To be used when loading from a saved game.
	 *
	 * @return the previously saved player.
	 */
	public Player getPlayer () {
		return this.player;
	}
}
