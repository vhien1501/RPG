import java.awt.image.BufferedImage;

/*ヒエン*/

public class Frame{

	private BufferedImage frame;
	private int duration;

	public Frame(BufferedImage frame, int duration){

		this.frame = frame;
		this.duration = duration;

	}

	public void SetFrame(BufferedImage frame){
		this.frame = frame;
	}

	public BufferedImage GetFrame(){
		return frame;
	}

	public void SetDuration(int duration){
		this.duration = duration;
	}

	public int GetDuration(){
		return duration;
	}

}