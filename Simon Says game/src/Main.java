import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

public class Main{
	private ArrayList<Integer> pattern = new ArrayList<Integer>();
	
	

	public static void main(String[] args) {
		
		//SwingUtilities.invokeLater(new Runnable(){

			//@Override
		//	public void run() {
				// TODO Auto-generated method stub
		//		new MainFrame();
				
				
			//}
			
	//	});
		
		MainFrame frame = new MainFrame();
		int choice = JOptionPane.showConfirmDialog(frame, "New Game?");
		
		if(choice == JOptionPane.YES_OPTION) {
			
			JFrame f = new JFrame();
			f.setSize(200,200);
			f.add(new JLabel("Game Starting"));
			f.setVisible(true);
		    final JDialog dialog = new JDialog(f, "Game Starting", true);
		    Timer timer = new Timer(2000, new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            dialog.setVisible(false);
		            dialog.dispose();
		            f.setVisible(false);
		            f.dispose();
		        }
		    });
		    timer.setRepeats(false);
		    timer.start();

		    dialog.setVisible(true); // if modal, application will pause here
		    
			//Run game sequence
		    run();
		    
		} else if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CANCEL_OPTION){
			frame.setVisible(false);
			frame.dispose();
			
			//let the user press button and makes sounds
		}
				
				
				
	}
	private void extendPattern() {
		for(int i = 0; i <= 10; i++) {
			pattern.add((int) (Math.random()*5));
		}
	}
	private void clearPattern() {
		pattern.clear();
	}
}