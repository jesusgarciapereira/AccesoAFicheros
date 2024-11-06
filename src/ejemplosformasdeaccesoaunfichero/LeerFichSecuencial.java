package ejemplosformasdeaccesoaunfichero;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class LeerFichSecuencial {
	public static void main(String[] args) throws IOException {
		
		File fichero = new File("C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\src\\ejemplosformasdeaccesoaunfichero\\fichero1.txt");
		
		// Debe ser un array de caracteres, luego veras por que. Con una longitud igual al tamaño del archivo en bytes
		char[] letras = new char[(int) fichero.length()];
		
		// FileReader se usa para leer datos del archivo de texto. FileReader convierte los bytes del archivo en caracteres de manera adecuada
		FileReader fr = new FileReader(fichero);
		
		// read() solo sirve para arrays
		// Llena los primeros 2 caracteres (del 0 al 2) del array letras con datos del archivo
		int letrasLeidas = fr.read(letras, 0, 2);
		
		// se va leyendo un caracter hasta que lea -1
		while (letrasLeidas != -1) { 

			// Muestra el array "lleno" con el metodo read()
			System.out.println(letras); // cast a char
			
			// Continua la lectura, por tanto lo que lee y luego rellena (sobreescribe) son los 2 siguientes
			letrasLeidas = fr.read(letras, 0, 2);
		}

		// cerrar fichero
		fr.close(); 
	}
}
