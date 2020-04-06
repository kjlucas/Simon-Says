import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;


public class MainFrame extends JFrame{

	public MainButton redB;
	public MainButton yellowB;
	public MainButton greenB;
	public MainButton blueB;
	public MainButton[] buttons = {redB    = new MainButton(Color.red), 
								   yellowB = new MainButton(new Color(249, 207, 93)), 
								   greenB  = new MainButton(Color.green), 
								   blueB   = new MainButton(Color.blue)
								  };
	
	public MainFrame() {
		super("Simon Says");
	
		
		for(MainButton i : buttons) {
			add(i);
			i.setBorder(BorderFactory.createLineBorder(i.getColor(),7));
			i.setOpaque(true);
			i.setBackground(Color.lightGray);
		}
		
		
		setLayout(new GridLayout(2,2,10,10));
		
		
		setSize(600,600);
		getContentPane().setBackground(Color.gray); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
