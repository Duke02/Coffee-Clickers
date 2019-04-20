package edu.uah.coffee.clicker.controller;

import edu.uah.coffee.clicker.CoffeeClickerModel;
import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.ResourceManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.Observable;

public class SaveGameController extends Controller implements ActionListener {

	private final String saveFilePath = Constants.SAVE_GAME_FILE_PATH;

	public SaveGameController () {
		super( Constants.SAVE_GAME_CONTROLLER_NAME );
	}

	@Override
	public void update ( Observable o, Object arg ) {
		if ( ! ( o instanceof CoffeeClickerModel ) ) {
			return;
		}


	}

	@Override
	public void propertyChange ( PropertyChangeEvent evt ) {

	}

	private void saveGame ( String filepath ) {
		for ( CoffeeClickerModel model : this.models.values() ) {
			ResourceManager.writeObjectToFile( filepath, model );
		}
	}

	@Override
	public void actionPerformed ( ActionEvent e ) {
		if ( e.getActionCommand().equals( "saveGame" ) ) {
			saveGame( saveFilePath );
		}
	}
}
