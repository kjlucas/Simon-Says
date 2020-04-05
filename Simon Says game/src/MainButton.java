import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class MainButton extends JButton {
	final private int buttonPitchExp; // The tone the buttons makes
	final private Color buttonCol;

	public MainButton(Color color) {
		// TODO Auto-generated constructor stub
		this.buttonCol=color;
		setBorder(BorderFactory.createLineBorder(color, 7));
		setOpaque(true);

		if (color == Color.red) {
			this.buttonPitchExp = 4; // Db
		} else if (color == Color.blue) {
			this.buttonPitchExp = 6; // Eb
		} else if (color == Color.green) {
			this.buttonPitchExp = 8; //  F
		} else if (color.equals(new Color(249, 207, 93))) {
			this.buttonPitchExp = 11;// Ab
		} else {
			this.buttonPitchExp = 0;
		}

	}


	public int getButtonPitchExp() {
		return buttonPitchExp;
	}
	public double getButtonPitch() {
		return 440 * Math.pow(2, getButtonPitchExp()/12.0);
	}
	public Color getColor() {
		return buttonCol;
	}

	@Override
	public String toString() {
		return "Button [Button Color :\n " + buttonCol.toString() + "\n Button Pitch : " + getButtonPitch() + "]";
	}

}
