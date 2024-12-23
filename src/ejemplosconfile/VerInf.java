package ejemplosconfile;

import java.io.File;

public class VerInf {
	
	public static void main(String[] args) {
		System.out.println("INFORMACIÓN SOBRE EL FICHERO:");
		// Es este mismo archivo .java
		  File f = new File("C:\\Users\\jgarcia\\eclipse-workspace\\AccesoAFicheros\\src\\ejemplosconfile\\VerInf.java");
		  
		  // En casa la ruta es:
		  // C:\Users\Tragedia\git\AccesoAFicheros\src\ejemplosconfile\VerInf.java
		  
		   if(f.exists()){
		        System.out.println("Nombre del fichero  : "+f.getName());
		        System.out.println("Ruta                : "+f.getPath());
		        System.out.println("Ruta absoluta       : "+f.getAbsolutePath());
		        System.out.println("Se puede leer       : "+f.canRead());
		        System.out.println("Se puede escribir   : "+f.canWrite());
		        System.out.println("Tamaño              : "+f.length());
				System.out.println("Es un directorio    : "+f.isDirectory()); 
				System.out.println("Es un fichero       : "+f.isFile());
				System.out.println("Nombre del directorio padre: "+f.getParent());
		  }
		   else {
			   System.out.println("No existe ningún archivo en la ruta " + f.getAbsolutePath());
		   }
		 }
		}

