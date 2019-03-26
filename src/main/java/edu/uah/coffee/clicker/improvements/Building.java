package edu.uah.coffee.clicker.improvements;

/**
 * @author trystanmay
 */
public class Building {

public static void main(String[] args){
    
    //Building 1 Information
    BuildingManager.Building1Name();
    String Building1Name = BuildingManager.Building1Name();
    
    BuildingManager.Building1CPS();
    int Building1CPS = BuildingManager.getBuilding1CPS();
    
    BuildingManager.Building1ID();
    int Building1ID = BuildingManager.getBuilding1ID();
    
    //Building 2 Information
    BuildingManager.Building2Name();
    String Building2Name = BuildingManager.getBuilding2Name();
    
    BuildingManager.Building2CPS();
    int Building2CPS = BuildingManager.getBuilding2CPS();
    
    BuildingManager.Building2ID();
    int Building2ID = BuildingManager.getBuilding2ID();
    
    //Building 3 Information
    BuildingManager.Building3Name();
    String Building3Name = BuildingManager.getBuilding3Name();
    
    BuildingManager.Building3CPS();
    int Building3CPS = BuildingManager.getBuilding3CPS();
    
    BuildingManager.Building3ID();
    int Building3ID = BuildingManager.getBuilding3ID();
    
    //Building 4 Information
    BuildingManager.Building4Name();
    String Building4Name = BuildingManager.getBuilding4Name();
    
    BuildingManager.Building4CPS();
    int Building4CPS = BuildingManager.getBuilding4CPS();
    
    BuildingManager.Building4ID();
    int Building4ID = BuildingManager.getBuilding4ID();
    
    //Building 5 Information
    BuildingManager.Building5Name();
    String Building5Name = BuildingManager.getBuilding5Name();
    
    BuildingManager.Building5CPS();
    int Building5CPS = BuildingManager.getBuilding5CPS();
    
    BuildingManager.Building5ID();
    int Building5ID = BuildingManager.getBuilding5ID();
    
    //Building 6 Information
    BuildingManager.Building6Name();
    String Building6Name = BuildingManager.getBuilding6Name();
    
    BuildingManager.Building6CPS();
    int Building6CPS = BuildingManager.getBuilding6CPS();
    
    BuildingManager.Building6ID();
    int Building6ID = BuildingManager.getBuilding6ID();
      
}

	protected int id;
	protected double cookiesPerSecond;
	protected String name;

	public Building ( String name, int id, double cookiesPerSecond ) {
		this.name = name;
		this.id = id;
		this.cookiesPerSecond = cookiesPerSecond;
	}

	public int getId () {
		return id;
	}

	public double getCookiesPerSecond () {
		return cookiesPerSecond;
	}

	public void setCookiesPerSecond ( double cookiesPerSecond ) {
		this.cookiesPerSecond = cookiesPerSecond;
	}

	public void multiplyCookiesPerSecond ( double modifier ) {
		this.cookiesPerSecond *= modifier;
	}

	public void addCookiesPerSecond ( double addition ) {
		this.cookiesPerSecond += addition;
	}

	public String getName () {
		return name;
	}

	public void setName ( String name ) {
		this.name = name;
	}


}
