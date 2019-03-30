package edu.uah.coffee.clicker.improvements;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.Player;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			Gson gson = new Gson();
			List< Building > temporaryBuildings = gson.fromJson( file, buildingListType );
			for ( Building building : temporaryBuildings ) {
				this.buildings.put( building.getId(), building );
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
}
