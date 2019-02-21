package edu.uah.coffee.clicker;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class CoffeeClickerMain extends JFrame {
	public static void main(String[] arguments) {
		// System.out.println("Hello World!");
		for (int i = 0; i < 200; ++i) {
			beans.add(new Bean());
		}
		for (int i = 0; i < 20; ++i) {
			danWords.add(new DanWord());
		}
		for (int i = 0; i < 500; ++i) {
			stars.add(new Star());
		}
		new CoffeeClickerMain();
	}

	// screen
	public static Toolkit toolkit = Toolkit.getDefaultToolkit();
	public final static int screenWidth = toolkit.getScreenSize().width;
	public final static int screenHeight = toolkit.getScreenSize().height;
	public static int width = 1500;
	public static int height = 1000;

	public static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(4);

	// input
	public static int mouseX;
	public static int mouseY;
	public static boolean leftMouseHeld = false;
	public static boolean rightMouseHeld = false;
	public static boolean[] keys = new boolean[525];// supposed to be 255 but getting outofbounds error fairly
													// consistantly after adding music
	public static boolean[] keysTyped = new boolean[525];

	// frames
	public static int microSecondsPerFrame = 16666;
	public static double spt = (double) microSecondsPerFrame / 1000000;// seconds per tick

	public static double time = 0;

	public static ArrayList<Bean> beans = new ArrayList<Bean>();
	public static ArrayList<DanWord> danWords = new ArrayList<DanWord>();
	public static ArrayList<Star> stars = new ArrayList<Star>();

	public static int counter = 0;

	public static void click() {
		++counter;
	}

	public static void close() {
		System.exit(0);
	}

	public CoffeeClickerMain() {
		JFrame frame = new JFrame();
		frame.setSize(width, height);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("C O F F E E");

		Window window = new Window();
		frame.add(window, BorderLayout.CENTER);
		frame.setVisible(true);

		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					click();
					leftMouseHeld = true;
				}
				if (e.getButton() == MouseEvent.BUTTON3) {
					rightMouseHeld = true;
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					leftMouseHeld = false;
				}
				if (e.getButton() == MouseEvent.BUTTON3) {
					rightMouseHeld = false;
				}
			}
		});
		frame.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				// zoom(e.getWheelRotation());
			}
		});
		frame.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				frame.setFocusTraversalKeysEnabled(false);
				keys[e.getKeyCode()] = true;
			}

			public void keyReleased(KeyEvent e) {
				frame.setFocusTraversalKeysEnabled(false);
				keys[e.getKeyCode()] = false;
			}
		});

		executor.scheduleAtFixedRate(new Draw(frame), 0L, (long) microSecondsPerFrame, TimeUnit.MICROSECONDS);
	}
}