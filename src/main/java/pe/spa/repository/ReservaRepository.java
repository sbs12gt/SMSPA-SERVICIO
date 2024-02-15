package pe.spa.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.spa.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva,Integer> {

	@Query(value="SELECT COUNT(*) FROM reservas WHERE fecha = :fecha AND id_empleado = :id_empleado GROUP BY id_empleado", nativeQuery=true)
	public abstract Integer findReservationsCountByWorker(LocalDate fecha, Integer id_empleado);

	@Query(value="SELECT COUNT(*) FROM reservas WHERE fecha = :fecha AND id_instalacion = :id_instalacion GROUP BY id_instalacion", nativeQuery=true)
	public abstract Integer findReservationsCountByFacility(LocalDate fecha, Integer id_instalacion);

	@Query(value="SELECT * FROM reservas WHERE fecha = :fecha AND ( "
	+ "(hora <= ADDTIME(:hora, '-00:45:00') AND hora_fin > ADDTIME(:hora, '-00:45:00')) OR "
	+ "(hora > ADDTIME(:hora, '-00:45:00') AND hora_fin < ADDTIME(:hora_fin, '00:45:00')) OR "
	+ "(hora < ADDTIME(:hora_fin, '00:45:00') AND hora_fin >= ADDTIME(:hora_fin, '00:45:00'))"
	+ " ) ORDER BY hora;", nativeQuery=true)
	public abstract List<Reserva> findReservationsMadeByFechaAndHora(LocalDate fecha, LocalTime hora, LocalTime hora_fin);

	@Query(value="SELECT * FROM reservas WHERE fecha = :fechaSeleccionada AND fecha < CURDATE()"
		+ " ORDER BY fecha DESC, hora DESC", nativeQuery=true)
	public abstract List<Reserva> findPastOnesByFecha(LocalDate fechaSeleccionada);

	@Query(value="SELECT * FROM reservas WHERE fecha < CURDATE() ORDER BY fecha DESC, hora DESC"
		+ " LIMIT 20 OFFSET :lote", nativeQuery=true)
	public abstract List<Reserva> findPastReservations(int lote);

	@Query(value="SELECT * FROM reservas WHERE fecha >= CURDATE() AND id_empleado = :id_empleado"
		+ " ORDER BY fecha, hora", nativeQuery=true)
	public abstract List<Reserva> findRecentOnesByEmpleado(Integer id_empleado);

	@Query(value="SELECT * FROM reservas WHERE fecha >= CURDATE() AND id_instalacion = :id_instalacion"
		+ " ORDER BY fecha, hora", nativeQuery=true)
	public abstract List<Reserva> findRecentOnesByInstalacion(Integer id_instalacion);

	@Query(value="SELECT * FROM reservas WHERE fecha >= CURDATE() ORDER BY fecha, hora", nativeQuery=true)
	public abstract List<Reserva> findRecentReservations();

}
