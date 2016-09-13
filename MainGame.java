import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/*ヒエン*/

public class MainGame extends JFrame{

	public MainGame(){
		initUI();
	}

	private void initUI(){

		add(new BoardGame());
		setSize(480, 320);
		setTitle("TEST");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args){

		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				MainGame game = new MainGame();
				game.setVisible(true);
			}
		});
		
	}
}