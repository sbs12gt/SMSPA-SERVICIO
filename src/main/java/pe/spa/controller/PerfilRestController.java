package pe.spa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.spa.entity.Perfil;
import pe.spa.service.PerfilService;

@RestController
@RequestMapping("/perfiles")
@CrossOrigin(origins="*")
public class PerfilRestController {
	
	@Autowired
	private PerfilService service;

	@GetMapping("/buscar/{id_perfil}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer id_perfil) {
		Perfil perfil = service.findById(id_perfil);
	    if (perfil == null) {
	    	return new ResponseEntity<>("Perfil no encontrado.", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(perfil, HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id_perfil}")
	public ResponseEntity<?> editar_PUT(@RequestBody Perfil perfil, @PathVariable Integer id_perfil) {
		Perfil perfilBD = service.findById(id_perfil);
		if (perfilBD != null) {
			if (perfil.getUsuario() != null) {
				if (perfil.getContrasena() != null) {
					
				}
			}
			return new ResponseEntity<>("Solicitud incorrecta.", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Perfil no encontrado.", HttpStatus.NOT_FOUND);
	}

}
