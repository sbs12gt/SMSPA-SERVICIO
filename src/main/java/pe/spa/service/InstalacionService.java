package pe.spa.service;

import java.util.Collection;

import pe.spa.entity.Instalacion;

public interface InstalacionService {
	
	//public abstract void delete(Integer id_instalacion);
	public abstract Collection<Instalacion> findAll();
	public abstract Instalacion findById(Integer id_instalacion);
	public abstract void save(Instalacion instalacion);

	public abstract Collection<Instalacion> findAvailableFacilities();
	public abstract Instalacion findByRotulo(String rotulo);
	public abstract void disable(Integer id_instalacion);

}
