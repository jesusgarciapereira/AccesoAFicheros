package ejerciciosaleatorios.segundo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EjercicioB {

	public static void main(String[] args) {
		// Archivo de origen donde se escribirá inicialmente las letras [a-e] en cada
		// linea
		File antiguoTxt = new File(
				"C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\src\\ejerciciosaleatorios\\segundo\\antiguoTxt.txt");
		// Archivo de destino donde se escribirá la letra de forma aleatoria
		File nuevoTxt = new File(
				"C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\src\\ejerciciosaleatorios\\segundo\\nuevoTxt.txt");
		// Variable para almacenar la letra leída del archivo de origen
		byte letraLeida;
		// Constante que almacena el caracter 'a'
		final char CARACTER_A = 'a';

		try {
			// BufferedWriter para escribir las letras [a-e] en el archivo de origen
			BufferedWriter wr = new BufferedWriter(new FileWriter(antiguoTxt));

			// Bucle for que ejecuta las instrucciones 5 veces
			for (int i = 0; i < 5; i++) {
				wr.write(CARACTER_A + i); // Escribe el caracter correspondiente
				wr.newLine(); // Salto de linea en la escritura
			}
			wr.flush(); // Vacia el buffer, asegurando que se escribe en el archivo
			wr.close(); // Cierra el BufferedWriter

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
