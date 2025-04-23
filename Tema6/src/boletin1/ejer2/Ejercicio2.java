package boletin1.ejer2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		int suma = 0;
		int media = 0;
		int contador = 0;
		int numero;

		try (Scanner in = new Scanner(new FileReader("src\\boletin1\\ejer2\\Enteros.txt"))) {
			while (in.hasNextInt()) {
				numero = in.nextInt();
				suma += numero;
				contador++;
			}

			media = suma / contador;

			in.close();
		} catch (IOException e) {
			System.out.println("Error al escribir en el fichero: " + e.getMessage());
		}

		System.out.println("Suma: " + suma + " Media: " + media);
	}

}
