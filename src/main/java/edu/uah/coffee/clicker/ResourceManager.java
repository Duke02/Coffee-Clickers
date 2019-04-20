package edu.uah.coffee.clicker;

import java.io.*;

public class ResourceManager {

	/**
	 * Gets an InputStreamReader for the desired filename.
	 *
	 * @param filename a filepath in the format of /path/to/file.ext
	 * @return an InputStreamReader at the given path.
	 */
	public static Reader getReader ( String filename ) {
		InputStream is = ResourceManager.class.getResourceAsStream( filename );
		try {
			if ( is.available() > 0 ) {

			}
			return new InputStreamReader( is );
		} catch ( IOException e ) {
			System.out.println( "Cannot find file with filename " + filename + "!" );
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Writes the provided model to a file at the given filepath.
	 *
	 * @param filepath the desired file path.
	 * @param model    the model to be written.
	 */
	public static void writeObjectToFile ( String filepath, CoffeeClickerModel model ) {
		try {

			FileOutputStream fileOut = new FileOutputStream( filepath );
			ObjectOutputStream objectOut = new ObjectOutputStream( fileOut );
			objectOut.writeObject( model );
			objectOut.close();

		} catch ( IOException ex ) {
			System.out.println( "Error accessing file at path " + filepath + "!" );
			ex.printStackTrace();
		}
	}

	/**
	 * Reads a CoffeeClickerModel at the given filepath.
	 *
	 * @param filepath the filepath to load the model from.
	 * @return the model if the file exists or is a model, null otherwise.
	 * @see CoffeeClickerModel
	 */
	public static CoffeeClickerModel readModelFromFile ( String filepath ) {
		try {
			FileInputStream fileIn = new FileInputStream( filepath );
			ObjectInputStream objectIn = new ObjectInputStream( fileIn );

			CoffeeClickerModel model = ( CoffeeClickerModel ) objectIn.readObject();

			objectIn.close();
			return model;

		} catch ( IOException ex ) {
			System.err.println( "Could not find file at path " + filepath + "!" );
			ex.printStackTrace();
			return null;
		} catch ( ClassNotFoundException e ) {
			System.err.println( "File at path " + filepath + " does not contain a model!" );
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * Gets a file at the desired path.
	 *
	 * @param filename A path to the desired file with the format of /path/to/file.ext
	 * @return a File object representing the stored file.
	 */
	public static File getFile ( String filename ) {
		String path = ResourceManager.class.getResource( filename ).getFile();
		return new File( path );
	}
}
