package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainMenu extends JFrame implements Common{
	
	JButton Play, Help, Quit;
	int BW = 100;
	int BH = 50;
	
	public MainMenu() {
		addButtons();
		addActions();
		
		getContentPane().setLayout(null);
		
//		Graphics g;
//		Graphics2D Draw = (Graphics2D) g;
//		final ImageIcon image = new ImageIcon(Player.class.getResource("pngs/screen.png"));
//		Draw.drawImage((Image) image, 0, 0, null);
		
		Play.setBounds(0, 5, BW, BH);
		Quit.setBounds(0, 50, BW, BH);
		
		getContentPane().add(Play);
		getContentPane().add(Quit);
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(SCALE*SIZEY,SCALE*SIZEX+20);
		setTitle("aMaze");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	
	}
	
	private void addButtons() {
		Play = new JButton("Play");
		Quit = new JButton("Quit");
	}
	
	private void addActions() {
		Play.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				game Game = new game();
				
				Game.start();
			}
		});
		
		Quit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

	}
}
