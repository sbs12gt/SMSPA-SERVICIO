package pe.spa.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.spa.entity.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
	
	@Query(value="SELECT * FROM servicio WHERE estado = true; ", nativeQuery=true)
	public abstract Collection<Servicio> findAvailableServices();
	@Query(value="SELECT * FROM servicio WHERE favorito = true; ", nativeQuery=true)
	public abstract Collection<Servicio> findPopularServices();

}
