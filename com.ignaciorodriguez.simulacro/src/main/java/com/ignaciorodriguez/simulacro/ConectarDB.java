package com.ignaciorodriguez.simulacro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/simulacro","root","");
			if(connection!=null) {
				System.out.println("se ha conectao la cosa letsgo");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
