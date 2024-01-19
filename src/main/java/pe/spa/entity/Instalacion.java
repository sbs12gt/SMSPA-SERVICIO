package pe.spa.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="instalacion")
public class Instalacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_instalacion;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column
	private String estado;
	
	public Instalacion() {
		// TODO Auto-generated constructor stub
	}

	public Instalacion(Integer id_instalacion, String nombre, String descripcion, String estado) {
		super();
		this.id_instalacion = id_instalacion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Integer getId_instalacion() {
		return id_instalacion;
	}

	public void setId_instalacion(Integer id_instalacion) {
		this.id_instalacion = id_instalacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
