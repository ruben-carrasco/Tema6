package boletin1.ejer7;

import java.util.Scanner;
import java.util.TreeMap;
import java.io.*;

public class Ejercicio7 {
	public static String rutaAgenda = "src\\boletin1\\ejer7\\Agenda.txt";

	public static void main(String[] args) {
		int opt;
		String nombre = "";
		Integer telefono;
		String contacto;
		Scanner sc = new Scanner(System.in);
		TreeMap<String, Integer> contactos = new TreeMap<>();

		cargaListaContactos(contactos);

		do {
			menu();
			opt = sc.nextInt();

			sc.nextLine();

			switch (opt) {
			case 1 -> {

				if (contactos.size() <= 20) {
					System.out.println("Introduzca el nombre del contacto: ");
					nombre = sc.nextLine();

					while (contactos.containsKey(nombre)) {
						System.out.println("El nombre ya existe");
						System.out.println("Introduzca otro nombre para el contacto: ");
						nombre = sc.nextLine();
					}

					System.out.println("Introduzca el telefono para el contacto: ");
					telefono = sc.nextInt();

					contactos.put(nombre, telefono);
				} else {
					System.out.println("La agenda está completa.");
				}

			}
			case 2 -> {
				System.out.println("Introduzca el nombre del contacto: ");
				nombre = sc.nextLine();

				while (!contactos.containsKey(nombre)) {
					System.out.println("El nombre no existe");
					System.out.println("Introduzca otro nombre para el contacto: ");
					nombre = sc.nextLine();
				}

				System.out.println("Telefono del contacto: " + contactos.get(nombre));
			}
			case 3 -> {
				for (String n : contactos.keySet()) {
					System.out.println(n + " " + contactos.get(n));
				}
			}
			case 4 -> {
				guardaListaContactos(contactos);
				System.out.println("Saliendo...");
			}
			}
		} while (opt != 4);

		sc.close();
	}

	public static void cargaListaContactos(TreeMap<String, Integer> contactos) {
		String[] datos = new String[2];
		String linea;

		// Rellena la lista
		try (BufferedReader reader = new BufferedReader(new FileReader(rutaAgenda))) {
			while ((linea = reader.readLine()) != null) {
				datos = linea.split(" ");
				contactos.put(datos[0], Integer.parseInt(datos[1]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void guardaListaContactos(TreeMap<String, Integer> contactos) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaAgenda))) {
			for (String n : contactos.keySet()) {
				writer.write(n + ": " + contactos.get(n));
				writer.newLine();
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
