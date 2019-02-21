package edu.uah.coffee.clicker;

public class Star {
	public Star() {
		x = Math.random() * CoffeeClickerMain.width;
		y = Math.random() * CoffeeClickerMain.height;
		diameter = Math.pow((Math.random() * 3), 1.25) + 1;
	}

	public double x;
	public double y;
	public double diameter;

	public void update() {
		x += 1 - diameter / 1000;
		if (x + diameter / 2 < 0)
			x = CoffeeClickerMain.width + diameter / 2 - 1;
		else if (x - diameter / 2 > CoffeeClickerMain.width)
			x = 1 - diameter / 2;
		if (y + diameter / 2 < 0)
			y = CoffeeClickerMain.height + diameter / 2 - 1;
		else if (y - diameter / 2 > CoffeeClickerMain.height)
			y = 1 - diameter / 2;
	}

}
