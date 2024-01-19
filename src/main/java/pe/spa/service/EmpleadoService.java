package pe.spa.service;

import java.util.Collection;

import pe.spa.entity.Empleado;

public interface EmpleadoService {

	public abstract void insert(Empleado empleado);
	public abstract Collection<Empleado> findAll();
	public abstract Empleado findById(Integer id_empleado);
	public abstract void update(Empleado empleado);
	public abstract void delete(Integer id_empleado);
}
