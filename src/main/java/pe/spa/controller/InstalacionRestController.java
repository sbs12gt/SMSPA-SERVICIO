package pe.spa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.spa.entity.Instalacion;
import pe.spa.service.InstalacionService;

@RestController
@RequestMapping("/instalacion")
@CrossOrigin(origins="*")
public class InstalacionRestController {
	
	@Autowired
	private InstalacionService service;
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Instalacion instalacion) {
		service.insert(instalacion);		
		return new ResponseEntity<>("¡Instalacion registrada!", HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Instalacion> instalaciones = service.findAll();
		if(instalaciones.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(instalaciones, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id_instalacion}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer id_instalacion) {
		Instalacion instalacion = service.findById(id_instalacion);
	    if (instalacion == null) {
	    	return new ResponseEntity<>("¡No existe la instalacion " + id_instalacion + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(instalacion, HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/borrar/{id_instalacion}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer id_instalacion) {
		Instalacion instalacionBD = service.findById(id_instalacion);
		if (instalacionBD != null) {		
			service.delete(id_instalacion);
			return new ResponseEntity<>("¡Instalacion borrada!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡No existe la Instalacion " + id_instalacion + "!", HttpStatus.NOT_FOUND);
	}

}
