package pe.spa.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_empleado;
	
	@Column
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="especialidad_id",nullable=false)
	private Servicio especialidad;
	
	@Column
	private String horario_trabajo;
	
	@Column
	private String url_foto;
	
	@Column
	private String estado;
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public Empleado(Integer id_empleado, String nombre, String horario_trabajo, String url_foto, String estado) {
		super();
		this.id_empleado = id_empleado;
		this.nombre = nombre;
		this.horario_trabajo = horario_trabajo;
		this.url_foto = url_foto;
		this.estado = estado;
	}

	public Integer getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Integer id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Servicio getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Servicio especialidad) {
		this.especialidad = especialidad;
	}

	public String getHorario_trabajo() {
		return horario_trabajo;
	}

	public void setHorario_trabajo(String horario_trabajo) {
		this.horario_trabajo = horario_trabajo;
	}


	public String getUrl_foto() {
		return url_foto;
	}

	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
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
