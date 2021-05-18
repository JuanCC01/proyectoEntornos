package personajes;

public class Tanque extends Base {

	private String clase;

	public Tanque() {
		super();
		clase = "Tanque";
	}

	public String getclase() {
		return clase;
	}

	public void setclase(String clase) {
		this.clase = clase;
	}

	public double setMp() {
		return mp = getMp() * 0.5;
	}

	public double setAtaque() {
		return ataque = getAtaque() * 1.5;
	}

	public double setVida() {
		return vida = getVida() * 1.75;
	}

	public double setDefensa() {
		return defensa = getDefensa() * 1.5;
	}

	public double setMagia() {
		return magia = getMagia() * 0.5;
	}

	public double setVelocidad() {
		return velocidad = getVelocidad() * 0.75;
	}

	public void subirNivel() {

	}

	public void setEstadisticas() {
		setMp();
		setDefensa();
		setVida();
		setAtaque();
		setVelocidad();
		setMagia();
	}

	@Override
	public String toString() {
		return "Tanque [clase=" + clase + ", vida=" + vida + ", mp=" + mp + ", ataque=" + ataque + ", defensa="
				+ defensa + ", magia=" + magia + ", velocidad=" + velocidad + "]";
	}

}
