package pe.spa.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaDTO {

	private Integer id_reserva;
	private String apellidos_cliente;
	private String correo_cliente;
	private EstadoReserva estado;
	private LocalDate fecha;
	private LocalTime hora;
	private LocalTime hora_fin;
	private String nombres_cliente;
	private String telefono_cliente;
	private ReservaEmpleado id_empleado;
	private ReservaInstalacion id_instalacion;
	private ReservaPromocion id_promocion;
	private ReservaServicio id_servicio;

    public ReservaDTO() { }

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

	public LocalTime getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(LocalTime hora_fin) {
		this.hora_fin = hora_fin;
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

	public ReservaEmpleado getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(ReservaEmpleado id_empleado) {
		this.id_empleado = id_empleado;
	}

	public ReservaInstalacion getId_instalacion() {
		return id_instalacion;
	}

	public void setId_instalacion(ReservaInstalacion id_instalacion) {
		this.id_instalacion = id_instalacion;
	}

	public ReservaPromocion getId_promocion() {
		return id_promocion;
	}

	public void setId_promocion(ReservaPromocion id_promocion) {
		this.id_promocion = id_promocion;
	}
	
	public ReservaServicio getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(ReservaServicio id_servicio) {
		this.id_servicio = id_servicio;
	}
    
}
