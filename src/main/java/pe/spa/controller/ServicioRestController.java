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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.spa.entity.Servicio;
import pe.spa.service.ServicioService;

@RestController
@RequestMapping("/servicio")
@CrossOrigin(origins="*")
public class ServicioRestController {
	
	@Autowired
	private ServicioService service;
	
	public ServicioRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Servicio servicio) {
		service.insert(servicio);		
		return new ResponseEntity<>("¡Servicio registrado!", HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Servicio> servicios = service.findAll();
		if(servicios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(servicios, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id_servicio}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer id_servicio) {
		Servicio servicio = service.findById(id_servicio);
	    if (servicio == null) {
	    	return new ResponseEntity<>("¡No existe el servicio " + id_servicio + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(servicio, HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/borrar/{id_servicio}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer id_servicio) {
		Servicio servicioBD = service.findById(id_servicio);
		if (servicioBD != null) {		
			service.delete(id_servicio);
			return new ResponseEntity<>("¡Servicio borrado!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡No existe el Servicio " + id_servicio + "!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/editar/{id_servicio}")
	public ResponseEntity<?> editar_PUT(@RequestBody Servicio servicio, @PathVariable Integer id_servicio) {
		Servicio servicioBD = service.findById(id_servicio);
		if (servicioBD != null) {
			servicioBD.setNombre(servicio.getNombre());
			servicioBD.setDescripcion(servicio.getDescripcion());
			servicioBD.setDuracion(servicio.getDuracion());
			servicioBD.setPrecio(servicio.getPrecio());
			servicioBD.setUrl_imagen(servicio.getUrl_imagen());
			servicioBD.setCategoria(servicio.getCategoria());
			service.update(servicioBD);
			return new ResponseEntity<>("¡Servicio editado!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡No existe el Servicio " + id_servicio + "!", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/listarServiciosDisponibles")
	public ResponseEntity<?> listarServiciosDisponibles_GET() {
		Collection<Servicio> servicios = service.findAvailableServices();
		if(servicios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(servicios, HttpStatus.OK);
	}
	
	@GetMapping("/listarServiciosPopulares")
	public ResponseEntity<?> listarServiciosPopulares_GET() {
		Collection<Servicio> servicios = service.findPopularServices();
		if(servicios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(servicios, HttpStatus.OK);
	}
	
	

}
