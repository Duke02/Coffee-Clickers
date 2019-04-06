package edu.uah.coffee.clicker;

import java.io.*;

public class ResourceManager {

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

	public static File getFile ( String filename ) {
		String path = ResourceManager.class.getResource( filename ).getFile();
		return new File( path );

	}
}
