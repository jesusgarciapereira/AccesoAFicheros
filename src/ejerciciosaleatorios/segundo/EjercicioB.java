package ejerciciosaleatorios.segundo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EjercicioB {

	/*
	 * Aumenta el documento de lectura hasta la letra "e" en líneas diferentes (a,
	 * b, c, d, e) y crea un método que las escriba en otro de forma inversa. Sin
	 * usar ARRAYS ni BUFFER.
	 */

	public static void main(String[] args) {
		// Archivo de origen donde se escribirá inicialmente las letras [a-e] en cada
		// linea
		File antiguoTxt = new File(
				"C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\src\\ejerciciosaleatorios\\segundo\\antiguoTxt.txt");
		// Archivo de destino donde se escribirá la letra de forma aleatoria
		File nuevoTxt = new File(
				"C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\src\\ejerciciosaleatorios\\segundo\\nuevoTxt.txt");
		// Variable para almacenar la letra leída del archivo de origen
		char letraLeida;
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

			// RandomAccessFile en modo lectura para leer del archivo de origen
			RandomAccessFile lectorAleatorio = new RandomAccessFile(antiguoTxt, "r");
			// RandomAccessFile en modo escritura para escribir en el archivo de destino
			RandomAccessFile escritorAleatorio = new RandomAccessFile(nuevoTxt, "rw");

			// Calcular la longitud del archivo de origen para usar seek()
			long longitudArchivo = lectorAleatorio.length();

			// Leer las letras en orden inverso y escribirlas en el archivo de destino
			for (long i = longitudArchivo - 1; i >= 0; i--) {
				lectorAleatorio.seek(i); // Mover el puntero a la posición deseada
				letraLeida = (char) lectorAleatorio.readByte();
				if (Character.isLetter(letraLeida)) {
					// Leer el byte en la posición
					escritorAleatorio.writeByte(letraLeida + '\n'); // Escribir en el archivo de destino
				}
			}

			lectorAleatorio.close(); // Cerrar el lector
			escritorAleatorio.close(); // Cerrar el escritor

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
