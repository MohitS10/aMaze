package game;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;


public class game extends Canvas implements Runnable, Common{

	static boolean gamerunning = false;
	JFrame gameWindow;
	BufferedImage image = new BufferedImage(SCALE*SIZEY,SCALE*SIZEX,BufferedImage.TYPE_INT_RGB);
	public static Player P;
	InputKeyEvent Inp;
	Maze m;
	Treasure T;
	Enemy E;
	Theme Th;
	public static int score = 0;
	public static boolean gamestarted;
	
	@Override
	public void run() {
		while(gamerunning)
		{
			tick();
			E.tick(this);
			render();
		}
		
	}
	
	public synchronized void start()
	{
		gamerunning = true;
		new Thread(this).start();
	}
	
	public synchronized void stop()
	{
		gamerunning = false;
		System.exit(0);
	}
	
	public void tick(){
		P.tick(this);
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();  
		if(bs==null)
		{
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		if(Treasure.pt.x == Player.pos.x && Treasure.pt.y == Player.pos.y)
		{	
			E.change();
			T.move();
			score++;
			gamestarted=false;
		}
		g.drawImage(image, 0, 0, getWidth(),getHeight(),null);
		m.render(g);
		E.render(g);
		P.render(g);
		T.render(g);
		
		g.setColor(Color.WHITE);
		g.drawString("Score: " + score, 1100, 15);
//		g.fillRect(10,10,50,50);
		g.dispose();
		bs.show();
	}
	
	public game() {
		gameWindow = new JFrame("aMaze");
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setResizable(false);
		gameWindow.setSize(SCALE*SIZEY,SCALE*SIZEX+40);
		gameWindow.setLocationRelativeTo(null);
		gameWindow.setVisible(true);
		gameWindow.add(this);
		m=new Maze(SIZEX,SIZEY);
		m.generateMaze();
		Inp=new InputKeyEvent(this);
		P = new Player();
		T = new Treasure();
		E = new Enemy();	
		Th = new Theme();
		gamestarted=false;
	}
		
}