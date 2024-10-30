package lecturaficherosecuencial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LecturaFicheroSecuencial {

	public static void main(String[] args) {


		// Cada una de las lineas leidas del .txt
		String linea = "";
		// Nueva linea creada a partir de la lectura de la linea anterior
		String nuevaLinea = "";

		try {

			// Crea los nuevos ficheros con la direccion indicada
			File antiguoFicheroTxt = new File("C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\src\\lecturaficherosecuencial\\palabras.txt");
			File nuevoFicheroTxt = new File("C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\src\\lecturaficherosecuencial\\palabrasSeparadas.txt");

			// BufferReader que leera la linea del archivo que ya esta creado
			BufferedReader br = new BufferedReader(new FileReader(antiguoFicheroTxt));
			// BufferedWriter que escribira cada palabra separada
			BufferedWriter wr = new BufferedWriter(new FileWriter(nuevoFicheroTxt));

			// Lee la primera linea y la asigna en nuestro string
			linea = br.readLine();

			// Inicializamos un contador a 1, para no empezar con la primera letra (siempre
			// es mayuscula)
			int contador = 1;

			// Mientras la linea leida no sea null y el contador sea menor a la longitud de
			// la linea
			while (linea != null && contador < linea.length()) {

				// Si el caracter en el que se encuentra el contador es mayusculas
				if (Character.isUpperCase(linea.charAt(contador))) {

					// Asigna a nuevaLinea una palabra mediante el substring correspondiente
					nuevaLinea = linea.substring(0, contador);
					// Y ahora, a la linea que hemos leido le quitamos dicha palabra mediante otro
					// substring
					linea = linea.substring(contador);

					// Para observar por consola que se han separado las palabras correctamente
					// System.out.println(nuevaLinea);

					// Escribe la nueva linea en el archivo
					wr.write(nuevaLinea);
					// Salto de línea en el archivo, importante esto porque si no, te lo escribira
					// todo seguido y los dos archivos seran exactamente iguales
					wr.newLine();
					// Vaciamos el buffer de entrada
					wr.flush();

					// El contador volvera a ser 1
					contador = 1;
				}

				// Incrementa el contador
				contador++;

			}

			// Cerramos el BufferedReader y el BufferedWriter
			wr.close();
			br.close();

			// Manejo de excepción si el archivo no se encuentra en la ruta especificada
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// Manejo de excepción si ocurre un error al leer el archivo
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
