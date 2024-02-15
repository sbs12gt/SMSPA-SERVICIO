package pe.spa.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.spa.entity.Empleado;
import pe.spa.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoRepository repository;
	/*
	@Override
	@Transactional
	public void delete(Integer id_empleado) {
		repository.deleteById(id_empleado);
	}
	*/
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
	public void save(Empleado empleado) {
		repository.save(empleado);
	}
	
	//

	@Override
	@Transactional(readOnly=true)
	public List<Integer> findAvailableWorkersId() {
		return repository.findAvailableWorkersId();
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Empleado> findAvailableWorkers() {
		return repository.findAvailableWorkers();
	}

	@Override
	@Transactional(readOnly=true)
	public Empleado findByCorreo(String correo) {
		return repository.findByCorreo(correo);
	}

	@Override
	@Transactional(readOnly=true)
	public Empleado findByTelefono(String telefono) {
		return repository.findByTelefono(telefono);
	}

	@Override
	@Transactional
	public void disable(Integer id_empleado) {
		Empleado empleado = repository.findById(id_empleado).orElse(null);
		if (empleado != null) {
			if (!empleado.getEstado()) {
				empleado.setEstado(true);
			} else {
				empleado.setEstado(false);
			}
			repository.save(empleado);
		}
	}

}
