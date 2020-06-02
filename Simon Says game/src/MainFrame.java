import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;


public class MainFrame extends JFrame{

	public MainButton   redB;
	public MainButton   yellowB;
	public MainButton   greenB;
	public MainButton   blueB;
	public MainButton[] buttons = {redB    = new MainButton(Color.red,"1"), 
								   yellowB = new MainButton(new Color(249, 207, 93),"2"), 
								   greenB  = new MainButton(Color.green,"3"), 
								   blueB   = new MainButton(Color.blue,"4")
								  };
	
	public MainFrame() {
		super("Simon Says");
	
		
		for(MainButton i : buttons) {
			add(i);
			i.setBorder(BorderFactory.createLineBorder(i.getColor(),7));
			i.setOpaque(true);
			i.setBackground(Color.lightGray);
			i.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					i.setBackground(i.getColor());
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					i.setBackground(Color.lightGray);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		
		setLayout(new GridLayout(2,2,10,10));
		
		
		setSize(600,600);
		getContentPane().setBackground(Color.gray); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
