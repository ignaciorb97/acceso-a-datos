package com.ignaciorodriguez.daoprimero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class InvocarProcedimiento2 {

	public static void main(String[] args) {
        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

            // Llamar al procedimiento almacenado
            cstmt = conn.prepareCall("call ObtenerClientesMayorQue2()");

            // Ejecutar el procedimiento
            cstmt.execute();

            
            ResultSet rs = cstmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nif = rs.getString("nif");
                String nombre = rs.getString("nombre");
                String edad = rs.getString("edad");
                System.out.println("id: " + id + ", nif: " + nif + ", "
                		+ "nombre: " + nombre + ", edad: " + edad);
            }

            System.out.println("Procedimiento invocado");

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
