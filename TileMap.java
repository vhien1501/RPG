import java.io.*;
import java.awt.*;

public class TileMap{

	private int x;
	private int y;

	private static final int TILE_SIZE = 32;

	private int[][] map;
	private int width;
	private int height;

	private Sprite sprite;
	private BufferedImage tile;

	public TileMap(String s){

		sprite.LoadSprite("")

		try{

			BufferedReader reader = new BufferedReader(new FileReader(s));

			width	= Integer.parseInt(reader.readLine());
			height	= Integer.parseInt(reader.readLine());
			map = new int[height][width];

			String space =" ";

			for(int row = 0; row < height; row++){
				String line  = reader.readLine();
				String[] num = line.split(space);
				for(int col = 0; col < width; col++){
					map[row][col] = Integer.parseInt(num[col]);
				}
			}
		}
		catch(Exception e){}
	}

	public void Draw(Graphics2D g2d){
		for(int row = 0; row < height; row++){
			for(int col =0; col < width; col++){
				int num = map[row][col];

				if(num ==  1){
					Sprite.LoadSprite("grass");
					tile = Sprite.GetSprite(0,0);
				}

				g2d.drawImage(tile, x + col*TILE_SIZE, y + row*TILE_SIZE, null);
			}
		}
	}

}