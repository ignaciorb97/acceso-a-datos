package com.ignaciorodriguez.daoprimero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearProcedimiento2 {

	public static void main(String[] args) {
		Connection conn = null;//2 2222 34 cristina
        PreparedStatement presta = null; // Cambio de nombre de la variable
        String dropProcedure = "DROP PROCEDURE IF EXISTS ObtenerClientesMayorQue2";
        String createProcedure = "CREATE PROCEDURE ObtenerClientesMayorQue2() " +
                "BEGIN " +
                "SELECT * FROM clientes WHERE id>=2;" +
                "END;";

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            
            // Primero, eliminamos el procedimiento si existe
            presta = conn.prepareStatement(dropProcedure);
            presta.executeUpdate();

            // Luego, creamos el procedimiento
            presta = conn.prepareStatement(createProcedure);
            presta.executeUpdate();

            System.out.println("Procedimiento creado");

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
