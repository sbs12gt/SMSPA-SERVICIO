package pe.spa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.spa.entity.Instalacion;
import pe.spa.service.InstalacionService;

@RestController
@RequestMapping("/instalaciones")
@CrossOrigin(origins="*")
public class InstalacionRestController {
	
	@Autowired
	private InstalacionService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Instalacion> instalaciones = service.findAll();
		if(instalaciones.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(instalaciones, HttpStatus.OK);
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Instalacion instalacion) {
		if (instalacion.getColor() == null || instalacion.getColor().length() == 7) {
			if (instalacion.getDescripcion() == null || instalacion.getDescripcion().length() <= 2000) {
				if (instalacion.getRotulo() != null && instalacion.getRotulo().length() <= 100) {
					if (service.findByRotulo(instalacion.getRotulo()) == null) {
						instalacion.setEstado(false);
						instalacion.setId_instalacion(null);
						service.save(instalacion);
						return new ResponseEntity<>("Instalación registrada.", HttpStatus.CREATED);
					}
				}
			}
		}
		return new ResponseEntity<>("Solicitud incorrecta.", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/buscar/{id_instalacion}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer id_instalacion) {
		Instalacion instalacion = service.findById(id_instalacion);
	    if (instalacion == null) {
	    	return new ResponseEntity<>("Instalación no encontrada.", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(instalacion, HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id_instalacion}")
	public ResponseEntity<?> editar_PUT(@RequestBody Instalacion instalacion, @PathVariable Integer id_instalacion) {
		Instalacion instalacionBD = service.findById(id_instalacion);
		if (instalacionBD != null) {
			if (instalacion.getColor() == null || instalacion.getColor().length() == 7) {
				if (instalacion.getDescripcion() == null || instalacion.getDescripcion().length() <= 2000) {
					if (instalacion.getRotulo() != null && instalacion.getRotulo().length() <= 100) {
						Instalacion instalacionDelRotulo = service.findByRotulo(instalacion.getRotulo());
						if (instalacionDelRotulo == null || instalacionDelRotulo.getId_instalacion() == id_instalacion) {
							instalacion.setEstado(instalacionBD.getEstado());
							instalacion.setId_instalacion(id_instalacion);
							service.save(instalacion);
							return new ResponseEntity<>("Instalación editada.", HttpStatus.OK);
						}
					}
				}
			}
			return new ResponseEntity<>("Solicitud incorrecta.", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Instalación no encontrada.", HttpStatus.NOT_FOUND);
	}
	/*
	@DeleteMapping("/borrar/{id_instalacion}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer id_instalacion) {
		Instalacion instalacion = service.findById(id_instalacion);
		if (instalacion != null) {		
			service.delete(id_instalacion);
			return new ResponseEntity<>("Instalación borrada.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Instalación no encontrada.", HttpStatus.NOT_FOUND);
	}
	*/
	//

	@GetMapping("/listarInstalacionesDisponibles")
	public ResponseEntity<?> listarInstalacionesDisponibles_GET() {
		Collection<Instalacion> instalaciones = service.findAvailableFacilities();
		if(instalaciones.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(instalaciones, HttpStatus.OK);
	}

	@PutMapping("/inhabilitar/{id_instalacion}")
	public ResponseEntity<?> inhabilitar_PUT(@PathVariable Integer id_instalacion) {
		Instalacion instalacion = service.findById(id_instalacion);
		if (instalacion != null) {		
			service.disable(id_instalacion);
			return new ResponseEntity<>("Instalación inhabilitada/habilitada.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Instalación no encontrada.", HttpStatus.NOT_FOUND);
	}

}
