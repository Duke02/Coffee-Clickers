package edu.uah.coffee.clicker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Window extends JComponent {
	private static final long serialVersionUID = 2908654408975964223L;
	public int mouseX;
	public int mouseY;

	public int fontSize = 64;

	ArrayList<Bean> beans = CoffeeClickerMain.beans;
	ArrayList<DanWord> danWords = CoffeeClickerMain.danWords;
	ArrayList<Star> stars = CoffeeClickerMain.stars;

	public BufferedImage dan;

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

		g.setColor(new Color(255 - red, 255 - green, 255 - blue));
		for (int i = stars.size() - 1; i > -1; --i) {
			stars.get(i).update();
			g.fillOval((int) (stars.get(i).x), (int) (stars.get(i).y), (int) stars.get(i).diameter,
					(int) stars.get(i).diameter);
		}

		g.setColor(new Color(255 - red, 255 - green, 255 - blue));
		for (int i = danWords.size() - 1; i > -1; --i) {
			danWords.get(i).update();
			if (danWords.get(i).visible == true) {
				g.drawString(danWords.get(i).word, (int) (danWords.get(i).x + Math.random() * 10 - 5),
						(int) (danWords.get(i).y + Math.random() * 10 - 5));
			}
		}

		transform = graphics.getTransform();
		for (int i = beans.size() - 1; i > -1; --i) {
			beans.get(i).update();

			int x = (int) beans.get(i).x;
			int y = (int) beans.get(i).y;
			int radius = (int) beans.get(i).diameter;

			graphics.rotate(beans.get(i).rotation, x, y);
			g.drawImage(dan, x - radius / 2, y - radius / 2, radius, radius, null);
			graphics.setTransform(transform);
		}

		g.setFont(new Font("TimesNewRoman", Font.PLAIN, fontSize));

		g.drawString("elapsed time: " + round(CoffeeClickerMain.time, 1), fontSize, fontSize);
		g.drawString("counter: " + CoffeeClickerMain.counter, fontSize, fontSize * 2);
	}

	public Window() {
		File file = new File("res/dan.png");
		try {
			dan = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public double round(double number, int decimalPlaces) {
		return (double) ((int) Math.round(number * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces));
	}
}