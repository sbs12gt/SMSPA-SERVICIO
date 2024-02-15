package pe.spa.service;

import java.util.Collection;
import java.util.List;

import pe.spa.entity.Empleado;

public interface EmpleadoService {

	//public abstract void delete(Integer id_empleado);
	public abstract Collection<Empleado> findAll();
	public abstract Empleado findById(Integer id_empleado);
	public abstract void save(Empleado empleado);
	
	public abstract List<Integer> findAvailableWorkersId();
	public abstract Collection<Empleado> findAvailableWorkers();
	public abstract Empleado findByCorreo(String correo);
	public abstract Empleado findByTelefono(String telefono);
	public abstract void disable(Integer id_empleado);
	
}
