package pe.spa.entity;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;

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
	private String apellidos;

	@Column(length=300, nullable=false, unique=true)
	private String correo;

	@Column(length=2000)
	private String descripcion;

	@Column(columnDefinition="BIT(1) NOT NULL")
	private Boolean estado;

	@Column(length=200, nullable=false)
	private String nombres;

	@Column(length=50, nullable=false, unique=true)
	private String telefono;
	
	@Column(length=1000)
	private String url_foto;
	/* 
	@JsonIgnore
	@OneToMany(mappedBy="empleado_reserva", cascade=CascadeType.ALL)
	private List<Reserva> itemsReserva = new ArrayList<>();
	*/
	public Empleado() { }

	public Integer getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Integer id_empleado) {
		this.id_empleado = id_empleado;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
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
	/*
	public List<Reserva> getItemsReserva() {
		return itemsReserva;
	}

	public void setItemsReserva(List<Reserva> itemsReserva) {
		this.itemsReserva = itemsReserva;
	}
	*/
}
