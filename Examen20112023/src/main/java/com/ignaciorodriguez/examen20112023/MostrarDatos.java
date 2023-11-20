package com.ignaciorodriguez.examen20112023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarDatos {

	public static void main(String[] args) {
		Connection conn =null;
		Statement stat=null;
		//Hacemos un select de la tabla
		String sql="SELECT * from tvideojuegos";

	
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbgametop", "root", "");
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("idjuego");
				String nombre = rs.getString("nombre");
				int anio = rs.getInt("anio");
				String compañia = rs.getString("compañia");
				float precio = rs.getFloat("precio");
				String sinopsis = rs.getString("sinopsis");
				String plataforma =rs.getString("plataforma");
				System.out.println("ID: " + id 
						+ ", Nombre: " + nombre
						+ " / año: " + anio
						+ " / compañia: " + compañia
						+ " / precio: " + precio 
						+ " / sinopsis: " + sinopsis
						+ " / plataforma: " + plataforma );
			}
			rs.close();
			stat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
