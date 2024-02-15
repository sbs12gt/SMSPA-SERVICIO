package pe.spa.entity;

public class ReservaEmpleado {

    private Integer id_empleado;
	private String apellidos;
	private String nombres;

    public ReservaEmpleado() { }

    public ReservaEmpleado(Integer id_empleado, String apellidos, String nombres) {
        this.id_empleado = id_empleado;
        this.apellidos = apellidos;
        this.nombres = nombres;
    }

    public Integer getId_empleado() {
        return id_empleado;
    }
    
    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
}
