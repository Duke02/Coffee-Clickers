package edu.uah.coffee.clicker;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;

public class ResourceManager  implements Serializable{

	public static Reader getReader ( String filename ) {
		InputStream is = ResourceManager.class.getResourceAsStream( filename );
		return new InputStreamReader( is );
	}

    void WriteObjectToFile(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
