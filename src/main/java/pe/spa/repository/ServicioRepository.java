package pe.spa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.spa.entity.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
	
	@Query(value="SELECT * FROM servicios ORDER BY estado DESC, nombre", nativeQuery=true)
	public abstract List<Servicio> findAll();

	@Query(value="SELECT * FROM servicios WHERE estado = true ORDER BY nombre", nativeQuery=true)
	public abstract List<Servicio> findAvailableServices();

	@Query(value="SELECT * FROM servicios WHERE id_promocion IS NULL ORDER BY estado DESC, nombre", nativeQuery=true)
	public abstract List<Servicio> findMiniServicesWithoutPromotions();

	@Query(value="SELECT * FROM servicios WHERE categoria = :categoria ORDER BY estado DESC, nombre", nativeQuery=true)
	public abstract List<Servicio> findByCategoria(String categoria);

	@Query(value="SELECT * FROM servicios WHERE id_promocion = :id_promocion ORDER BY estado DESC, nombre", nativeQuery=true)
	public abstract List<Servicio> findMiniServicesByIdPromocion(Integer id_promocion);

	public abstract Servicio findByNombre(String nombre);

	@Query(value="SELECT * FROM servicios WHERE favorito = true AND estado = true ORDER BY nombre", nativeQuery=true)
	public abstract List<Servicio> findPopularServices();

}
