package edu.uah.coffee.clicker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Serializable;

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
	public void WriteObjectToFile(String filepath,CoffeeClickerModel model) {

		try {

			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(model);
			objectOut.close();

		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Object ReadObjectFromFile(String filepath) {

		try {

			FileInputStream fileIn = new FileInputStream(filepath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);

			Object obj = objectIn.readObject();

			objectIn.close();
			return obj;

		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
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
