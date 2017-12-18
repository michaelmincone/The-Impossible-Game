
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ImpossibleGame extends JPanel implements KeyListener, ActionListener {
	public BallList balls;
	public EnemyList en;
	private Enemy enemiesC; //bounds
	private Enemy enemiesC1; //bounds
	private Player p;
	private Rectangle powerup;
	private Rectangle speedpowerup;
	private Rectangle goal = new Rectangle(1600, 800, 25, 25);
	public int lives = 100000;
	public int level = 1;
	private Color lastColor = Color.YELLOW;
	private int goaldirectionx = 1;
	private int goaldirectiony = 1;
	public int sizex = 30;
	public int sizey = 30;
	public int i = 0;
	public int s = 500;
	public int s1 = 500;
	public int s2 = 0;
	public int s3 = 920;
	public boolean yes;
	public static boolean moveleft;
	public static boolean moveright;
	public static boolean moveup;
	public static boolean movedown;
	public boolean show;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
					ex.printStackTrace();
				}

				JFrame frame = new JFrame("Testing");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(new ImpossibleGame());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	public ImpossibleGame() {
        en = new EnemyList();
		p = new Player();
		powerup = new Rectangle(800, 150, 20, 20);
		speedpowerup = new Rectangle(500, 100, 1200, 20);
		balls = new BallList(this, p);
		enemiesC = new Enemy(0, 100, 50, 1000);
		enemiesC1 = new Enemy(50, 950, 1900, 100);
	

		

		setBackground(Color.BLACK);// backgraund color can be changed
		Timer timer = new Timer(40, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				updateState();
				repaint();
			}
		});
		timer.start();
		setFocusable(true);
		requestFocusInWindow();
		addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				requestFocusInWindow();
			}
		});
		addKeyListener(this);

	}

	public Dimension getPreferredSize() {
		return new Dimension(1920, 1080);
	}

	protected void paintComponent(Graphics g) {// opens paint method
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g.create();
		g.setColor(Color.white);
		g.drawString("LIVES: " + lives, 1700, 20);
		g.drawString("LEVEL: " + level, 1700, 50);
		if (moveleft) {
			if (level == 14) {

				if (p.player.intersects(speedpowerup)) {
					p.player.x -= 20;
				}
				p.player.x -= 2;
			} else if (level != 15) {
				p.player.x -= 2;
			} // variable controlling right movement

			if (level == 15) {
				p.player.x += 2;
			}
		}
		if (moveright) {
			if (level == 14) {
				if (p.player.intersects(speedpowerup)) {
					p.player.x += 20;
				}
				p.player.x += 2;
			} else if (level != 15) {

				p.player.x += 2;

			} // variable controlling

			if (level == 15) {
				p.player.x -= 2;
			}

		}
		if (moveup) {
			if (level == 14) {
				if (p.player.intersects(speedpowerup)) {
					p.player.y -= 20;
				}
				p.player.y -= 2;
			} else if (level != 15) {
				p.player.y -= 2;
			} // variable controlling right movement

			if (level == 15) {
				p.player.y += 2;
			}
		}
		if (movedown) {
			if (level == 14) {
				if (p.player.intersects(speedpowerup)) {
					p.player.y += 20;
				}
				p.player.y += 2;
			} else if (level != 15) {
				p.player.y += 2;
			} // variable controlling right movement
			if (level == 15) {
				p.player.y -= 2;
			}
		}

		if (lives == 0) {
			show = false;
			g.setColor(Color.YELLOW);
			if (lastColor.equals(Color.YELLOW)) {
				lastColor = Color.WHITE;
			} else if (lastColor.equals(Color.WHITE)) {
				lastColor = Color.GREEN;
			} else if (lastColor.equals(Color.GREEN)) {
				lastColor = Color.RED;
			} else if (lastColor.equals(Color.RED)) {
				lastColor = Color.MAGENTA;
			} else if (lastColor.equals(Color.MAGENTA)) {
				lastColor = Color.YELLOW;
			}

			g.setColor(lastColor);
			g.fillRect(0, 0, 2000, 2000);

			g.setColor(Color.black);
			Font font1 = new Font("Serif", Font.BOLD, 200);
			Font font2 = new Font("Serif", Font.BOLD, 50);
			g.setFont(font1);
			g.drawString("Game Over", s, s);
			g.drawString("Game Over", s1, s1);
			g.drawString("Press 1 to restart", s2, 130);
			g.drawString("Press 1 to restart", s3, 1000);

			try {
				Thread.sleep(1);
			} catch (Exception ex) {
			}
			s += 1;
			s1 -= 1;
			s2 += 3;
			s3 -= 3;
			if (s + 800 > this.getWidth()) {
				s = 0;
			}
			if (s1 + 110 < 0) {
				s1 = 1000;
			}
			if (s2 > this.getWidth()) {
				s2 = 0;
			}
			if (s3 + 1450 < 0) {
				s3 = 920;
			}
			repaint();

		}
		if (level == 1 && lives > 0) {
			show = true;
			if (show == true) {
				drawGuardians(g2d);
				
				drawGoal(g2d);
				p.drawPlayer(g2d); // draws the player

				g2d.setColor(Color.RED);

				for (Enemy enemy : en.enemies1) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) {
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}
				}
				repaint();
			}
		}

		if (level == 2 && lives > 0) {
			show = true;
			if (show == true) {
				drawGuardians(g2d);
				drawGoal(g2d);
				p.drawPlayer(g2d); // draws the player

				g2d.setColor(Color.RED);
				for (Enemy enemy : en.enemies2) {

					g2d.fill(enemy.e);

					if (p.player.intersects(enemy.e)) { 
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}
				}
				repaint();
			}
		}
		repaint();
		if (level == 3 && lives > 0) {
			show = true;
			if (show == true) {
				drawGuardians(g2d);
				drawGoal(g2d);
				p.drawPlayer(g2d); // draws the player
				g2d.setColor(Color.RED);

				for (Enemy enemy : en.enemies3) {

					g2d.fill(enemy.e);

					if (p.player.intersects(enemy.e)) { // if player
																// intersects
																// enemy send
																// him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}

				}
				repaint();
				for (Enemy enemy : en.enemies3Alt) {

					g2d.fill(enemy.e);

					if (p.player.intersects(enemy.e)) { // if player
															// intersects enemy
															// send him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}

				}
				repaint();
			}
		}
		if (level == 4 && lives > 0) {
			show = true;
			if (show == true) {
				drawGuardians(g2d);
				Ball b = balls.ballLst.get(0);
				b.drawBall(g2d);
				drawGoal(g2d);
				p.drawPlayer(g2d); // draws the player
				g2d.setColor(Color.RED);

				for (Enemy enemy : en.enemies3) {

					g2d.fill(enemy.e);

					if (p.player.intersects(enemy.e)) { 
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}

				}

				for (Enemy enemy : en.enemies3Alt) {

					g2d.fill(enemy.e);

					if (p.player.intersects(enemy.e)) {
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}

				}
				repaint();
			}
		}
		repaint();

		if (level == 5 && lives > 0) {
			show = true;
			if (show = true) {
				balls.speed = 3;
				drawGoal(g2d);
				p.drawPlayer(g2d); // draws the player
				drawPowerup(g2d);
				g2d.setColor(Color.RED);
				for(int i = 0; i < 8; ++i){
					Ball b = balls.ballLst.get(i);
					b.drawBall(g2d);
				}
				g2d.setColor(Color.RED);
				drawGuardians(g2d);
			}
		}
		if (level == 6 && lives > 0) {
			show = true;
			if (show = true) {
				balls.speed = 3;
				drawGoal(g2d);
				p.drawPlayer(g2d); // draws the player
				drawPowerup(g2d);
				g2d.setColor(Color.RED);
				for(int i = 0; i < 8; ++i){
					Ball b = balls.ballLst.get(i);
					b.drawBall(g2d);
				}
			
				g2d.setColor(Color.RED);
				drawGuardians(g2d);
				for (Enemy enemy : en.enemies2) {

					g2d.fill(enemy.e);

					if (p.player.intersects(enemy.e)) {
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}
				}
				repaint();
			}
		}
		if (level == 7 && lives > 0) {
			show = true;
			if (show = true) {
				drawGoal(g2d);
				p.drawPlayer(g2d); // draws the player
				drawPowerup(g2d);
				g2d.setColor(Color.RED);
				drawGuardians(g2d);
				Ball b = balls.bigBallLst.get(0);
				b.drawBigBall(g2d);
			}
		}

		if (level == 8 && lives > 0) {
			show = true;
			if (show = true) {
				drawGoal(g2d);
				p.drawPlayer(g2d); // draws the player
				drawPowerup(g2d);
				g2d.setColor(Color.RED);
				Ball b = balls.ballLst.get(0);
				b.drawBall(g2d);
				g2d.setColor(Color.RED);
				drawGuardians(g2d);

				for (Enemy enemy : en.enemies3) {

					g2d.fill(enemy.e);

					if (p.player.intersects(enemy.e)) { // if player
																// intersects
																// enemy send
																// him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}

				}

				for (Enemy enemy : en.enemies3Alt) {

					g2d.fill(enemy.e);

					if (p.player.intersects(enemy.e)) { // if player
															// intersects enemy
															// send him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}

				}

				for (Enemy enemy : en.enemiesy1) {
					g2d.fill(enemy.e);

					if (p.player.intersects(enemy.e)) { // if player
															// intersects enemy
															// send him back and
															// decrease a life
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}

				}
			}
		}

		if (level == 9 && lives > 0) {
			show = true;
			if (show = true) {
				drawGoal(g2d);
				p.drawPlayer(g2d); // draws the player
				drawPowerup(g2d);
				g2d.setColor(Color.RED);
				Ball b = balls.ballLst.get(0);
				b.drawBall(g2d);
				g2d.setColor(Color.RED);
				drawGuardians(g2d);
				g2d.setColor(Color.RED);
				for (Enemy enemy : en.enemiesy3) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
															// intersects enemy
															// send him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}

				}
				for (Enemy enemy : en.enemiesYAlt) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
															// intersects enemy
															// send him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}

				}
			}
		}

		if (level == 10 && lives > 0) {
			show = true;
			if (show = true) {
				drawGoal(g2d);
				p.drawPlayer(g2d); // draws the player
				drawPowerup(g2d);
				g2d.setColor(Color.RED);
				for(int i = 0; i < 16; ++i){
					Ball b = balls.ballLst.get(i);
					b.drawBall(g2d);
				}
		
				drawGuardians(g2d);
				for (Enemy enemy : en.enemies3) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
																// intersects
																// enemy send
																// him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}
				}

				for (Enemy enemy : en.enemies3Alt) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
															// intersects enemy
															// send him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}

				}

			}
		}

		if (level == 11 && lives > 0) {
			show = true;
			if (show = true) {
				drawGoal(g2d);
				p.drawPlayer(g2d); // draws the player
				drawPowerup(g2d);
				g2d.setColor(Color.RED);
				Ball b = balls.ballLst.get(0);
				b.drawBall(g2d);
				g2d.setColor(Color.RED);
				drawGuardians(g2d);
				for (Enemy enemy : en.enemies3) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
																// intersects
																// enemy send
																// him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}
				}

				for (Enemy enemy : en.enemies3Alt) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
															// intersects enemy
															// send him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}

				}

				for (Enemy enemy : en.enemiesy2) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
															// intersects enemy
															// send him back and
															// decrease a life
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}
				}
			}
		}
		if (level == 12 && lives > 0) {
			show = true;
			if (show = true) {
				drawGoal(g2d);
				p.drawPlayer(g2d); // draws the player
				drawPowerup(g2d);
				g2d.setColor(Color.RED);
				Ball b = balls.ballLst.get(0);
				b.drawBall(g2d);
				g2d.setColor(Color.RED);
				drawGuardians(g2d);
				for (Enemy enemy : en.enemiesYAlt1) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
															// intersects enemy
															// send him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}
				}

				for (Enemy enemy : en.enemiesy4) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
															// intersects enemy
															// send him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}
				}
			}
		}
		if (level == 13 && lives > 0) {
			show = true;
			if (show = true) {
				drawGoal(g2d);
				p.drawPlayer(g2d); // draws the player
				drawPowerup(g2d);

				g2d.setColor(Color.RED);
				Ball b = balls.ballLst.get(0);
				b.drawBall(g2d);
				g2d.setColor(Color.RED);
				drawGuardians(g2d);
				for (Enemy enemy : en.enemiesYAlt1) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
															// intersects enemy
															// send him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}
				}

				for (Enemy enemy : en.enemiesy4) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
															// intersects enemy
															// send him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}
				}

				for (Enemy enemy : en.enemies3) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
																// intersects
																// enemy send
																// him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}
				}

				for (Enemy enemy : en.enemies3Alt) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
															// intersects enemy
															// send him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
					}

				}
			}
		}
		if (level == 14 && lives > 0) {
			show = true;
			if (show = true) {
				drawGoal(g2d);
				p.drawPlayer(g2d); // draws the player
				drawPowerup(g2d);
				drawSpeedPowerup(g2d);
				g2d.setColor(Color.RED);
				for(int i = 0; i < 16; ++i){ //draw 16 balls
					Ball b = balls.ballLst.get(i);
					b.drawBall(g2d);
				}
				drawGuardians(g2d);
			}
		}

		if (level == 15 && lives > 0) {

			show = true;
			if (show = true) {
				if (i == 1000) {
					yes = false;

					p.drawPlayer(g2d);
					drawPowerup(g2d);
					drawGoal(g2d);
					g2d.setColor(Color.RED);
					Ball b = balls.ballLst.get(0);
					b.drawBall(g2d);
					g2d.setColor(Color.RED);
					drawGuardians(g2d);
					for (Enemy enemy : en.enemiesYAlt1) {
						g2d.fill(enemy.e);
						if (p.player.intersects(enemy.e)) { // if player
																// intersects
																// enemy send
																// him back
							lives--;
							p.player.x = 0;
							p.player.y = 0;
						}
					}

					for (Enemy enemy : en.enemiesy4) {
						g2d.fill(enemy.e);
						if (p.player.intersects(enemy.e)) { // if player
																// intersects
																// enemy send
																// him back
							lives--;
							p.player.x = 0;
							p.player.y = 0;
						}
					}

					for (Enemy enemy : en.enemies3) {
						g2d.fill(enemy.e);
						if (p.player.intersects(enemy.e)) { // if player
																	// intersects
																	// enemy
																	// send him
																	// back
							lives--;
							p.player.x = 0;
							p.player.y = 0;
						}
					}

					for (Enemy enemy : en.enemies3Alt) {
						g2d.fill(enemy.e);
						if (p.player.intersects(enemy.e)) { // if player
																// intersects
																// enemy send
																// him back
							lives--;
							p.player.x = 0;
							p.player.y = 0;
						}

					}

				} else {
					i++;
				}
				if (i < 1000) {
					yes = true;
					if (yes = true) {
						g2d.setColor(Color.WHITE);
						g2d.drawString("System modules have been modified : 800b0100", 500, 500);
						g2d.drawString("Arrow keys are inversely proportional : 8024afff ", 500, 520);
						g2d.drawString("0xc004e0030x80070424", 500, 540);

					}
				}
			}
		}
		if (level == 16 && lives > 0) {
			show = true;
			if (show = true) {
				p.drawPlayer(g2d);
				drawPowerup(g2d);
				drawGoal(g2d);
				g2d.setColor(Color.RED);
				Ball b = balls.ballLst.get(0);
				b.drawBall(g2d);
				Ball b5 = balls.ballLst.get(5);
				b5.drawBall(g2d);
				g2d.setColor(Color.RED);
				drawGuardians(g2d);
				for (Enemy enemy : en.enemies3) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
																// intersects
																// enemy send
																// him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
						p.player.setSize(sizex + 20, sizey + 20);

					}
				}

				for (Enemy enemy : en.enemiesYAlt1) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
															// intersects enemy
															// send him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
						p.player.setSize(sizex + 20, sizey + 20);
					}
				}

				for (Enemy enemy : en.enemiesy4) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
															// intersects enemy
															// send him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
						p.player.setSize(sizex + 20, sizey + 20);
					}
				}

				for (Enemy enemy : en.enemies3Alt) {
					g2d.fill(enemy.e);
					if (p.player.intersects(enemy.e)) { // if player
															// intersects enemy
															// send him back
						lives--;
						p.player.x = 0;
						p.player.y = 0;
						p.player.setSize(sizex + 20, sizey + 20);
					}

				}
			}
		}
		if (level == 17 && lives > 0) {
			g.setColor(Color.YELLOW);
			if (lastColor.equals(Color.YELLOW)) {
				lastColor = Color.WHITE;
			} else if (lastColor.equals(Color.WHITE)) {
				lastColor = Color.GREEN;
			} else if (lastColor.equals(Color.GREEN)) {
				lastColor = Color.RED;
			} else if (lastColor.equals(Color.RED)) {
				lastColor = Color.MAGENTA;
			} else if (lastColor.equals(Color.MAGENTA)) {
				lastColor = Color.YELLOW;
			}

			g.setColor(lastColor);
			g.fillRect(0, 0, 2000, 2000);

			g.setColor(Color.black);
			Font font1 = new Font("Serif", Font.BOLD, 200);
			Font font2 = new Font("Serif", Font.BOLD, 50);
			g.setFont(font1);
			g.drawString("YOU WON", s, s);
			g.drawString("YOU WON", s1, s1);
			g.drawString("CONGRATULATIONS", s2 - 2100, 130);
			g.drawString("CONGRATULATIONS", s3, 1000);

			try {
				Thread.sleep(1);
			} catch (Exception ex) {
			}
			s += 1;
			s1 -= 1;
			s2 += 3;
			s3 -= 3;
			if (s + 800 > this.getWidth()) {
				s = 0;
			}
			if (s1 + 110 < 0) {
				s1 = 1000;
			}
			if (s2 - 2000 > this.getWidth()) {
				s2 = 0;
			}
			if (s3 + 2100 < 0) {
				s3 = 920;
			}
			repaint();

		}
	}//end of paintComponent

	public void actionPerformed(ActionEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == e.VK_LEFT) {
			moveleft = false;
		}
		if (e.getKeyCode() == e.VK_RIGHT) {
			moveright = false;
		}
		if (e.getKeyCode() == e.VK_UP) {
			moveup = false;
		}
		if (e.getKeyCode() == e.VK_DOWN) {
			movedown = false;
		}
	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == e.VK_RIGHT) {
			moveright = true;
		}
		if (e.getKeyCode() == e.VK_LEFT) {
			moveleft = true;

		}
		if (e.getKeyCode() == e.VK_UP) {
			moveup = true;

		}
		if (e.getKeyCode() == e.VK_DOWN) {
			movedown = true;

		}
		if (e.getKeyCode() == e.VK_1) {
			++level;

		}

	}

	public void drawGuardians(Graphics2D g2d){
		enemiesC1.drawGuardian(g2d, p, this);
		enemiesC.drawGuardian(g2d, p, this);
	}

	public void drawPowerup(Graphics2D g) {
		g.setColor(Color.green);
		g.fill(powerup);

		if (p.player.intersects(powerup)) {
			lives++;
			powerup.x = 6000;
		}
		if (level == 7) {
			powerup.x = 200;
			powerup.y = 200;
			g.fill(powerup);
		}
		if (level == 8) {
			powerup.x = 200;
			powerup.y = 200;
			g.fill(powerup);
		}
		if (level == 9) {
			powerup.x = 300;
			powerup.y = 300;
			g.fill(powerup);
		}
		if (level == 10) {
			powerup.x = 400;
			powerup.y = 400;
			g.fill(powerup);
		}
		if (level == 11) {
			powerup.x = 500;
			powerup.y = 500;
			g.fill(powerup);
		}
		if (level == 12) {
			powerup.x = 600;
			powerup.y = 600;
			g.fill(powerup);
		}
		if (level == 13) {
			powerup.x = 700;
			powerup.y = 700;
			g.fill(powerup);
		}

		repaint();

	}

	public void drawSpeedPowerup(Graphics2D g) {
		g.setColor(Color.MAGENTA);
		g.draw(speedpowerup);
		if (level == 15) {
			speedpowerup.y = 100;
		}
		repaint();
	}




	public void drawGoal(Graphics2D g) {
		if (lastColor.equals(Color.YELLOW)) {
			lastColor = Color.BLUE;
		} else {
			lastColor = Color.YELLOW;
		}
		g.setColor(lastColor);

		g.fill(goal);
		if (p.player.intersects(goal)) {
			level++;
			p.player.x = 0;
			p.player.y = 0;
		}
		if (level == 16) {
			if (goal.y < 1000) {
				goal.y += goaldirectiony;
			}
		}
	}

	public void updateState() {

		Rectangle bounds = new Rectangle(20, 20, getWidth(), getHeight());
		for (Enemy enemy : en.enemies1) {
			enemy.update(bounds);
		}
		for (Enemy enemy : en.enemies2) {
			enemy.update(bounds);
		}
		for (Enemy enemy : en.enemies3) {
			enemy.update(bounds);
		}
		for (Enemy enemy : en.enemies4) {
			enemy.update(bounds);
		}
		for (Enemy enemy : en.enemies3Alt) {
			enemy.update(bounds);
		}
		for (Enemy enemy : en.enemiesy1) {
			enemy.updateY(bounds);
		}
		for (Enemy enemy : en.enemiesy2) {
			enemy.updateY(bounds);
		}
		for (Enemy enemy : en.enemiesy3) {
			enemy.updateY(bounds);
		}
		for (Enemy enemy : en.enemiesy4) {
			enemy.updateY(bounds);
		}
		for (Enemy enemy : en.enemiesYAlt) {
			enemy.updateYAlt(bounds);
		}
		for (Enemy enemy : en.enemiesYAlt1) {
			enemy.updateYAlt(bounds);
		}

	}


	

}
