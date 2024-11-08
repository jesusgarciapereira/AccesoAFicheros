package ejerciciosaleatorios.tercero;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EjercicioC {

	public static void main(String[] args) {
		// Archivo de origen donde se escribirá inicialmente las letras [a-e] en cada
		// linea
		File antiguoTxt = new File(
				"C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\src\\ejerciciosaleatorios\\tercero\\antiguoTxt.txt");
		// Archivo de destino donde se escribirá la letra de forma aleatoria
		File nuevoTxt = new File(
				"C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\src\\ejerciciosaleatorios\\tercero\\nuevoTxt.txt");
		// Variable para almacenar el caracter leido del archivo de origen
		char caracterLeido;
		// Constante que almacena el caracter 'a'
		final char CARACTER_A = 'a';

		try {
			// BufferedWriter para escribir las letras [a-e] en el archivo de origen
			BufferedWriter wr = new BufferedWriter(new FileWriter(antiguoTxt));

			// Bucle for que ejecuta las instrucciones 5 veces
			for (int i = 0; i < 5; i++) {
				wr.write(CARACTER_A + i); // Escribe el caracter correspondiente
				wr.write(String.valueOf(i + 1)); // String.valueOf() para concatenar el numero correspondiente
				wr.newLine(); // Salto de linea en la escritura
			}
			wr.flush(); // Vacia el buffer, asegurando que se escribe en el archivo
			wr.close(); // Cierra el BufferedWriter

			// RandomAccessFile en modo lectura para leer del archivo de origen
			RandomAccessFile lectorAleatorio = new RandomAccessFile(antiguoTxt, "r");
			// RandomAccessFile en modo escritura para escribir en el archivo de destino
			RandomAccessFile escritorAleatorio = new RandomAccessFile(nuevoTxt, "rw");

			// Bucle for que recorre la longitud de lectorAleatorio, en orden inverso
			for (long i = lectorAleatorio.length() - 1; i >= 0; i--) {
				// Posiciona el puntero de lectura en la posición indicada por el contador
				lectorAleatorio.seek(i);
				// Lee el caracter y lo castea como char para asignarla a la variable
				caracterLeido = (char) lectorAleatorio.readByte();

				// Si el caracter leido es una letra
				if (Character.isLetter(caracterLeido)) {
					// Escribe la letra leida en esa posición
					escritorAleatorio.writeByte(caracterLeido);

				}

				else if (Character.isDigit(caracterLeido)) {
					// Escribe la letra leida en esa posición
					escritorAleatorio.writeByte(caracterLeido);
					// Escribe tambien un salto de linea
					escritorAleatorio.writeByte('\n');
				}
			}

			// Cerramos los RandomAccessFile
			lectorAleatorio.close();
			escritorAleatorio.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
