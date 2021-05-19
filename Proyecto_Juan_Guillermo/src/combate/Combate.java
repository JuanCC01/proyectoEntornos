package combate;

import personajes.*;

public class Combate {

	public boolean comprobarVelocidad(Object aliado, Object enemigo) {
		boolean vasPrimero = false;
		if (((Base) aliado).getVelocidad() >= ((Base) enemigo).getVelocidad()) {
			vasPrimero = true;
		} // Del if
		return vasPrimero;
	} // Del comprobarVelocidad

	public void calcularDanioFisico(Object atacante, Object defensor) {
		double vidaRestante = 0;
		vidaRestante = ((Base) defensor).getVida()
				- ((2 * ((Base) atacante).getAtaque()) - ((Base) defensor).getDefensa());
		((Base) defensor).setVida(vidaRestante);
	} // Del calcularDanioFisico

	public void calcularDanioMagico(Object atacante, Object defensor) {
		double vidaRestante = 0;
		vidaRestante = ((Base) defensor).getVida()
				- ((2 * ((Base) atacante).getMagia()) - ((Base) defensor).getDefensa());
		((Base) defensor).setVida(vidaRestante);
	} // Del calcularDanioMagico
} // Del class