package com.ignaciorodriguez.simulacro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarDatos {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		String sql= "SELECT * FROM Productos";

		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/simulacro","root","");
			stmt=conn.createStatement();
			stmt.execute(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				
				int id=rs.getInt("id");
				String nombre=rs.getString("nombre");
				String tipo_de_gama=rs.getString("tipo_de_gama");
				String marca=rs.getString("marca");
				String precio=rs.getString("precio");
				String numero_de_serie=rs.getString("numero_de_serie");
				System.out.println("id: "+id+", nombre: "+nombre+", tipo_de_gama: "+tipo_de_gama+", marca: "+marca+", precio: "+precio+", numero_de_serie: "+numero_de_serie);
			}
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
