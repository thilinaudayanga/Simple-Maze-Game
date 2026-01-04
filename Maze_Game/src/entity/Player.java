package entity;
import java.awt.*;
import basic.*;

public class Player extends Entity
{

	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp,KeyHandler keyH) 
	{
		this.gp = gp;
		this.keyH = keyH;
		setdefaultValue();
	}
	public void setdefaultValue()
	{
		X = 48;
		Y = 96;
		speed = 3;
		direction = "up";
	}
	
	public void update()
	{
		if(keyH.up == true || keyH.down == true || keyH.left == true || keyH.right == true)
		{
			if(keyH.up == true)
			{
				direction = "up";
			}	
			else if(keyH.down == true)
			{
				direction = "down";
			}
			else if(keyH.left == true)
			{
				direction = "left";
				
			}
			else if(keyH.right == true)
			{
				direction = "right";
			}
			
			collision = false;
			gp.cCheck.checkCollisionOn(this);
			
			if(collision == false)
			{
				if(direction.equals("up"))
				{
					Y -= speed;
				}
				else if(direction.equals("down"))
				{
					Y += speed;
				}
				else if(direction.equals("left"))
				{
					X -= speed;
				}
				else if(direction.equals("right"))
				{
					X += speed;
				}
			}
				
		}	
		
	}
	
	public void Draw(Graphics2D g2)
	{
		g2.setColor(Color.white);
		g2.fillRect(X, Y, gp.TileSize/2, gp.TileSize/2);
		
		/*g2.setColor(Color.yellow);
		g2.fillRect(1345, 650, 48, 48);*/
		g2.dispose();
		
		
	}	
		
		

}
