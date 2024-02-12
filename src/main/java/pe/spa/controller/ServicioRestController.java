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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.spa.entity.Promocion;
import pe.spa.entity.Servicio;
import pe.spa.entity.ServicioDTO;
import pe.spa.service.PromocionService;
import pe.spa.service.ServicioService;

@RestController
@RequestMapping("/servicios")
@CrossOrigin(origins="*")
public class ServicioRestController {
	
	@Autowired
	private ServicioService service;
	@Autowired
	private PromocionService promocionService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Servicio> servicios = service.findAll();
		if(servicios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(servicios, HttpStatus.OK);
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Servicio servicio) {
		if (servicio.getCategoria() != null && servicio.getCategoria().length() <= 100) {
			if (servicio.getDescripcion() == null || servicio.getDescripcion().length() <= 2000) {
				if (servicio.getDuracion() != null) {
					if (servicio.getNombre() != null && servicio.getNombre().length() <= 200) {
						if (servicio.getPrecio() != null && servicio.getPrecio().toString().matches("\\d{1,5}\\.\\d{2}")) {
							if (servicio.getUrl_imagen() == null || servicio.getUrl_imagen().length() <= 1000) {
								if (service.findByNombre(servicio.getNombre()) == null) {
									servicio.setEstado(false);
									servicio.setFavorito(false);
									servicio.setId_servicio(null);
									service.save(servicio);
									return new ResponseEntity<>("Servicio registrado.", HttpStatus.CREATED);
								}
							}
						}
					}
				}
			}
		}
		return new ResponseEntity<>("Solicitud incorrecta.", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/buscar/{id_servicio}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer id_servicio) {
		Servicio servicio = service.findById(id_servicio);
	    if (servicio == null) {
	    	return new ResponseEntity<>("Servicio no encontrado.", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(servicio, HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id_servicio}")
	public ResponseEntity<?> editar_PUT(@RequestBody Servicio servicio, @PathVariable Integer id_servicio) {
		Servicio servicioBD = service.findById(id_servicio);
		if (servicioBD != null) {
			if (servicio.getCategoria() != null && servicio.getCategoria().length() <= 100) {
				if (servicio.getDescripcion() == null || servicio.getDescripcion().length() <= 2000) {
					if (servicio.getDuracion() != null) {
						if (servicio.getFavorito() != null) {
							if (servicio.getNombre() != null && servicio.getNombre().length() <= 200) {
								if (servicio.getPrecio() != null && servicio.getPrecio().toString().matches("\\d{1,5}\\.\\d{2}")) {
									if (servicio.getUrl_imagen() == null || servicio.getUrl_imagen().length() <= 1000) {
										Servicio servicioDelNombre = service.findByNombre(servicio.getNombre());
										if (servicioDelNombre == null || servicioDelNombre.getId_servicio() == id_servicio) {
											servicio.setEstado(servicioBD.getEstado());
											servicio.setId_servicio(id_servicio);
											service.save(servicio);
											return new ResponseEntity<>("Servicio editado.", HttpStatus.OK);
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
		return new ResponseEntity<>("Servicio no encontrado.", HttpStatus.NOT_FOUND);
	}
	/*
	@DeleteMapping("/borrar/{id_servicio}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer id_servicio) {
		Servicio servicio = service.findById(id_servicio);
		if (servicio != null) {		
			service.delete(id_servicio);
			return new ResponseEntity<>("Servicio borrado.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Servicio no encontrado.", HttpStatus.NOT_FOUND);
	}
	*/
	//
	
	@GetMapping("/listarServiciosDisponibles")
	public ResponseEntity<?> listarServiciosDisponibles_GET() {
		Collection<Servicio> servicios = service.findAvailableServices();
		if (servicios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(servicios, HttpStatus.OK);
	}

	@GetMapping("/listarServiciosSinPromociones")
	public ResponseEntity<?> listarServiciosSinPromociones_GET() {
		Collection<ServicioDTO> servicios = service.findMiniServicesWithoutPromotions();
		if (servicios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(servicios, HttpStatus.OK);
	}

	@GetMapping("/buscarPorCategoria/{categoria}")
	public ResponseEntity<?> buscarPorCategoria_GET(@PathVariable String categoria) {
		Collection<Servicio> servicios = service.findByCategoria(categoria);
		if (servicios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(servicios, HttpStatus.OK);
	}

	@GetMapping("/buscarPorIdPromocion/{id_promocion}")
	public ResponseEntity<?> buscarPorIdPromocion_GET(@PathVariable Integer id_promocion) {
		Collection<ServicioDTO> servicios = service.findMiniServicesByIdPromocion(id_promocion);
		if (servicios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(servicios, HttpStatus.OK);
	}
	
	@GetMapping("/listarServiciosPopulares")
	public ResponseEntity<?> listarServiciosPopulares_GET() {
		Collection<Servicio> servicios = service.findPopularServices();
		if (servicios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(servicios, HttpStatus.OK);
	}

	@PutMapping("/limpiarPromocion/{id_servicio}")
	public ResponseEntity<?> limpiarPromocion_PUT(@PathVariable Integer id_servicio) {
		Servicio servicio = service.findById(id_servicio);
		if (servicio == null) {
			return new ResponseEntity<>("Servicio no encontrado.", HttpStatus.NOT_FOUND);
		}
		service.cleanPromocion(id_servicio);
		return new ResponseEntity<>("Promoción limpiada del servicio.", HttpStatus.OK);
	}

	@PutMapping("/inhabilitar/{id_servicio}")
	public ResponseEntity<?> inhabilitar_PUT(@PathVariable Integer id_servicio) {
		Servicio servicio = service.findById(id_servicio);
		if (servicio != null) {
			service.disable(id_servicio);
			return new ResponseEntity<>("Servicio inhabilitado/habilitado.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Servicio no encontrado.", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/guardarPromocion")
	public ResponseEntity<?> guardarPromocion_PUT(@RequestParam Integer id_servicio, @RequestParam Integer id_promocion) {
		Servicio servicio = service.findById(id_servicio);
		Promocion promocion = promocionService.findById(id_promocion);
		if (servicio == null) {
			return new ResponseEntity<>("Servicio no encontrado.", HttpStatus.NOT_FOUND);
		} else if (promocion == null) {
			return new ResponseEntity<>("Promoción no encontrada.", HttpStatus.NOT_FOUND);
		} else {
			service.savePromocion(id_servicio, id_promocion);
			return new ResponseEntity<>("Promoción guardada en el servicio.", HttpStatus.OK);
		}
	}

}
