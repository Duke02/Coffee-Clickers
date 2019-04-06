package edu.uah.coffee.clicker.graphics;

import edu.uah.coffee.clicker.Constants;
import edu.uah.coffee.clicker.controller.BuildingController;
import edu.uah.coffee.clicker.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Panel for displaying individual buildings.
 */
public class BuildingPanel extends CoffeeClickerPanel {
	private CoffeeClickerLabel numberBought;
	private CoffeeClickerLabel buildingName;
	private CoffeeClickerLabel cost;
	private CoffeeClickerLabel beansPerSecond;
	private CoffeeClickerLabel buildingImage;
	private CoffeeClickerButton buyButton;
	private int buildingId;

	public BuildingPanel () {
		super( Constants.BUILDING_PANEL_NAME );

		this.setRelativeSize( 0.1, 0.1 );
		setLayout( new GridLayout( 3, 2 ) );


		buildingImage = new CoffeeClickerLabel();
		buildingImage.setVisible( true );
		this.add( buildingImage );

		buildingName = new CoffeeClickerLabel();
		buildingName.setVisible( true );
		this.add( buildingName );

		numberBought = new CoffeeClickerLabel();
		numberBought.setText( "Owned: 0" );
		numberBought.setVisible( true );
		this.add( numberBought );

		beansPerSecond = new CoffeeClickerLabel();
		beansPerSecond.setText( "Beans/sec: 0" );
		beansPerSecond.setVisible( true );
		this.add( beansPerSecond );

		cost = new CoffeeClickerLabel();
		cost.setText( "Cost: 0" );
		cost.setVisible( true );
		this.add( cost );

		buyButton = new CoffeeClickerButton();
		buyButton.setName( "buyBuilding" );
		buyButton.setText( "Buy!" );
		buyButton.setVisible( true );
		this.buyButton.setActionCommand( "buy" );
		this.add( buyButton );

		// Set up initial building id.
		this.buildingId = - 1;
	}

	public void setBuildingName ( String name ) {
		this.name = Constants.BUILDING_PANEL_NAME + name;
		this.buildingName.setText( name );
	}

	public void setNumberBought ( int numBought ) {
		this.numberBought.setText( String.format( "Owned: %d", numBought ) );
	}

	public void setCost ( int cost ) {
		this.cost.setText( String.format( "Cost: %d", cost ) );
	}

	public int getBuildingId () {
		return this.buildingId;
	}

	public void setBuildingId ( int id ) {
		if ( this.buildingId == - 1 ) {
			// Ignore any changes to building id.
			this.buildingId = id;
		}
	}

	public void setBuildingImage ( String filename ) {
		this.buildingImage.setIcon( new ImageIcon( filename ) );
	}

	public void setBPS ( int bps ) {
		this.beansPerSecond.setText( String.format( "Beans/sec: %d", bps ) );
	}

	@Override
	public void addController ( Controller controller ) {
		super.addController( controller );
		if ( controller instanceof BuildingController ) {
			this.buyButton.addActionListener( ( ActionListener ) controller );
		}
	}

	@Override
	public void setRelativeSize ( double x, double y ) {
		if ( this.getParent() == null ) {
			super.setRelativeSize( x, y );
		} else {
			Dimension parentSize = this.getParent().getSize();
			this.relativeSize = new Dimension( ( int ) ( parentSize.width * x ), ( int ) ( parentSize.height * y ) );
			this.setSize( this.relativeSize );
		}
	}
}
