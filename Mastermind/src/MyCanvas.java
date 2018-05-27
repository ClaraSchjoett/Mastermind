import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

class MyCanvas extends Canvas {
	private static final long serialVersionUID = 1L;
	public Board mainBoard;	
	
	public static Color ballColor [] = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.MAGENTA};
	public static Color resultColor [] = {Color.BLACK, Color.WHITE};

	MyCanvas (Board mainBoard) {
		this.mainBoard = mainBoard; // Verbindung zu Frame.
	}	
	
	public void paint (Graphics g) {
			new Background(g);
			for (int i=0; i < 6; i++ ) {
				Ball BaseBall = new Ball(Board.xPosBase[i], Board.yPosBase, ballColor[i]);
				BaseBall.draw(g);
			}

		// Hier kommen die if-else und for schlaufen zum Zeichnen der Bälle hin. 
			for (int i=0; i<Board.PlayList.size(); i++) {
				Board.PlayList.get(i).draw(g);
			}
			
		// SelectFrame zeichnen
			Board.s.draw(g);
	}

}