package pe.spa.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

import pe.spa.entity.Reserva;

public interface ReservaService {
	
	public abstract void delete(Integer id_reserva);
	//public abstract Collection<Reserva> findAll();
	public abstract Reserva findById(Integer id_reserva);
	public abstract void save(Reserva reserva);

	public abstract Integer findReservationsCountByWorker(LocalDate fecha, Integer id_empleado);
	public abstract Integer findReservationsCountByFacility(LocalDate fecha, Integer id_instalacion);
	public abstract Collection<Reserva> findReservationsMadeByFechaAndHora(LocalDate fecha, LocalTime hora, LocalTime hora_fin);
	public abstract Collection<Reserva> findPastOnesByFecha(LocalDate fechaSeleccionada);
	public abstract Collection<Reserva> findPastReservations(int lote);
	public abstract Collection<Reserva> findRecentOnesByEmpleado(Integer id_empleado);
	public abstract Collection<Reserva> findRecentOnesByInstalacion(Integer id_instalacion);
	public abstract Collection<Reserva> findRecentReservations();

}
