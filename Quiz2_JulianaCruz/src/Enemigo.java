import processing.core.PApplet;

public class Enemigo extends Personaje {

	private boolean derecha = true;
	private int velX;
	private int velY;
	private int vida;

	public Enemigo(PApplet app, int posX, int posY, int velX, int velY) {
		super(app, posX, posY);
		this.velX = velX;
		this.velY = velY;
		vida = 1;
	}

	@Override
	public void pintar() {
		app.fill(36, 247, 18);
		app.rect(posX, posY, 30, 30);
	}

	@Override
	public void movimiento() {

	}

	public void movimiento2() throws PerderExcepcion {
		if (posY <= 550) {

			if (derecha == true && posX < app.width - 10) {
				posX += velX;

			} else if (posX >= app.width - 10) {
				derecha = false;
				posY += velY;
			}
			if (derecha == false && posX > 18) {
				posX -= velX;
			} else if (posX <= 18) {
				derecha = true;
				posY += velY;
			}
		} else {
			throw new PerderExcepcion();
		}
	}

	public void run() {

		while (true) {
			try {
				movimiento2();

				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PerderExcepcion e) {
				e.printStackTrace();
			}
		}
	}

}
