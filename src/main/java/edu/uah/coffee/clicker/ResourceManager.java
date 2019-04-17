package edu.uah.coffee.clicker;

import java.io.*;

public class ResourceManager implements Serializable {

	public static Reader getReader ( String filename ) {
		InputStream is = ResourceManager.class.getResourceAsStream( filename );
		return new InputStreamReader( is );
	}

	public static void writeObjectToFile ( String filepath, CoffeeClickerModel model ) {

		try {

			FileOutputStream fileOut = new FileOutputStream( filepath );
			ObjectOutputStream objectOut = new ObjectOutputStream( fileOut );
			objectOut.writeObject( model );
			objectOut.close();

		} catch ( Exception ex ) {
			ex.printStackTrace();
		}
	}

	public Object readObjectFromFile ( String filepath ) {

		try {

			FileInputStream fileIn = new FileInputStream( filepath );
			ObjectInputStream objectIn = new ObjectInputStream( fileIn );

			Object obj = objectIn.readObject();

			objectIn.close();
			return obj;

		} catch ( Exception ex ) {
			ex.printStackTrace();
			return null;
		}
	}
}

