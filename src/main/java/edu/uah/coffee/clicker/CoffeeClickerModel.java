package edu.uah.coffee.clicker;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Observable;

public abstract class CoffeeClickerModel extends Observable implements Serializable{

	protected String modelName;

	public CoffeeClickerModel ( String modelName ) {
		super();
		this.modelName = modelName;
	}

	public String getModelName () {
		return this.modelName;
	}

	public void setModelName ( String name ) {
		this.modelName = name;
	}
        
         public static void serialize(String modelName, String filePath) throws IOException {
            ObjectOutputStream outputStream = null;
            try {
                outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
                outputStream.writeObject(modelName);
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found.");
            try
            {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            }
            catch (IOException E) {
            }
            }
            catch (IOException e)
            {
            try
            {
                if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
                }
            } 
            catch (IOException E) {
            }
            }
            finally
            {
            try
            {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
            }
            } 
            catch (IOException e) {
            }
            }
            }

    public static Player deSerialize(String filePath)
        throws IOException
        {
        try
        {
            FileInputStream fileIn = new FileInputStream(filePath);
            Player p;
        try ( ObjectInputStream in = new ObjectInputStream(fileIn)) {
            p = (Player)in.readObject();
        }
            return p;
        } catch (FileNotFoundException e) {
        } catch (IOException | ClassNotFoundException e) {
        }
            return null;
        }
}
