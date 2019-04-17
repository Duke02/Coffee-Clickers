package edu.uah.coffee.clicker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Serializable;

public class ResourceManager  implements Serializable{

	public static Reader getReader ( String filename ) {
		InputStream is = ResourceManager.class.getResourceAsStream( filename );
		return new InputStreamReader( is );
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

