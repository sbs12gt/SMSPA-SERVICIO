package pe.spa.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.spa.entity.Empleado;
import pe.spa.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoRepository repository;

	@Override
	@Transactional
	public void insert(Empleado empleado) {
		repository.save(empleado);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Empleado> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Empleado findById(Integer id_empleado) {
		return repository.findById(id_empleado).orElse(null);
	}

	@Override
	@Transactional
	public void update(Empleado empleado) {
		repository.save(empleado);	
	}

	@Override
	@Transactional
	public void delete(Integer id_empleado) {
		repository.deleteById(id_empleado);
		
	}

	//

	@Override
	@Transactional(readOnly=true)
	public Collection<Empleado> findAvailableWorkers() {
		return repository.findAvailableWorkers();
	}

}
