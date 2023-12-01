package com.ignaciorodriguez.simulacro2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjercicioLeerFicheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File archivo = new File("c:\\prueba\\ciudades.txt");

		if (!archivo.exists()) {
			System.out.println("El archivo ciudades.txt no existe ");
			return; // salimos del programa si el archivo no existe
		}

		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			// Leemos el contendo del ficher malaga.txt

			String linea;

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
