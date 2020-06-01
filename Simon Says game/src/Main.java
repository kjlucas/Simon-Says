import javax.swing.*;

public class Main{
	
	

	public static void main(String[] args) {
		
		//SwingUtilities.invokeLater(new Runnable(){

			//@Override
		//	public void run() {
				// TODO Auto-generated method stub
		//		new MainFrame();
				
				
			//}
			
	//	});
		
		MainFrame frame = new MainFrame();
		if(JOptionPane.showConfirmDialog(frame, "New Game?") == JOptionPane.YES_OPTION) {
			//Run game sequence
		} else {
			//let the user press button and makes sounds
		}
				
				
				
	}
}