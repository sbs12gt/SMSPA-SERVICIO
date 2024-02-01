package pe.spa.service;

import java.util.Collection;

import pe.spa.entity.Reserva;

public interface ReservaService {
	
	public abstract void insert(Reserva reserva);
	public abstract Collection<Reserva> findAll();
	public abstract Reserva findById(Integer id_reserva);
	public abstract void update(Reserva reserva);
	public abstract void delete(Integer id_reserva);

}
