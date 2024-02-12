package pe.spa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="servicios")
public class Servicio implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_servicio;

	@Column(length=100, nullable=false)
	private String categoria;

	@Column(length=2000)
	private String descripcion;

	@Column(columnDefinition="SMALLINT NOT NULL")
	private Short duracion;

	@Column(columnDefinition="BIT(1) NOT NULL")
	private Boolean estado;

	@Column(columnDefinition="BIT(1) NOT NULL")
	private Boolean favorito;
	
	@Column(length=200, nullable=false, unique=true)
	private String nombre;

	@Column(precision=7, scale=2, nullable=false)
	private BigDecimal precio;
	
	@Column(length=1000)
	private String url_imagen;

	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_promocion")
    private Promocion promocion;
	/*
	@JsonIgnore
	@OneToMany(mappedBy="servicio_reserva", cascade=CascadeType.ALL)
	private List<Reserva> itemsReserva = new ArrayList<>();
	*/
	public Servicio() {	}

	public Integer getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Integer id_servicio) {
		this.id_servicio = id_servicio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Boolean getFavorito() {
		return favorito;
	}

	public void setFavorito(Boolean favorito) {
		this.favorito = favorito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Promocion getPromocion() {
		return promocion;
	}

	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
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
