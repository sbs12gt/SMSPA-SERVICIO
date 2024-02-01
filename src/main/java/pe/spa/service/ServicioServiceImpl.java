package pe.spa.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.spa.entity.Servicio;
import pe.spa.repository.ServicioRepository;

@Service
public class ServicioServiceImpl implements ServicioService {

	@Autowired
	private ServicioRepository repository;

	@Override
	@Transactional
	public void insert(Servicio servicio) {
		repository.save(servicio);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Servicio> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Servicio findById(Integer id_servicio) {
		return repository.findById(id_servicio).orElse(null);
	}

	@Override
	@Transactional
	public void update(Servicio servicio) {
		repository.save(servicio);
	}

	@Override
	@Transactional
	public void delete(Integer id_servicio) {
		repository.deleteById(id_servicio);
	}

	//

	@Override
	@Transactional(readOnly=true)
	public Collection<Servicio> findAvailableServices() {
		return repository.findAvailableServices();
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Servicio> findPopularServices() {
		return repository.findPopularServices();
	}
	
}
