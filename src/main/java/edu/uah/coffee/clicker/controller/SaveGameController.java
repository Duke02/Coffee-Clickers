package edu.uah.coffee.clicker.controller;

import edu.uah.coffee.clicker.CoffeeClickerModel;
import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.ResourceManager;

import java.beans.PropertyChangeEvent;
import java.util.Observable;

public class SaveGameController extends Controller {

	public SaveGameController () {
		super( Constants.SAVE_GAME_CONTROLLER_NAME );
	}

	@Override
	public void update ( Observable o, Object arg ) {

	}

	@Override
	public void propertyChange ( PropertyChangeEvent evt ) {

	}

	private void saveGame ( String filepath ) {
		for ( CoffeeClickerModel model : this.models.values() ) {
			ResourceManager.writeObjectToFile( model, filepath );
		}
	}
}
