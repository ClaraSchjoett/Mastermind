import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	Color ballColor;
	private int x;
	private int y;
	
	public Ball(int x, int y, Color ballColor){
		this.ballColor = ballColor;
		this.x = x;
		this.y = y;	
	}
	
	public void draw(Graphics g){
		int size = 35;
		g.setColor(ballColor);
		g.fillOval(x-(size/2), y-(size/2), size, size);
	}
	
}
