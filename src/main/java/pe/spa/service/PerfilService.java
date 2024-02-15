package pe.spa.service;

//import java.util.Collection;

import pe.spa.entity.Perfil;

public interface PerfilService {
	
	//public abstract void delete(Integer id_perfil);
	//public abstract Collection<Perfil> findAll();
	public abstract Perfil findById(Integer id_perfil);
	public abstract void save(Perfil perfil);

}
