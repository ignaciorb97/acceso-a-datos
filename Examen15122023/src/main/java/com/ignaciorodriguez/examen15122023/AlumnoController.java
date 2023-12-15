package com.ignaciorodriguez.examen15122023;

import java.sql.SQLException;
import java.util.List;

//utilizando el modelo y view, creamos una lista de alumnos y los mostramos
public class AlumnoController {
	private AlumnoModel model;
	private AlumnoView view;

	public AlumnoController(String dbURL, String dbUser, String dbPassword) throws SQLException {
		model = new AlumnoModel(dbURL, dbUser, dbPassword);
		view = new AlumnoView();
	}
	public void mostrarAlumnos() throws SQLException {
	     List<Alumno> alumnos = model.getAllAlumnos(); // Obtiene la lista de alumnos desde el modelo
	        view.mostrarAlumno(alumnos); // Muestra los alumnos en la vista
	    
	}
    // Método para cerrar la conexión a la base de datos
    public void cerrarConexion() throws SQLException {
        model.close(); // Cierra la conexión en el modelo
    }

}
