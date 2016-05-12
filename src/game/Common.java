package game;
public interface Common
{
	public int WALL='W';
	public int IN=0;// considered in generated MST
	public int CANDIDATE=1;//is a candidate to be a path
	public int OUT=2;//to be considered in MST
	public int dx[]={0,-2,0,2};
	public int dy[]={-2,0,2,0};
	public int dx1[]={0,-1,0,1};
	public char START='S';
	public char PATH=' ';
	public int dy1[]={-1,0,1,0};
	public int SCALE=40;
	public int INC = 1;
	public double dINC = 0.1;

	public int SIZEX = 10, SIZEY=30;//size of arena should be even
	public static final int MOVE_UP=0,	MOVE_DOWN=2,	MOVE_LEFT=1,	MOVE_RIGHT=3;
	
}