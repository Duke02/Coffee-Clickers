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

	}

	@Override
	public void propertyChange ( PropertyChangeEvent evt ) {

	}

	/**
	 * Saves the game at the provided file path.
	 *
	 * @param filepath the file path to save the game to.
	 */
	private void saveGame ( String filepath ) {
		for ( CoffeeClickerModel model : this.models.values() ) {
			ResourceManager.writeObjectToFile( filepath, model );
		}
	}

	/**
	 * Used to save the game whenever the saveButton from GamePanel is clicked.
	 *
	 * @param e
	 */
	@Override
	public void actionPerformed ( ActionEvent e ) {
		if ( e.getActionCommand().equals( "saveGame" ) ) {
			saveGame( saveFilePath );
		}
	}
}
