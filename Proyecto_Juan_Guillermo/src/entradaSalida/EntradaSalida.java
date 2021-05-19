package entradaSalida;

import java.io.*;
import java.util.*;

/**
 * Clase EntradaSalida utilizada para exportar los datos de los peronajes.
 * 
 * @author Juan Cañadas Cañadillas
 * @author Guillermo González Martín
 * @version 1.0, 19/05/2021
 */
public class EntradaSalida {

	/**
	 * Clase que escribe el nombre del jugador, las rondas jugadas y el personaje
	 * utilizado.
	 * 
	 * @param aux String con los datos
	 */
	public void escribir(String aux) {
		try {
			FileWriter escribir = new FileWriter("datosJugadores.txt", true);
			escribir.write(aux);
			escribir.close();
			System.out.println("Escrito correctamente.");
		} catch (IOException e) {
			System.out.println("Ha habido un problema.");
			e.printStackTrace();
		} // Del try-catch
	} // Del escribir

	/**
	 * Clase que lee el archivo de la tabla de records.
	 */
	public void leer() {
		try {
			File fichero = new File("datosJugadores.txt");
			Scanner leer = new Scanner(fichero);
			while (leer.hasNextLine()) {
				String datos = leer.nextLine();
				System.out.println(datos);
			} // Del while
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un problema.");
			e.printStackTrace();
		} // Del try-catch
	} // Del leer
} // Del class