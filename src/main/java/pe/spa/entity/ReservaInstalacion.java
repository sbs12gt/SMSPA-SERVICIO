package pe.spa.entity;

public class ReservaInstalacion {

    private Integer id_instalacion;
	private String color;
	private String rotulo;

    public ReservaInstalacion() { }

    public ReservaInstalacion(Integer id_instalacion, String color, String rotulo) {
        this.id_instalacion = id_instalacion;
        this.color = color;
        this.rotulo = rotulo;
    }

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

    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

}
