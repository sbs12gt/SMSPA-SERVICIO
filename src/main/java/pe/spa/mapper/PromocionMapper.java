package pe.spa.mapper;

import java.time.LocalDateTime;

import pe.spa.entity.Promocion;
import pe.spa.entity.TipoPromocion;

public class PromocionMapper {
	
	private Integer id_promocion;
	private String titulo;
	private String descripcion;
	private Boolean estado;
	private LocalDateTime fecha_inicio;
	private LocalDateTime fecha_fin;
	private String url_imagen;
	private Short descuento;
	private TipoPromocion tipo;
	private String servicios;
	
	public PromocionMapper() { }
	
	public PromocionMapper(Promocion promocion) {
		this(promocion.getId_promocion(),promocion.getTitulo(),promocion.getDescripcion(),promocion.getEstado(),
				promocion.getFecha_inicio(),promocion.getFecha_fin(),promocion.getUrl_imagen(),
				promocion.getDescuento(),promocion.getTipo(),promocion.getServicios());
	}

	public PromocionMapper(Integer id_promocion, String titulo, String descripcion, Boolean estado, LocalDateTime fecha_inicio,
		LocalDateTime fecha_fin, String url_imagen, Short descuento, TipoPromocion tipo, String servicios) {
		super();
		this.id_promocion = id_promocion;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.url_imagen = url_imagen;
		this.descuento = descuento;
		this.tipo = tipo;
		this.servicios = servicios;
	}

	public Integer getId_promocion() {
		return id_promocion;
	}

	public void setId_promocion(Integer id_promocion) {
		this.id_promocion = id_promocion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public LocalDateTime getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(LocalDateTime fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public LocalDateTime getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(LocalDateTime fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getUrl_imagen() {
		return url_imagen;
	}

	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
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

	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

}
