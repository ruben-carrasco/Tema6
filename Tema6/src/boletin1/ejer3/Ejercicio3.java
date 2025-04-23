package boletin1.ejer3;

import java.io.*;

public class Ejercicio3 {
	public static void main(String[] args) {
		String[] datos = new String[3];
		String linea;
		int mediaEdad;
		int recuentoAlumnos = 0;
		double mediaEstatura;
		int sumaEdad = 0;
		double sumaEstatura = 0;

		System.out.println("Lista de Alumnos: ");

		try (BufferedReader in = new BufferedReader(new FileReader("src\\boletin1\\ejer3\\Alumnos.txt"))) {
			while ((linea = in.readLine()) != null) {
				datos = linea.split(" ");

				System.out.println("Nombre: " + datos[0]);

				sumaEdad += Integer.parseInt(datos[1]);
				sumaEstatura += Double.parseDouble(datos[2]);

				recuentoAlumnos++;

			}
			in.close();
		} catch (IOException e) {
			System.out.println("Error al escribir en el fichero: " + e.getMessage());
		}

		mediaEdad = sumaEdad / recuentoAlumnos;
		mediaEstatura = sumaEstatura / recuentoAlumnos;

		System.out.println();

		System.out.println("Media de edad: " + mediaEdad);
		System.out.println("Media de estatura: " + mediaEstatura);
	}

}
