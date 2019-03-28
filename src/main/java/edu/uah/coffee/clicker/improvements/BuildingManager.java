package edu.uah.coffee.clicker.improvements;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BuildingManager extends AbstractManager
{
    private double CookiesPerSecond;
    private int BuildingID;
    private String BuildingName;
    private ArrayList<String[]> BuildingInfo = new ArrayList<String[]>();
    
    
    public BuildingManager(double CookiesPerSecond, int BuildingID, String BuildingName)
    {
        CookiesPerSecond = CookiesPerSecond;
        BuildingID = BuildingID;
        BuildingName = BuildingName;
        BuildingInfo = (ArrayList<String[]>) BuildingInfo;
    }

    public double getCookiesPerSecond()
    {
        return CookiesPerSecond;
    }
    
    public void setCookiesPerSecond(double CookiesPerSecond)
    {
        CookiesPerSecond = CookiesPerSecond;
    }
    
    public int getBuildingId()
    {
        return BuildingID;
    }
    
    public void setBuildingId(int BuildingId)
    {
        BuildingID = BuildingId;
    }
    
    public String getBuildingName()
    {
        return BuildingName;
    }
    
    public void setBuildingName(String BuildingName)
    {
        BuildingName = BuildingName;
    }
    public void setBuildingInfo(int BuildingID, String BuildingName, double CookiesPerSecond)
    {
        
        
    }
    
    
    
    
}
