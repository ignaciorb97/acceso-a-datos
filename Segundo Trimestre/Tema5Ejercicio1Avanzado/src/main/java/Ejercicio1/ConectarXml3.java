package Ejercicio1;

import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
import org.xmldb.api.*;
import javax.xml.transform.OutputKeys;
import org.exist.xmldb.EXistResource;

public class ConectarXml3 {

	// URI para conectarse a la base de datos XML existente en localhost en el
	// puerto 8080
	private static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/";

	// Nombre de la colecci�n donde se encuentran los datos XML
	private static String COLLECTION = "libros";

	// Nombre del recurso XML dentro de la colecci�n
	private static String RESOURCE = "libros.xml";

	public static void main(String args[]) throws Exception {

		final String driver = "org.exist.xmldb.DatabaseImpl";

		// Inicializa el controlador de la base de datos
		Class cl = Class.forName(driver);
		Database database = (Database) cl.getDeclaredConstructor().newInstance();
		database.setProperty("create-database", "true");
		DatabaseManager.registerDatabase(database);

		Collection col = null;
		XMLResource res = null;
		try {
			// Obtiene la colecci�n
			col = DatabaseManager.getCollection(URI + COLLECTION, "admin", "admin");

			// Configura la propiedad de salida para indentaci�n
			col.setProperty(OutputKeys.INDENT, "no");

			// Obtiene el recurso XML de la colecci�n
			res = (XMLResource) col.getResource(RESOURCE);

			// Verifica si el recurso existe
			if (res == null) {
				System.out.println("Base de datos no encontrada!");
			} else {
				// Imprime el contenido del recurso
				System.out.println(res.getContent());
			}
		} finally {
			// Limpieza de recursos

			if (res != null) {
				try {
					// Libera los recursos del recurso exist
					((EXistResource) res).freeResources();
				} catch (XMLDBException xe) {
					xe.printStackTrace();
				}
			}

			if (col != null) {
				try {
					// Cierra la colecci�n
					col.close();
				} catch (XMLDBException xe) {
					xe.printStackTrace();
				}
			}
		}
	}
}
