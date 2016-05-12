package game;

public class Point
{
	public int x,y;
	public Point(){}
	public Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public void randomPoint()
	{
		this.randomizeX(0,Maze.rows-1);
		this.randomizeY(0,Maze.columns-1);
	}
	public void randomizeX(int minX,int maxX)// random X between minX and maxX inclusive
	{
		x=(int)(Math.random()*((maxX-minX)+1))+minX;
	}
	public void randomizeY(int minY,int maxY)// random Y between minY and maxY inclusive
	{
		y=(int)(Math.random()*((maxY-minY)+1))+minY;
	}
	public void setPoint(int x,int y)
	{
		this.x=x;this.y=y;
	}
}