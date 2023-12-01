package com.ignaciorodriguez.simulacro2;

import java.io.File;

public class Ejercicio2FicheroMalagaConTexto {

	public static void main(String[] args) {

		String ruta="c:\\prueba\\";
		File fichero= new File(ruta);
		
		if(fichero.mkdir()) {
			System.out.println("Carpeta creada");
			
		}else {
			System.err.println("No se puedo crear la carpeta ");
			if(fichero.exists()) {
				System.err.println("La carpeta ya existe ");
			}
		}
	}

}
