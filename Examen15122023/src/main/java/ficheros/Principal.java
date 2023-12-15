package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

//las carpetas y ficheros se crean en este proyecto
public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte opcion;
		String ruta = ".\\";
		String nombreCarpeta;
		String nombreArchivo = null;
		String respuesta = null;

		do {
			// el menu se imprime por pantalla
			System.out.println();
			System.out.println("Elige una opción:" + "\n\t0 - Salir" + "\n\t1 - Crear carpeta" + "\n\t2 - Crear fichero"
					+ "\n\t3 - Borrar Fichero" + "\n\t4 - Borrar Carpeta" + "\n\t5 - Leer Fichero"
					+ "\n\t6 - Leer Carpeta");

			opcion = Byte.parseByte(sc.nextLine());
			switch (opcion) {
			// salida del menu
			case 0:
				System.out.println("Saliendo");
				break;

			case 1: // Creación de directorio
				System.out.println("Introduzca el nombre de la carpeta:");
				nombreCarpeta = sc.nextLine();
				File carpeta = new File(ruta + nombreCarpeta);

				if (carpeta.mkdir()) {
					System.out.println("Carpeta creada.");
				} else {
					System.out.println("No se pudo crear la carpeta.");
				}
				break;

			case 2: // Creación de archivo
				System.out.println("Dime el nombre del archivo. Recuerda que tenga la extensión .txt");
				nombreArchivo = sc.nextLine();
				System.out.println("¿Quieres escribir un mensaje en el fichero? si-no");
				respuesta = sc.nextLine();

				try (BufferedWriter fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo))) {

					if (respuesta.equalsIgnoreCase("si")) {
						System.out.println("Escribe el mensaje que contendrá el fichero:");
						String contenido = sc.nextLine();
						fw.write(contenido);
						System.out.println("Archivo " + nombreArchivo + " creado correctamente.");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case 3:
				// borrar archivo
				System.out.println("Dime el nombre del archivo que quieres borrar");
				nombreArchivo = sc.nextLine();
				File archivoBorrar = new File(ruta + nombreArchivo);

				if (archivoBorrar.exists()) {
					boolean borrado = archivoBorrar.delete();
					if (borrado) {
						System.out.println("El fichero " + nombreArchivo + " ha sido borrado con éxito.");
					} else {
						System.out.println("No se pudo borrar el fichero.");
					}
				} else {
					System.out.println("El fichero no existe en la ubicación especificada.");
				}
				break;
			case 4:
				// borrar carpeta
				System.out.println("Introduzca el nombre de la carpeta que desea borrar:");
				nombreCarpeta = sc.nextLine();
				File carpetaBorrar = new File(ruta + nombreCarpeta);

				if (carpetaBorrar.exists()) {
					try {
						FileUtils.deleteDirectory(carpetaBorrar);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					carpetaBorrar.delete();
					System.out.println("La carpeta " + carpetaBorrar + " se ha borrado correctamente.");
				} else {
					System.out.println("La carpeta " + carpetaBorrar + " no existe.");
				}
				break;

			case 5:
				// borrar archivo
				System.out.println("Dime el nombre del archivo que quieres borrar");
				nombreArchivo = sc.nextLine();
				File archivo = new File(ruta + nombreArchivo);
				if (!archivo.exists()) {
					System.err.println("El archivo no existe");
					return; // para salir del programa
				}

				try {
					FileReader fr = new FileReader(archivo);
					BufferedReader br = new BufferedReader(fr);
					String linea;
					while ((linea = br.readLine()) != null) {
						System.out.println(linea);
					}
					br.close();
					fr.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 6:
				// leer carpeta
				System.out.println("Dime el nombre de la carpeta de la que quieres información");
				File direc = new File(sc.nextLine());
				if (direc.exists()) {
					System.out.println("Nombre del directorio: " + direc.getName());
					System.out.println("Ruta: " + direc.getPath());
					System.out.println("Ruta absoluta: " + direc.getAbsolutePath());
					System.out.println("Lectura: " + direc.canRead());
					System.out.println("Escritura: " + direc.canWrite());
					System.out.println("Tamaño: " + direc.length() + " Kb");
					System.out.println("Directorio: " + direc.isDirectory());
					System.out.println("Fichero: " + direc.isFile());
					System.out.println("Nombre del directorio padre: " + direc.getParent());
				} else {
					System.out.println("El directorio no existe");
				}

			}

		} while (opcion != 0);
		sc.close();

	}

	// funcion no utilizada borrar fichero para comprobar el flujo de datos
	public void BorrarFichero(String nombreArchivo, String ruta, Scanner sc) {
		System.out.println("Dime el nombre del archivo que quieres borrar");
		nombreArchivo = sc.nextLine();
		File archivoBorrar = new File(ruta + nombreArchivo);

		if (archivoBorrar.exists()) {
			boolean borrado = archivoBorrar.delete();
			if (borrado) {
				System.out.println("El fichero " + nombreArchivo + " ha sido borrado con éxito.");
			} else {
				System.out.println("No se pudo borrar el fichero.");
			}
		} else {
			System.out.println("El fichero no existe en la ubicación especificada.");
		}
	}
}
