


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;




public class Player {
    
    public Rectangle player;
    public int sizex = 30;
    public int sizey = 30;
   
    public Player(){
        player = new Rectangle(0, 0, sizex, sizey);  
       
    }
    
    
    public void drawPlayer(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fill(player);

		if (player.x <= 0) {
			player.x = 0;
		}
		if (player.y <= 0) {
			player.y = 0;
		}
		if (player.x >= 1880) {
			player.x = 1880;
		}
	}
	 
       
    
}
