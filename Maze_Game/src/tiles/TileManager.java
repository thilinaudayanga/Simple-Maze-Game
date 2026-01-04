package tiles;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import basic.GamePanel;

public class TileManager
{
	
	
	GamePanel gp;
	public Tile[] tile;
	public int MapTileNum[][];
	
	int newMaxRow;
	int newMaxColumn;
	
	public TileManager(GamePanel gp) 
	{
		this.gp = gp;
		tile = new Tile[10];
		
		newMaxRow = gp.maxRow*2;
		newMaxColumn = gp.maxColumn*2;
		
		MapTileNum = new int [newMaxRow][newMaxColumn];
		
		getImage();
		mapLoad();
	}
	
	public void getImage()
	{
		try
		{
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResource("/tiles/wall.png"));
			tile[0].collision = true;
			
			tile[1] = new Tile();
			tile[1].collision = false;
			
			tile[2] = new Tile();
			tile[2].collision = true;

			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	//**************************************************************************************
	public void mapLoad()
	{
		try
		{
			InputStream text01 = getClass().getResourceAsStream("/maps/BasicMap01.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(text01));
			
			for(int i = 0 ; i < newMaxRow ; i++)
			{
				String textLine = br.readLine();
				String[] number = textLine.split(" ");
				
				for(int j = 0; j < newMaxColumn ; j++)
				{
					int num = Integer.parseInt(number[j]);
					MapTileNum[i][j] = num;
				}
			}

			//test text file
			for(int i = 0 ; i < newMaxRow; i++)
			{
				for(int j = 0; j < newMaxColumn ; j++)
				{
					System.out.print(MapTileNum[i][j]);
				}
				System.out.println();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void Draw(Graphics2D g2)
	{
		int tileX = 0;
		int tileY = 0;
		int tileImageNum = 0;
		int newTileSize = gp.TileSize/2;
		
		for(int i = 0 ; i <newMaxRow; i++ )
		{
			tileX = 0;
			for(int j = 0; j < newMaxColumn ; j++)
			{
				tileImageNum = MapTileNum[i][j];
				if(tileImageNum == 1)
				{
					tileX += newTileSize;
					continue;
					
				}
				
				if(tileImageNum == 0)
				{
					g2.drawImage(tile[tileImageNum].image, tileX, tileY, newTileSize, newTileSize, null);
				}
				
				if(tileImageNum == 2)
				{
					g2.setColor(Color.white);
					g2.fillRect(tileX, tileY, gp.TileSize/2, gp.TileSize/2);
				}
				
				tileX += newTileSize;
			}
			tileY += newTileSize;
		}
		
	}

}
