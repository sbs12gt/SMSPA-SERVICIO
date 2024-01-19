package pe.spa.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.spa.entity.Instalacion;
import pe.spa.repository.InstalacionRepository;

@Service
public class InstalacionServiceImpl implements InstalacionService{

	@Autowired
	private InstalacionRepository repository;
	
	
	@Override
	@Transactional
	public void insert(Instalacion instalacion) {
		repository.save(instalacion);
		
	}

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
	public void update(Instalacion instalacion) {
		repository.save(instalacion);
		
	}

	@Override
	@Transactional
	public void delete(Integer id_instalacion) {
		repository.deleteById(id_instalacion);
		
	}

}
