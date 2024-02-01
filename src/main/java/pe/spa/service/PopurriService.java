package pe.spa.service;

import java.util.Collection;

import pe.spa.entity.Popurri;

public interface PopurriService {

    public abstract void insert(Popurri popurri);
	public abstract Collection<Popurri> findAll();
	public abstract Popurri findById(Integer id);
	public abstract void update(Popurri popurri);
	public abstract void delete(Integer id);
    
}
