package edu.uah.coffee.clicker;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ResourceManager {

	public static Reader getReader ( String filename ) {
		InputStream is = ResourceManager.class.getResourceAsStream( filename );
		return new InputStreamReader( is );
	}
}
