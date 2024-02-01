package pe.spa.service;

import java.util.Collection;

import pe.spa.entity.Promocion;

public interface PromocionService {

	public abstract void insert(Promocion promocion);
	public abstract Collection<Promocion> findAll();
	public abstract Promocion findById(Integer id_promocion);
	public abstract void update(Promocion promocion);
	public abstract void delete(Integer id_promocion);
	
}
