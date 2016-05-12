package game;

import java.awt.Graphics;
import java.util.concurrent.locks.ReentrantLock;

public class Player implements Common//should have separate thread
{
	ReentrantLock lock=new ReentrantLock();
//	private static ImageIcon PImage = new ImageIcon(Player.class.getResource("pngs/p1.png"));
	public static Point pos;
	public static boolean globalmoved;
	public static int last;
	
	public Player()//Spawn a player at startTime
	{
		pos = new Point();
		pos.x=Maze.start.x;
		pos.y=Maze.start.y;
//		moved=false;
	}
	
	public boolean move(int _dx, int _dy) ///define movement of Player
	{
		if(globalmoved)
		{
			pos.x+=_dx;pos.y+=_dy;
			return true;
		}
//		System.out.println("Before: "+posx+" "+posy);
		if(Maze.grid[pos.x+_dx][pos.y+_dy]!=WALL)
		{
			pos.x+=_dx;pos.y+=_dy;
//			moved = true;
			return true;
		}
		return false;
//		System.out.println("After: "+(posx+_dx)+" "+(posy+_dy));
//		System.out.println();
	}

	/*@Override
	public void run() {
		lock.lock();
		
		///////////////////////////////////////////////
		lock.unlock();
	}*/
	
//	public void respawn()
//	{
//		pos.randomPoint();
//		boolean found=false;int x=0,y=0;
//			for(x=pos.x;x<Maze.rows && found==false;x++)
//			for(y=pos.y;y<Maze.columns && found==false;y++)
//				found=(Maze.grid[x][y]==PATH);
//		for(x=pos.x;x>=0 && found==false;x--)
//			for(y=pos.y;y>=0 && found==false;y--)
//				found=(Maze.grid[x][y]==PATH);
//	pos.x=x;pos.y=y;
//		System.out.println(pos.x+" "+pos.y);
//	}
	
//	public static Image getP() {
//		return PImage.getImage();
//	}
	
//	public static Point getPos(){
//		return pos;
//	}
	
	public void tick(game g)
	{
		
	}
	
	public void render(Graphics g)
	{
//		if(!moved)
		{
			g.setColor(Theme.getThemePlayer());
			g.fillRect(pos.y*SCALE, pos.x*SCALE+20, 40, 40);
		}
//		else
//		{
//			int ctr=0;
//			for(double i=pos.x-dx1[last],j=pos.y-dy1[last];ctr<10 && !(Math.abs(i-pos.x)<=0.000001 && Math.abs(j-pos.y)<=0.000001);ctr++,i+=dINC*dx1[last],j+=dINC*dy1[last])
//			{	
//				System.out.println(i+" "+j);
//				Maze.render(g);
//				g.setColor(Color.BLUE);
//				g.fillRect((int)(j*SCALE), (int)(i*SCALE+20), 40, 40);
//				
//			}
//		}
	}
}