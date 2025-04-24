package boletin1.ejer5;

import java.io.*;
import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		String nombre;
		int edad;
		Scanner reader = new Scanner(System.in);

		System.out.println("Introduce un nombre: ");
		nombre = reader.nextLine();

		System.out.println("Introduce una edad: ");
		edad = reader.nextInt();

		try (BufferedWriter in = new BufferedWriter(new FileWriter("src\\boletin1\\ejer5\\datos.txt", true))) {
			in.write(nombre + " " + edad);
			in.newLine();
			in.flush();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		reader.close();
	}

}
