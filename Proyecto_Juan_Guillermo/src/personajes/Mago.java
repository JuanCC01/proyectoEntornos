package personajes;

public class Mago extends Base {

	private String clase;

	public Mago() {
		super();
		clase = "Mago";
	}

	public String getclase() {
		return clase;
	}

	public void setclase(String clase) {
		this.clase = clase;
	}

	public double setAtaque() {
		return ataque = getAtaque() * 0.75;
	}

	public double setMp() {
		return mp = getMp() * 1.5;
	}

	public double setDefensa() {
		return defensa = getDefensa() * 0.75;
	}

	public double setVelocidad() {
		return velocidad = getVelocidad() * 1.25;
	}

	public double setMagia() {
		return magia = getMagia() * 1.75;
	}

	public void subirNivel() {

	}
	
	public void setEstadisticas() {
		setDefensa();
		setMp();
		setAtaque();
		setMagia();
		setVelocidad();
	}
	
	@Override
	public String toString() {
		return "Mago [clase=" + clase + ", vida=" + vida + ", mp=" + mp + ", ataque=" + ataque + ", defensa="
				+ defensa + ", magia=" + magia + ", velocidad=" + velocidad + "]";
	}
	

}