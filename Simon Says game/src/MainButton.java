import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton; 

public class MainButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final private int buttonPitchDist; // The tone the buttons makes (chromatic distance from A above middle C)
	final private Color buttonCol;
	//private boolean isPressed = false;

	public MainButton(Color color) {
		// TODO Auto-generated constructor stub
		this.buttonCol=color;
		setBorder(BorderFactory.createLineBorder(color, 7));
		setOpaque(true);

		if (color == Color.red) {
			this.buttonPitchDist = -11; // Db
		} else if (color == Color.blue) {
			this.buttonPitchDist = -9; // Eb
		} else if (color == Color.green) {
			this.buttonPitchDist = -7; //  F
		} else if (color.equals(new Color(249, 207, 93))) {
			this.buttonPitchDist = -4;// Ab
		} else {
			this.buttonPitchDist = 0;
		}
	}

	public int getPitchDist() {
		return buttonPitchDist;
	}
	public void playTone() {
		double hz = 440.0 * Math.pow(2.0, getPitchDist()/12.0);
		double seconds = 1;
		int SAMPLE_RATE = 44100;
		int N = (int) (seconds * SAMPLE_RATE);
		double[] d = new double [N];
		
		for(int i = 0; i<N; i++) {
			d[i] = Math.sin((2*Math.PI*i*hz)/SAMPLE_RATE);
		}
		StdAudio.play(d);
		return;
	}
//	public void setPressed(boolean b) {
//		this.isPressed = b;
//	}
//	public boolean isPressed() {
//		return this.isPressed;
//	}
	public Color getColor() {
		return buttonCol;
	}

	@Override
	public String toString() {
		return "Button [Button Color : " + buttonCol.toString() + "\n Button Pitch : " + getPitchDist() + "]";
	}

}
