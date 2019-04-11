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
