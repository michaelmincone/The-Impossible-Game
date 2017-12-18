import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class EnemyList {

	public List<Enemy> enemies1;
	public List<Enemy> enemies2;
	public List<Enemy> enemies3;
	public List<Enemy> enemies4;
	public List<Enemy> enemies3Alt;
	public List<Enemy> enemiesYAlt;
	public List<Enemy> enemiesYAlt1;
	public List<Enemy> enemiesy1;
	public List<Enemy> enemiesy2;
	public List<Enemy> enemiesy3;
	public List<Enemy> enemiesy4;

	public EnemyList() {

		enemies1 = new ArrayList<>(10);
		enemies2 = new ArrayList<>(10);
		enemies3 = new ArrayList<>(10);
		enemies4 = new ArrayList<>(10);
		enemies3Alt = new ArrayList<>(10);
		enemiesy1 = new ArrayList<>(10);
		enemiesy2 = new ArrayList<>(10);
		enemiesy3 = new ArrayList<>(10);
		enemiesy4 = new ArrayList<>(10);
		enemiesYAlt = new ArrayList<>(10);
		enemiesYAlt1 = new ArrayList<>(10);

		int y = 0;
		for (int i = 0; i < 10; i++) { // these enemies are for level 1
			int x = (i % 2 == 0) ? 0 : 600; // This creates a List of Enemys
											// which are distributed evenly
											// without the container.

			Enemy enemy = new Enemy(x, y, "x");
			Enemy enemy1 = new Enemy(x + 100, y, "x");
			enemies1.add(enemy1);
			enemies1.add(enemy);

			y += 100; // how spaced the enemies are
		}

		y = 0;
		for (int i = 0; i < 10; i++) { // these enemies are for level 2
			// int x = (i % 2 == 0) ? 0 : 600 ; //This creates a List of Enemys
			// which are distributed evenly without the container.
			int x = 30;
			int x2 = 200;
			Enemy enemy = new Enemy(x, y, "x");
			Enemy enemy1 = new Enemy(x + 200, y, "x");
			Enemy enemy2 = new Enemy(x + 400, y, "x");
			Enemy enemy3 = new Enemy(x + 600, y, "x");

			enemies2.add(enemy);
			enemies2.add(enemy1);
			enemies2.add(enemy2);
			enemies2.add(enemy3);

			y += 100; // how spaced the enemies are
		}
		y = 0;
		for (int i = 0; i < 10; i++) { // these enemies are for level 3
			// int x = (i % 2 == 0) ? 0 : 600 ; //This creates a List of Enemys
			// which are distributed evenly without the container.
			int x = 50;

			for (int j = 0; j < 10; ++j) {
				enemies3.add(new Enemy(x, y, "x"));
				x += 200;
			}

			x = 50;
			for (int j = 0; j < 10; ++j) {
				enemies3Alt.add(new Enemy(x, y, "xAlt"));
				x += 200;
			}

			y += 100; // how spaced the enemies are
		}

		y = 0;
		for (int i = 0; i < 10; i++) { // these enemies are for level 5
			// This creates a List of Enemys which are distributed evenly
			// without the container.
			int x = 150;

			Enemy enemy = new Enemy(x, y, "y");
			Enemy enemy1 = new Enemy(x + 400, y, "y");
			Enemy enemy2 = new Enemy(x + 800, y, "y");
			Enemy enemy3 = new Enemy(x + 1200, y, "y");

			enemiesy1.add(enemy);
			enemiesy1.add(enemy1);
			enemiesy1.add(enemy2);
			enemiesy1.add(enemy3);

			y += 100; // how spaced the enemies are
		}
		y = 0;
		for (int i = 0; i < 10; i++) {
			int x = 150;

			for (int j = 0; j < 10; ++j) {
				enemiesy2.add(new Enemy(x, y, "y"));
				x += 200;
			}

			y += 100; // how spaced the enemies are
		}
		y = 0;
		for (int i = 0; i < 10; i++) {
			int x = 350;

			for (int j = 0; j < 10; ++j) {
				enemiesy3.add(new Enemy(x, y, "y"));
				x += 400;
			}

			x = 150;
			for (int k = 0; k < 5; ++k) {
				enemiesYAlt.add(new Enemy(x, y, "yAlt"));
				x += 400;
			}
			x = 250;
			for (int l = 0; l < 5; ++l) {
				enemiesYAlt.add(new Enemy(x, y, "yAlt"));
				x += 400;
			}

			y += 100; // how spaced the enemies are
		}
		y = 0;
		for (int i = 0; i < 10; i++) {
			int x = 150;

			for (int j = 0; j < 10; ++j) {
				enemiesy4.add(new Enemy(x, y, "y"));
				x += 200;
			}

			x = 250;
			for (int j = 0; j < 10; ++j) {
				enemiesYAlt1.add(new Enemy(x, y, "yAlt"));
				x += 200;
			}

			y += 100; // how spaced the enemies are
		}
		y = 0;
		for (int i = 0; i < 10; i++) {
			int x = 150;

			Enemy enemy = new Enemy(x, y, "x");
			Enemy enemy1 = new Enemy(x + 200, y, "x");
			Enemy enemy2 = new Enemy(x + 400, y, "x");
			Enemy enemy3 = new Enemy(x + 600, y, "x");

			enemies4.add(enemy);
			enemies4.add(enemy1);
			enemies4.add(enemy2);
			enemies4.add(enemy3);

		}

	}

}
