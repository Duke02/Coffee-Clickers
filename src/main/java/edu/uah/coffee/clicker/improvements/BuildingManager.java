package edu.uah.coffee.clicker.improvements;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.Player;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;

public class BuildingManager extends AbstractManager {
	private Map< Integer, Building > buildings;
	protected Player player;

	public BuildingManager () {
		super( Constants.BUILDING_MANAGER_NAME );

		this.buildings = new HashMap< Integer, Building >();
	}

	public void setPlayer ( Player player ) {
		this.player = player;
	}

	public Building getBuilding ( int buildingId ) {
		return this.buildings.get( buildingId );
	}

	public void parseJsonFile ( String filename ) {
		try {
			FileReader file = new FileReader( filename );
			Type buildingListType = new TypeToken< List< Building > >() {
			}.getType();
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter( BuildingManager.class, new BuildingTypeAdapter() );
			Gson gson = gsonBuilder.create();

			List< Building > temporaryBuildings = gson.fromJson( file, buildingListType );
			for ( Building building : temporaryBuildings ) {
				addBuilding( building );
			}

		} catch ( FileNotFoundException e ) {
			System.err.println( "Cannot find Building JSON file with filename " + filename + "!" );
			e.printStackTrace();
		}
	}

	public void buyBuilding ( int buildingId, int amount ) {
		Building buildingToBuy = this.getBuilding( buildingId );
		int wallet = this.player.getCoffeeBeans();
		int numCanBuy = buildingToBuy.numberCanBuy( wallet );
		if ( numCanBuy < amount ) {
			amount = numCanBuy;
		}
		int cost = buildingToBuy.buy( amount );
		this.player.loseBeans( cost );
		this.setChanged();
		this.notifyObservers();
	}

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

	public void addBuilding ( Building building ) {
		this.buildings.put( building.getId(), building );
	}

	public List< Building > getBuildings () {
		return new ArrayList< Building >( this.buildings.values() );
	}

	public int getBeansPerSecond () {
		int out = 0;
		for ( Building building : this.getBuildings() ) {
			out += building.getNumberBought() * building.getBeansPerSecond();
		}
		return out;
	}
}
