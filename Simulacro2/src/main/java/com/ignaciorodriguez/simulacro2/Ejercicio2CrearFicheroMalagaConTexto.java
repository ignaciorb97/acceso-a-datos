package com.ignaciorodriguez.simulacro2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio2CrearFicheroMalagaConTexto {

	public static void main(String[] args) {


		String ruta="c:\\prueba\\";
		String nombreArchivo="malaga.txt";
		String contenido="Málaga lo meo vieo";
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(ruta+nombreArchivo));
			System.out.println("Archivo malaga.txt creado correctamente.");
			fw.write(contenido);
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Error al crear el archivo malaga.txt");
		}
				
	}

}
