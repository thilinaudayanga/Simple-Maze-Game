package basic;

import javax.swing.JFrame;

public class Main
{

	public static void main(String[] args)
	{
		//basic GUI
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("New Adventure");
		
		GamePanel gamePanel = new GamePanel();
		
		window.add(gamePanel);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.gameStart();
		
	}

}
