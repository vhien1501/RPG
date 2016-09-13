import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.Timer;

/*ヒエン*/

public class BoardGame extends JPanel implements ActionListener{

	private final int WIDTH = 480;
	private final int HIEGHT = 320;
	private final int PLAYER_X = 100;
	private final int PLAYER_Y = 100;
	private final int DELAY =20;

	private Player Hero;
	private TileMap Map;


	private Timer timer;

	public BoardGame(){

		initBoardGame();
	}

	private void initBoardGame(){

		setBackground(Color.BLACK);
		new Dimension(WIDTH, HIEGHT);

		Hero = new Player(PLAYER_X, PLAYER_Y);
		Map = new Map("Map");

		addKeyListener(new TAdapter());

		setFocusable(true);
		setDoubleBuffered(true);

		timer = new Timer(DELAY, this);
		timer.start();

	}

	@Override
	public void paintComponent(Graphics g){

		super.paintComponent(g);
		DrawPlayer(g);
		Toolkit.getDefaultToolkit().sync();

	}

	private void Draw(Graphics g){
		 	Graphics2D g2d = (Graphics2D) g;

		 	g2d.drawImage(Hero.GetImage(), Hero.GetX(), Hero.GetY(), this);
		 	Map.Draw(g2d);
	}

	@Override
	public void actionPerformed(ActionEvent e){

		Hero.Move();
		Hero.Update();

		repaint();

	}

	private class TAdapter extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e){
			
			Hero.keyPressed(e);

		}

		public void keyReleased(KeyEvent e){

			Hero.keyReleased(e);

		}
	}

}