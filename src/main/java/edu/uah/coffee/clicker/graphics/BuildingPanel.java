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
	private JLabel numberBought;
	private JLabel buildingName;
	private JLabel cost;
	private JButton buyButton;
	private int buildingId;

	public BuildingPanel () {
		super( Constants.BUILDING_PANEL_NAME );

		setLayout( new GridLayout( 2, 2 ) );
		setMaximumSize( new Dimension( 300, 100 ) );


		buildingName = new JLabel();
		buildingName.setVisible( true );
		this.add( buildingName );

		numberBought = new JLabel();
		numberBought.setText( "Owned: 0" );
//		numberBought.setHorizontalAlignment( JLabel.RIGHT );
		numberBought.setVisible( true );
		this.add( numberBought );

		cost = new JLabel();
		cost.setText( "Cost: 0" );
		cost.setVisible( true );
		this.add( cost );

		buyButton = new JButton();
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

	@Override
	public void addController ( Controller controller ) {
		super.addController( controller );
		if ( controller instanceof BuildingController ) {
			this.buyButton.addActionListener( ( ActionListener ) controller );
		}
	}
}
