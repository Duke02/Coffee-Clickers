package doNotTouchMeYall;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import edu.uah.coffee.clicker.CoffeeClickerMain;

public class Temp {

	private static ArrayList<Bean> beans = CoffeeClickerMain.beans;
	private static ArrayList<DanWord> danWords = CoffeeClickerMain.danWords;
	private static ArrayList<Star> stars = CoffeeClickerMain.stars;

	private static BufferedImage dan;

	private static AffineTransform transform;

	static {
		for (int i = 0; i < 200; ++i) {
			beans.add(new Bean());
		}
		for (int i = 0; i < 20; ++i) {
			danWords.add(new DanWord());
		}
		for (int i = 0; i < 500; ++i) {
			stars.add(new Star());
		}

		File file = new File("res/dan.png");
		try {
			dan = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void draw(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		g.setColor(new Color(255, 255, 255));
		for (int i = stars.size() - 1; i > -1; --i) {
			stars.get(i).update();
			g.fillOval((int) (stars.get(i).x), (int) (stars.get(i).y), (int) stars.get(i).diameter,
					(int) stars.get(i).diameter);
		}

		g.setColor(new Color(255, 255, 255));
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
	}
}
