package pe.spa.entity;

import java.math.BigDecimal;

public class ReservaServicio {

    private Integer id_servicio;
	private Short duracion;
	private String nombre;
	private BigDecimal precio;

    public ReservaServicio() { }

    public ReservaServicio(Integer id_servicio, Short duracion, String nombre, BigDecimal precio) {
        this.id_servicio = id_servicio;
        this.duracion = duracion;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getId_servicio() {
        return id_servicio;
    }
    
    public void setId_servicio(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }

    public Short getDuracion() {
        return duracion;
    }

    public void setDuracion(Short duracion) {
        this.duracion = duracion;
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

}
