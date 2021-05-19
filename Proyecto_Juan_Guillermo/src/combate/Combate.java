package combate;

import personajes.*;

public class Combate {

	public boolean comprobarVelocidad(Object o1, Object o2) {
		boolean vasPrimero = false;
		if (((Base) o1).getVelocidad() >= ((Base) o1).getVelocidad()) {
			vasPrimero = true;
		} // Del if
		return vasPrimero;
	} // Del comprobarVelocidad

	public void calcularDanio(Object atacante, Object defensor) {
		double vidaRestante = 0;
		if (atacante instanceof Mago) {
			vidaRestante = ((Enemigo) defensor).getVida()
					- (((Mago) atacante).getMagia() - ((Enemigo) defensor).getDefensa());
			((Enemigo) defensor).setVida(vidaRestante);
		} // Del if
		else if (atacante instanceof Guerrero) {
			vidaRestante = ((Enemigo) defensor).getVida()
					- (((Guerrero) atacante).getAtaque() - ((Enemigo) defensor).getDefensa());
			((Enemigo) defensor).setVida(vidaRestante);
		} // Del else-if
		else if (atacante instanceof Tanque) {
			vidaRestante = ((Enemigo) defensor).getVida()
					- (((Tanque) atacante).getAtaque() - ((Enemigo) defensor).getDefensa());
			((Enemigo) defensor).setVida(vidaRestante);
		} // Del else-if
		else {
			vidaRestante = ((Base) defensor).getVida()
					- (((Enemigo) atacante).getAtaque() - ((Base) defensor).getDefensa());
			((Base) defensor).setVida(vidaRestante);
		} // Del else
	} // Del calcularDanio
} // Del class