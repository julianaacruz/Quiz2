import processing.core.PApplet;

public class BalaJugador {
	private int posX;
	private int posY;
	private int velocidad;
	private PApplet app;

	public BalaJugador(PApplet app, int posX, int posY, int vel) {
		this.posX = posX;
		this.posY = posY;
		this.velocidad = vel;
		this.app = app;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void pintar() {
		app.fill(255);
		app.ellipse(posX+30, posY, 10, 10);
		
	}
	
	public void mover() {
		posY -= velocidad;

	}
}
