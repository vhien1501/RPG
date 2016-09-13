import java.io.*;
import java.awt.*;

public class TileMap{

	private int x;
	private int y;

	private int TileSize;
	private int[][] map;
	private int width;
	private int height;

	private Sprite sprite;

	public TileMap(String s, int TileSize){
		this.TileSize = TileSize;

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
		
	}

}