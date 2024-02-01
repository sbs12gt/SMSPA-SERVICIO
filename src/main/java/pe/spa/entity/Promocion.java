package pe.spa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Collection;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="promociones")
public class Promocion implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_promocion;
	
	@Column
	private String titulo;
	
	@Column
	private String descripcion;
	
	@Column
	private Boolean estado;
	
	@Column
	private LocalDateTime fecha_inicio;
	
	@Column
	private LocalDateTime fecha_fin;
	
	@Column
	private String url_imagen;
	
	@Column
	private Integer descuento;
	
	@Column
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="servicio_promocion")
	private Servicio id_servicio;
	/*
	@OneToMany(mappedBy="promocion_reserva", cascade=CascadeType.ALL)
	@JsonIgnore
	private Collection<Reserva> itemsReserva=new ArrayList<>();
	*/
	public Promocion() { }

	public Promocion(String titulo, String descripcion, Boolean estado,
			LocalDateTime fecha_inicio, LocalDateTime fecha_fin, String url_imagen, Integer descuento,
			String tipo, Servicio id_servicio) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.url_imagen = url_imagen;
		this.descuento = descuento;
		this.tipo = tipo;
		this.id_servicio = id_servicio;
	}

	public Integer getId_promocion() {
		return id_promocion;
	}

	public void setId_promocion(Integer id_promocion) {
		this.id_promocion = id_promocion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public LocalDateTime getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(LocalDateTime fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public LocalDateTime getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(LocalDateTime fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getUrl_imagen() {
		return url_imagen;
	}

	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Servicio getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Servicio id_servicio) {
		this.id_servicio = id_servicio;
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
