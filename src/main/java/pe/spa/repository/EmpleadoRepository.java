package pe.spa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.spa.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	
	@Query(value="SELECT * FROM empleados ORDER BY estado DESC, apellidos, nombres", nativeQuery=true)
	public abstract List<Empleado> findAll();

	@Query(value="SELECT id_empleado FROM empleados WHERE estado = true", nativeQuery=true)
	public abstract List<Integer> findAvailableWorkersId();

	@Query(value="SELECT * FROM empleados WHERE estado = true ORDER BY apellidos, nombres", nativeQuery=true)
	public abstract List<Empleado> findAvailableWorkers();

	public abstract Empleado findByCorreo(String correo);

	public abstract Empleado findByTelefono(String telefono);

}
