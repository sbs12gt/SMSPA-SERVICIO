package pe.spa.entity;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collection;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicio implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_servicio;
	
	@Column(length=200, nullable=false, unique=true)
	private String nombre;
	
	@Column(length=2000)
	private String descripcion;
	
	@Column(columnDefinition="SMALLINT DEFAULT 60 NOT NULL")
	private Short duracion;
	
	@Column(precision=7, scale=2, nullable=false)
	private BigDecimal precio;
	
	@Column(length=1000)
	private String url_imagen;
	
	@Column(length=100, nullable=false)
	private String categoria;
	
	@Column(columnDefinition="TINYINT(1) DEFAULT 0")
	private Boolean favorito;
	
	@Column (columnDefinition="TINYINT(1) DEFAULT 0")
	private Boolean estado;
	/*
	@OneToMany(mappedBy="servicio_promocion", cascade=CascadeType.ALL)
	@JsonIgnore
	private Collection<Promocion> itemsPromocion=new ArrayList<>();
	
	@OneToMany(mappedBy="servicio_reserva", cascade=CascadeType.ALL)
	@JsonIgnore
	private Collection<Reserva> itemsReserva=new ArrayList<>();
	*/
	public Servicio() {	}

	public Servicio(String nombre, String descripcion, Short duracion, BigDecimal precio,
			String url_imagen, String categoria, Boolean favorito, Boolean estado) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.precio = precio;
		this.url_imagen = url_imagen;
		this.categoria = categoria;
		this.favorito = favorito;
		this.estado = estado;
	}

	public Integer getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Integer id_servicio) {
		this.id_servicio = id_servicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Short getDuracion() {
		return duracion;
	}

	public void setDuracion(Short duracion) {
		this.duracion = duracion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getUrl_imagen() {
		return url_imagen;
	}

	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public Boolean getFavorito() {
		return favorito;
	}

	public void setFavorito(Boolean favorito) {
		this.favorito = favorito;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	/*
	public Collection<Reserva> getItemsReserva() {
		return itemsReserva;
	}

	public void setItemsReserva(Collection<Reserva> itemsReserva) {
		this.itemsReserva = itemsReserva;
	}

	public Collection<Promocion> getItemsPromocion() {
		return itemsPromocion;
	}

	public void setItemsPromocion(Collection<Promocion> itemsPromocion) {
		this.itemsPromocion = itemsPromocion;
	}
	*/
}
