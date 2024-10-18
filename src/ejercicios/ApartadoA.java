package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ApartadoA {

	public static void main(String[] args) {

		// Ruta absoluta del archivo de texto que contiene la estructura de carpetas
		String estructuraCarpetas = "C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\bin\\ejercicios\\carpetas.txt";

		// Ruta base donde se crearán las carpetas (donde lo pide el ejercicio)
		String rutaBase = "C:\\Users\\jgarcia\\";

		// Declaración de una variable de tipo File que usaremos para crear los directorios
		File directorio;

		// Buffer para leer el archivo línea por línea.
		BufferedReader br;
		
		// Variable para almacenar cada linea leida del archivo de texto
		String linea = "";

		// Leer el archivo de texto y crear las carpetas
		try {

			 // Inicializamos el BufferedReader para leer el archivo de texto que contiene las rutas
			br = new BufferedReader(new FileReader(estructuraCarpetas));
			 // Leemos la primera línea del archivo
			linea = br.readLine();

			// Mientras la linea no sea null
			while (linea != null) {

				// Crea un objeto File que representa la ruta completa combinando la ruta base y la linea leida del archivo
				directorio = new File(rutaBase + linea);

				// Si el directorio no existe
				if (!directorio.exists()) {
					// Crea el directorio y todas las carpetas intermedias necesarias. Luego lo comunica
					directorio.mkdir();
					System.out.println("Directorio creado: " + directorio.getPath());

					// Si ya existe, lo comunica y
				} else {
					System.out.println("El directorio ya existe: " + directorio.getPath());
				}
				
				// Lee la siguiente linea del archivo
				linea = br.readLine();
			}
			
			// Cierra el BufferedReader una vez que terminamos de leer el archivo
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
