package edu.uah.coffee.clicker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.geom.AffineTransform;

import javax.swing.JComponent;

import doNotTouchMeYall.Temp;

public class Window extends JComponent {
	private static final long serialVersionUID = 2908654408975964223L;
	public int mouseX;
	public int mouseY;

	public int fontSize = 64;

	AffineTransform transform;

	public void paint(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		g.setFont(new Font("TimesNewRoman", Font.PLAIN, fontSize));
		int red = (int) (Math.sin(CoffeeClickerMain.time / 5) * 32 + 32);
		int green = (int) (Math.sin(CoffeeClickerMain.time / 4) * 32 + 32);
		int blue = (int) (Math.sin(CoffeeClickerMain.time / 4) * 32 + 32);

		g.setColor(new Color(red, green, blue));
		g.fillRect(0, 0, CoffeeClickerMain.width, CoffeeClickerMain.height);

		mouseX = MouseInfo.getPointerInfo().getLocation().x - this.getLocationOnScreen().x;
		mouseY = MouseInfo.getPointerInfo().getLocation().y - this.getLocationOnScreen().y;
		CoffeeClickerMain.mouseX = mouseX;
		CoffeeClickerMain.mouseY = mouseY;
		
		Temp.draw(g);

		g.setColor(new Color(255, 255, 255));
		g.setFont(new Font("TimesNewRoman", Font.PLAIN, fontSize));
		
		g.drawString("elapsed time: " + round(CoffeeClickerMain.time, 1), fontSize, fontSize);
		g.drawString("counter: " + CoffeeClickerMain.counter, fontSize, fontSize * 2);
	}

	public Window() {
	}

	public double round(double number, int decimalPlaces) {
		return (double) ((int) Math.round(number * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces));
	}
}