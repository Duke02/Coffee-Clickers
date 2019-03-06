
package main.java.edu.uah.coffee.clicker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Brandenburg
 */
public class ReadJSONFile {

    public static void main(String[] args){
        
        JSONParser parser = new JSONParser();
        
        try
        {
            Object obj = parser.parse(new FileReader("Coffee_json.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String name = (String) jsonObject.getString("name");
            System.out.println("Name is: "+ name);
            
            String location = (String) jsonObject.getString("location");
            System.out.println("Loaction is: " + location);
            
            //loop array
            JSONArray BuildingsArray = (JSONArray) jsonObject.getJSONArray("Buildings");
            Iterator<String> iterator = BuildingsArray.iterator();
            
            while(iterator.hasNext())
            {
                System.out.println("Building: " + iterator.next());
            }
        }
        catch(FileNotFoundException e) { e.printStackTrace(); }
        catch(IOException e) { e.printStackTrace(); }
        catch(ParseException e) { e.printStackTrace(); }
        catch(Exception e) { e.printStackTrace(); }
        
    }
}
