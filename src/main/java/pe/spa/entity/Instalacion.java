package pe.spa.entity;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collection;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="instalaciones")
public class Instalacion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_instalacion;
	
	@Column
	private String rotulo;
	
	@Column
	private String descripcion;
	
	@Column
	private String estado;
	/*
	@OneToMany(mappedBy="instalacion_reserva", cascade=CascadeType.ALL)
	@JsonIgnore
	private Collection<Reserva> itemsReserva=new ArrayList<>();
	*/
	public Instalacion() { }

	public Instalacion(String rotulo, String descripcion, String estado) {
		super();
		this.rotulo = rotulo;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Integer getId_instalacion() {
		return id_instalacion;
	}

	public void setId_instalacion(Integer id_instalacion) {
		this.id_instalacion = id_instalacion;
	}

	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
