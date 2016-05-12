package game;

import java.awt.Graphics;

public class Treasure implements Common{
		
	public static Point pt; 
	public Treasure() {
		pt=new Point(0,0);
		do
		{
		pt.randomPoint();
		}while(Maze.grid[pt.x][pt.y] == WALL || pt == Player.pos);
	}
	
	public void move()
	{
		Point temp=new Point(0,0);
		do
		{
		temp.randomPoint();
		}while(Maze.grid[temp.x][temp.y] == WALL || temp==Player.pos || temp == Enemy.pt);
		pt = temp;
	}
	
	public void tick(game g)
	{
		
	}
	
	public void render(Graphics g)
	{
		{
			g.setColor(Theme.getThemeTreasure());
			g.fillRect(pt.y*SCALE, pt.x*SCALE+20, 40, 40);
		}
	}
}
