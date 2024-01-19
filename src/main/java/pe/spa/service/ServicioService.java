package pe.spa.service;

import java.util.Collection;

import pe.spa.entity.Servicio;

public interface ServicioService {
	
	public abstract void insert(Servicio servicio);
	public abstract Collection<Servicio> findAll();
	public abstract Servicio findById(Integer id_servicio);
	public abstract void update(Servicio servicio);
	public abstract void delete(Integer id_servicio);

}
