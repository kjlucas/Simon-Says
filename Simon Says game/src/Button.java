import java.awt.Color;

public class Button {
	final private Color buttonCol; //The color of a game button
	final private int buttonPitch; //The tone the buttons makes
	public Button(Color color) {
		// TODO Auto-generated constructor stub
		this.buttonCol = color;
		if(color == Color.RED) {
			
			this.buttonPitch = 4; //Db
		} else if(color == Color.BLUE){
			this.buttonPitch = 6; //Eb
		} else if(color == Color.GREEN) {
			this.buttonPitch = 8; //F
		}else if(color == Color.YELLOW) {
			this.buttonPitch = 11; //Ab
		} else {
			this.buttonPitch = 0;
		}
		
	}
	public Color getButtonCol() {
		return buttonCol;
	}
	public int getButtonPitch() {
		return buttonPitch;
	}
	@Override
	public String toString() {
		return "Button [Button Color = " + buttonCol + ", Button Pitch = " + buttonPitch + "]";
	}
	
}
