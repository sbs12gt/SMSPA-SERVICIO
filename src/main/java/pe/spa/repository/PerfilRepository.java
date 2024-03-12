package pe.spa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.spa.entity.Perfil;
import pe.spa.entity.PerfilAcceso;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

    public abstract Perfil findByUsuario(PerfilAcceso usuario);

}
