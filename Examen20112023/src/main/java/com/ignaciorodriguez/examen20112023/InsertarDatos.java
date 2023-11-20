package com.ignaciorodriguez.examen20112023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarDatos {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stat=null;
		//insertamos los valores en la tabla
		String sql="INSERT INTO tvideojuegos(idjuego,nombre,anio,compañia,precio,sinopsis,plataforma)"
								   + "VALUES(1,'The Legend of zelda Breath of the wild',2017,'Nintendo',59.99,'Aventura épica','Nintendo Switch')"
								   + ",(2,'Red Dead Redemption 2',2018,'Rockstar Games',49.99,'Aventura del viejo oeste','Playstation 4')"
								   + ",(3,'Minecraft',2011,'Mojang',29.99,'Mundo abierto y construcción','Multiplataforma')";
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbgametop","root","");
			stat=conn.createStatement();
			stat.execute(sql);
			System.out.println("Insertados los datos en la tabla");
			
			conn.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

}
