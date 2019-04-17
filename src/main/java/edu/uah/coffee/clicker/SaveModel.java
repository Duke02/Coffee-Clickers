
package edu.uah.coffee.clicker;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveModel {
 
    public static void Save(String args[]) {
 
        ResourceManager objectIO = new ResourceManager();
 
        Player player = new Player();
        objectIO.WriteObjectToFile(player);
    }
 
    public void WriteObjectToFile(Object serObj, String filepath) {
 
        try {
            
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
