import java.awt.Color;
import sedgewick.StdDraw;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Main {
	private static ArrayList<Integer> pattern = new ArrayList<Integer>();
	public static MainFrame frame = new MainFrame();
	public static JButton[] components = {frame.redB, frame.yellowB, frame.greenB, frame.blueB};

	private enum button {
		Red, Yellow, Green, Blue
	};

	private static button[] curButton = { button.Red, button.Yellow, button.Green, button.Blue };

	public static void main(String[] args) throws InterruptedException {
		boolean done = false;
		while (!done) {
			int choice = JOptionPane.showConfirmDialog(frame, "New Game?");

			if (choice == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(frame, "Hit OK when ready", "Ready?", JOptionPane.QUESTION_MESSAGE);

				// Run game sequence
				TimeUnit.SECONDS.sleep(2);
				run();

			} else if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CANCEL_OPTION) {
				done = true;
				frame.setVisible(false);
				frame.dispose();
			}
		}

	}

	public static void run() {
		boolean wrong = false;
		extendPattern();
		int level = 1;

		while (!wrong) {
			if (level == pattern.size()) {
				extendPattern();
			}
			for (int i = 0; i < level; i++) {
				int x = pattern.get(i);

				switch (curButton[x]) {
				case Red:
					frame.redB.setBackground(frame.redB.getColor());
					frame.redB.playTone();
					frame.redB.setBackground(Color.lightGray);
					break;

				case Green:
					frame.greenB.setBackground(frame.greenB.getColor());
					frame.greenB.playTone();
					frame.greenB.setBackground(Color.lightGray);
					break;

				case Blue:
					frame.blueB.setBackground(frame.blueB.getColor());
					frame.blueB.playTone();
					frame.blueB.setBackground(Color.lightGray);
					break;

				case Yellow:
					frame.yellowB.setBackground(frame.yellowB.getColor());
					frame.yellowB.playTone();
					frame.yellowB.setBackground(Color.lightGray);
					break;
				}

			}
			
			for(int i = 0; i < level; i++) {
				//wait for a press
				//check what was pressed
				//compare to correct choice
				//break or not accordingly 
				
			}

			level++;
		}
		clearPattern();
	}

	private static void extendPattern() {
		for (int i = 0; i < 20; i++) {
			pattern.add((int) (Math.random() * 4));
		}
	}

	private static void clearPattern() {
		pattern.clear();
	}
}