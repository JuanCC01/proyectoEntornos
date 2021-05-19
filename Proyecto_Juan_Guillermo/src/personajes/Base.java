package personajes;

/**
 * Clase Base para que hereden el resto de personajes. Guarda las estadísticas
 * bases de todos.
 * 
 * @author Juan Cañadas Cañadillas
 * @author Guillermo González Martín
 * @version 1.0, 19/05/2021
 */
public class Base {

	protected double vida, mp, ataque, defensa, magia, velocidad;

	/**
	 * Constructor de la clase. Inicializa todas las estadísticas base.
	 */
	public Base() {
		vida = 25.0;
		mp = 25.0;
		ataque = 10;
		defensa = 10;
		magia = 10;
		velocidad = 3;
	} // Del General

	/**
	 * Método que devuelve el valor de la vida.
	 * 
	 * @return vida - vida del personaje.
	 */
	public double getVida() {
		return vida;
	} // Del getVida

	/**
	 * Método que nos permite modificar la vida del personaje.
	 * 
	 * @param vida vida que queremos modificar.
	 */
	public void setVida(double vida) {
		this.vida = vida;
	} // Del setVida

	/**
	 * Método que devuelve el valor de los mp.
	 * 
	 * @return mp - mp del personaje.
	 */
	public double getMp() {
		return mp;
	} // Del getMp

	/**
	 * Método que nos permite modificar los mp del personaje.
	 * 
	 * @param mp mp que queremos modificar.
	 */
	public void setMp(double mp) {
		this.mp = mp;
	} // Del setMp

	/**
	 * Método que devuelve el valor del ataque.
	 * 
	 * @return ataque - ataque del personaje.
	 */
	public double getAtaque() {
		return ataque;
	} // Del getAtaque

	/**
	 * Método que nos permite modificar el ataque del personaje.
	 * 
	 * @param ataque ataque que queremos modificar.
	 */
	public void setAtaque(double ataque) {
		this.ataque = ataque;
	} // Del setAtaque

	/**
	 * Método que devuelve el valor de la defensa.
	 * 
	 * @return defensa - defensa del personaje.
	 */
	public double getDefensa() {
		return defensa;
	} // Del getDefensa

	/**
	 * Método que nos permite modificar la defensa del personaje.
	 * 
	 * @param defensa defensa que queremos modificar.
	 */
	public void setDefensa(double defensa) {
		this.defensa = defensa;
	} // Del setDefensa

	/**
	 * Método que devuelve el valor de la magia.
	 * 
	 * @return magia - magia del personaje.
	 */
	public double getMagia() {
		return magia;
	} // Del getMagia

	/**
	 * Método que nos permite modificar la magia del personaje.
	 * 
	 * @param magia magia que queremos modificar.
	 */
	public void setMagia(double magia) {
		this.magia = magia;
	} // Del setMagia

	/**
	 * Método que devuelve el valor de la velocidad.
	 * 
	 * @return velocidad - velocidad del personaje.
	 */
	public double getVelocidad() {
		return velocidad;
	} // Del getVelocidad

	/**
	 * Método que nos permite modificar la velocidad del personaje.
	 * 
	 * @param velocidad velocidad que queremos modificar.
	 */
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	} // Del setVelocidad

	public void resetearEstadisticas() {
		vida = 25.0;
		mp = 25.0;
		ataque = 10;
		defensa = 10;
		magia = 10;
		velocidad = 3;
	} // Del resetearEstadisticas

	public void aumentarEstadisticas(int nivel) {
		vida = getVida() * nivel;
		mp = getMp() * nivel;
		ataque = getAtaque() * nivel;
		defensa = getDefensa() * nivel;
		magia = getMagia() * nivel;
		velocidad = getVelocidad() * nivel;
	} // Del aumentarEstadisticas
} // Del class