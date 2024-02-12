package pe.spa.service;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.spa.entity.Reserva;
import pe.spa.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	private ReservaRepository repository;

	@Override
	@Transactional
	public void delete(Integer id_reserva) {
		repository.deleteById(id_reserva);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Reserva> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Reserva findById(Integer id_reserva) {
		return repository.findById(id_reserva).orElse(null);
	}

	@Override
	@Transactional
	public void save(Reserva reserva) {
		repository.save(reserva);
	}

	//

	@Override
	@Transactional(readOnly=true)
	public Collection<Reserva> findPastOnesByFecha(LocalDate fechaSeleccionada) {
		return repository.findPastOnesByFecha(fechaSeleccionada);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Reserva> findPastReservations(int lote) {
		return repository.findPastReservations(lote);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Reserva> findRecentOnesByEmpleado(Integer id_empleado) {
		return repository.findRecentOnesByEmpleado(id_empleado);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Reserva> findRecentOnesByInstalacion(Integer id_instalacion) {
		return repository.findRecentOnesByInstalacion(id_instalacion);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Reserva> findRecentReservations() {
		return repository.findRecentReservations();
	}

}
