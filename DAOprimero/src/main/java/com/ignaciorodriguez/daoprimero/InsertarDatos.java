package com.ignaciorodriguez.daoprimero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarDatos {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		String sql= "INSERT INTO clientes (id, nif, nombre, edad)"
				+"VALUES (5, '5555', 'pablo', '20')";
//raul pablo 50 25
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa","root","");
			stmt=conn.createStatement();
			stmt.execute(sql);
			System.out.println("Datos insertados en la tabla \"clientes\" correctamente");
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
