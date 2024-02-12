package pe.spa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_reserva;
	
	@Column(length=200, nullable=false)
	private String apellidos_cliente;

	@Column(length=300, nullable=false)
	private String correo_cliente;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition="ENUM('CANCELADO', 'PAGADO', 'REPROGRAMADO')"
		+ " NOT NULL")
	private EstadoReserva estado;

	@Column(nullable=false)
	private LocalDate fecha;

	@Column(columnDefinition="TIME(0) NOT NULL")
	private LocalTime hora;

	@Column(length=200, nullable=false)
	private String nombres_cliente;

	@Column(length=50, nullable=false)
	private String telefono_cliente;

	@ManyToOne
	@JoinColumn(name="id_empleado", nullable=false)
	private Empleado id_empleado;
	
	@ManyToOne
	@JoinColumn(name="id_instalacion", nullable=false)
	private Instalacion id_instalacion;

	@ManyToOne
	@JoinColumn(name="id_promocion")
	private Promocion id_promocion;

	@ManyToOne
	@JoinColumn(name="id_servicio", nullable=false)
	private Servicio id_servicio;

	public Reserva() { }

	public Integer getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Integer id_reserva) {
		this.id_reserva = id_reserva;
	}

	public String getApellidos_cliente() {
		return apellidos_cliente;
	}

	public void setApellidos_cliente(String apellidos_cliente) {
		this.apellidos_cliente = apellidos_cliente;
	}

	public String getCorreo_cliente() {
		return correo_cliente;
	}

	public void setCorreo_cliente(String correo_cliente) {
		this.correo_cliente = correo_cliente;
	}

	public EstadoReserva getEstado() {
		return estado;
	}

	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getNombres_cliente() {
		return nombres_cliente;
	}

	public void setNombres_cliente(String nombres_cliente) {
		this.nombres_cliente = nombres_cliente;
	}

	public String getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}

	public Empleado getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Empleado id_empleado) {
		this.id_empleado = id_empleado;
	}

	public Instalacion getId_instalacion() {
		return id_instalacion;
	}

	public void setId_instalacion(Instalacion id_instalacion) {
		this.id_instalacion = id_instalacion;
	}

	public Promocion getId_promocion() {
		return id_promocion;
	}

	public void setId_promocion(Promocion id_promocion) {
		this.id_promocion = id_promocion;
	}
	
	public Servicio getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Servicio id_servicio) {
		this.id_servicio = id_servicio;
	}

}
