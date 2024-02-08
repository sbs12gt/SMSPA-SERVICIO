package pe.spa.entity;

import java.io.Serializable;
import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Collection;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="promociones")
public class Promocion implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_promocion;
	
	@Column(length=500, nullable=false, unique=true)
	private String titulo;
	
	@Column(length=3000)
	private String descripcion;
	
	@Column(columnDefinition="TINYINT(1) DEFAULT 0")
	private Boolean estado;
	
	@Column(nullable=false)
	private LocalDate fecha_inicio;
	
	@Column(nullable=false)
	private LocalDate fecha_fin;
	
	@Column(length=1000)
	private String url_imagen;
	
	@Column(nullable=false)
	private Short descuento;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private TipoPromocion tipo;
	
	@Column(length=1000)
	private String servicios;
	/*
	@OneToMany(mappedBy="promocion_reserva", cascade=CascadeType.ALL)
	@JsonIgnore
	private Collection<Reserva> itemsReserva=new ArrayList<>();
	*/
	public Promocion() { }

	public Promocion(String titulo, String descripcion, Boolean estado,
	LocalDate fecha_inicio, LocalDate fecha_fin, String url_imagen, Short descuento,
			TipoPromocion tipo, String servicios) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.url_imagen = url_imagen;
		this.descuento = descuento;
		this.tipo = tipo;
		this.servicios = servicios;
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

	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public LocalDate getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getUrl_imagen() {
		return url_imagen;
	}

	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}

	public Short getDescuento() {
		return descuento;
	}

	public void setDescuento(Short descuento) {
		this.descuento = descuento;
	}

	public TipoPromocion getTipo() {
		return tipo;
	}

	public void setTipo(TipoPromocion tipo) {
		this.tipo = tipo;
	}

	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
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
