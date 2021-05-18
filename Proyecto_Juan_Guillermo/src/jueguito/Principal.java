package jueguito;

import java.util.ArrayList;
import java.util.Scanner;

import personajes.*;

public class Principal {

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Object> clases = new ArrayList<Object>();

	public static void main(String[] args) {
		elegirClase();
		System.out.println(clases.get(0).toString());
		sc.close();
	} // Del main

	private static void elegirClase() {
		int opcion;
		System.out.println("¿Qué personaje quieres elegir?");
		System.out.println("\t1. Guerrero\n\t2. Mago\n\t3. Tanque");
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
		} // Del switch
	} // Del elegirClase
} // Del class