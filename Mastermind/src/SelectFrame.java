import java.awt.Color;
import java.awt.Graphics;

public class SelectFrame {
	private int x;
	private int y;
	
	public SelectFrame(int x, int y){
		this.x = x;
		this.y = y;	
	}
	
	public void draw(Graphics g){
		int size = 50;
		g.setColor(Color.yellow);
		g.drawRoundRect(x-(size/2), y-(size/2), size, size, 15, 15);
	}
	
}