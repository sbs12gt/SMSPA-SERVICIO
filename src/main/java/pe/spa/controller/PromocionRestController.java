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
import pe.spa.entity.Promocion;
import pe.spa.service.PromocionService;

@RestController
@RequestMapping("/promociones")
@CrossOrigin(origins="*")
public class PromocionRestController {
	
	@Autowired
	private PromocionService service;
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Promocion promocion) {
		service.insert(promocion);		
		return new ResponseEntity<>("¡Promoción registrada!", HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Promocion> promociones = service.findAll();
		if(promociones.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(promociones, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id_promocion}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer id_promocion) {
		Promocion promocion = service.findById(id_promocion);
	    if (promocion == null) {
	    	return new ResponseEntity<>("¡No existe la promoción " + id_promocion + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(promocion, HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id_promocion}")
	public ResponseEntity<?> editar_PUT(@RequestBody Promocion promocion, @PathVariable Integer id_promocion) {
		Promocion promocionBD = service.findById(id_promocion);
		if (promocionBD != null) {
			promocionBD.setDescripcion(promocion.getDescripcion());
			promocionBD.setDescuento(promocion.getDescuento());
			promocionBD.setEstado(promocion.getEstado());
			promocionBD.setFecha_fin(promocion.getFecha_fin());
			promocionBD.setFecha_inicio(promocion.getFecha_inicio());
			promocionBD.setId_servicio(promocion.getId_servicio());
			promocionBD.setTipo(promocion.getTipo());
			promocionBD.setTitulo(promocion.getTitulo());
			promocionBD.setUrl_imagen(promocion.getUrl_imagen());
			service.update(promocionBD);
			return new ResponseEntity<>("¡Promoción editada!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡No existe la promoción " + id_promocion + "!", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{id_promocion}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer id_promocion) {
		Promocion promocionBD = service.findById(id_promocion);
		if (promocionBD != null) {		
			service.delete(id_promocion);
			return new ResponseEntity<>("¡Promoción borrada!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡No existe la promoción " + id_promocion + "!", HttpStatus.NOT_FOUND);
	}
	
	//
	@GetMapping("/listarPromocionesDisponibles")
	public ResponseEntity<?> listarPromocionesDisponibles_GET() {
		Collection<Promocion> promociones = service.findAvailablePromotions();
		if (promociones.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(promociones, HttpStatus.OK);
	}
	
}
