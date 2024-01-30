package pe.spa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="servicio")
public class Servicio implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_servicio;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column
	private Integer duracion;
	
	@Column
	private Double precio;
	
	@Column
	private String url_imagen;
	
	@Column
	private Integer categoria;
	
	@Column
	private Boolean favorito;
	
	@Column 
	private Boolean estado;

	@OneToMany(mappedBy="servicio", cascade=CascadeType.ALL)
	@JsonIgnore
	private Collection<Promocion> itemsPromocion=new ArrayList<>();
	
	@OneToMany(mappedBy="especialidad", cascade=CascadeType.ALL)
	@JsonIgnore
	private Collection<Empleado> itemsEmpleado=new ArrayList<>();
	
	@OneToMany(mappedBy="servicio_reservado", cascade=CascadeType.ALL)
	@JsonIgnore
	private Collection<Reserva> itemsReserva=new ArrayList<>();
	
	
	public Servicio() {
		
	}

	

	public Servicio(Integer id_servicio, String nombre, String descripcion, Integer duracion, Double precio,
			String url_imagen, Integer categoria, Boolean favorito, Boolean estado) {
		super();
		this.id_servicio = id_servicio;
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

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getUrl_imagen() {
		return url_imagen;
	}

	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
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

	public Collection<Empleado> getItemsEmpleado() {
		return itemsEmpleado;
	}

	public void setItemsEmpleado(Collection<Empleado> itemsEmpleado) {
		this.itemsEmpleado = itemsEmpleado;
	}

	
	
	
	
	

}

