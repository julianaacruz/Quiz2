import processing.core.PApplet;

public abstract class Personaje extends Thread{

	protected volatile int posX;
	protected volatile int posY;
	protected int vida;
	protected PApplet app;
	
	public Personaje(PApplet app, int posX,int posY) {
	this.posX=posX;
	this.posY=posY;
	this.app=app;
	vida=1;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public abstract void pintar();

	public abstract void movimiento();
	
}
