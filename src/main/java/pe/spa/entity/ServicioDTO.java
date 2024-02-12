package pe.spa.entity;

public class ServicioDTO {

    private Integer id_servicio;
    private Boolean estado;
    private String nombre;

    public ServicioDTO() { }

    public ServicioDTO(Integer id_servicio, Boolean estado, String nombre) {
        this.id_servicio = id_servicio;
        this.estado = estado;
        this.nombre = nombre;
    }

    public Integer getId_servicio() {
        return id_servicio;
    }
    
    public void setId_servicio(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
