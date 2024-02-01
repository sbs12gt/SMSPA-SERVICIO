package pe.spa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_reserva;
	
	@ManyToOne
	@JoinColumn(name="servicio",nullable=false)
	private Servicio servicio_reservado;
	
	@Column
	private LocalDateTime fecha;
	
	@Column
	private LocalDateTime hora;

	@Column
	private String correo_cliente;
	
	@Column
	private String nombre_cliente;
	
	@Column
	private String apellido_cliente;
	
	@Column
	private String telefono_cliente;
	
	@ManyToOne
	@JoinColumn(name="empleado",nullable=false)
	private Empleado empleado_reservado;
	
	@ManyToOne
	@JoinColumn(name="instalacion",nullable=false)
	private Instalacion instalacion_reservada;
	
	@ManyToOne
	@JoinColumn(name="promocion",nullable=false)
	private Promocion promocion_reservada;
	
	public Reserva() {
		
	}

	public Reserva(Integer id_reserva, LocalDateTime fecha, LocalDateTime hora, String correo_cliente,
			String nombre_cliente, String apellido_cliente, String telefono_cliente) {
		super();
		this.id_reserva = id_reserva;
		this.fecha = fecha;
		this.hora = hora;
		this.correo_cliente = correo_cliente;
		this.nombre_cliente = nombre_cliente;
		this.apellido_cliente = apellido_cliente;
		this.telefono_cliente = telefono_cliente;
	}

	public Integer getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Integer id_reserva) {
		this.id_reserva = id_reserva;
	}

	public Servicio getServicio_reservado() {
		return servicio_reservado;
	}

	public void setServicio_reservado(Servicio servicio_reservado) {
		this.servicio_reservado = servicio_reservado;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}

	public String getCorreo_cliente() {
		return correo_cliente;
	}

	public void setCorreo_cliente(String correo_cliente) {
		this.correo_cliente = correo_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getApellido_cliente() {
		return apellido_cliente;
	}

	public void setApellido_cliente(String apellido_cliente) {
		this.apellido_cliente = apellido_cliente;
	}

	public String getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}

	public Empleado getEmpleado_reservado() {
		return empleado_reservado;
	}

	public void setEmpleado_reservado(Empleado empleado_reservado) {
		this.empleado_reservado = empleado_reservado;
	}

	public Instalacion getInstalacion_reservada() {
		return instalacion_reservada;
	}

	public void setInstalacion_reservada(Instalacion instalacion_reservada) {
		this.instalacion_reservada = instalacion_reservada;
	}

	public Promocion getPromocion_reservada() {
		return promocion_reservada;
	}

	public void setPromocion_reservada(Promocion promocion_reservada) {
		this.promocion_reservada = promocion_reservada;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
