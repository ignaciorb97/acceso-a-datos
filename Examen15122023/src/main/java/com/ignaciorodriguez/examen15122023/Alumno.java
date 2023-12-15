package com.ignaciorodriguez.examen15122023;



//creamos la clase alumno con las caracteristicas requeridas por la base de datos
public class Alumno {
	private int id;
	private String nif;
	private String nombre;
	private String apellido;
	private String apellido2;
	private EsRepetidor repetidor;
	private String telefono;
//generamos el constructor
	public Alumno(int id, String nombre, String apellido, String apellido2, EsRepetidor repetidor, String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.apellido2 = apellido2;
		this.repetidor = repetidor;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
//dependiendo del enum EsRepetidor, si es "No" se guarda el string no, y si no lo es se guarda "Si"
	public String getRepetidor() {
		if (this.repetidor == EsRepetidor.no) {
			return "No";
		} else {
			return "Si";
		}

	}

	public void setRepetidor(EsRepetidor repetidor) {
		this.repetidor = repetidor;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
