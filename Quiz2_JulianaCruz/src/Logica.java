import java.util.ArrayList;


import processing.core.PApplet;

public class Logica extends Thread {

	private PApplet app;
	private ArrayList<Personaje> personajes;
	private ArrayList<BalaJugador> balasJugador;

	public Logica(PApplet app) {
		this.app = app;

		crearPersonajes();
		balasJugador = new ArrayList<BalaJugador>();
	}

	public void crearPersonajes() {
		personajes = new ArrayList<Personaje>();

		personajes.add(new Jugador(app, app.width / 2, 500, 0));
		
		for (int i = 0; i < 12; i++) {
			Enemigo n = new Enemigo(app, (i * 40), 100, 5, 50);
			personajes.add(n);
			n.start();	
		}
	}

	public void pintar() {
		pintarPersonajes();
		pintarBalasUsuario();
		app.fill(255);
		app.textSize(18);
		
		app.text("Puntaje: "+((Jugador) personajes.get(0)).darPuntuacion(),50,50);
		
		app.text("Presiona R para volver a jugar",50,70);
	}

	public void pintarPersonajes() {

		for (int i = 0; i < personajes.size(); i++) {
			if (personajes.get(i) instanceof Jugador) {
				personajes.get(i).pintar();
			} else if (personajes.get(i) instanceof Enemigo) {
				personajes.get(i).pintar();
			}
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
			//	System.out.println("hola");
				for (int i = 0; i < personajes.size(); i++) {
					personajes.get(i).movimiento();
				}
				if (balasJugador.size() != 0) {
					for (int j = 0; j < balasJugador.size(); j++) {
                        balasJugador.get(j).mover();
					}
				}
				
				validarAtaqueAlien();
				ganador();
				sleep(100);
			} catch (InterruptedException e) {
				// e.printStackTrace();
			} catch (GanarExcepcion e) {
				e.printStackTrace();
			}
		}
	}

	public void disparar() {
		for (int i = 0; i < personajes.size(); i++) {
			if (personajes.get(i) instanceof Jugador) {
				if (app.keyCode == 32) {
					//System.out.println("cree bala");

					if (balasJugador.size() < 20) {
						balasJugador
								.add(new BalaJugador(app, personajes.get(i).getPosX(), personajes.get(i).getPosY(), 6));
					}
				}

			}
		}
	}


	public void pintarBalasUsuario() {
		for (int j = 0; j < balasJugador.size(); j++) {
			balasJugador.get(j).pintar();
			if (balasJugador.get(j).getPosY() <= -1) {
				balasJugador.remove(j);
			}
		}

	}
	
	public void validarAtaqueAlien() {
		for (int i = 0; i < balasJugador.size(); i++) {
			boolean choco = false;
			for (int j = 0; j < personajes.size() && !choco; j++) {
				if (personajes.get(j) instanceof Enemigo) {
					if (PApplet.dist(balasJugador.get(i).getPosX(), balasJugador.get(i).getPosY(),
							personajes.get(j).getPosX(), personajes.get(j).getPosY()) < 20) {
						choco = true;

						personajes.remove(j);
						balasJugador.remove(i);
						
						((Jugador) personajes.get(0)).aumentarPuntuacion();

					}
				}
			}
		}
	}
	
	public void ganador() throws GanarExcepcion{
	if(((Jugador) personajes.get(0)).darPuntuacion()==12) {
		throw new GanarExcepcion();
	}
		
	}
	
	public void volverAJugar() {
		if (app.keyCode == 82) {
			app.setup();
		}
		
	}
}
