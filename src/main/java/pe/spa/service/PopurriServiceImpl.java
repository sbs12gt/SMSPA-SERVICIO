package pe.spa.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.spa.entity.Popurri;
import pe.spa.repository.PopurriRepository;

@Service
public class PopurriServiceImpl implements PopurriService {

	@Autowired
	private PopurriRepository repository;
	
	@Override
	@Transactional
	public void insert(Popurri popurri) {
		repository.save(popurri);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Popurri> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Popurri findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void update(Popurri popurri) {
		repository.save(popurri);	
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
