package com.ignaciorodriguez.daoprimero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteFrom {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		String sql= "DELETE FROM clientes WHERE edad ='1'";
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa","root","");
			stmt=conn.createStatement();
			stmt.execute(sql);
			System.out.println("cliente borrado");
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
