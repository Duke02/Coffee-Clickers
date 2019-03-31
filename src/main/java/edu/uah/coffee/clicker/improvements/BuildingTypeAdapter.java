package edu.uah.coffee.clicker.improvements;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * GSON type adapter for parsing the building json file.
 */
public class BuildingTypeAdapter extends TypeAdapter {
	public void write ( JsonWriter out, Object value ) throws IOException {

	}

	public Object read ( JsonReader in ) throws IOException {

		final Building building = new Building();

		in.beginObject();
		while ( in.hasNext() ) {
			String s = in.nextName();
			if ( "name".equals( s ) ) {
				building.setName( in.nextString() );
				building.setModelName( building.getName() );
			} else if ( "cookiesPerSecond".equals( s ) ) {
				building.setCookiesPerSecond( in.nextInt() );
			} else if ( "costCoefficient".equals( s ) ) {
				building.setCostCoefficient( in.nextInt() );
			} else if ( "id".equals( s ) ) {
				building.setId( in.nextInt() );
			} else if ( "initialCost".equals( s ) ) {
				building.setInitialCost( in.nextInt() );
			}
		}
		in.endObject();

		return building;
	}
}
