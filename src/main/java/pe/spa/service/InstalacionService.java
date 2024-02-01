package pe.spa.service;

import java.util.Collection;

import pe.spa.entity.Instalacion;

public interface InstalacionService {
	
	public abstract void insert(Instalacion instalacion);
	public abstract Collection<Instalacion> findAll();
	public abstract Instalacion findById(Integer id_instalacion);
	public abstract void update(Instalacion instalacion);
	public abstract void delete(Integer id_instalacion);

}
