package edu.uah.coffee.clicker.improvements;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BuildingManager extends AbstractManager {
	private List< Building > buildings;

	public BuildingManager () {
		this.buildings = new ArrayList< Building >();
	}

	public Building getBuilding ( int buildingId ) {
		for ( Building building : this.buildings ) {
			if ( building.getId() == buildingId ) {
				return building;
			}
		}
		return null;
	}

}
