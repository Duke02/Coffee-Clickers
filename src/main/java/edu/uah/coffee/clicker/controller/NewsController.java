package edu.uah.coffee.clicker.controller;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.graphics.NewsPanel;
import edu.uah.coffee.clicker.news.NewsManager;

import java.beans.PropertyChangeEvent;
import java.util.Observable;

public class NewsController extends Controller implements Runnable {

	public NewsController () {
		super( Constants.NEWS_CONTROLLER_NAME );
	}

	public void update ( Observable o, Object arg ) {

	}

	public void propertyChange ( PropertyChangeEvent evt ) {

	}

	public void run () {
		NewsManager newsManager = ( NewsManager ) this.models.get( Constants.NEWS_MANAGER_NAME );
		NewsPanel newsPanel = ( NewsPanel ) this.views.get( Constants.NEWS_PANEL_NAME );
		newsPanel.setNews( newsManager.getCurrentNews().getText() );
	}
}
