package com.ignaciorodriguez.examen20112023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stat=null;
		//creamos la tabla con los valores
		String sql="CREATE TABLE tvideojuegos ("
				+ "idjuego INT PRIMARY KEY,"
				+ " nombre VARCHAR(50) NOT NULL,"
				+ " anio INT,"
				+ " compañia VARCHAR(50),"
				+ " precio DECIMAL(10, 2),"
				+ " sinopsis VARCHAR(150),"
				+ " plataforma VARCHAR(50))";
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbgametop","root","");
			stat=conn.createStatement();
			stat.execute(sql);
			System.out.println("Creada la tabla tvideojuegos");
			
			conn.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

	}

}
