package com.ignaciorodriguez.simulacro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement statement = null;
		String sql = "CREATE TABLE Productos("
				+ "id INT PRIMARY KEY,"
				+ "nombre VARCHAR(25),"
				+ "tipo_de_gama VARCHAR(20),"
				+ "marca VARCHAR(20),"
				+ "precio DOUBLE,"
				+ "numero_de_serie VARCHAR(10))";
		
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/simulacro","root","");
			statement=conn.createStatement();
			statement.execute(sql);
			System.out.println("Tabla \"productos\" creada correctamente");
			conn.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
