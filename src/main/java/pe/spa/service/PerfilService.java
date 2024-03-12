package pe.spa.service;

//import java.util.Collection;

import pe.spa.entity.Perfil;
import pe.spa.entity.PerfilAcceso;

public interface PerfilService {
	
	//public abstract void delete(Integer id_perfil);
	//public abstract Collection<Perfil> findAll();
	public abstract Perfil findById(Integer id_perfil);
	public abstract void save(Perfil perfil);

	//

	public abstract Perfil findByUsuario(PerfilAcceso usuario);

}
