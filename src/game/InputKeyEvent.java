package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputKeyEvent implements KeyListener, Common{
	
	public InputKeyEvent(game g) {
		g.addKeyListener(this);
	}
	
	public void keyPressed(KeyEvent e) {
		int keys = e.getKeyCode();
		game.gamestarted = true;
		if(keys==KeyEvent.VK_UP)
		{
			if(!Maze.outOfBounds(Player.pos.x-INC, Player.pos.y))
			{	
				if(game.P.move(-INC, 0))
					Player.last=MOVE_UP;
			}
		}
		else if(keys==KeyEvent.VK_DOWN)
		{
			if(!Maze.outOfBounds(Player.pos.x+INC, Player.pos.y))
			{	
				if(game.P.move(INC, 0))
					Player.last=MOVE_DOWN;
			}
		}
		else if(keys==KeyEvent.VK_LEFT)
		{	
			if(!Maze.outOfBounds(Player.pos.x, Player.pos.y-INC))
			{	
				if(game.P.move(0, -INC))
					Player.last=MOVE_LEFT;
			}
		}
		else if(keys==KeyEvent.VK_RIGHT)
		{	
			if(!Maze.outOfBounds(Player.pos.x, Player.pos.y+INC))
			{
				if(game.P.move(0, INC))
					Player.last=MOVE_RIGHT;
			}
		}
		
		if(keys==KeyEvent.VK_1)
			Theme.setCurrentTheme(0);
		else if(keys==KeyEvent.VK_2)
			Theme.setCurrentTheme(1);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keys = e.getKeyCode();
		if(keys==KeyEvent.VK_SPACE)
			Player.globalmoved=!(Player.globalmoved);
		}
}
