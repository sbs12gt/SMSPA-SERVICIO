package pe.spa.service;

import java.util.Collection;

import pe.spa.entity.Servicio;
import pe.spa.entity.ServicioDTO;

public interface ServicioService {
	
	//public abstract void delete(Integer id_servicio);
	public abstract Collection<Servicio> findAll();
	public abstract Servicio findById(Integer id_servicio);
	public abstract void save(Servicio servicio);
	
	public abstract Collection<Servicio> findAvailableServices();
	public abstract Collection<ServicioDTO> findMiniServicesWithoutPromotions();
	public abstract Collection<Servicio> findByCategoria(String categoria);
	public abstract Collection<ServicioDTO> findMiniServicesByIdPromocion(Integer id_promocion);
	public abstract Servicio findByNombre(String nombre);
	public abstract Collection<Servicio> findPopularServices();
	public abstract void cleanPromocion(Integer id_servicio);
	public abstract void disable(Integer id_promocion);
	public abstract void savePromocion(Integer id_servicio, Integer id_promocion);

}
