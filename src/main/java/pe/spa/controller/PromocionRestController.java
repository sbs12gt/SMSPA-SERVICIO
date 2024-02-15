package pe.spa.controller;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.spa.entity.Promocion;
import pe.spa.entity.Servicio;
import pe.spa.entity.TipoPromocion;
import pe.spa.service.PromocionService;
import pe.spa.service.ServicioService;

@RestController
@RequestMapping("/promociones")
@CrossOrigin(origins = "*")
public class PromocionRestController {

	@Autowired
	private PromocionService service;
	@Autowired
	private ServicioService servicioService;

	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Promocion> promociones = service.findAll();
		if (promociones.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(promociones, HttpStatus.OK);
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Promocion promocion) {
		if (promocion.getDescripcion() == null || promocion.getDescripcion().length() <= 3000) {
			if (promocion.getDescuento() != null) {
				if (promocion.getEstado() != null) {
					if (promocion.getFecha_fin() != null) {
						if (promocion.getFecha_inicio() != null) {
							if (promocion.getFecha_inicio().isBefore(promocion.getFecha_fin())) {
								if (promocion.getTipo() != null) {
									if (promocion.getTitulo() != null && promocion.getTitulo().length() <= 500) {
										if (promocion.getUrl_imagen() == null
												|| promocion.getUrl_imagen().length() <= 1000) {
											if (service.findByTitulo(promocion.getTitulo()) == null) {
												promocion.setId_promocion(null);
												service.save(promocion);
												return new ResponseEntity<>("Promoción registrada.",
														HttpStatus.CREATED);
											}
										}
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

	@GetMapping("/buscar/{id_promocion}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer id_promocion) {
		Promocion promocion = service.findById(id_promocion);
		if (promocion == null) {
			return new ResponseEntity<>("Promoción no encontrada.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(promocion, HttpStatus.OK);
	}

	@PutMapping("/editar/{id_promocion}")
	public ResponseEntity<?> editar_PUT(@RequestBody Promocion promocion, @PathVariable Integer id_promocion) {
		Promocion promocionBD = service.findById(id_promocion);
		if (promocionBD != null) {
			if (promocion.getDescripcion() == null || promocion.getDescripcion().length() <= 3000) {
				if (promocion.getDescuento() != null) {
					if (promocion.getFecha_fin() != null) {
						if (promocion.getFecha_inicio() != null) {
							if (promocion.getFecha_inicio().isBefore(promocion.getFecha_fin())) {
								if (promocion.getTipo() != null) {
									if (promocion.getTitulo() != null && promocion.getTitulo().length() <= 500) {
										if (promocion.getUrl_imagen() == null
												|| promocion.getUrl_imagen().length() <= 1000) {
											Promocion promocionDelTitulo = service.findByTitulo(promocion.getTitulo());
											if (promocionDelTitulo == null
													|| promocionDelTitulo.getId_promocion() == id_promocion) {
												promocion.setEstado(promocionBD.getEstado());
												promocion.setId_promocion(id_promocion);
												service.save(promocion);
												return new ResponseEntity<>("Promoción editada.",
														HttpStatus.OK);
											}
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
		return new ResponseEntity<>("Promoción no encontrada.", HttpStatus.NOT_FOUND);
	}
	/*
	@DeleteMapping("/borrar/{id_promocion}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer id_promocion) {
		Promocion promocion = service.findById(id_promocion);
		if (promocion != null) {
			service.delete(id_promocion);
			return new ResponseEntity<>("Promoción borrada.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Promoción no encontrada.",
				HttpStatus.NOT_FOUND);
	}
	*/
	//

	@GetMapping("/buscarPromocionAplicable")
	public ResponseEntity<?> buscarPromocionAplicable_GET(@RequestParam Integer id_servicio, @RequestParam LocalDate fechaReserva) {
		Servicio servicio = servicioService.findById(id_servicio);
		if (servicio != null) {
			Promocion promocion = service.findApplicablePromotion(id_servicio, fechaReserva);
			if (promocion == null) {
				return new ResponseEntity<>("Promoción no encontrada.", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(promocion, HttpStatus.OK);
		}
		return new ResponseEntity<>("Servicio no encontrado", HttpStatus.NOT_FOUND);
	}
	 
	@GetMapping("/listarPromocionesDisponibles")
	public ResponseEntity<?> listarPromocionesDisponibles_GET() {
		Collection<Promocion> promociones = service.findAvailablePromotions();
		if (promociones.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(promociones, HttpStatus.OK);
	}

	@GetMapping("/buscarPorTipoPromocion/{tipo}")
	public ResponseEntity<?> buscarPorTipoPromocion_GET(@PathVariable TipoPromocion tipo) {
		Collection<Promocion> promociones = service.findByTipoPromocion(tipo);
		if (promociones.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(promociones, HttpStatus.OK);
	}

	@PutMapping("/inhabilitar/{id_promocion}")
	public ResponseEntity<?> inhabilitar_PUT(@PathVariable Integer id_promocion) {
		Promocion promocion = service.findById(id_promocion);
		if (promocion != null) {
			service.disable(id_promocion);
			return new ResponseEntity<>("Promoción inhabilitada/habilitada.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Promoción no encontrada.", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/removerServicios/{id_promocion}")
	public ResponseEntity<?> removerServicios_PUT(@PathVariable Integer id_promocion) {
		Promocion promocion = service.findById(id_promocion);
		if (promocion != null) {
			service.removeServicios(id_promocion);
			return new ResponseEntity<>("Remoción de servicios finalizada.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Promoción no encontrada.", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/actualizarEstadoPromociones")
	public ResponseEntity<?> actualizarEstadoPromociones_PUT() {
        LocalDate fechaActual = LocalDate.now();
        Collection<Promocion> promociones = service.findAvailablePromotions();
        for (Promocion promocion : promociones) {
            if (promocion.getFecha_fin().isBefore(fechaActual)) {
                service.disable(promocion.getId_promocion());
            }
        }
		return new ResponseEntity<>(HttpStatus.OK);
    }

}
