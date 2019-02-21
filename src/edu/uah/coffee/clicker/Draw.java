package edu.uah.coffee.clicker;

import javax.swing.JFrame;

class Draw implements Runnable {
	JFrame frame;

	public void run() {
		CoffeeClickerMain.time += CoffeeClickerMain.spt;
		frame.repaint();
	}

	public Draw(JFrame frame) {
		this.frame = frame;
	}
}
