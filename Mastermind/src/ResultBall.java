import java.awt.Color;
import java.awt.Graphics;

public class ResultBall {
	Color ResultColor;
	private int x;
	private int y;
	
	public ResultBall(int x, int y, Color ResultColor){
		this.ResultColor = ResultColor;
		this.x = x;
		this.y = y;	
	}
	
	public void draw(Graphics g){
		int size = 15;
		g.setColor(ResultColor);
		g.fillOval(x-(size/2), y-(size/2), size, size);
	}
	
}