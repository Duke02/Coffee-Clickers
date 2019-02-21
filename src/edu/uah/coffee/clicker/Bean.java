package edu.uah.coffee.clicker;

public class Bean {
	public Bean() {
		x = Math.random() * CoffeeClickerMain.width * 2 - CoffeeClickerMain.width / 2;
		y = Math.random() * CoffeeClickerMain.height * 2 - CoffeeClickerMain.height / 2;
		diameter = Math.pow((Math.random() * 1.25), 25) + 30;
	}

	public double x;
	public double y;
	public double diameter;
	public double rotation = 0;

	public double vx = 0;
	public double vy = 0;

	public void update() {
		if (CoffeeClickerMain.leftMouseHeld == true) {
			double direction = Math.atan2(CoffeeClickerMain.mouseX - x, CoffeeClickerMain.mouseY - y);

			double distX = Math.abs(CoffeeClickerMain.mouseX - x);
			double distY = Math.abs(CoffeeClickerMain.mouseY - y);
			double distance = Math.sqrt(distX * distX + distY + distY);

			double multX = ((CoffeeClickerMain.width - distance) / CoffeeClickerMain.width) / (diameter / 50);
			double multY = ((CoffeeClickerMain.width - distance) / CoffeeClickerMain.height) / (diameter / 50);

			vx += Math.sin(direction) * multX * CoffeeClickerMain.spt * 15;
			vy += Math.cos(direction) * multY * CoffeeClickerMain.spt * 15;
		}

		vx *= 0.995;
		vy *= 0.995;

		x += vx;
		y += vy;

		rotation += Math.random() / 256;
		rotation += Math.random() * vx / 64;
		rotation += Math.random() * vy / 64;

		if (Math.random() * 100 < CoffeeClickerMain.spt) {
			vx += Math.random() * 20 - 10;
			vy += Math.random() * 20 - 10;
		}

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
