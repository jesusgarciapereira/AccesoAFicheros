package ejerciciosaleatorios.primero;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EjercicioA {
	/*
	 * Crea un documento de texto con una única letra "a" que será leído de forma
	 * aleatoria (seek) y escrito 5 veces en otro documento también de forma
	 * aleatoria (seek).
	 */
	public static void main(String[] args) {
		// Archivo de origen donde se escribirá inicialmente la letra "a"
		File antiguoTxt = new File(
				"C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\src\\ejerciciosaleatorios\\primero\\antiguoTxt.txt");
		// Archivo de destino donde se escribirá la letra de forma aleatoria
		File nuevoTxt = new File(
				"C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\src\\ejerciciosaleatorios\\primero\\nuevoTxt.txt");
		// Variable para almacenar el caracter leido del archivo de origen
		char caracterLeido;

		try {
			// BufferedWriter para escribir la letra "a" en el archivo de origen
			BufferedWriter wr = new BufferedWriter(new FileWriter(antiguoTxt));
			wr.write("a");  // Escribe la letra "a" en el archivo de origen
			wr.flush();     // Vacia el buffer, asegurando que se escribe en el archivo
			wr.close();     // Cierra el BufferedWriter

			// RandomAccessFile en modo lectura para leer del archivo de origen
			RandomAccessFile lectorAleatorio = new RandomAccessFile(antiguoTxt, "r");
			// RandomAccessFile en modo escritura para escribir en el archivo de destino
			RandomAccessFile escritorAleatorio = new RandomAccessFile(nuevoTxt, "rw");
			
			// Posiciona el puntero de lectura en el inicio 
			lectorAleatorio.seek(0);
			// Lee el caracter y lo castea como char para asignarla a la variable
			caracterLeido = (char) lectorAleatorio.read();

			// Bucle for que ejecuta las instrucciones 5 veces
			for (int i = 0; i < 5; i++) {

				// Posiciona el puntero de escritura en la posición indicada por el contador
				escritorAleatorio.seek(i);
				// Escribe la letra leida en esa posición
				escritorAleatorio.writeByte(caracterLeido);

			}
			// Cerramos los RandomAccessFile
			lectorAleatorio.close();
			escritorAleatorio.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
