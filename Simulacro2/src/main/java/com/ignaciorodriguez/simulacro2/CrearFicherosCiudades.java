package com.ignaciorodriguez.simulacro2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CrearFicherosCiudades {

	public static void main(String[] args) {

		String ruta="c:\\prueba\\";
		String nombreArchivo = "ciudades.txt";
		String[] contenido = { "Córdoba,Málaga,Sevilla,Cádiz,Almería,Jaén" };

		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo));
			System.out.println("Oleeeeeee ahi mi ninio se crearon las siudades");
			for (String content : contenido) {
				fw.write(content + "\n");
				fw.flush();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error");
		}

	}
}
