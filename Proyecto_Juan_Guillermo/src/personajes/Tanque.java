package personajes;

/**
 * Clase de personaje Tanque que nos permite crear objetos tanque y establecer
 * todas sus estadísticas.
 * 
 * @author Juan Cañadas Cañadillas
 * @author Guillermo González Martín
 * @version 1.0, 19/05/2021
 */
public class Tanque extends Base {

	private String clase;

	/**
	 * Constructor que recibe los valores de la clase padre.
	 */
	public Tanque() {
		super();
		clase = "Tanque";
	} // Del constructor

	/**
	 * Método que devuelve la clase.
	 * 
	 * @retun clase - la clase del personaje.
	 */
	public String getClase() {
		return clase;
	} // Del getClase

	/**
	 * Método que nos permite modificar la clase del personaje.
	 * 
	 * @param clase clase ala cual lo quieres cambiar.
	 */
	public void setClase(String clase) {
		this.clase = clase;
	} // Del setClase

	/**
	 * Método que modifica el valor base de los puntos mágicos.
	 * 
	 * @return mp - puntos mágicos modificados.
	 */
	public double modificarMp() {
		return mp = getMp() * 0.5;
	} // Del modificarMp

	/**
	 * Método que modifica el valor base del ataque.
	 * 
	 * @return ataque - ataque modificado.
	 */
	public double modificarAtaque() {
		return ataque = getAtaque() * 1.25;
	} // Del modificarAtaque

	/**
	 * Método que modifica el valor base de la vida.
	 * 
	 * @return vida - vida modificada.
	 */
	public double modificarVida() {
		return vida = getVida() * 1.5;
	} // Del modificarVida

	/**
	 * Método que modifica el valor base de la defensa.
	 * 
	 * @return defensa - defensa modificada.
	 */
	public double modificarDefensa() {
		return defensa = getDefensa() * 1.5;
	} // Del modificarDefensa

	/**
	 * Método que modifica el valor base de la magia.
	 * 
	 * @return magia - magia modificada.
	 */
	public double modificarMagia() {
		return magia = getMagia() * 0.5;
	} // Del modificarMagia

	/**
	 * Método que modifica el valor base de la velocidad.
	 * 
	 * @return velocidad - velocidad modificada.
	 */
	public double modificarVelocidad() {
		return velocidad = getVelocidad() * 0.75;
	} // Del modificarVelocidad

	/**
	 * Método que llama al resto de métodos para modificar todas las estadísticas.
	 */
	public void generarEstadísticas() {
		modificarMp();
		modificarDefensa();
		modificarVida();
		modificarAtaque();
		modificarVelocidad();
		modificarMagia();
	} // Del generarEstadísticas

	@Override
	public String toString() {
		return "Tanque [clase=" + clase + ", vida=" + vida + ", mp=" + mp + ", ataque=" + ataque + ", defensa="
				+ defensa + ", magia=" + magia + ", velocidad=" + velocidad + "]";
	} // Del toString
} // Del class