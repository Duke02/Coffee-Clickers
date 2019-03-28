package edu.uah.coffee.clicker.improvements;
import java.util.ArrayList;

public class BuildingManager extends AbstractManager
{
    private double CookiesPerSecond;
    private int BuildingID;
    private String BuildingName;
    private ArrayList BuildingInfo = new ArrayList();
    
    public BuildingManager(double CookiesPerSecond, int BuildingID, String BuildingName)
    {
        CookiesPerSecond = CookiesPerSecond;
        BuildingID = BuildingID;
        BuildingName = BuildingName;
        BuildingInfo = (ArrayList) BuildingInfo;
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
    public void setBuildingInfo(int BuildingID, String BuildingName, double CookiesPerSecond, ArrayList BuildingInfo)
    {
        ArrayList  BuildingArray = new ArrayList();

        BuildingArray.add(BuildingID);
        BuildingArray.add(BuildingName);
        BuildingArray.add(CookiesPerSecond);
        
        BuildingInfo = (ArrayList) BuildingArray;
    }
    
    
    
    
}
