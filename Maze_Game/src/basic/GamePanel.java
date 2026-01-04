package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import entity.*;
import tiles.TileManager;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable
{
	//screen setting
	
	final int originalTileSize = 16;
	final int scale = 3;
	
	public final int TileSize = originalTileSize * scale;
	
	public final int maxColumn = 30; 
	public final int maxRow = 15;
	
	final int screenWidth = maxColumn * TileSize;
	final int screenHeight = maxRow * TileSize;
	
	//Thread variable
	Thread gameThread;
	
	
	//key handler OBJ
	 KeyHandler keyH = new KeyHandler();
	 
	 //player OBJ
	 Player player = new Player(this,keyH);
	
	 public CollisionCheck cCheck = new CollisionCheck(this);
	 
	 //map OBJ
	 TileManager tileManager = new TileManager(this);
	 
	 //create FPS
	 int FPS = 60;
	 
	public GamePanel() 
	{
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		
		//add keyH
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void gameStart()
	{
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void run()
	{
		//FPS time cal
		
		double drawInterval = 1000000000/FPS;
		
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(gameThread != null)
		{
			//System.out.println("Running");
			
			player.update();
			
			repaint();
			try
			{
				double remainTime = nextDrawTime - System.nanoTime();
				remainTime = remainTime/1000000;
				
				if(remainTime < 0)
					remainTime = 0;
				
				Thread.sleep((long)remainTime);
				
				
				nextDrawTime += drawInterval;
			}
			catch(Exception e)
			{
				
			}
			
			
		}
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		tileManager.Draw(g2);
		
		player.Draw(g2);
	}

}
