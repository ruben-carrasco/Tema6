package boletin1.ejer4;

import java.io.*;
import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		String cadena;
		Scanner reader = new Scanner(System.in);

		try (BufferedWriter in = new BufferedWriter(new FileWriter("src\\boletin1\\ejer4\\CadenasTexto.txt"))) {
			System.out.println("Introduzca una cadena de texto: ");
			cadena = reader.nextLine();

			while (!cadena.equals("fin")) {
				in.write(cadena);
				
				in.newLine();
				
				System.out.println("Introduzca una cadena de texto: ");
				cadena = reader.nextLine();
			}

			in.flush();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
