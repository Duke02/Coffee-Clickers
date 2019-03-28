package edu.uah.coffee.clicker.improvements;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BuildingManager extends AbstractManager {
	private double CookiesPerSecond;
	private int BuildingID;
	private ArrayList< String > BuildingName;

	public BuildingManager ( double CookiesPerSecond, int BuildingID, List BuildingName ) {
		CookiesPerSecond = CookiesPerSecond;
		BuildingID = BuildingID;
		BuildingName = ( ArrayList< String > ) BuildingName;
	}

	public double getEmployeeName () {
		return CookiesPerSecond;
	}

	public void setEmployeeName ( double CookiesPerSecond ) {
		CookiesPerSecond = CookiesPerSecond;
	}

	public int getBuildingId () {
		return BuildingID;
	}

	public void setBuildingId ( int BuildingId ) {
		BuildingID = BuildingId;
	}

	public List< String > getBuildingName () {
		return BuildingName;
	}

	public void setBuildingName ( List< String > BuildingName ) {
		BuildingName = ( ArrayList< String > ) BuildingName;
	}

	public void parseJsonFile ( String filename ) {
		try {
			FileReader file = new FileReader( filename );
			Type buildingListType = new TypeToken< List< Building > >() {
			}.getType();
			Gson gson = new Gson();
			this.BuildingName = gson.fromJson( file, buildingListType );
		} catch ( FileNotFoundException e ) {
			System.err.println( "Cannot find Building JSON file with filename " + filename + "!" );
			e.printStackTrace();
		}
	}
}
