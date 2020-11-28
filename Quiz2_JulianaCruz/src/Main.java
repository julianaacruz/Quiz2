import processing.core.PApplet;

public class Main extends PApplet{

	Logica log; 
	public static void main(String[] args) {
		PApplet.main("Main");

	}
	
	public void settings() {

		size(500, 600);
	}

	public void setup() {
		log = new Logica(this);
		log.start();	
	}

	public void draw() {
		background(0);
		log.pintar();
	}

	public void keyPressed() {
		log.disparar();
		log.volverAJugar();
	}


}
