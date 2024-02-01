package pe.spa.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.spa.entity.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	
	@Query(value="SELECT * FROM empleados WHERE estado = true;", nativeQuery=true)
	public abstract Collection<Empleado> findAvailableWorkers();

}
