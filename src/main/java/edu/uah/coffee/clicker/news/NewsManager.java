package edu.uah.coffee.clicker.news;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.uah.coffee.clicker.CoffeeClickerModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsManager extends CoffeeClickerModel {

	protected List< News > news;
	protected int lastIndex;
	protected Random randomEngine;

	public NewsManager () {
		super( "newsManager" );
		this.news = new ArrayList< News >();
		this.randomEngine = new Random();
		this.lastIndex = - 1;
	}

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

	public void parseNewsDataFile ( String filename ) {
		try {
			FileReader file = new FileReader( filename );
			Type buildingListType = new TypeToken< List< News > >() {
			}.getType();
			Gson gson = new Gson();
			this.news = gson.fromJson( file, buildingListType );
		} catch ( FileNotFoundException e ) {
			System.err.println( "Cannot find News JSON file with filename " + filename + "!" );
			e.printStackTrace();
		}
	}
}
