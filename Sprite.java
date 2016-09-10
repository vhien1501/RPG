import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*ヒエン*/

public class Sprite{
	private static BufferedImage spriteSheet;
	private static final int TILE_SIZE = 32;

	public static  BufferedImage LoadSprite(String file){

		BufferedImage sprite = null;

		try{
			sprite = ImageIO.read(new File("Resource/"+file+".png"));
		}catch(IOException e){
			e.printStackTrace();
		}

		return sprite;
	}

	public static BufferedImage GetSprite(int xGrid, int yGrid){

		if(spriteSheet == null){
			spriteSheet = LoadSprite("AnimationSpriteSheet");
		}

		return spriteSheet.getSubimage(xGrid * TILE_SIZE, yGrid * TILE_SIZE, TILE_SIZE, TILE_SIZE);
	}
}