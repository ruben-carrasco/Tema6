package boletin1.ejer6;

import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class Ejercicio6 {
	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<>();
		String numero;
		
		try(BufferedReader in = new BufferedReader(new FileReader("src\\boletin1\\ejer6\\NumerosDesordenados.txt"))) {
			while ((numero = in.readLine()) != null) {
				numeros.add(Integer.parseInt(numero));
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Collections.sort(numeros);
		
		try(BufferedWriter in = new BufferedWriter(new FileWriter("src\\boletin1\\ejer6\\NumerosOrdenados.txt"))){
			for(int n : numeros) {
				in.write(String.valueOf(n));
				in.newLine();
			}
			in.flush();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
