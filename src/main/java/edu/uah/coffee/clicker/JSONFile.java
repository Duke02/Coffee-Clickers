
package main.java.edu.uah.coffee.clicker;

import java.io.FileWriter;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONFile {
    public static void main(String[] args) {
        //create JSON object and put the value
        JSONObject jsonObject = new JSONObject();
        
       jsonObject.put("name", "Coffee Stand");
        jsonObject.put("CPS", "2");
        
        //create JSON array for buildings and add value
        JSONArray jsonArray = new JSONArray();
        
        jsonArray.put("Coffee Stand");
        jsonArray.put("Bigger Coffee Stand");
        jsonArray.put("Small Hut");
        
        //add JSON array to JSON object
        jsonObject.put("Buildings", jsonArray);
        
        //c
        
        //write all to a file
        
        try { 
            FileWriter fileWriter = new FileWriter("CoffeeJSON.json");
            fileWriter.write(jsonObject.toString());
            fileWriter.flush();
            fileWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
            
}
