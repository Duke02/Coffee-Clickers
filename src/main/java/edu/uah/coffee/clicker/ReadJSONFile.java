
//how did this class appear in this branch?
//who knows.
//I need to PUSH

/*package main.java.edu.uah.coffee.clicker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.text.ParseException;
import java.util.Iterator;
import org.json.simple.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadJSONFile {

    public static void main(String[] args){
        
        JSONParser parser = new JSONParser();
        
        try
        {
            Object obj = parser.parse(new FileReader("CoffeeJSON.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String name = (String) jsonObject.getString("name");
            System.out.println("Name is: "+ name);
            
            String CPS = (String) jsonObject.getString("CPS");
            System.out.println("CPS is: " + CPS);
            
            //loop array
            JSONArray BuildingsArray = (JSONArray) jsonObject.getJSONArray("Buildings");
            Iterator<Object> iterator = BuildingsArray.iterator();
            
            while(iterator.hasNext())
            {
                System.out.println("Building: " + iterator.next());
            }
        }
        catch(FileNotFoundException e) { e.printStackTrace(); }
        catch(IOException e) { e.printStackTrace(); }
        //catch(ParseException e) { e.printStackTrace(); }
        catch(Exception e) { e.printStackTrace(); }
        
    }
}*/
