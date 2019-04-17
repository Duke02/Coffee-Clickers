
package edu.uah.coffee.clicker;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveModel {
    private static final String filepath="C:\\CoffeeClckekr\\Saves";
 
    public static void main(String args[]) {
 
        ResourceManager objectIO = new ResourceManager();
 
        Player player = new Player();
        objectIO.WriteObjectToFile(player);
    }
 
    public void WriteObjectToFile(Object serObj) {
 
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
