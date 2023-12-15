package ficherosytal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String nombre = null;
		boolean salir = false;

		do {
			System.out.println("Que quieres hacer:");
			System.out.println("1. crear fichero");
			System.out.println("2. crear carpeta");
			System.out.println("3. Salir");
			System.out.print("Elige una opción: ");

			int opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				System.out.print("Ingresa un nombre para el fichero: ");

				nombre = sc.nextLine();
				crearFichero(nombre,);
				break;
			case 2:

				break;
			case 3:
				System.out.println("taluego...");
				salir = true;
				break;
			default:
				salir = true;
			}
		} while (salir != false);
	}

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
