package com.ignaciorodriguez.examen15122023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AlumnoModel {
	//establecemos conexion
	private Connection conn;

	public AlumnoModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
		conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
	}
//recorremos la lista de alumnos de la base de datos y creamos alumnos en java a traves del arraylist alumnos 
	public List<Alumno> getAllAlumnos() throws SQLException {
		List<Alumno> alumnos = new ArrayList<Alumno>();
		PreparedStatement stmt = conn.prepareStatement("Select * FROM alumno");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			int id = rs.getInt("id");
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido1");
			String apellido2 = rs.getString("apellido2");
			String repetidorString = rs.getString("es_repetidor");
			EsRepetidor repetidor = EsRepetidor.valueOf(repetidorString); // Convierte el String a EsRepetidor

			String telefono = rs.getString("teléfono");
			alumnos.add(new Alumno(id, nombre, apellido, apellido2, repetidor, telefono));
		}

		stmt.close(); // Cierra la declaración
		rs.close(); // Cierra el resultado
		return alumnos; // Devuelve la lista de clientes
	}
	   public void close() throws SQLException {
	        conn.close();
	    }
}
