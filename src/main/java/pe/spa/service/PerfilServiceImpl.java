package pe.spa.service;

//import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.spa.entity.Perfil;
import pe.spa.entity.PerfilAcceso;
import pe.spa.repository.PerfilRepository;

@Service
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	private PerfilRepository repository;
	/*
	@Override
	@Transactional
	public void delete(Integer id_perfil) {
		repository.deleteById(id_perfil);
	}
	 
	@Override
	@Transactional(readOnly=true)
	public Collection<Perfil> findAll() {
		return repository.findAll();
	}
	*/
	@Override
	@Transactional(readOnly=true)
	public Perfil findById(Integer id_perfil) {
		return repository.findById(id_perfil).orElse(null);
	}

	@Override
	@Transactional
	public void save(Perfil perfil) {
		repository.save(perfil);	
	}

	@Override
	@Transactional(readOnly=true)
	public Perfil findByUsuario(PerfilAcceso usuario) {
		return repository.findByUsuario(usuario);
	}

}
