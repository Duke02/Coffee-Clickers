package edu.uah.coffee.clicker;

import edu.uah.coffee.clicker.controller.BuildingController;
import edu.uah.coffee.clicker.controller.NewsController;
import edu.uah.coffee.clicker.controller.PlayerController;
import edu.uah.coffee.clicker.graphics.View;
import edu.uah.coffee.clicker.improvements.BuildingManager;
import edu.uah.coffee.clicker.news.NewsManager;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CoffeeClickerMain {
	public static void main ( String[] args ) {

		int numOfCores = 0;
		Player player = new Player();

		// Set up the building manager
		BuildingManager buildingManager = new BuildingManager();
		buildingManager.parseJsonFile( "/json/buildings.json" );
		buildingManager.setPlayer( player );

		// Set up the news manager
		NewsManager newsManager = new NewsManager();
		newsManager.parseNewsDataFile( "/json/news.json" );

		View view = new View();
		numOfCores++;

		// Set up the player controller
		PlayerController playerController = new PlayerController();
		playerController.addModel( player );
		playerController.addModel( buildingManager );
		playerController.addView( view.getPanel( Constants.GAME_PANEL_NAME ) );

		// Set up the news controller
		NewsController newsController = new NewsController();
		newsController.addModel( newsManager );
		newsController.addView( view.getPanel( Constants.NEWS_PANEL_NAME ) );
		numOfCores++;

		BuildingController buildingController = new BuildingController();
		buildingController.addView( view.getPanel( Constants.BUILDING_PANEL_NAME ) );
		buildingController.addModel( buildingManager );
		buildingController.addModel( player );
		numOfCores++;

		view.pack();

		// Schedule the view and news controller to do their job.
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor( numOfCores );
		// There are 0.06 frames per millisecond.
		executor.scheduleAtFixedRate( view, 0L, ( long ) ( 1.0 / 0.06 ), TimeUnit.MICROSECONDS );
		executor.scheduleAtFixedRate( newsController, 0L, 60, TimeUnit.SECONDS );
		executor.scheduleAtFixedRate( buildingController, 0L, 1, TimeUnit.SECONDS );
	}
}
