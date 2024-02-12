package pe.spa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="promociones")
public class Promocion implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_promocion;
	
	@Column(length=3000)
	private String descripcion;

	@Column(nullable=false)
	private Short descuento;

	@Column(columnDefinition="BIT(1) NOT NULL")
	private Boolean estado;

	@Column(nullable=false)
	private LocalDate fecha_fin;

	@Column(nullable=false)
	private LocalDate fecha_inicio;

	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private TipoPromocion tipo;

	@Column(length=500, nullable=false, unique=true)
	private String titulo;

	@Column(length=1000)
	private String url_imagen;

	@JsonIgnore
	@OneToMany(mappedBy="promocion", cascade=CascadeType.ALL)
    private List<Servicio> itemsServicio = new ArrayList<>();
	/*
	@JsonIgnore
	@OneToMany(mappedBy="promocion_reserva", cascade=CascadeType.ALL)
	private List<Reserva> itemsReserva = new ArrayList<>();
	*/
	public Promocion() { }

	public Integer getId_promocion() {
		return id_promocion;
	}

	public void setId_promocion(Integer id_promocion) {
		this.id_promocion = id_promocion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Short getDescuento() {
		return descuento;
	}

	public void setDescuento(Short descuento) {
		this.descuento = descuento;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public LocalDate getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	
	public TipoPromocion getTipo() {
		return tipo;
	}

	public void setTipo(TipoPromocion tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl_imagen() {
		return url_imagen;
	}

	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}

	public List<Servicio> getItemsServicio() {
		return itemsServicio;
	}

	public void setItemsServicio(List<Servicio> itemsServicio) {
		this.itemsServicio = itemsServicio;
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
