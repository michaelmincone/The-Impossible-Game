import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball {
	
	public Ellipse2D.Double ball;
	public Ellipse2D.Double bigBall;
	int xDirection = 1;
	int yDirection = 1;
	int speed = 4;
	public ImpossibleGame f;
	public Player p;
	
	public Ball(int w, int x, int y, int z, ImpossibleGame f, Player p){
		ball = new Ellipse2D.Double(w, x, y, z);
		
		this.f = f;
		this.p = p;
	}
	
	public Ball(ImpossibleGame f, Player p){
		bigBall = new Ellipse2D.Double(300, 600, 400, 400);
		this.f = f;
		this.p = p;
	}
	
	
	
	
	
	public void drawBall(Graphics2D g) {
		
		g.setColor(Color.YELLOW);

		g.fill(ball);

		if (f.level == 10) {
			speed = 3;
			ball.x += (Math.random() > 0.5 ? 1 : -1) * speed;
			ball.y += (Math.random() > 0.5 ? 1 : -1) * speed;
		} 
		
		else if (f.level == 14) {
			speed = 4;
			ball.x += (Math.random() > 0.5 ? 1 : -1) * speed;
			ball.y += (Math.random() > 0.5 ? 1 : -1) * speed;
			ball.x += xDirection * speed;
			ball.y += yDirection * speed;
		} 
		else {
			ball.x += xDirection * speed;
			ball.y += yDirection * speed;
		}
		if (ball.x < 0) {
			xDirection = 1;
			ball.x = 0;
		} 
		
		else if (ball.x > f.getWidth() - ball.getBounds().width) {
			xDirection = -1;
			ball.x = f.getWidth() - ball.getBounds().width;
		}

		if (ball.y < 0) {
			yDirection = 1;
			ball.y = 0;
		}
		else if (ball.y > f.getHeight() - ball.getBounds().height) {
			yDirection = -1;
			ball.y = f.getHeight() - ball.getBounds().height;
		}
		if (ball.intersects(p.player)) {
			f.lives--;
			p.player.x = 0;
			p.player.y = 0;
		}

	}
	
	public void drawBigBall(Graphics2D g) {
		
		g.setColor(Color.RED);

		g.fill(bigBall);
		speed = 3;
		bigBall.x += xDirection * speed;// This chunk of code moves the ball
											// around the screen
		bigBall.y += yDirection * speed;
		if (bigBall.x < 0) {
			xDirection = 1;
			bigBall.x = 0;
		} else if (bigBall.x > f.getWidth() - bigBall.getBounds().width) {
			xDirection = -1;
			bigBall.x = f.getWidth() - bigBall.getBounds().width;
		}

		if (bigBall.y < 0) {
			yDirection = 1;
			bigBall.y = 0;
		} else if (bigBall.y > f.getHeight() - bigBall.getBounds().height) {
			yDirection = -1;
			bigBall.y = f.getHeight() - bigBall.getBounds().height;
		}
		if (bigBall.intersects(p.player)) {
			f.lives--;
			p.player.x = 0;
			p.player.y = 0;
		}
		
	}

}
