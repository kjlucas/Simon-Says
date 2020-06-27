import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class Main {
	private static ArrayList<Integer> pattern = new ArrayList<Integer>();
	private static final MainFrame frame = new MainFrame();
	private static final ArrayList<MainButton> mainButtons = new ArrayList<MainButton>(Arrays.asList(frame.buttons));
	
	private static enum button {
		Red, Yellow, Green, Blue
	};

	private final static button[] curButton = { button.Red, button.Yellow, button.Green, button.Blue };

	private static void run() throws InterruptedException {
		boolean wrong = false;

		extendPattern();
		int level = 1;
		
		while (!wrong) {
			if (level > pattern.size()) {
				extendPattern();
			}
			for (int i = 0; i < level; i++) {
				int x = pattern.get(i);
				MainButton button = mainButtons.get(x);

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
				int ans = pattern.get(i);

				// wait for a press
				while (frame.pressed == null) {
					System.out.print("");
				}
				int chosen = mainButtons.indexOf(frame.pressed);
				MainButton button = mainButtons.get(chosen);

				button.setBackground(button.getColor());
				button.playTone();
				button.setBackground(Color.lightGray);
				frame.pressed = null;

				if (chosen != ans) {
					wrong = true;
					JOptionPane.showMessageDialog(frame, "You lasted " + (level - 1) + " levels", "Game Over",
							JOptionPane.INFORMATION_MESSAGE);
					break;
				}

			}
			TimeUnit.SECONDS.sleep(1);
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

}