package basic;

import entity.Entity;

public class CollisionCheck 
{
	GamePanel gp;
	public CollisionCheck(GamePanel gp) 
	{
		this.gp = gp;
	}
	
	public void checkCollisionOn(Entity entity)
	{
		int playerLeftX = entity.X+2;
		int playerRightX = entity.X + (gp.TileSize/2)-2;
		int playerTop = entity.Y +2 ;
		int playerBottom = entity.Y + (gp.TileSize/2)-2;
		
		int leftCol = playerLeftX / (gp.TileSize/2);
		int RightCol = playerRightX / (gp.TileSize/2);
		int TopRow = playerTop / (gp.TileSize/2);
		int BottomRow = playerBottom / (gp.TileSize/2);
		
		int num1 = 0, num2 = 0;
		
		switch(entity.direction)
		{
		case "up":
			TopRow = (playerTop - entity.speed) / (gp.TileSize/2);	
		    num1 = gp.tileManager.MapTileNum[TopRow][leftCol];
		    num2 = gp.tileManager.MapTileNum[TopRow][RightCol];
		    
		    if(gp.tileManager.tile[num1].collision == true || gp.tileManager.tile[num2].collision == true) {
		        entity.collision = true;
		    }
		    break;
			
			
		case "down":
		    BottomRow = (playerBottom + entity.speed) / (gp.TileSize/2);
		    num1 = gp.tileManager.MapTileNum[BottomRow][leftCol];
		    num2 = gp.tileManager.MapTileNum[BottomRow][RightCol];
		    
		    if(gp.tileManager.tile[num1].collision == true || gp.tileManager.tile[num2].collision == true) {
		        entity.collision = true;
		    }
		    break;
			
		case "left":
			leftCol = ( playerLeftX - entity.speed)/ (gp.TileSize/2);
			
			num1 = gp.tileManager.MapTileNum[TopRow][leftCol];
			num2 = gp.tileManager.MapTileNum[BottomRow][leftCol];
			
			if(gp.tileManager.tile[num1].collision == true || gp.tileManager.tile[num2].collision == true)
			{
				entity.collision = true;
			}
			break;
			
		case "right":
			RightCol = ( playerRightX + entity.speed)/(gp.TileSize/2);
			
			num1 = gp.tileManager.MapTileNum[TopRow][RightCol];
			num2 = gp.tileManager.MapTileNum[BottomRow][RightCol];
			
			if(gp.tileManager.tile[num1].collision == true || gp.tileManager.tile[num2].collision == true)
			{
				entity.collision = true;
			}
			break;
			
			
		}
		
		System.out.println("num1: " + num1 + " collision: " + gp.tileManager.tile[num1].collision);
        System.out.println("num2: " + num2 + " collision: " + gp.tileManager.tile[num2].collision);
		System.out.println(entity.X);
        boolean won = false;
        
		if(won == false && (entity.X == 1368 && (num1 == 2 || num2 == 2 )))
		{
			won = true;
			gp.gameThread = null;
			new WinningInterFace();
		}
		

	}

}
