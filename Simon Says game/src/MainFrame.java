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
		super("WIP");
		
		
		add(redB);
		add(yellowB);
		add(greenB);
		add(blueB);
		
		setLayout(new GridLayout(2,2,10,10));
		
		redB.setBorder(BorderFactory.createLineBorder(redB.getColor(),7));
		yellowB.setOpaque(true);
		redB.setBackground(Color.lightGray);
		
		greenB.setBorder(BorderFactory.createLineBorder(greenB.getColor(),7));
		greenB.setOpaque(true);
		greenB.setBackground(Color.lightGray);
		
		blueB.setBorder(BorderFactory.createLineBorder(blueB.getColor(),7));
		blueB.setOpaque(true);
		blueB.setBackground(Color.lightGray);
		
		yellowB.setBorder(BorderFactory.createLineBorder(yellowB.getColor(),7));
		yellowB.setOpaque(true);
		yellowB.setBackground(Color.lightGray);
		
		
		
		
		setSize(600,600);
		getContentPane().setBackground(Color.gray); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
