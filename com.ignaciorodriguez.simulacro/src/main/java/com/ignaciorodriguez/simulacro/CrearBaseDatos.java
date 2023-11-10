package com.ignaciorodriguez.simulacro;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CrearBaseDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement statement=null;
		String sql ="CREATE DATABASE simulacro;";
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
			statement=conn.createStatement();
			statement.execute(sql);
			System.out.println("Base de datos creada");
			conn.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
