package pe.spa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.spa.entity.Instalacion;

public interface InstalacionRepository extends JpaRepository<Instalacion, Integer> {

	@Query(value="SELECT * FROM instalaciones ORDER BY estado DESC, rotulo", nativeQuery=true)
	public abstract List<Instalacion> findAll();

	@Query(value="SELECT * FROM instalaciones WHERE estado = true ORDER BY rotulo", nativeQuery=true)
	public abstract List<Instalacion> findAvailableFacilities();

	@Query(value="SELECT id_instalacion FROM instalaciones WHERE estado = true", nativeQuery=true)
	public abstract List<Integer> findAvailableFacilitiesId();

	public abstract Instalacion findByRotulo(String rotulo);

}
