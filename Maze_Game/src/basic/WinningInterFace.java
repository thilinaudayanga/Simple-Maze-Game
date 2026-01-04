package basic;

import java.awt.*;
import javax.swing.*;

public class WinningInterFace {

	public WinningInterFace() 
	{
		
			JLabel label = new JLabel("* You Achieved Your Goal !!!", SwingConstants.CENTER);
			label.setFont(new Font("Segoe UI", Font.BOLD, 28));
			label.setForeground(new Color(255, 215, 0));
			label.setBorder(BorderFactory.createEmptyBorder(40, 10, 20, 10));
			
		
			JFrame frame = new JFrame(" You Win!");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(500, 300);
	        frame.setResizable(false);
	        frame.setLayout(new BorderLayout());
	        frame.getContentPane().setBackground(new Color(30, 30, 30)); 
	        frame.setLocationRelativeTo(null);
	        
	        frame.setVisible(true);
	        frame.add(label, BorderLayout.CENTER);
		
		System.out.println("great Winning!!! ");
	}

	
}
