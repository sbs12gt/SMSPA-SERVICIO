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
import pe.spa.entity.Reserva;
import pe.spa.service.ReservaService;

@RestController
@RequestMapping("/reserva")
@CrossOrigin(origins="*")
public class ReservaRestController {
	
	@Autowired
	private ReservaService service;
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Reserva reserva) {
		service.insert(reserva);		
		return new ResponseEntity<>("¡Reserva registrado!", HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Reserva> reservas = service.findAll();
		if(reservas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(reservas, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id_reserva}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer id_reserva) {
		Reserva reserva = service.findById(id_reserva);
	    if (reserva == null) {
	    	return new ResponseEntity<>("¡No existe la reserva " + id_reserva + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(reserva, HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/borrar/{id_reserva}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer id_reserva) {
		Reserva reservaBD = service.findById(id_reserva);
		if (reservaBD != null) {		
			service.delete(id_reserva);
			return new ResponseEntity<>("¡Reserva borrada!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡No existe la Reserva " + id_reserva + "!", HttpStatus.NOT_FOUND);
	}

}
