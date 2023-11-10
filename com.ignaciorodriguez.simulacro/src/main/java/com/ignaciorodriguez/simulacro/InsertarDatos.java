package com.ignaciorodriguez.simulacro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement statement = null;
		String sql = "INSERT INTO Productos (id,nombre,tipo_de_gama,marca,precio,numero_de_serie)"
				+ "VALUES(1,'portatil1','portatilgamaalta','HP',1500,'111'),"
						+ "(2,'portatil2','portatilgamabaja','Apple',1000,'222'),"
						+ "(3,'monitor1','Monitorgamaalta','LG',800,'333'),"
						+ "(4,'monitor2','Monitorgamabaja','HP',200,'444')";

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simulacro", "root", "");
			statement = conn.createStatement();
			statement.execute(sql);

			System.out.println("Datos insertados en la tabla \"productos\" correctamente");
			conn.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
