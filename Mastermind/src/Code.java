import java.awt.Color;
import java.util.Random;

public class Code {
	protected Color CodeColor0;
	protected Color CodeColor1;
	protected Color CodeColor2;
	protected Color CodeColor3;
	
	Code(){
		Random r0 = new Random();
		Random r1 = new Random();
		Random r2 = new Random();
		Random r3 = new Random();
		CodeColor0 = MyCanvas.ballColor[r0.nextInt(5)];
		CodeColor1 = MyCanvas.ballColor[r1.nextInt(5)];
		CodeColor2 = MyCanvas.ballColor[r2.nextInt(5)];
		CodeColor3 = MyCanvas.ballColor[r3.nextInt(5)];
	}
	
	public void printInfo() {
		System.out.println("Color 0: " + CodeColor0);
		System.out.println("Color 1: " + CodeColor1);
		System.out.println("Color 2: " + CodeColor2);
		System.out.println("Color 3: " + CodeColor3);
	}
}