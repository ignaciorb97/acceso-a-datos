package ficherosytal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Funciones {

	public String crearFichero(String nombre, String[] contenido) {
		String ruta = "c:\\prueba\\";
		String nombreArchivo = nombre + ".txt";

		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo));
			for (String content : contenido) {
				fw.write(content + "\n");
				fw.flush();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "se ha creado perfectamente";

	}

	public String crearCarpeta(String nombre) {
		String ruta = "c:\\" + nombre + "\\";
		File fichero = new File(ruta);

		if (fichero.mkdir()) {
			return "carpeta creada";

		} else {

			if (fichero.exists()) {
				return "La carpeta ya existe ";
			}
			return "No se puedo crear la carpeta ";
		}
	}
	public String borrarCarpeta(String nombreCarpetaBorrar) {
		String ruta = "c:\\";
		
		File carpetaBorrar = new File(ruta + nombreCarpetaBorrar);

		if (carpetaBorrar.exists()) {
			try {
				FileUtils.deleteDirectory(carpetaBorrar);
				carpetaBorrar.delete();
				return "La carpeta " + nombreCarpetaBorrar + " se ha borrado correctamente.";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			return "La carpeta " + nombreCarpetaBorrar + " no existe.";
		}
		return "";
	}

}
