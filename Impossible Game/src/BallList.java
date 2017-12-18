
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author micha
 */
public class BallList {

	public List<Ball> ballLst;
	public List<Ball> bigBallLst;
	public double speed = 6;
	public ImpossibleGame f;
	public Player p;

	public BallList(ImpossibleGame f, Player p) {
		this.f = f;
		this.p = p;

		ballLst = new ArrayList<Ball>();
		bigBallLst = new ArrayList<Ball>();

		int xPos = 300;
		for (int i = 0; i < 8; ++i) {
			ballLst.add(new Ball(xPos, 300, 25, 25, f, p));
			xPos += 200;
		}

		xPos = 300;
		for (int i = 0; i < 8; ++i) {
			ballLst.add(new Ball(xPos, 600, 25, 25, f, p));
			xPos += 200;
		}

		bigBallLst.add(new Ball(f, p));

	}

	
	
	
}
