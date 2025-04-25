package boletin1.ejer8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio8 {
	public static String rutaTemperaturas = "src\\boletin1\\ejer8\\RegistroTemperaturas.txt";

	public static void main(String[] args) {
		String fecha;
		int tempMinima;
		int tempMaxima;
		int minTempMinima = Integer.MAX_VALUE;
		int maxTempMaxima = Integer.MIN_VALUE;
		int opt;
		String[] datos = new String[3];
		Scanner sc = new Scanner(System.in);
		ArrayList<String> registros = new ArrayList<>();

		cargaListaTemperaturas(registros);

		do {
			menu();
			opt = sc.nextInt();

			sc.nextLine();

			switch (opt) {
			case 1 -> {
				System.out.println("Introduzca la fecha: ");
				fecha = sc.nextLine();

				System.out.println("Introduzca la temperatura maxima: ");
				tempMinima = sc.nextInt();

				System.out.println("Introduzca la temperatura minima: ");
				tempMaxima = sc.nextInt();

				registros.add(fecha + "," + tempMinima + "," + tempMaxima);
			}
			case 2 -> {
				for (String registro : registros) {
					System.out.println(registro);
					datos = registro.split(",");
					if (registro.equals("Fecha,Temperatura máxima,Temperatura mínima")) {
						continue;
					}
					if (Integer.parseInt(datos[1]) > maxTempMaxima) {
						maxTempMaxima = Integer.parseInt(datos[1]);
					}
					if (Integer.parseInt(datos[2]) < minTempMinima) {
						minTempMinima = Integer.parseInt(datos[2]);
					}
				}
				System.out.println("Temperatura Maxima Historica: " + maxTempMaxima + " Temperatura Minima Historica: "
						+ minTempMinima);

			}
			case 3 -> {
				guardaListaRegistros(registros);
				System.out.println("Saliendo...");
			}
			}

		} while (opt != 3);

		sc.close();
	}

	public static void cargaListaTemperaturas(ArrayList<String> registros) {
		String linea;

		// Rellena la lista
		try (BufferedReader reader = new BufferedReader(new FileReader(rutaTemperaturas))) {
			while ((linea = reader.readLine()) != null) {
				registros.add(linea);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void guardaListaRegistros(ArrayList<String> registros) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaTemperaturas))) {
			for (String registro : registros) {
				writer.write(registro);
				writer.newLine();
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void menu() {
		System.out.println("1. Registra nueva temperatura.");
		System.out.println("2. Mostrar historial de registros.");
		System.out.println("3. Salir.");
		System.out.println("Introduzca una opción: ");
	}

}
