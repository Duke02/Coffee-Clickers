package edu.uah.coffee.clicker.improvements;
import java.util.ArrayList;
import java.util.List;

public class BuildingManager extends AbstractManager
{
    private double CookiesPerSecond;
    private int BuildingID;
    private ArrayList<String> BuildingName;
    
    public BuildingManager(double CookiesPerSecond, int BuildingID, List BuildingName)
    {
        CookiesPerSecond = CookiesPerSecond;
        BuildingID = BuildingID;
        BuildingName = (ArrayList<String>) BuildingName;
    }

    public double getEmployeeName()
    {
        return CookiesPerSecond;
    }
    public void setEmployeeName(double CookiesPerSecond)
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
    public List<String> getBuildingName()
    {
        return BuildingName;
    }
    public void setBuildingName(List<String> BuildingName)
    {
        BuildingName = (ArrayList<String>) BuildingName;
    }
}
