package edu.uah.coffee.clicker;

import edu.uah.coffee.clicker.controller.PlayerController;
import edu.uah.coffee.clicker.graphics.View;
import edu.uah.coffee.clicker.improvements.BuildingManager;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CoffeeClickerMain {
	public static void main ( String[] args ) {

		Player player = new Player();

		BuildingManager buildingManager = new BuildingManager();
		buildingManager.parseJsonFile( "json/buildings.json" );

		View view = new View();
		PlayerController playerController = new PlayerController();
		playerController.addModel( player );

		playerController.addView( view.getPanel( Constants.GAME_PANEL_NAME ) );


		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor( 4 );
		executor.scheduleAtFixedRate( view, 0L, ( long ) ( 1 / 60 * 10 ^ 6 ), TimeUnit.MICROSECONDS );
	}
}
