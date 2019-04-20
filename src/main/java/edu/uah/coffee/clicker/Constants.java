package edu.uah.coffee.clicker;

import edu.uah.coffee.clicker.controller.BuildingController;
import edu.uah.coffee.clicker.controller.NewsController;
import edu.uah.coffee.clicker.controller.PlayerController;
import edu.uah.coffee.clicker.controller.SaveGameController;
import edu.uah.coffee.clicker.graphics.BuildingPanel;
import edu.uah.coffee.clicker.graphics.BuildingsPanel;
import edu.uah.coffee.clicker.graphics.GamePanel;
import edu.uah.coffee.clicker.graphics.NewsPanel;
import edu.uah.coffee.clicker.improvements.BuildingManager;
import edu.uah.coffee.clicker.news.NewsManager;

public class Constants {

	/**
	 * The name of the game panel to be used as a key for Game Panel.
	 *
	 * @see GamePanel
	 */
	public static final String GAME_PANEL_NAME = "game-panel";

	/**
	 * The name of the news panel to be used as a key for NewsPanel.
	 *
	 * @see NewsPanel
	 */
	public static final String NEWS_PANEL_NAME = "news-panel";

	/**
	 * The model name of the player to be used as a key.
	 *
	 * @see Player
	 */
	public static final String PLAYER_MODEL_NAME = "player-model";

	/**
	 * The name of the controller that handles interactions with the player.
	 *
	 * @see PlayerController
	 */
	public static final String PLAYER_CONTROLLER_NAME = "player-controller";

	/**
	 * The name of the controller that handles interactions with the News.
	 *
	 * @see NewsController
	 */
	public static final String NEWS_CONTROLLER_NAME = "news-controller";

	/**
	 * The name of the NewsManager model.
	 *
	 * @see NewsManager
	 */
	public static final String NEWS_MANAGER_NAME = "news-manager";

	/**
	 * The name of the controller that handles interactions with buildings.
	 *
	 * @see BuildingController
	 */
	public static final String BUILDING_CONTROLLER_NAME = "building-controller";

	/**
	 * The model name for the building manager.
	 *
	 * @see BuildingManager
	 */
	public static final String BUILDING_MANAGER_NAME = "building-manager";

	/**
	 * The view name for the BuildingsPanel and to be modified individually for each BuildingPanel.
	 *
	 * @see BuildingsPanel
	 * @see BuildingPanel
	 */
	public static final String BUILDING_PANEL_NAME = "building-panel";

	/**
	 * The controller name to be used by the SaveGameController which saves the game.
	 *
	 * @see SaveGameController
	 */
	public static final String SAVE_GAME_CONTROLLER_NAME = "save-game-controller";
}
