package edu.uah.coffee.clicker;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Input {

	public static void click() {
		// ++player.counter;//no player yet bucko!
	}

	public Input(Frame frame) {
		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					click();
					CoffeeClickerMain.leftMouseHeld = true;
				}
				if (e.getButton() == MouseEvent.BUTTON3) {
					CoffeeClickerMain.rightMouseHeld = true;
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					CoffeeClickerMain.leftMouseHeld = false;
				}
				if (e.getButton() == MouseEvent.BUTTON3) {
					CoffeeClickerMain.rightMouseHeld = false;
				}
			}
		});
		frame.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				// zoom(e.getWheelRotation());
			}
		});
	}
}
