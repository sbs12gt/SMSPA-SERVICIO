package pe.spa.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.spa.entity.Instalacion;
import pe.spa.repository.InstalacionRepository;

@Service
public class InstalacionServiceImpl implements InstalacionService {

	@Autowired
	private InstalacionRepository repository;
	/*
	@Override
	@Transactional
	public void delete(Integer id_instalacion) {
		repository.deleteById(id_instalacion);
	}
	*/

	@Override
	@Transactional(readOnly=true)
	public Collection<Instalacion> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Instalacion findById(Integer id_instalacion) {
		return repository.findById(id_instalacion).orElse(null);
	}

	@Override
	@Transactional
	public void save(Instalacion instalacion) {
		repository.save(instalacion);	
	}
	
	//

	@Override
	@Transactional(readOnly=true)
	public Collection<Instalacion> findAvailableFacilities() {
		return repository.findAvailableFacilities();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Integer> findAvailableFacilitiesId() {
		return repository.findAvailableFacilitiesId();
	}

	@Override
	@Transactional(readOnly=true)
	public Instalacion findByRotulo(String rotulo) {
		return repository.findByRotulo(rotulo);
	}

	@Override
	@Transactional
	public void disable(Integer id_instalacion) {
		Instalacion instalacion = repository.findById(id_instalacion).orElse(null);
		if (instalacion != null) {
			if (!instalacion.getEstado()) {
				instalacion.setEstado(true);
			} else {
				instalacion.setColor(null);
				instalacion.setEstado(false);
			}
			repository.save(instalacion);
		}
	}

}
