import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
	//Bild einlesen
	static Image BoardJPG = null;
	
	Background(Graphics g){
	    File f = null;
	    try{
	    	f = new File("src//Feld.jpg");   //image file path
	    	BoardJPG = ImageIO.read(f);
	    	System.out.println("Reading complete.");   
	    } catch(IOException e) {
	    	System.out.println("Error: "+e);
	    }
	    g.drawImage(BoardJPG, 0, 0, 500, 900, null);	
	}
}