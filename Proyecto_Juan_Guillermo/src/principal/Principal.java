package principal;

import java.util.*;
import combate.Combate;
import personajes.*;

public class Principal {

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Object> clases = new ArrayList<Object>();

	public static void main(String[] args) {

		Enemigo enemigo = null;

		elegirClase();
		System.out.println("Esta es la clase que has elegido:\n\t" + clases.get(0).toString());

		enemigo = generarEnemigo();
		System.out.println("Enemigo: " + enemigo.toString());

		System.out.println("Se va a comenzar el combate: ");
		menuCombate(enemigo);

		System.out.println(clases.get(0).toString());
		System.out.println(enemigo.toString());
		sc.close();
	} // Del main

	private static void comprobarEntero() {
		while (!sc.hasNextInt()) {
			System.out.println("Eso no es un numero entero. Introduzca uno de nuevo: ");
			sc.next();
		} // Del while
	} // Del comprobarEntero

	private static Enemigo generarEnemigo() {
		Enemigo e = new Enemigo();
		e.setEstadisticas();
		return e;
	} // Del generarEnemigo

	private static void elegirClase() {
		int opcion;
		System.out.println("¿Qué personaje quieres elegir?");
		System.out.println("\t1. Guerrero\n\t2. Mago\n\t3. Tanque");
		do {
			comprobarEntero();
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				Guerrero c = new Guerrero();
				c.setEstadisticas();
				clases.add(c);
				break;
			case 2:
				Mago m = new Mago();
				m.setEstadisticas();
				clases.add(m);
				break;
			case 3:
				Tanque t = new Tanque();
				t.setEstadisticas();
				clases.add(t);
				break;
			default:
				System.out.println("Error, elija una opcion correcta.");
				System.out.println("\t1. Guerrero\n\t2. Mago\n\t3. Tanque");
				break;
			} // Del switch
		} while (opcion != 1 && opcion != 2 && opcion != 3); // Del do-while
	} // Del elegirClase

	private static void menuCombate(Enemigo enemigo) {
		Combate combate = new Combate();
		int opcion;

		System.out.println("Elija que quiere hacer: ");
		System.out.println("\t1. Ataque físico.\n\t2. Ataque mágico.\n\t3. Huir del combate.");
		System.out.println();
		do {
			comprobarEntero();
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				if (combate.comprobarVelocidad(clases.get(0), enemigo)) {
					System.out.println("Somos mas rápidos!");
					combate.calcularDanioFisico(clases.get(0), enemigo);
					System.out.println("Vida restante del enemigo: " + enemigo.getVida());
					if (enemigo.getVida() > 0) {
						combate.calcularDanioFisico(enemigo, clases.get(0));
						System.out.println("Vida restante del personaje: " + ((Base) clases.get(0)).getVida());
						System.out.println("Elija que quiere hacer: ");
						System.out.println("\t1. Ataque físico.\n\t2. Ataque mágico.\n\t3. Huir del combate.");
					} // Del if
					else
						System.out.println("El enemigo ha muerto, enhorabuena.");
				} // Del if
				else {
					System.out.println("Somos mas lentos...");
					combate.calcularDanioFisico(enemigo, clases.get(0));
					System.out.println("Vida restante del personaje: " + ((Base) clases.get(0)).getVida());
					if (((Base) clases.get(0)).getVida() > 0) {
						combate.calcularDanioFisico(clases.get(0), enemigo);
						System.out.println("Vida restante del enemigo: " + enemigo.getVida());
						System.out.println("Elija que quiere hacer: ");
						System.out.println("\t1. Ataque físico.\n\t2. Ataque mágico.\n\t3. Huir del combate.");
					} // Del if
					else
						System.out.println("F.");
				} // Del else
				break;
			case 2:
				if (combate.comprobarVelocidad(clases.get(0), enemigo)) {
					System.out.println("Somos mas rapidos!");
					combate.calcularDanioMagico(clases.get(0), enemigo);
					System.out.println("Vida restante del enemigo: " + enemigo.getVida());
					if (enemigo.getVida() > 0) {
						combate.calcularDanioMagico(enemigo, clases.get(0));
						System.out.println("Vida restante del personaje: " + ((Base) clases.get(0)).getVida());
						System.out.println("\t1. Ataque físico.\n\t2. Ataque mágico.\n\t3. Huir del combate.");
					} // Del if
					else
						System.out.println("El enemigo ha muerto, enhorabuena.");
				} // Del if
				else {
					System.out.println("Somos mas lentos...");
					combate.calcularDanioMagico(enemigo, clases.get(0));
					System.out.println("Vida restante del personaje: " + ((Base) clases.get(0)).getVida());
					if (((Base) clases.get(0)).getVida() > 0) {
						combate.calcularDanioMagico(clases.get(0), enemigo);
						System.out.println("Vida restante del enemigo: " + enemigo.getVida());
						System.out.println("\t1. Ataque físico.\n\t2. Ataque mágico.\n\t3. Huir del combate.");
					} // Del if
					else
						System.out.println("F.");
				} // Del else
				break;
			case 3:
				System.out.println("Ha decidido huir.");
				break;
			default:
				System.out.println("Error. elija una opción correcta:");
				System.out.println("\t1. Ataque físico.\n\t2. Ataque mágico.\n\t3. Huir del combate.");
				System.out.println();
			} // Del switch
		} while (enemigo.getVida() > 0 && opcion != 3 && ((Base) clases.get(0)).getVida() > 0);
	} // Del menuCombate
} // Del class