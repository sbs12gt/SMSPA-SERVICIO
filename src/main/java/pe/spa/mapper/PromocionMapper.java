package pe.spa.mapper;

import java.time.LocalDateTime;

import pe.spa.entity.Promocion;


public class PromocionMapper {
	
	private Integer id_promocion;
	private String titulo;
	private String descripcion;
	private Boolean estado;
	private LocalDateTime fecha_inicio;
	private LocalDateTime fecha_fin;
	private String url_imagen;
	private Integer descuento;
	private String tipo;
	private Integer id_servicio;
	private String nombre_servicio;
	
	public PromocionMapper() {
		// TODO Auto-generated constructor stub
	}
	
	public PromocionMapper(Promocion promocion) {
		this(promocion.getId_promocion(),promocion.getTitulo(),promocion.getDescripcion(),promocion.getEstado(),
				promocion.getFecha_inicio(),promocion.getFecha_fin(),promocion.getUrl_imagen(),
				promocion.getDescuento(),promocion.getTipo(),promocion.getId_servicio().getId_servicio(),promocion.getId_servicio().getNombre());
	}


	public PromocionMapper(Integer id_promocion, String titulo, String descripcion, Boolean estado,
			LocalDateTime fecha_inicio, LocalDateTime fecha_fin, String url_imagen, Integer descuento, String tipo,
			Integer id_servicio, String nombre_servicio) {
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
		this.id_servicio = id_servicio;
		this.nombre_servicio = nombre_servicio;
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

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Integer id_servicio) {
		this.id_servicio = id_servicio;
	}

	public String getNombre_servicio() {
		return nombre_servicio;
	}

	public void setNombre_servicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}
	
	
	

}
