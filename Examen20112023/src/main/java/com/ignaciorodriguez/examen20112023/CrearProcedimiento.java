package com.ignaciorodriguez.examen20112023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearProcedimiento {

	public static void main(String[] args) {
		
		Connection conn=null;
		PreparedStatement stat=null;
		//creamos el proceso y si ya existe lo borramos
		String drop = "DROP PROCEDURE IF EXISTS MostrarDatos";
		String create = "CREATE PROCEDURE MostrarDatos() " +
		                "BEGIN " +
		                "SELECT * FROM tvideojuegos; " +
		                "END;";

		try {
			//conectamos con base de datos
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbgametop","root","");
			if (conn!=null) {
				System.out.println("Conexión con la base de datos establecida correctamente");
			}
			//borramos el statement anterior
			stat=conn.prepareStatement(drop);
			stat.executeUpdate();
			System.out.println("Procedimiento eliminado correctamente");
	//creamos el statement
			stat=conn.prepareStatement(create);
			stat.executeUpdate();
			System.out.println("Procedimiento creado correctamente");
			
			stat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
