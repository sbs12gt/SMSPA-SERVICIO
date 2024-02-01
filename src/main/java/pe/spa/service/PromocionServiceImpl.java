package pe.spa.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.spa.entity.Promocion;
import pe.spa.repository.PromocionRepository;

@Service
public class PromocionServiceImpl implements PromocionService {
	
	@Autowired
	private PromocionRepository repository;

	@Override
	@Transactional
	public void insert(Promocion promocion) {
		repository.save(promocion);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Promocion> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Promocion findById(Integer id_promocion) {
		return repository.findById(id_promocion).orElse(null);
	}

	@Override
	@Transactional
	public void update(Promocion promocion) {
		repository.save(promocion);
	}

	@Override
	@Transactional
	public void delete(Integer id_promocion) {
		repository.deleteById(id_promocion);
	}

}
