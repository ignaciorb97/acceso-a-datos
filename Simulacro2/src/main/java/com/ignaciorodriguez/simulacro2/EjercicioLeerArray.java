package com.ignaciorodriguez.simulacro2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjercicioLeerArray {

	public static void main(String[] args) {
		String[] carpeta = { "ciudades.txt","cordoba.txt","malaga.txt","sevilla.txt" };
		for (String carp : carpeta) {
			System.out.println(carp + ":");
			leerFicheros(carp);
			System.out.println();
		}
	}

	public static void leerFicheros(String fichero) {
		try {
			File archivo = new File("c:/prueba/" + fichero);
			if (!archivo.exists()) {
				System.out.println("El archivo no existe");
				return;
			}
			FileReader fr;

			fr = new FileReader(archivo);

			// TODO Auto-generated catch block

			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
