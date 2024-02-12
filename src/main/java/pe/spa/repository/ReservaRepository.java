package pe.spa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.spa.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva,Integer> {

	@Query(value="SELECT * FROM reservas WHERE fecha = :fechaSeleccionada AND fecha < CURRENT_TIMESTAMP"
		+ " ORDER BY fecha DESC, hora DESC", nativeQuery=true)
	public abstract List<Reserva> findPastOnesByFecha(LocalDate fechaSeleccionada);

	@Query(value="SELECT * FROM reservas WHERE fecha < CURRENT_TIMESTAMP ORDER BY fecha DESC, hora DESC"
		+ " LIMIT 20 OFFSET :lote", nativeQuery=true)
	public abstract List<Reserva> findPastReservations(int lote);

	@Query(value="SELECT * FROM reservas WHERE fecha >= CURRENT_TIMESTAMP AND id_empleado = :id_empleado"
		+ " ORDER BY fecha, hora", nativeQuery=true)
	public abstract List<Reserva> findRecentOnesByEmpleado(Integer id_empleado);

	@Query(value="SELECT * FROM reservas WHERE fecha >= CURRENT_TIMESTAMP AND id_instalacion = :id_instalacion"
		+ " ORDER BY fecha, hora", nativeQuery=true)
	public abstract List<Reserva> findRecentOnesByInstalacion(Integer id_instalacion);

	@Query(value="SELECT * FROM reservas WHERE fecha >= CURRENT_TIMESTAMP ORDER BY fecha, hora", nativeQuery=true)
	public abstract List<Reserva> findRecentReservations();

}
