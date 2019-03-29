package edu.uah.coffee.clicker;

import edu.uah.coffee.clicker.graphics.View;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CoffeeClickerMain {
	public static void main ( String[] args ) {

		View view = new View();


		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor( 4 );
		executor.scheduleAtFixedRate( view, 0L, ( long ) ( 1 / 60 * 10 ^ 6 ), TimeUnit.MICROSECONDS );
	}
}
