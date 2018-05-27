import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Board extends Frame implements MouseListener {
	private static final long serialVersionUID = 1;
	public static boolean playBoard[][] = new boolean [4][9];  // Wo wurde schon ein Ball gesetzt?
	public int result[][] = new int [14][2]; 

	MyCanvas myBoard;  // Verbindung zu Zeichenfläche.
	static SelectFrame s = null;
	public static int baseSelect;
	
	public static ArrayList <Ball> PlayList = new ArrayList <Ball>();  //Liste mit den Punktobjekten. (Wo/Welche Farbe) 
	public static ArrayList <Ball> ResultList = new ArrayList <Ball>();  //Liste mit den Punktobjekten der Resultate. (Wo/Welche Farbe) 
	
	static public int xPosGame[]; 
	static public int yPosGame[];
	static public int xPosResult[];
	static public int yPosResult[];
	static public int xPosBase[];
	static public int yPosBase;

	
	static public int latestClickX;
	static public int latestClickY;
	
	public int Try = 0; // Versuch (Zeile)

	
	Board (String Title){
		super(Title);
		//Aktuelles Board erstellen und zeichnen
		myBoard = new MyCanvas(this);
		add(myBoard); 	// Bild zum Frame hinzufügen.
	    myBoard.addMouseListener(this);	// Der Liestener wird hier vor das Bild platziert. Sonst wäre das Bild im weg.    
		
		// Fenster schliessen:
		addWindowListener (new WindowAdapter() {	
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});	
	
		setSize(500, 946);			// Groesse des Frames.
		setVisible(true);    
	}
	
	// Hauptprogramm
	public static void main(String[] args) {
		initPositions(); // PositionsArrays befüllen
		new Board("Let's play Mastermind! by David & Clara");
		Code myCode = new Code();	
//		myCode.printInfo();
	}

	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {
		System.out.println("x = " + arg0.getX() + ", y = " + arg0.getY());

		latestClickX = arg0.getX();
		latestClickY = arg0.getY();
		
		// SelectFrame setzen wo Maus geklickt hat
		if ((arg0.getY() > yPosBase-20) && (arg0.getY() < yPosBase+20)){  // Wo muss der Rahmen gesetzt werden? 
			if ((arg0.getX() > xPosBase[0]-20) && (arg0.getX() < xPosBase[0]+20)) {	 // Position 0
				s = new SelectFrame(xPosBase[0], yPosBase);
				baseSelect = 0;
			}
			if ((arg0.getX() > xPosBase[1]-20) && (arg0.getX() < xPosBase[1]+20)) {	 // Position 1
				s = new SelectFrame(xPosBase[1], yPosBase);
				baseSelect = 1;
			}
			if ((arg0.getX() > xPosBase[2]-20) && (arg0.getX() < xPosBase[2]+20)) {	 // Position 2
				s = new SelectFrame(xPosBase[2], yPosBase);
				baseSelect = 2;
			}
			if ((arg0.getX() > xPosBase[3]-20) && (arg0.getX() < xPosBase[3]+20)) {	 // Position 3
				s = new SelectFrame(xPosBase[3], yPosBase);
				baseSelect = 3;
			}
			if ((arg0.getX() > xPosBase[4]-20) && (arg0.getX() < xPosBase[4]+20)) {	 // Position 4
				s = new SelectFrame(xPosBase[4], yPosBase);
				baseSelect = 4;
			}
			if ((arg0.getX() > xPosBase[5]-20) && (arg0.getX() < xPosBase[5]+20)) {	 // Position 5
				s = new SelectFrame(xPosBase[5], yPosBase);
				baseSelect = 5;
			}
		}
		

		int Turn = 0; // Spielzug in einem Versuch (4 auf einer Zeile)
		for (int i = 0; i < 4; i++) {	// vergangene Turns zählen.
		    if (playBoard[i][Try] == true) {
		    	Turn++;
		    }
		}
		
	    if (Turn > 3) {
	    	checkResult(Try);
	    	Try++;
	    	Turn = 0;
	    }
	    
	    if (Try > 8 ) {
	    	// TODO: Hier eine Anzeige auf Spielfeld einbauen.
	    	System.out.println("!!!Verloren!!!");
	    }
	    
		System.out.println("Try: " + Try);
		System.out.println("Turn: " + Turn);
		System.out.println("playBoard free:" + (playBoard[Turn][Try] != true));		
		System.out.println("playBoard: [" + playBoard[0][1] + playBoard[1][1] + playBoard[2][1] + playBoard[3][1] + "]");
		System.out.println("playBoard: [" + playBoard[0][0] + playBoard[1][0] + playBoard[2][0] + playBoard[3][0] + "]");
		

		if ((latestClickY > yPosGame[Try]-20) && (latestClickY < yPosGame[Try]+20)){
			if ((latestClickX > xPosGame[Turn]-20) && (latestClickX < xPosGame[Turn]+20) && (playBoard[Turn][Try] != true)) {		    
				setBall(Try, Turn);	
			}
		}
	
		myBoard.repaint();	// Nach jedem Mausklick muss neu gezeichnet werden, weil es Änderungen verursacht.
	}
	
	public static void setBall(int Try, int Turn) {
				PlayList.add(new Ball(xPosGame[Turn], yPosGame[Try], MyCanvas.ballColor[baseSelect]));
				playBoard[Turn][Try] = true;
	}

	public void checkResult(int Try) {
		// Beispiel platzieren Resultball ResultList.add(new Ball(xPosResult[i], yPosResult[Try], MyCanvas.resultColor[baseSelect]));
	}
	
	public static void initPositions() {
		// x-y Positionen Spielbrett
		xPosGame = new int [4];  // 4 Plätze reservieren
		for (int x=1 ; x<=3; x++) {
				xPosGame[0] = 171;
				xPosGame[x] = xPosGame[x-1] + 84;
			}
		yPosGame = new int [8];  // 7 Plätze reservieren
		for (int y=1 ; y<=7; y++) {
				yPosGame[0] = 766;
				yPosGame[y] = yPosGame[y-1] - 90;
		}
		
		// x-y Positionen Resultate
		xPosResult = new int [2];  // 2 Plätze reservieren
		xPosResult[0] = 171;
		xPosResult[1] = xPosResult[0] + 30;

		yPosResult = new int [16];  // 7 Plätze reservieren
		for (int y=1 ; y<=15; y++) {
				yPosResult[0] = 780;
				if ((y % 2) == 0) { // Wenn y gerade ist
				yPosResult[y] = yPosResult[y-1] - 29;
				} else {
				yPosResult[y] = yPosResult[y-1] - 60;	
				}
		}
		// x Positionen Farb-Basis
		xPosBase = new int [6];  // 6 Plätze reservieren
		for (int x=1 ; x<=5; x++) {
				xPosBase[0] = 86;
				xPosBase[x] = xPosBase[x-1] + 64;
		}
		yPosBase = 855;
	}
}

