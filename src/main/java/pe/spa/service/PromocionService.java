package pe.spa.service;

import java.time.LocalDate;
import java.util.Collection;

import pe.spa.entity.Promocion;
import pe.spa.entity.TipoPromocion;

public interface PromocionService {

	//public abstract void delete(Integer id_promocion);
	public abstract Collection<Promocion> findAll();
	public abstract Promocion findById(Integer id_promocion);
	public abstract void save(Promocion promocion);

	public abstract Promocion findApplicablePromotion(Integer id_promocion, LocalDate fechaReserva);
	public abstract Collection<Promocion> findAvailablePromotions();
	public abstract Collection<Promocion> findByTipoPromocion(TipoPromocion tipo);
	public abstract Promocion findByTitulo(String titulo);
	public abstract void disable(Integer id_promocion);
	public abstract void removeServicios(Integer id_promocion);
	
}
