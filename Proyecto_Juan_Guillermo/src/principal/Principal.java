package principal;

import java.text.DecimalFormat;
import java.util.*;
import combate.*;
import personajes.*;
import entradaSalida.*;

/**
 * Clase Principal.
 * 
 * @author Juan Cañadas Cañadillas
 * @author Guillermo González Martín
 * @version 1.0, 19/05/2021
 */
public class Principal {

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Object> clases = new ArrayList<Object>();
	private static boolean huir = true;
	private static String datosJugador;
	private static int contador = 1;
	private static EntradaSalida io = new EntradaSalida();

	public static void main(String[] args) {

		Enemigo enemigo = null;

		System.out.println("::::::::::: :::::::::: :::    ::: ::::::::::: :::::::::  :::::::::   ::::::::  \r\n"
				+ "    :+:     :+:        :+:    :+:     :+:     :+:    :+: :+:    :+: :+:    :+: \r\n"
				+ "    +:+     +:+         +:+  +:+      +:+     +:+    +:+ +:+    +:+ +:+        \r\n"
				+ "    +#+     +#++:++#     +#++:+       +#+     +#++:++#:  +#++:++#+  :#:        \r\n"
				+ "    +#+     +#+         +#+  +#+      +#+     +#+    +#+ +#+        +#+   +#+# \r\n"
				+ "    #+#     #+#        #+#    #+#     #+#     #+#    #+# #+#        #+#    #+# \r\n"
				+ "    ###     ########## ###    ###     ###     ###    ### ###         ########  \r\n" + "\r\n" + "");

		elegirClase();
		System.out.println("Esta es la clase que has elegido:\n\t" + clases.get(0).toString());

		enemigo = generarEnemigo();

		do {
			System.out.println();
			System.out.println("-----SE VA A COMENZAR EL COMBATE NÚMERO " + contador + "-----\n");
			System.out.println("Estadísticas del enemigo:\n\t" + enemigo.toString() + "\n");
			menuCombate(enemigo);
			if (huir) {
				contador++;
				subirNivel(contador, ((Base) clases.get(0)));
				System.out.println("¡Has subido al nivel! " + contador);
				System.out.println(clases.get(0).toString() + "\n");
				enemigo = generarEnemigo();
				subirNivel(contador, enemigo);
			} // Del if
		} while (huir); // Del do-while
		if (!huir) {
			exportarDatos();
		} // Del if
		sc.close();
	} // Del main

	/**
	 * Método que comprueba si un número introducido por teclado es o no un entero.
	 */
	private static void comprobarEntero() {
		while (!sc.hasNextInt()) {
			System.out.println("Eso no es un numero entero. Introduzca uno de nuevo: ");
			sc.next();
		} // Del while
	} // Del comprobarEntero

	/**
	 * Método que se encarga de crear un objeto de la clase Enemigo con unas
	 * estadísticas nuevas.
	 * 
	 * @return e - Enemigo ya generado.
	 */
	private static Enemigo generarEnemigo() {
		Enemigo e = new Enemigo();
		e.generarEstadisticas();
		return e;
	} // Del generarEnemigo

	/**
	 * Método que nos va a permitir elegir la clase de nuestro personaje y que la
	 * añadirá a una lista con la misma.
	 */
	private static void elegirClase() {
		int opcion;
		System.out.println("¿Qué personaje quieres elegir?");
		System.out
				.println("\t1. Guerrero\t|\t2. Mago\n\t-------------\t|\t-------------\n\t3. Tanque\t|\t4. Aleatorio");
		do {
			comprobarEntero();
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				Guerrero g = new Guerrero();
				g.generarEstadisticas();
				clases.add(g);
				imprimirAsci(clases.get(0));
				break;
			case 2:
				Mago m = new Mago();
				m.generarEstadisticas();
				clases.add(m);
				imprimirAsci(clases.get(0));
				break;
			case 3:
				Tanque t = new Tanque();
				t.generarEstadisticas();
				clases.add(t);
				imprimirAsci(clases.get(0));
				break;
			case 4:
				int min = 0, max = 2, aux;
				aux = (int) (min + (Math.random() * (max - min + 1)));
				if (aux == 0) {
					Guerrero gAux = new Guerrero();
					gAux.generarEstadisticas();
					clases.add(gAux);
					imprimirAsci(clases.get(0));
				} // Del if
				else if (aux == 1) {
					Mago mAux = new Mago();
					mAux.generarEstadisticas();
					clases.add(mAux);
					imprimirAsci(clases.get(0));
				} // Del else-if
				else {
					Tanque tAux = new Tanque();
					tAux.generarEstadisticas();
					clases.add(tAux);
					imprimirAsci(clases.get(0));
				} // Del else
				break;
			default:
				System.out.println("Error, elija una opcion correcta.");
				System.out.println("\t1. Guerrero\n\t2. Mago\n\t3. Tanque\n\t4. Aleatorio");
				break;
			} // Del switch
		} while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4); // Del do-while
	} // Del elegirClase

	/**
	 * Método creado para no repetir todo el rato el mismo código al mostrar las
	 * opciones.
	 */
	private static void mostrarRepeticion() {
		System.out.println("Elija que quiere hacer: ");
		System.out.println("\t1. Ataque físico.\n\t2. Ataque mágico.\n\t3. Huir del combate.");
	} // Del mostrarRepeticion

	/**
	 * Método en el cual se desarrolla el combate. Posee un menú con las diferentes
	 * opciones de combate.
	 * 
	 * @param enemigo Enemigo con el que combates.
	 */
	private static void menuCombate(Enemigo enemigo) {
		Combate combate = new Combate();
		int opcion;
		mostrarRepeticion();
		System.out.println();
		do {
			comprobarEntero();
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				combateFisico(combate, enemigo);
				break;
			case 2:
				combateMagico(combate, enemigo);
				break;
			case 3:
				System.out.println("Ha decidido huir.");
				huir = false;
				break;
			default:
				System.out.println("ERROR");
				mostrarRepeticion();
				System.out.println();
			} // Del switch
		} while (enemigo.getVida() > 0 && opcion != 3 && ((Base) clases.get(0)).getVida() > 0 && huir);
	} // Del menuCombate

	/**
	 * Método que desarrolla el combate si eliges "Ataque físico".
	 * 
	 * @param combate objeto que importas para poder utilizar los métodos de la
	 *                clase combate.
	 * @param enemigo enemigo con el que vas a combatir.
	 */
	private static void combateFisico(Combate combate, Enemigo enemigo) {
		if (combate.comprobarVelocidad(clases.get(0), enemigo)) {
			System.out.println("Somos más rápidos.");
			System.out.println("Turno aliado");
			combate.calcularDanioFisico(clases.get(0), enemigo);
			System.out.println("Vida restante del enemigo: " + mostrarDosDecimales(enemigo.getVida()) + "\n");
			if (enemigo.getVida() > 0) {
				System.out.println("Turno enemigo");
				calcularTipoDanioEnemigo(enemigo, combate);
				System.out.println(
						"Vida restante del personaje: " + mostrarDosDecimales(((Base) clases.get(0)).getVida()) + "\n");
				if (((Base) clases.get(0)).getVida() <= 0) {
					System.out.println("Has perdido.");
					exportarDatos();
					System.exit(0);
				} // Del if
				mostrarRepeticion();
			} // Del if
			else {
				System.out.println("El enemigo ha muerto, enhorabuena.");
				clases.add(enemigo);
			} // Del else
		} // Del if
		else {
			System.out.println("Somos mas lentos.");
			System.out.println("Turno enemigo");
			calcularTipoDanioEnemigo(enemigo, combate);
			System.out.println(
					"Vida restante del personaje: " + mostrarDosDecimales(((Base) clases.get(0)).getVida()) + "\n");
			if (((Base) clases.get(0)).getVida() > 0) {
				System.out.println("Turno aliado");
				combate.calcularDanioFisico(clases.get(0), enemigo);
				System.out.println("Vida restante del enemigo: " + mostrarDosDecimales(enemigo.getVida()) + "\n");
				if (enemigo.getVida() <= 0) {
					System.out.println("El enemigo ha muerto, enhorabuena.");
					clases.add(enemigo);
				} // Del if
				mostrarRepeticion();
			} // Del if
			else {
				System.out.println("Has perdido.");
				exportarDatos();
				System.exit(0);
			} // Del else
		} // Del else
	} // Del combateFisico

	/**
	 * Método que desarrolla el combate si eliges "Ataque mágico".
	 * 
	 * @param combate objeto que importas para poder utilizar los métodos de la
	 *                clase combate.
	 * @param enemigo enemigo con el que vas a combatir.
	 */
	private static void combateMagico(Combate combate, Enemigo enemigo) {
		if (combate.comprobarVelocidad(clases.get(0), enemigo)) {
			System.out.println("Somos más rápidos.");
			System.out.println("Turno aliado");
			combate.calcularDanioMagico(clases.get(0), enemigo);
			System.out.println("Vida restante del enemigo: " + mostrarDosDecimales(enemigo.getVida()) + "\n");
			if (enemigo.getVida() > 0) {
				System.out.println("Turno enemigo");
				calcularTipoDanioEnemigo(enemigo, combate);
				System.out.println(
						"Vida restante del personaje: " + mostrarDosDecimales(((Base) clases.get(0)).getVida()) + "\n");
				if (((Base) clases.get(0)).getVida() <= 0) {
					System.out.println("Has perdido.");
					exportarDatos();
					System.exit(0);
				} // Del if
				mostrarRepeticion();
			} // Del if
			else {
				System.out.println("El enemigo ha muerto, enhorabuena.");
				clases.add(enemigo);
			} // Del else
		} // Del if
		else {
			System.out.println("Somos mas lentos.");
			System.out.println("Turno enemigo");
			calcularTipoDanioEnemigo(enemigo, combate);
			System.out.println(
					"Vida restante del personaje: " + mostrarDosDecimales(((Base) clases.get(0)).getVida()) + "\n");
			if (((Base) clases.get(0)).getVida() > 0) {
				System.out.println("Turno aliado");
				combate.calcularDanioMagico(clases.get(0), enemigo);
				System.out.println("Vida restante del enemigo: " + mostrarDosDecimales(enemigo.getVida()) + "\n");
				if (enemigo.getVida() <= 0) {
					System.out.println("El enemigo ha muerto, enhorabuena.");
					clases.add(enemigo);
				} // Del if
				mostrarRepeticion();
			} // Del if
			else {
				System.out.println("Has perdido.");
				exportarDatos();
				System.exit(0);
			} // Del else
		} // Del else
	} // Del combateMagico

	/**
	 * Método por el cual el enemigo siempre atacará con el tipo de daño mas eficaz.
	 * 
	 * @param combate objeto que importas para poder utilizar los métodos de la
	 *                clase combate.
	 * @param enemigo enemigo con el que se calcula el daño.
	 */
	private static void calcularTipoDanioEnemigo(Enemigo enemigo, Combate combate) {
		if (enemigo.getAtaque() > enemigo.getMagia())
			combate.calcularDanioFisico(enemigo, clases.get(0));
		else
			combate.calcularDanioMagico(enemigo, clases.get(0));
	} // Del calcularTipoDanioEnemigo

	/**
	 * Método al cual le pasas por argumento un dato en double y te devuelve un
	 * String del mismo sólo con dos decimales.
	 * 
	 * @param dato dato que le mandas para darle formato.
	 * @return formato - String con el dato truncado.
	 */
	private static String mostrarDosDecimales(double dato) {
		DecimalFormat df = new DecimalFormat("##.##");
		String formato = df.format(dato);
		return formato;
	} // Del mostrarDosDecimales

	/**
	 * Método que sirve para subir de nivel tanto al personaje como al enemigo.
	 * 
	 * @param nivel Nivel de la ronda en la que estamos.
	 * @param aux   Personaje o enemigo al que queremos subir de nivel.
	 */
	private static void subirNivel(int nivel, Object aux) {
		if (aux instanceof Guerrero) {
			((Guerrero) aux).resetearEstadisticas();
			((Guerrero) aux).generarEstadisticas();
			((Guerrero) aux).aumentarEstadisticas(nivel);
		} // Del if
		else if (aux instanceof Mago) {
			((Mago) aux).resetearEstadisticas();
			((Mago) aux).generarEstadisticas();
			((Mago) aux).aumentarEstadisticas(nivel);
		} // Del else-if
		else if (aux instanceof Tanque) {
			((Tanque) aux).resetearEstadisticas();
			((Tanque) aux).generarEstadisticas();
			((Tanque) aux).aumentarEstadisticas(nivel);
		} // Del else-if
		else {
			((Enemigo) aux).aumentarEstadisticas(nivel + 0.2);
		} // Del else
	} // Del subirNivel

	/**
	 * Método que genera el String con los datos que luego escribiremos en el
	 * archivo de records.
	 * 
	 * @return datosJugador - String con el nombre, el número de rondas y el
	 *         personaje que ha utilizado el jugador.
	 */
	private static String pedirDatos() {
		String nombre;
		System.out.println("Escriba su nombre: ");
		nombre = sc.next();
		System.out.println();
		return datosJugador = "Jugador: " + nombre + "\tNúmero de rondas: " + (contador) + "\n\tPersonaje: "
				+ clases.get(0).toString() + "\n";
	} // Del pedirDatos

	/**
	 * Método que realiza la secuencia de acciones para escribir el fichero con los
	 * datos de los jugadores y posteriormente leerlo si es oportuno.
	 */
	private static void exportarDatos() {
		char respuesta;
		pedirDatos();
		io.escribir(datosJugador);
		System.out.println("¿Quiere revisar el histórico de jugadores? (S/N)");
		respuesta = sc.next().toUpperCase().charAt(0);
		System.out.println();
		if (respuesta == 'S') {
			System.out.println("Se va a proceder a leer el archivo");
			io.leer();
		} // Del if
		System.out.println("Fin del programa.");
		sc.close();
	} // Del exportarDatos

	/**
	 * Método que imprime un dibujo en ASCII de cada clase.
	 * 
	 * @param aux Objeto de tipo Base para saber que dibujo realizar.
	 * */
	private static void imprimirAsci(Object aux) {
		if (aux instanceof Guerrero) {
			System.out.println("Has elegido Guerrero");
			System.out.println("    _,.\r\n" + "    ,` -.)\r\n" + "   ( _/-\\\\-._\r\n"
					+ "  /,|`--._,-^|            ,\r\n" + "  \\_| |`-._/||          ,'|\r\n"
					+ "    |  `-, / |         /  /\r\n" + "    |     || |        /  /\r\n"
					+ "     `r-._||/   __   /  /\r\n" + " __,-<_     )`-/  `./  /\r\n" + "'  \\   `---'   \\   /  /\r\n"
					+ "    |           |./  /\r\n" + "    /           //  /\r\n" + "\\_/' \\         |/  /\r\n"
					+ " |    |   _,^-'/  /\r\n" + " |    , ``  (\\/  /_\r\n" + "  \\,.->._    \\X-=/^\r\n"
					+ "  (  /   `-._//^`\r\n" + "   `Y-.____(__}\r\n" + "    |     {__)\r\n" + "          ()");
		} // Del if
		else if (aux instanceof Mago) {
			System.out.println("Has elegido Mago");
			System.out.println("              _,-'|\r\n" + "           ,-'._  |\r\n" + " .||,      |####\\ |\r\n"
					+ "\\.`',/     \\####| |\r\n" + "= ,. =      |###| |\r\n" + "/ || \\    ,-'\\#/,'`.\r\n"
					+ "  ||     ,'   `,,. `.\r\n" + "  ,|____,' , ,;' \\| |\r\n" + " (3|\\    _/|/'   _| |\r\n"
					+ "  ||/,-''  | >-'' _,\\\\\r\n" + "  ||'      ==\\ ,-'  ,'\r\n" + "  ||       |  V \\ ,|\r\n"
					+ "  ||       |    |` |\r\n" + "  ||       |    |   \\\r\n" + "  ||       |    \\    \\\r\n"
					+ "  ||       |     |    \\\r\n" + "  ||       |      \\_,-'\r\n" + "  ||       |___,,--\")_\\\r\n"
					+ "  ||         |_|   ccc/\r\n" + "  ||        ccc/\r\n" + "  ||             ");
		} // Del else-if
		else {
			System.out.println("Has elegido Tanque");
			System.out.println("  ,   A           {}\r\n" + " / \\, | ,        .--.\r\n" + "|    =|= >      /.--.\\\r\n"
					+ " \\ /` | `       |====|\r\n" + "  `   |         |`::`|\r\n"
					+ "      |     .-;`\\..../`;_.-^-._\r\n" + "     /\\\\/  /  |...::..|`   :   `|\r\n"
					+ "     |:'\\ |   /'''::''|   .:.   |\r\n" + "      \\ /\\;-,/\\   ::  |..:::::..|\r\n"
					+ "      |\\ <` >  >._::_.| ':::::' |\r\n" + "      | `\"\"`  /   ^^  |   ':'   |\r\n"
					+ "      |       |       \\    :    /\r\n" + "      |       |        \\   :   /\r\n"
					+ "      |       |___/\\___|`-.:.-`\r\n" + "      |        \\_ || _/    `\r\n"
					+ "      |        <_ >< _>\r\n" + "      |        |  ||  |\r\n" + "      |        |  ||  |\r\n"
					+ "      |       _\\.:||:./_\r\n" + "      |      /____/\\____\\");
		} // Del else
	} // Del imprimirAsci
} // Del class