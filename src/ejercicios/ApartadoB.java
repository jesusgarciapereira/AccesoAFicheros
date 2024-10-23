package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ApartadoB {

	public static void main(String[] args) {

		// Ruta absoluta del archivo de texto que contiene la estructura de carpetas,
		// necesito leerlo
		String estructuraCarpetas = "C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\bin\\ejercicios\\carpetas.txt";

		// Ruta base donde estan las carpetas 
		String rutaBase = "C:\\Users\\jgarcia\\";

		// Extension que crearemos en cada carpeta
		String paginaWeb = "\\paginaWeb.html";
		
		// Contenido del html
		String html = "";

		// Declaración de una variable de tipo File que usaremos para crear los ficheros (en este caso, paginas web)
		File ficheroWeb;

		// Buffer para leer el archivo línea por línea.
		BufferedReader br;

		// Variable para almacenar cada linea leida del archivo de texto
		String linea = "";

		// Buffer para leer el archivo línea por línea.
		BufferedWriter wr = null;
		
		
		try {
			// BufferedReader que leera cada linea carpetas.txt
			br = new BufferedReader(new FileReader(estructuraCarpetas));

			// Leemos la primera línea del archivo
			linea = br.readLine();

			// Mientras la linea no sea null
			while (linea != null) {
				// Crea cada fichero concatenando las rutas
				ficheroWeb = new File(rutaBase + linea + paginaWeb);
				
				// A partir del objeto File creamos el fichero físicamente
				if (ficheroWeb.createNewFile()) {
					
					// Escribe el html correspondiente
					html = "<html>\r\n"
							+ "   <head>\r\n"
							+ "      <title>" +linea+ "</title>\r\n"
							+ "   </head>\r\n"
							+ "   <body>\r\n"
							+ "      <h1>"+ficheroWeb+"</h1>\r\n"
							+ "      <h3>Autor: Jesús García Pereira</h3>\r\n"
							+ "   </body>\r\n"
							+ "</html>"; 
					
					// BufferedWriter que escribira cada paginaWeb.html
					wr = new BufferedWriter(new FileWriter(ficheroWeb));
					
					// Escribe el html indicado
					wr.write(html);
					// Vaciamos el buffer de entrada
					wr.flush();

					// Informa que se ha podido crear y en que directorio se encuentra
					System.out.println("El fichero se ha creado correctamente en la ruta " + ficheroWeb.getParent());

				}
				// Si no se ha podido crear, lo informaremos
				else
					System.out.println("No se ha podido crear el fichero");

				// Leemos la siguiente línea del archivo
				linea = br.readLine();
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
