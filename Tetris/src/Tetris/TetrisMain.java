package Tetris;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class TetrisMain extends Canvas implements Runnable, KeyListener{
	
	public static final int WIDTH = 400, HEIGHT = 565;
	
	public static void main(String args[]){
		JFrame frame = new JFrame("Tetris");
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		
		KeyGetter.LoadKeys();
		
		JMenuBar bar = new JMenuBar();
		bar.setBounds(0, 0, WIDTH, 25);
		
		JMenu file = new JMenu("File");
		file.setBounds(0, 0, 45, 24);
		
		TetrisMain tm = new TetrisMain();
		tm.setBounds(0, 25, WIDTH, HEIGHT - 25);
		
		JMenuItem newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener(){
			@SuppressWarnings("unused")
			public void ActionPerformed(ActionEvent e){
				//Code for game
				System.out.print("Starting new game...");
			}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenuItem highScore = new JMenuItem("High Score");
		highScore.addActionListener(new ActionListener(){
			@SuppressWarnings("unused")
			public void ActionPerformed(ActionEvent e){
				//Code for game
				int highscore = 0;//Replace with getHighscoreMethod later;
				JFrame alert = new JFrame("High Score");
				alert.setSize(200, 100);
				alert.setLayout(null);
				alert.setLocationRelativeTo(null);
				alert.setResizable(false);
				alert.setVisible(true);
			}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int highscore = 0;//Replace with getHighscoreMethod later;
				final JFrame alert = new JFrame("High Score");
				alert.setSize(300, 200);
				alert.setLayout(null);
				alert.setLocationRelativeTo(null);
				
				JLabel score = new JLabel("The highest score is: " + highscore);
				score.setBounds(0, 0, 200, 50);
				
				JButton okayButton = new JButton("Okay");
				okayButton.setBounds(50, 120, 100, 30);
				okayButton.addActionListener(new ActionListener(){
					public void ActionPerformed(ActionEvent e){
						alert.dispose();
					}

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						alert.dispose();
					}
				});
				
				alert.add(score);
				alert.add(okayButton);
				alert.setResizable(false);
				alert.setVisible(true);
			}
		});
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener(){
			@SuppressWarnings("unused")
			public void ActionPerformed(ActionEvent e){
				//Code for game
				System.out.print("Closing...");
				System.exit(0);
			}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//Code for game
				System.out.print("Closing...");
				System.exit(0);
			}
		});
		
		frame.add(tm);
		file.add(newGame);
		file.add(highScore);
		file.add(exit);
		
		frame.add(bar);
		bar.add(file);
		frame.setVisible(true);
		tm.start();
	}
	
	public void start(){
		Thread t = new Thread(this);
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
	}
	
	public void run(){
		boolean running = true;
		while(running){
			update();
			BufferStrategy buf = getBufferStrategy();
			if(buf==null){
				createBufferStrategy(3);
				continue;
			}
			Graphics2D g = (Graphics2D) buf.getDrawGraphics();
			render(g);
			buf.show();
		}
	}
	
	public void init(){
		
	}
	
	public void update(){
		
	}
	public void render(Graphics2D g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Calibri", Font.PLAIN, 20));
		g.drawString("Tetris", 180, 50);
	}
	
	public void keyPressed(KeyEvent e){
		
	}
	public void keyTyped(KeyEvent e){
		
	}
	public void keyReleased(KeyEvent e){
		
	}
}
