package edu.uah.coffee.clicker.news;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.uah.coffee.clicker.CoffeeClickerModel;
import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.ResourceManager;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsManager extends CoffeeClickerModel {

	protected List< News > news;
	protected int lastIndex;
	protected Random randomEngine;

	/**
	 * Creates a new NewsManager using the manager name in Constants.
	 *
	 * @see Constants#NEWS_MANAGER_NAME
	 */
	public NewsManager () {
		super( Constants.NEWS_MANAGER_NAME );
		this.news = new ArrayList<>();
		this.randomEngine = new Random();
		this.lastIndex = - 1;
	}

	/**
	 * @return a randomly selected news story that is stored within the manager.
	 */
	public News getCurrentNews () {
		if ( this.news.size() == 0 ) {
			return null;
		}
		if ( this.news.size() == 1 ) {
			return this.news.get( 0 );
		}
		int currIndex;
		do {
			currIndex = this.randomEngine.nextInt( this.news.size() );
		} while ( currIndex == lastIndex );
		return this.news.get( currIndex );
	}

	/**
	 * Parses the provided json file for any groundbreaking news stories.
	 *
	 * @param filename the path to the json file to be parsed.
	 */
	public void parseNewsDataFile ( String filename ) {
		Reader file = ResourceManager.getReader( filename );
		Type buildingListType = new TypeToken< List< News > >() {
		}.getType();
		Gson gson = new Gson();
		this.news = gson.fromJson( file, buildingListType );
	}
}
