package com.ignaciorodriguez.examen15122023;

import java.util.List;
//imprimimos por pantalla los atributos de cada alumno
public class AlumnoView {
	public void mostrarAlumno(List<Alumno> alumnos) {
	    for (Alumno alumno : alumnos) {
	        System.out.println("ID: " + alumno.getId()); 
	        System.out.println("Nombre: " + alumno.getNombre());
	        System.out.println("Apellido: " + alumno.getApellido()); 
	        System.out.println("Apellido2: " + alumno.getApellido2()); 
	        System.out.println("Repetidor: " + alumno.getRepetidor()); 
	        System.out.println("Teléfono: " + alumno.getTelefono()); 
	        System.out.println(); 
	    }
	}

}
