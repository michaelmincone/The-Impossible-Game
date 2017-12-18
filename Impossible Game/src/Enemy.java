
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author micha
 */
public class Enemy {
	public Rectangle e;
	public int xdirection; 
	public int ydirection;

	public Enemy(int x, int y, String type) {
		e = new Rectangle(x, y, 20, 20);

		if (type.equals("x")) {
			if (x < 1900) {
				xdirection = 5;

			}
			if (x > 1900) {
				xdirection = -5;

			}
		}
		else if (type.equals("xAlt")){
			if (x < 1900) {
				xdirection = -5;

			}
			if (x > 30) {
				xdirection = -5;

			}
		}
		else if (type.equals("y")) {
			if (y > 1000) {
				ydirection = 5;
			}
			if (y < 1000) {
				ydirection = -5;
			}
		}
		else if (type.equals("yAlt")) {
			if (y > 1000) {
				ydirection = -5;
			}
			if (y < 1000) {
				ydirection = 5;
			}
		}
		else if(type.equals("guardian")){
			
		}
		
	}
	
	public Enemy(int w, int x, int y, int z){
		e = new Rectangle(w, x, y, z);
	}
	
	
	public void update(Rectangle bounds) {
		
		e.x += xdirection;
		if (e.x < bounds.x + 30) {
			e.x = bounds.x + 30;
			xdirection *= -1;
		} else if (e.x > bounds.x + bounds.width - e.width) {
			e.x = bounds.x + bounds.width - e.width;
			xdirection *= -1;
		}

	}

	  public void updateY(Rectangle bounds) {
	      e.y += ydirection;

	      if (e.y < bounds.y) {
	          e.y = bounds.y;
	          ydirection *= -1;
	      } else if (e.y > bounds.y - 900 + bounds.width - e.width) {
	          e.y = bounds.y - 900 + bounds.width - e.width;
	          ydirection *= -1;
	      }

	  }
	  
	  public void updateYAlt(Rectangle bounds) {
	      e.y += ydirection;

	      if (e.y < bounds.y) {
	          e.y = bounds.y;
	          ydirection *= -1;
	      } else if (e.y > bounds.y - 900 + bounds.width - e.width) {
	          e.y = bounds.y - 900 + bounds.width - e.width;
	          ydirection *= -1;
	      }

	  }
	  
		public void drawGuardian(Graphics2D g, Player p, ImpossibleGame fp) {
			g.setColor(Color.RED);
			g.draw(e);
			if (p.player.intersects(e)) {
				fp.lives--;
				p.player.x = 0;
				p.player.y = 0;
			}
		}
	  

}
