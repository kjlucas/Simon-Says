import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Main implements Runnable{
	private static ArrayList<Integer> pattern = new ArrayList<Integer>();
	private static final MainFrame frame = new MainFrame();
	private static final MainButton[] mainButtons = { frame.redB, frame.yellowB, frame.greenB, frame.blueB };

	private enum button {
		Red, Yellow, Green, Blue
	};

	private static final button[] curButton = { button.Red, button.Yellow, button.Green, button.Blue };

	public void run() {
		boolean wrong = false;
		extendPattern();
		int level = 1;

		while (!wrong) {
			if (level == pattern.size()) {
				extendPattern();
			}
			for (int i = 0; i < level; i++) {
				int x = pattern.get(i);
				MainButton button = mainButtons[x];

				switch (curButton[x]) {
				case Red:
					button.setBackground(button.getColor());
					button.playTone();
					button.setBackground(Color.lightGray);
					break;

				case Green:
					button.setBackground(button.getColor());
					button.playTone();
					button.setBackground(Color.lightGray);
					break;

				case Blue:
					button.setBackground(button.getColor());
					button.playTone();
					button.setBackground(Color.lightGray);
					break;

				case Yellow:
					button.setBackground(button.getColor());
					button.playTone();
					button.setBackground(Color.lightGray);
					break;
				}

			}

			for (int i = 0; i < level; i++) {
				int x = pattern.get(i);
				// wait for a press
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (!mainButtons[x].isPressed()) {
					wrong = true;
					JOptionPane.showMessageDialog(frame, "You lasted " + (level - 1) + " levels", "Game Over",
							JOptionPane.INFORMATION_MESSAGE);
					break;

				}
				System.out.println("level passed");
				mainButtons[x].setPressed(false);
				frame.setPressed(false);
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

	public static void main(String[] args) throws InterruptedException {
		boolean done = false;
		Thread main = new Thread(new Main());
		while (!done) {
			int choice = JOptionPane.showConfirmDialog(frame, "New Game?");

			if (choice == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(frame, "Hit OK when ready", "Ready?", JOptionPane.QUESTION_MESSAGE);

				// Run game sequence
				TimeUnit.SECONDS.sleep(2);
				main.run();

			} else if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CANCEL_OPTION) {
				done = true;
				frame.setVisible(false);
				frame.dispose();
			}
		}

	}

}