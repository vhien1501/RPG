import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/*ヒエン*/

public class Player{

	private int x;
	private int y;
	private int dx;
	private int dy;

	private BufferedImage[] Left = {Sprite.GetSprite(0,1), Sprite.GetSprite(2,1)};
	private BufferedImage[] Right = {Sprite.GetSprite(0,2), Sprite.GetSprite(2,2)};
	private BufferedImage[] Down = {Sprite.GetSprite(0,0), Sprite.GetSprite(2,0)};
	private BufferedImage[] Up =  {Sprite.GetSprite(0,3), Sprite.GetSprite(2,3)};
	private BufferedImage[] StandDown = {Sprite.GetSprite(1,0)};
	private BufferedImage[] StandUp = {Sprite.GetSprite(1,3)};
	private BufferedImage[] StandLeft = {Sprite.GetSprite(1,1)};
	private BufferedImage[] StandRight = {Sprite.GetSprite(1,2)};

	private Animation walkLeft = new Animation(Left, 10);
	private Animation walkRight = new Animation(Right, 10);
	private Animation walkUp = new Animation(Up, 10);
	private Animation walkDown = new Animation(Down, 10);
	private Animation standingDown = new Animation(StandDown, 10);
	private Animation standingRight = new Animation(StandRight, 10);
	private Animation standingLeft = new Animation(StandLeft, 10);
	private Animation standingUp = new Animation(StandUp, 10);

	private Animation animation;

	public Player(int x, int y){

		this.x = x;
		this.y = y;
		animation = standingDown;
	}

	public int GetX(){
		return x;
	}

	public int GetY(){
		return y;
	}

	public BufferedImage GetImage(){
		return animation.GetSprite();
	}

	public void Move(){
		x += dx;
		y += dy;
	}

	public void Update(){
		animation.Update();
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_LEFT){

			animation = walkLeft;
			animation.Start();

			dx = -1;

		}

		if(key == KeyEvent.VK_RIGHT){

			animation = walkRight;
			animation.Start();

			dx = +1;

		}

		if(key ==  KeyEvent.VK_UP){

			animation = walkUp;
			animation.Start();

			dy = -1;

		}

		if(key ==  KeyEvent.VK_DOWN){

			animation = walkDown;
			animation.Start();

			dy = +1;

		}

	}

	public void keyReleased(KeyEvent e){

		int key = e.getKeyCode();

		if(key == KeyEvent.VK_LEFT){

			animation.Stop();
			animation.Reset();
			animation = standingLeft;

			dx = 0;

		}

		if(key == KeyEvent.VK_RIGHT){

			animation.Stop();
			animation.Reset();
			animation = standingRight;

			dx = 0;

		}

		if(key == KeyEvent.VK_UP){

			animation.Stop();
			animation.Reset();
			animation = standingUp;

			dy = 0;

		}

		if(key == KeyEvent.VK_DOWN){

			animation.Stop();
			animation.Reset();
			animation = standingDown;

			dy = 0;

		}
	}
}