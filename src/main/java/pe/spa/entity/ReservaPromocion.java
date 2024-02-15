package pe.spa.entity;

public class ReservaPromocion {

    private Integer id_promocion;
	private Short descuento;
	private TipoPromocion tipo;

    public ReservaPromocion() { }

    public ReservaPromocion(Integer id_promocion, Short descuento, TipoPromocion tipo) {
        this.id_promocion = id_promocion;
        this.descuento = descuento;
        this.tipo = tipo;
    }

    public Integer getId_promocion() {
        return id_promocion;
    }
    
    public void setId_promocion(Integer id_promocion) {
        this.id_promocion = id_promocion;
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

}
