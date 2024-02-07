package pe.spa.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.spa.entity.Promocion;
public interface PromocionRepository extends JpaRepository<Promocion, Integer> {
	
	@Query(value="SELECT * FROM promociones WHERE estado = true;", nativeQuery=true)
	public abstract Collection<Promocion> findAvailablePromotions();
	
	@Query(value="SELECT pro.id_promocion, pro.titulo, pro.descripcion, pro.estado, pro.fecha_inicio, pro.fecha_fin, pro.url_imagen, pro.descuento, pro.tipo, s.id_servicio, s.nombre  \n"
			+ "FROM promociones pro \n"
			+ "INNER JOIN servicios s ON pro.id_servicio = s.id_servicio \n"
			+ ";", nativeQuery=true)
	public abstract Collection<Object[]> SpecificFindAll();

}
