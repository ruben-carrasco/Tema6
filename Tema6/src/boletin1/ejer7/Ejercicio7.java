package boletin1.ejer7;

import java.util.Scanner;
import java.io.*;

public class Ejercicio7 {
	public static String rutaAgenda = "src\\boletin1\\ejer7\\Agenda.txt";

	public static void main(String[] args) {
		int opt;
		String nombre;
		String telefono;
		String contacto;
		Scanner sc = new Scanner(System.in);

		do {
			menu();
			opt = sc.nextInt();
			System.out.println();
			sc.nextLine();

			// Leemos el fichero
			try (BufferedReader in = new BufferedReader(new FileReader(rutaAgenda))) {
				in.mark(10000);

				switch (opt) {
				case 1 -> {

					// Comprobamos que tiene menos de 20 lineas
					if (cuentaLineas(in) < 20) {

						do {
							// Pedimos un nombre
							System.out.println("Introduce el nombre del contacto: ");
							nombre = sc.nextLine();
						} while (compruebaNombre(nombre, in));

						// Pedimos el telefono
						System.out.println("Introduzca el telefono del contacto:");
						telefono = sc.nextLine();

						// Contacto completo
						contacto = nombre + " " + telefono;

						// Escribimos el contacto
						try (BufferedWriter inWriter = new BufferedWriter(new FileWriter(rutaAgenda, true))) {
							inWriter.write(contacto);
							inWriter.newLine();
							inWriter.flush();
							inWriter.close();

						}

						System.out.println("Añadido");

					} else {
						System.out.println("Agenda llena");
					}

					System.out.println();

				}
				case 2 -> {
					do {
						// Pedimos un nombre
						System.out.println("Introduce el nombre del contacto: ");
						nombre = sc.nextLine();
					} while (!compruebaNombre(nombre, in));
					
					System.out.println("Encontrado.");
					
				}
				case 3 -> {

				}
				case 4 -> {
					System.out.println("Saliendo...");
				}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} while (opt != 4);

		sc.close();
	}

	/**
	 * Metodo que comprueba si el nombre ay existe en la agenda
	 * 
	 * @param nombre
	 * @param in
	 * @return
	 * @throws IOException
	 */
	private static boolean compruebaNombre(String nombre, BufferedReader in) throws IOException {
		String linea;
		boolean nombreInsertado = false;
		String[] datos;

		// Revisamos linea por linea para ver si el nombre existe o no en la agenda
		while (!nombreInsertado && (linea = in.readLine()) != null) {
			// Separamos el nombre del telefono
			datos = linea.split(" ");
			if (nombre.equals(datos[0])) {
				nombreInsertado = true;
				System.out.println("Nombre ya agregado");
				System.out.println();
			}

			in.reset();
			;
		}
		return nombreInsertado;
	}

	/**
	 * Metodo que cuenta las lineas de la agenda
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static int cuentaLineas(BufferedReader in) throws IOException {
		int numeroLineas = 0;

		while (in.readLine() != null) {
			numeroLineas++;
		}

		in.reset();

		return numeroLineas;
	}

	/**
	 * Menu
	 */
	public static void menu() {
		System.out.println("1. Nuevo contacto.");
		System.out.println("2. Buscar por nombre.");
		System.out.println("3. Mostrar todos.");
		System.out.println("4. Salir.");
		System.out.println("Elige una opcion:");
	}
}
