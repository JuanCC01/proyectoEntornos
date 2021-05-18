package personajes;

public class Enemigo extends Base {

	private String nombre;

	public Enemigo() {
		super();
		nombre = "Enemigo";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double setVida() {
		double min = (getVida() * 85) / 100;
		double max = (getVida() * 115) / 100;
		double aux = min + (Math.random() * (max - min));
		return vida = Math.round(aux * 100.00) / 100.00;
	}

	public double setMp() {
		double min = (getMp() * 85) / 100;
		double max = (getMp() * 115) / 100;
		double aux = min + (Math.random() * (max - min));
		return mp = Math.round(aux * 100.00) / 100.00;
	}

	public double setAtaque() {
		double min = (getAtaque() * 85) / 100;
		double max = (getAtaque() * 115) / 100;
		double aux = min + (Math.random() * (max - min));
		return ataque = Math.round(aux * 100.00) / 100.00;
	}

	public double setDefensa() {
		double min = (getDefensa() * 85) / 100;
		double max = (getDefensa() * 115) / 100;
		double aux = min + (Math.random() * (max - min));
		return defensa = Math.round(aux * 100.00) / 100.00;
	}

	public double setMagia() {
		double min = (getMagia() * 85) / 100;
		double max = (getMagia() * 115) / 100;
		double aux = min + (Math.random() * (max - min));
		return magia = Math.round(aux * 100.00) / 100.00;
	}

	public double setVelocidad() {
		double min = (getVelocidad() * 85) / 100;
		double max = (getVelocidad() * 115) / 100;
		double aux = min + (Math.random() * (max - min));
		return velocidad = Math.round(aux * 100.00) / 100.00;
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
		return "Enemigo [nombre=" + nombre + ", vida=" + vida + ", mp=" + mp + ", ataque=" + ataque + ", defensa="
				+ defensa + ", magia=" + magia + ", velocidad=" + velocidad + "]";
	}

} // Del class