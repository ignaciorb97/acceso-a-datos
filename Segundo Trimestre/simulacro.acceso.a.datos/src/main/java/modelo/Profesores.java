package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="profesores")
public class Profesores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@Column(name ="nombre")
	private String nombre;
	
	@Column(name ="apellidos")
	private String apellidos;
	
	@Column(name ="direccion")
	private String direccion;
	
	@Column(name ="cp")
	private String cp;
	
	@Column(name ="ciudad")
	private String ciudad;
	
	@Column(name ="provincia")
	private String provincia;
	
	@Column(name ="telefono")
	private String telefono;

	public Profesores(String nombre, String apellidos, String direccion, String cp, String ciudad,
			String provincia, String telefono) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.cp = cp;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.telefono = telefono;
	}

	public Profesores() {
		super();
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Profesores [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", cp=" + cp + ", ciudad=" + ciudad + ", provincia=" + provincia + ", telefono=" + telefono + "]";
	}
	
}
