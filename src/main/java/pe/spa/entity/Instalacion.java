package pe.spa.entity;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;

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
	
	@Column(columnDefinition="CHAR(7)")
	private String color;

	@Column(length=2000)
	private String descripcion;

	@Column(columnDefinition="BIT(1) NOT NULL")
	private Boolean estado;

	@Column(length=100, nullable=false, unique=true)
	private String rotulo;
	/*
	@JsonIgnore
	@OneToMany(mappedBy="instalacion_reserva", cascade=CascadeType.ALL)
	private List<Reserva> itemsReserva = new ArrayList<>();
	*/
	public Instalacion() { }
	
	public Integer getId_instalacion() {
		return id_instalacion;
	}

	public void setId_instalacion(Integer id_instalacion) {
		this.id_instalacion = id_instalacion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
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
