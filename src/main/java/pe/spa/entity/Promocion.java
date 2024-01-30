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
@Table(name="promociones")
public class Promocion implements Serializable{
	
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
	private String url_imagen_promocion;
	
	@Column
	private Integer descuento;
	
	@Column
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="servicio_id",nullable=false)
	private Servicio servicio;

	public Promocion() {
		// TODO Auto-generated constructor stub
	}

	

	public Promocion(Integer id_promocion, String titulo, String descripcion, Boolean estado,
			LocalDateTime fecha_inicio, LocalDateTime fecha_fin, String url_imagen_promocion, Integer descuento,
			String tipo, Servicio servicio) {
		super();
		this.id_promocion = id_promocion;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.url_imagen_promocion = url_imagen_promocion;
		this.descuento = descuento;
		this.tipo = tipo;
		this.servicio = servicio;
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

	public String getUrl_imagen_promocion() {
		return url_imagen_promocion;
	}

	public void setUrl_imagen_promocion(String url_imagen_promocion) {
		this.url_imagen_promocion = url_imagen_promocion;
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

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	
	
}
