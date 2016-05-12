package game;

import java.awt.Graphics;

public class Enemy implements Common{
	public static Point pt; 
	public Enemy() {
		pt=new Point(0,0);
		pt=Maze.start;
	}
	
	public void change()
	{
		pt = Treasure.pt;
	}
	
	public void tick(game g)
	{
//		if(pt.x == Player.pos.x && pt.y == Player.pos.y && g.gamestarted==true) // && Player.globalmoved == false
//		{
//			System.out.println("Over");
//			System.exit(0);
//		}
//		else
//		{	
//			System.out.println(pt.x+" "+pt.y+" "+Player.pos.x+" "+Player.pos.y+" "+ g.gamestarted);
//		}
	}
	
	public void render(Graphics g)
	{
		{
			g.setColor(Theme.getThemeEnemy());
			g.fillRect(pt.y*SCALE, pt.x*SCALE+20, 40, 40);
		}
	}

	public void move(int fromX, int fromY) {
		//////////////////////// TODO Auto-generated method stub
	}
}
