package edu.uah.coffee.clicker.controller;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.graphics.NewsPanel;
import edu.uah.coffee.clicker.news.NewsManager;

import java.beans.PropertyChangeEvent;
import java.util.Observable;

public class NewsController extends Controller implements Runnable {

	/**
	 * Creates the NewsController with the given controller name in Constants.
	 *
	 * @see Constants#NEWS_CONTROLLER_NAME
	 */
	public NewsController () {
		super( Constants.NEWS_CONTROLLER_NAME );
	}

	/**
	 * @param o   the model
	 * @param arg the arguments passed.
	 */
	public void update ( Observable o, Object arg ) {

	}

	/**
	 * @param evt
	 */
	public void propertyChange ( PropertyChangeEvent evt ) {

	}

	/**
	 * Updates the news that is to be displayed.
	 */
	public void run () {
		NewsManager newsManager = ( NewsManager ) this.models.get( Constants.NEWS_MANAGER_NAME );
		NewsPanel newsPanel = ( NewsPanel ) this.views.get( Constants.NEWS_PANEL_NAME );
		newsPanel.setNews( newsManager.getCurrentNews().getText() );
	}
}
