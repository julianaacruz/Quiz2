import processing.core.PApplet;

public class Jugador extends Personaje {

	protected int puntuacion;

	public Jugador(PApplet app, int posX, int posY, int puntuacion) {
		super(app, posX, posY);
		this.puntuacion = puntuacion;
	}

	public int darPuntuacion() {
		return puntuacion;
	}

	public void matarlo() {
		vida = 0;
	}
	

	public void aumentarPuntuacion() {
		puntuacion +=1;
	}

	@Override
	public void pintar() {

		app.fill(255);
		app.rect(posX,posY,50,50);
		
	}

	@Override
	public void movimiento() {
		if (app.keyCode == PApplet.RIGHT) {
			if (posX > 0 && posX < 500) {
				app.smooth();
				posX += 10;

			} else {
				posX = app.width - 30;
			}
		}

		if (app.keyCode == PApplet.LEFT) {
			if (posX > 0 && posX < 500) {

				app.smooth();
				posX -= 10;

			} else {
				posX = 30;
			}
		}

	}

}
