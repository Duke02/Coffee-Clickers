package edu.uah.coffee.clicker;

import edu.uah.coffee.clicker.controller.NewsController;
import edu.uah.coffee.clicker.controller.PlayerController;
import edu.uah.coffee.clicker.graphics.View;
import edu.uah.coffee.clicker.improvements.BuildingManager;
import edu.uah.coffee.clicker.news.NewsManager;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CoffeeClickerMain {
	public static void main ( String[] args ) {

		Player player = new Player();

		// Set up the building manager
		BuildingManager buildingManager = new BuildingManager();
		buildingManager.parseJsonFile( "json/buildings.json" );

		// Set up the news manager
		NewsManager newsManager = new NewsManager();
		newsManager.parseNewsDataFile( "json/news.json" );

		View view = new View();

		// Set up the player controller
		PlayerController playerController = new PlayerController();
		playerController.addModel( player );
		playerController.addView( view.getPanel( Constants.GAME_PANEL_NAME ) );

		// Set up the news controller
		NewsController newsController = new NewsController();
		newsController.addModel( newsManager );
		newsController.addView( view.getPanel( Constants.NEWS_PANEL_NAME ) );

		// Schedule the view and news controller to do their job.
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor( 4 );
		executor.scheduleAtFixedRate( view, 0L, ( long ) ( 1 / 60 * 10 ^ 6 ), TimeUnit.MICROSECONDS );
		executor.scheduleAtFixedRate( newsController, 0L, 60, TimeUnit.SECONDS );
	}
}
