package pe.spa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="perfiles")
public class Perfil {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_perfil;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private PerfilAcceso usuario;

	@Column(nullable=false)
	private String contrasena;

	public Perfil() { }

	public Perfil(PerfilAcceso usuario, String contrasena) {
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	
	public Integer getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(Integer id_perfil) {
		this.id_perfil = id_perfil;
	}

	public PerfilAcceso getUsuario() {
		return usuario;
	}

	public void setUsuario(PerfilAcceso usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
