package edu.uah.coffee.clicker;

public class DanWord {
	public DanWord() {
		x = Math.random() * CoffeeClickerMain.width;
		y = Math.random() * CoffeeClickerMain.height;
	}

	public double x;
	public double y;
	public boolean visible = false;

	public String word;

	{
		double rand = Math.random() * 100;
		if (rand < 50)
			word = "DAN";
		else if (rand < 75)
			word = "Thanks Dan!";
		else if (rand < 87)
			word = "Dan's a cool guy!";
		else if (rand < 93)
			word = "PLAN MAN DAN";
		else if (rand < 96)
			word = "I love you Dan!";
		else if (rand < 98)
			word = "D	A	N";
		else
			word = "Dr. Dan";
	}

	public void update() {
		if (Math.random() * 20 < CoffeeClickerMain.spt) {
			x = Math.random() * CoffeeClickerMain.width;
			y = Math.random() * CoffeeClickerMain.height;
			visible = true;
		}
	}
}
