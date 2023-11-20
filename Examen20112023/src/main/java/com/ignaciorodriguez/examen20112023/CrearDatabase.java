package com.ignaciorodriguez.examen20112023;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CrearDatabase {

	public static void main(String[] args) {

		//creamos la base de datos
		
		Connection conn=null;
		Statement stat=null;
		String sql="CREATE DATABASE dbgametop";
		//conectamos y ejecutamos el statement
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
			stat=conn.createStatement();
			stat.execute(sql);
			System.out.println("Creada la base de datos dbgametop");
			
			conn.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


