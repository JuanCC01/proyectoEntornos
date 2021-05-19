package combate;

import personajes.*;

/**
 * Clase Combate en la cual se van a programas los métodos referidos al combate.
 * 
 * @author Juan Cañadas Cañadillas
 * @author Guillermo González Martín
 * @version 1.0, 19/05/2021
 */
public class Combate {

	/**
	 * Método que comprueba la prioridad de los turnos en función de la velocidad.
	 * 
	 * @param aliado Personaje con el que estamos jugando.
	 * @param enemigo Enemigo contra el que nos enfrentamos.
	 * @return vasPrimero - true si somos nosotros los más rárpidos, flase en caso
	 *         contrario.
	 */
	public boolean comprobarVelocidad(Object aliado, Object enemigo) {
		boolean vasPrimero = false;
		if (((Base) aliado).getVelocidad() >= ((Base) enemigo).getVelocidad()) {
			vasPrimero = true;
		} // Del if
		return vasPrimero;
	} // Del comprobarVelocidad

	/**
	 * Método que calcula la vida restante del defensor tras recibir un ataque
	 * físico.
	 * 
	 * @param atacante Personaje que ataca.
	 * @param defensor Personaje que defiende.
	 */
	public void calcularDanioFisico(Object atacante, Object defensor) {
		double vidaRestante = 0;
		double vidaActual = ((Base) defensor).getVida();
		vidaRestante = ((Base) defensor).getVida()
				- ((2 * ((Base) atacante).getAtaque()) - ((Base) defensor).getDefensa());
		if (vidaRestante > vidaActual)
			vidaRestante = vidaActual;
		((Base) defensor).setVida(vidaRestante);
	} // Del calcularDanioFisico

	/**
	 * Método que calcula la vida restante del defensor tras recibir un ataque
	 * mágico.
	 * 
	 * @param atacante Personaje que ataca.
	 * @param defensor Personaje que defiende.
	 */
	public void calcularDanioMagico(Object atacante, Object defensor) {
		double vidaRestante = 0;
		double vidaActual = ((Base) defensor).getVida();
		vidaRestante = ((Base) defensor).getVida()
				- ((2 * ((Base) atacante).getMagia()) - ((Base) defensor).getDefensa());
		if (vidaRestante > vidaActual)
			vidaRestante = vidaActual;
		((Base) defensor).setVida(vidaRestante);
	} // Del calcularDanioMagico
} // Del class