package pe.spa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.spa.entity.Promocion;

public interface PromocionRepository extends JpaRepository<Promocion, Integer> {
	
	@Query(value="SELECT * FROM promociones ORDER BY estado DESC, fecha_fin DESC", nativeQuery=true)
	public abstract List<Promocion> findAll();

	@Query(value="SELECT * FROM promociones WHERE id_promocion = :id_promocion AND estado = true"
		+ " AND :fechaReserva BETWEEN fecha_inicio AND fecha_fin", nativeQuery=true)
	public abstract Promocion findApplicablePromotion(Integer id_promocion, LocalDate fechaReserva);

	@Query(value="SELECT * FROM promociones WHERE estado = true AND fecha_fin >= CURRENT_TIMESTAMP"
		+ " ORDER BY fecha_fin DESC", nativeQuery=true)
	public abstract List<Promocion> findAvailablePromotions();

	@Query(value="SELECT * FROM promociones WHERE tipo = :tipo ORDER BY estado DESC, fecha_fin DESC", nativeQuery=true)
	public abstract List<Promocion> findByTipoPromocion(String tipo);

	public abstract Promocion findByTitulo(String titulo);

}
