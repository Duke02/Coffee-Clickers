package edu.uah.coffee.clicker.improvements;

/**
 * The interface to be used by anything that improves the beans per second rate of the player.
 */
public interface Improvement {

	/**
	 * Gets the id of the improvement to be used for the managers.
	 *
	 * @return the id of the improvement.
	 * @see AbstractManager
	 */
	int getId ();

	/**
	 * Gets the name of the improvement to be used as a visual, not for storage.
	 *
	 * @return the name of the improvement.
	 */
	String getName ();

	/**
	 * Changes the name of the improvement to be used as a visual, not for storage.
	 *
	 * @param name the new name.
	 */
	void setName ( String name );

}
