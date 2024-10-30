package lecturaficheroaleatorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LecturaFicheroAleatorio {

	public static void main(String[] args) {
		
		// ArrayList en el que guardaremos un listado de paplabras, para luego ordenarlo
		List<String> listadoPalabras = new ArrayList<String>();

		// Cada una de las lineas leidas del .txt
		String linea = "";
		// Palabra extraida a partir de la lectura de la linea anterior
		String palabraExtraida = "";

		try {

			// Crea los nuevos ficheros con la direccion indicada
			File antiguoFicheroTxt = new File("C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\src\\lecturaficheroaleatorio\\palabras.txt");
			File nuevoFicheroTxt = new File("C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\src\\lecturaficheroaleatorio\\palabrasOrdenadas.txt");

			// BufferReader que leera la linea del archivo que ya esta creado
			BufferedReader br = new BufferedReader(new FileReader(antiguoFicheroTxt));
			// BufferedWriter que escribira cada palabra separada
			BufferedWriter wr = new BufferedWriter(new FileWriter(nuevoFicheroTxt));

			// Lee la primera linea y la asigna en nuestro string
			linea = br.readLine();

			// Inicializamos un contador a 1, para no empezar con la primera letra (siempre
			// es mayuscula)
			int contador = 1;

			// Mientras la linea leiada no sea null y el contador sea menor a la longitud de
			// la linea
			while (linea != null && contador < linea.length()) {

				// Si el caracter en el que se encuentra el contador es mayusculas
				if (Character.isUpperCase(linea.charAt(contador))) {

					
					// Asigna a palabraExtraida una palabra mediante el substring correspondiente
					palabraExtraida = linea.substring(0, contador);
					// Y la anniade a nuestra lista
					listadoPalabras.add(palabraExtraida);
					
					// Y ahora, a la linea que hemos leido le quitamos dicha palabra mediante otro
					// substring
					linea = linea.substring(contador);

					// El contador volvera a ser 1
					contador = 1;
				}

				// Incrementa el contador
				contador++;

			}
			
			// Ordenamos alfabeticamente las palabras de nuestra lista
			listadoPalabras.sort(null);
			
			// Bucle for que recorrera cada elemento de listadoPalabras
			for (int i = 0; i < listadoPalabras.size(); i++) {
				// Escribe cada palabra en el archivo
				wr.write(listadoPalabras.get(i));
				// Salto de línea en el archivo, importante esto porque si no, te lo escribira
				// todo seguido y los dos archivos seran exactamente iguales
				wr.newLine();
				// Vaciamos el buffer de entrada
				wr.flush();
			}
		


			// Cerramos el BufferedReader y el BufferedWriter
			wr.close();
			br.close();
			
			// por si quieres comprobar por consola que la lista es correcta y esta ordenada
			// System.out.println(listadoPalabras);

			// Manejo de excepción si el archivo no se encuentra en la ruta especificada
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// Manejo de excepción si ocurre un error al leer el archivo
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
