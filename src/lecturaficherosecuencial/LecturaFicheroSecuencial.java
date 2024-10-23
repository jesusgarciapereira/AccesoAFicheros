package lecturaficherosecuencial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaFicheroSecuencial {

	public static void main(String[] args) {

		File archivoCreado;

		// Archivo .txt que leeremos
		String textoPalabras = "C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\src\\lecturaficherosecuencial\\palabras.txt";

		// Declaracion del BufferedReader
		BufferedReader br;

		// Cada una de las lineas leidas del .txt
		String linea = "";

		String nuevaLinea = "";

		try {

			br = new BufferedReader(new FileReader(textoPalabras));

			linea = br.readLine();

			while (linea != null) {

				for (int i = 1; i < linea.length(); i++) {
					if (Character.isUpperCase(linea.charAt(i))) {

						nuevaLinea = linea.substring(0, i);
						
						linea = linea.substring(i);
						
						System.out.println(nuevaLinea);
					}
				}

				linea = br.readLine();
			}

			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
