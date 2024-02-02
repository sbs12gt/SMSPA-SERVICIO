package pe.spa.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.spa.entity.Promocion;
public interface PromocionRepository extends JpaRepository<Promocion, Integer> {
	
	@Query(value="SELECT * FROM promociones WHERE estado = true;", nativeQuery=true)
	public abstract Collection<Promocion> findAvailablePromotions();
}
