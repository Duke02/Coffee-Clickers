package edu.uah.coffee.clicker.controller;

import edu.uah.coffee.clicker.CoffeeClickerModel;
import edu.uah.coffee.clicker.improvements.Building;

import java.beans.PropertyChangeEvent;
import java.util.Observable;

public class BuildingController extends Controller {
	public BuildingController () {
		super( "buildingController" );
	}

	@Override
	public void addModel ( CoffeeClickerModel model ) {
		super.addModel( model );
		if ( model instanceof Building ) {
			this.name = ( ( Building ) model )
					            .getName()
					            .replaceAll( " ", "-" ) + "-controller";
		}
	}

	public void update ( Observable o, Object arg ) {

	}

	public void propertyChange ( PropertyChangeEvent evt ) {

	}
}
