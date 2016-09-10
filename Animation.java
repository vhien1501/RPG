import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/*ヒエン*/

public class Animation{

	private int frameCount;
	private int frameDelay;
	private int currentFrame;
	private int animationDirection;
	private int totalFrame;

	private boolean stopped;

	private List<Frame> frames = new ArrayList<Frame>();

	public Animation(BufferedImage[] frames, int frameDelay){

		this.frameDelay = frameDelay;
		this.stopped = true;

		for (int i =0; i < frames.length; i++){
			AddFrame(frames[i], frameDelay);
		}

		this.frameCount = 0;
		this.currentFrame = 0;
		this.animationDirection = 1;
		this.totalFrame = this.frames.size();

	}

	public void Start(){

		if(!stopped){
			return;
		}

		if(frames.size() == 0){
			return;
		}

		stopped = false;

	}

	public void Stop(){

		if(frames.size() == 0){
			return;
		}

		stopped = true;
	}

	public void Restart(){

		if(frames.size() == 0){
			return;
		}

		stopped = false;
		currentFrame = 0;

	}

	public void Reset(){

		stopped = true;
		frameCount = 0;
		currentFrame = 0;
	}

	private void AddFrame(BufferedImage frame, int duration){

		if(duration <=0){
			System.err.println("Invalid duration : " + duration);
			throw new RuntimeException("Invalid duration : " + duration);
		}

		frames.add(new Frame(frame,duration));
		currentFrame = 0;

	}

	public BufferedImage GetSprite(){

		return frames.get(currentFrame).GetFrame();

	}

	public void Update(){

		if(!stopped){

			frameCount++;

			if(frameCount > frameDelay){
				frameCount = 0;
				currentFrame += animationDirection;

				if(currentFrame > totalFrame - 1){
					currentFrame = 0;
				}else if( currentFrame < 0){
					currentFrame = totalFrame -1;
				}
			}
		}
	}

}