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

import pe.spa.entity.Reserva;
import pe.spa.service.EmpleadoService;
import pe.spa.service.InstalacionService;
import pe.spa.service.PromocionService;
import pe.spa.service.ReservaService;
import pe.spa.service.ServicioService;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins="*")
public class ReservaRestController {
	
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private InstalacionService instalacionService;
	@Autowired
	private PromocionService promocionService;
	@Autowired
	private ReservaService service;
	@Autowired
	private ServicioService servicioService;

	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Reserva> reservas = service.findAll();
		if(reservas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(reservas, HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Reserva reserva) {
		if (reserva.getApellidos_cliente() != null && reserva.getApellidos_cliente().length() <= 200) {
			if (reserva.getCorreo_cliente() != null && reserva.getCorreo_cliente().length() <= 300) {
				if (reserva.getEstado() != null) {
					if (reserva.getFecha() != null) {
						if (reserva.getHora() != null) {
							if (reserva.getNombres_cliente() != null && reserva.getNombres_cliente().length() <= 200) {
								if (reserva.getTelefono_cliente() != null && reserva.getTelefono_cliente().length() <= 50) {
									if (reserva.getId_servicio() != null && servicioService.findById(reserva.getId_servicio().getId_servicio()) != null) {
										reserva.setId_reserva(null);
										service.save(reserva);
										return new ResponseEntity<>("Reserva registrada.",
											HttpStatus.CREATED);
									}
								}
							}
						}
					}
				}
			}
		}
		return new ResponseEntity<>("Solicitud incorrecta.", HttpStatus.BAD_REQUEST);
	}
	
	
	
	@GetMapping("/buscar/{id_reserva}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer id_reserva) {
		Reserva reserva = service.findById(id_reserva);
	    if (reserva == null) {
	    	return new ResponseEntity<>("¡No existe la reserva " + id_reserva + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(reserva, HttpStatus.OK);
	}
	/* 
	@PutMapping("/editar/{id_reserva}")
	public ResponseEntity<?> editar_PUT(@RequestBody Reserva reserva, @PathVariable Integer id_reserva) {
		Reserva reservaBD = service.findById(id_reserva);
		if (reservaBD != null) {
			reservaBD.setApellidos_cliente(reserva.getApellidos_cliente());
			reservaBD.setCorreo_cliente(reserva.getCorreo_cliente());
			reservaBD.setFecha(reserva.getFecha());
			reservaBD.setHora(reserva.getHora());
			reservaBD.setId_empleado(reserva.getId_empleado());
			reservaBD.setId_instalacion(reserva.getId_instalacion());
			reservaBD.setId_promocion(reserva.getId_promocion());
			reservaBD.setId_servicio(reserva.getId_servicio());
			reservaBD.setNombres_cliente(reserva.getNombres_cliente());
			reservaBD.setTelefono_cliente(reserva.getTelefono_cliente());
			service.update(reservaBD);
			return new ResponseEntity<>("¡Reserva editada!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡No existe la reserva " + id_reserva + "!", HttpStatus.NOT_FOUND);
	}
	*/
	@DeleteMapping("/borrar/{id_reserva}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer id_reserva) {
		Reserva reservaBD = service.findById(id_reserva);
		if (reservaBD != null) {		
			service.delete(id_reserva);
			return new ResponseEntity<>("¡Reserva borrada!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡No existe la reserva " + id_reserva + "!", HttpStatus.NOT_FOUND);
	}

}
