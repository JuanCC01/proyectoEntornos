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

	private String nombreDirectorio = "records/";
	private String nombreFichero = "datosJugadores";

	/**
	 * Clase que escribe el nombre del jugador, las rondas jugadas y el personaje
	 * utilizado.
	 * 
	 * @param aux String con los datos
	 */
	public void escribir(String aux) {
		File directorio = new File(nombreDirectorio);
		if (!directorio.exists())
			directorio.mkdir();
		File archivo = new File(nombreDirectorio + nombreFichero + ".txt");
		try {
			FileWriter escribir = new FileWriter(archivo, true);
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
			File fichero = new File(nombreDirectorio + nombreFichero + ".txt");
			Scanner leer = new Scanner(fichero);
			int contadorLineas = 0, aux = 0;
			while (leer.hasNextLine()) {
				String datos = leer.nextLine();
				aux++;
				if (aux % 2 != 0) {
					contadorLineas++;
					System.out.print("Partida " + contadorLineas + ": ");
				} // Del if
				System.out.println("\t" + datos);
				if (aux % 2 == 0)
					System.out.print("\n");
			} // Del while
			leer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un problema.");
			e.printStackTrace();
		} // Del try-catch
	} // Del leer
} // Del class