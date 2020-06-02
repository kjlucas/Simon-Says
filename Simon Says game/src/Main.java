import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			//maybe have an intermediate dialog popup here saying "Game Starting"
			JFrame f = new JFrame();
			f.setSize(100,100);
			f.add(new JLabel("Game Starting"));
		    final JDialog dialog = new JDialog(f, "Game Starting", true);
		    Timer timer = new Timer(2000, new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            dialog.setVisible(false);
		            dialog.dispose();
		        }
		    });
		    timer.setRepeats(false);
		    timer.start();

		    dialog.setVisible(true); // if modal, application will pause here

		    System.out.println("Dialog closed");
			//Run game sequence
		} else {
			//Message popup saying "Entering free mode"
			JFrame f = new JFrame();
			f.setSize(100,100);
			f.add(new JLabel("Entering Freemode"));
		    final JDialog dialog = new JDialog(f, "Entering Freemode", true);
		    Timer timer = new Timer(2000, new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            dialog.setVisible(false);
		            dialog.dispose();
		        }
		    });
		    timer.setRepeats(false);
		    timer.start();

		    dialog.setVisible(true); // if modal, application will pause here

		    System.out.println("Dialog closed");
			//let the user press button and makes sounds
		}
				
				
				
	}
}