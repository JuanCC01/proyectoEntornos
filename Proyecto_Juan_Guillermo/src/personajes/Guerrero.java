package personajes;

public class Guerrero extends Base {

	private String clase;

	public Guerrero() {
		super();
		clase = "Guerrero";
	}

	public String getclase() {
		return clase;
	}

	public void setclase(String clase) {
		this.clase = clase;
	}

	public double setMp() {
		return mp = getMp() * 0.75;
	}

	public double setAtaque() {
		return ataque = getAtaque() * 1.5;
	}

	public double setVida() {
		return vida = getVida() * 1.25;
	}

	public double setMagia() {
		return magia = getMagia() * 0.5;
	}

	public void subirNivel() {

	}

	public void setEstadisticas() {
		setMp();
		setVida();
		setAtaque();
		setMagia();
	}

	@Override
	public String toString() {
		return "Guerrero [clase=" + clase + ", vida=" + vida + ", mp=" + mp + ", ataque=" + ataque + ", defensa="
				+ defensa + ", magia=" + magia + ", velocidad=" + velocidad + "]";
	}
	
	
}