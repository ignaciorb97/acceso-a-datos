package com.ignaciorodriguez.simulacro2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CrearFicheroArrayProducto {

	public static void main(String[] args) {
		String ruta="c:\\prueba\\";
		String nombreArchivo="productos.txt";
		String [] contenido= {"Pulpa,Mango,Plátano"};
		
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(ruta+nombreArchivo));
			System.out.println("Archivo productos.txt creado correctamente.");
			
			for(String content:contenido) {
				fw.write(content+"\n");
				fw.flush();
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error");
		}
	

}}
