package pe.spa.entity;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collection;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_empleado;
	
	@Column(length=200, nullable=false)
	private String nombres;

	@Column(length=200, nullable=false)
	private String apellidos;

	@Column(length=300, nullable=false, unique=true)
	private String correo;

	@Column(length=50, nullable=false, unique=true)
	private String telefono;
	
	@Column(length=1000)
	private String url_foto;
	
	@Column(columnDefinition="TINYINT(1) DEFAULT 0")
	private Boolean estado;

	@Column(length=2000)
	private String descripcion;
	/* 
	@OneToMany(mappedBy="empleado_reserva", cascade=CascadeType.ALL)
	@JsonIgnore
	private Collection<Reserva> itemsReserva=new ArrayList<>();
	*/
	public Empleado() { }

	public Empleado(String nombres, String apellidos, String correo,
		String telefono, String url_foto, Boolean estado, String descripcion) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.telefono = telefono;
		this.url_foto = url_foto;
		this.estado = estado;
		this.descripcion = descripcion;
	}

	public Integer getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Integer id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUrl_foto() {
		return url_foto;
	}

	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/*
	public Collection<Reserva> getItemsReserva() {
		return itemsReserva;
	}

	public void setItemsReserva(Collection<Reserva> itemsReserva) {
		this.itemsReserva = itemsReserva;
	}
	*/
}
