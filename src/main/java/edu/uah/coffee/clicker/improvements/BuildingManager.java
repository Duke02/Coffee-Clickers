package edu.uah.coffee.clicker.improvements;

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
