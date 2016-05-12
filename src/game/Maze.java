package game;

import java.awt.Graphics;

public class Maze implements Common
{
	public static char[][] grid;
	public static int rows=SIZEX,columns=SIZEY;//number of rows and columns a.k.a dimensions of grid
	public static Point start;
	public Maze()
	{
		rows=columns=0;
	}
	public Maze(int r,int c)
	{		rows=r;columns=c;	}
	public Maze(int n)
	{		this(n,n);								}
	public void setSize(int r,int c)
	{		rows=r;columns=c;	}				
	public boolean loadMaze()
	{
		///////////////////////////////////////////////////////////
		return true;
	}
	public void saveMaze()
	{
		////////////////////////////////////////////////////////////
	}
	public void resetMaze()// Sets grid with Walls
	{
		for(int i=0;i<rows;i++)
			for(int j=0;j<columns;j++)
				grid[i][j]=OUT;
	}
	public static boolean outOfBounds(int x,int y)
	{
		return !((x>=0 && x<rows) && (y>=0 && y<columns));
	}
	public static int encode(int x,int y)
	{
		return (y*columns)+x;
	}
	public static void makeWay(int x1,int y1,int x2,int y2)
	{
		for(int i=0;i<4;i++)
			if(x1+dx[i]==x2 && y1+dy[i]==y2)
				grid[x1+dx1[i]][y1+dy1[i]]=' ';
	}
	public static void render(Graphics g)
	{
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				if(grid[i][j]==IN)
				{
					g.setColor(Theme.getThemeWhite());
					g.fillRect(j*40, i*40+20, 40, 40);
				}
				else if(grid[i][j]==START || grid[i][j]==PATH)
				{
					g.setColor(Theme.getThemeWhite());
					g.fillRect(j*40, i*40+20, 40, 40);
				}
				else
				{
					g.setColor(Theme.getThemeBlack());
					g.fillRect(j*40, i*40+20, 40, 40);
				}
			}
		}
	}
	
	public static void resolve()
	{
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				if(grid[i][j]==IN || grid[i][j]==PATH || grid[i][j]==START)
					grid[i][j]=PATH;
				else
					grid[i][j]=WALL;
				System.out.print(grid[i][j]);
			}
			System.out.println("");
		}
	}
	
	public void generateMaze()
	{
		if(rows==0 || columns==0)return ;
		grid=new char[rows][columns];// allocate extra for borders
		resetMaze();
		start=new Point(0,0);
		start.randomPoint();
		grid[start.x][start.y]=IN;
		int[] candidates=new int[rows*columns];
		int candidateNum=0,x,y,newCellIndex,INneighboursCount,INcell;
		for(int i=0;i<4;i++)// insert into candidate list all cells into which we can expand our MST
			{
				if(outOfBounds(start.x+dx[i],start.y+dy[i]))continue;
				candidates[candidateNum++]=encode(start.x+dx[i],start.y+dy[i]);
				grid[start.x+dx[i]][start.y+dy[i]]=CANDIDATE;
			}
		int[] INneighbours=new int[4];
		while(candidateNum>0)
		{
			newCellIndex=(int)(Math.random()*candidateNum);//Chose candidate cell at random from all possible candidates
			x=candidates[newCellIndex]%columns;
			y=candidates[newCellIndex]/columns;
			INneighboursCount=0;
			for(int i=0;i<4;i++)
			{
				if(outOfBounds(x+dx[i],y+dy[i]) || grid[x+dx[i]][y+dy[i]]==OUT || grid[x+dx[i]][y+dy[i]]==CANDIDATE)continue;
				INneighbours[INneighboursCount++]=encode(x+dx[i],y+dy[i]);
			}
			//we will expand into the chosen random candidate cell from a randomly chosen grid vertice marked as IN "in" the MST
			INcell=INneighbours[(int)(Math.random()*INneighboursCount)];
			//make a path from INcell to (x,y)
			makeWay(x,y,INcell%columns,INcell/columns);
			try{grid[x][y]=IN;}catch(Exception e){System.out.println(x+" "+y);}
			if(newCellIndex<(candidateNum-1))
				System.arraycopy(candidates, newCellIndex+1,candidates, newCellIndex, candidateNum-newCellIndex-1);
			candidateNum--;
			for(int i=0;i<4;i++)
			{
				if(outOfBounds(x+dx[i],y+dy[i]) || grid[x+dx[i]][y+dy[i]]!=OUT)continue;
				grid[x+dx[i]][y+dy[i]]=CANDIDATE;
				candidates[candidateNum++]=encode(x+dx[i],y+dy[i]);
			}
		}
		grid[start.x][start.y]=START;
		resolve();
	}
}