package pe.spa.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

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

import pe.spa.entity.Empleado;
import pe.spa.entity.Instalacion;
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
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Reserva reserva) {
		if (reserva.getApellidos_cliente() != null && reserva.getApellidos_cliente().length() <= 200) {
			if (reserva.getCorreo_cliente() != null && reserva.getCorreo_cliente().length() <= 300) {
				if (reserva.getEstado() != null) {
					if (reserva.getFecha() != null) {
						if (reserva.getHora() != null) {
							if (!reserva.getFecha().isBefore(LocalDate.now())) {
								if (reserva.getNombres_cliente() != null && reserva.getNombres_cliente().length() <= 200) {
									if (reserva.getTelefono_cliente() != null && reserva.getTelefono_cliente().length() <= 50) {
										if (reserva.getId_promocion() != null) {
											Integer id_promocion = reserva.getId_promocion().getId_promocion();
											if (id_promocion == null || promocionService.findById(id_promocion) == null) {
												return new ResponseEntity<>("Solicitud incorrecta.", HttpStatus.BAD_REQUEST);	
											}
										}
										if (reserva.getId_servicio() != null) {
											Integer id_servicio = reserva.getId_servicio().getId_servicio();
											if (id_servicio == null || servicioService.findById(id_servicio) == null) {
												return new ResponseEntity<>("Solicitud incorrecta.", HttpStatus.BAD_REQUEST);
											}
											LocalDate fecha = reserva.getFecha();
											LocalTime hora = reserva.getHora();
											Short duracion = servicioService.findById(id_servicio).getDuracion();
											LocalTime hora_fin = hora.plusMinutes(duracion);
											// VER SI HAY EMPLEADOS O INSTALACIONES DISPONIBLES EN ESE HORARIO
											Collection<Reserva> reservasRealizadas;
											reservasRealizadas = service.findReservationsMadeByFechaAndHora(fecha, hora, hora_fin);
											List<Integer> empleados = empleadoService.findAvailableWorkersId();
											List<Integer> instalaciones = instalacionService.findAvailableFacilitiesId();
											for (Reserva reservaRealizada : reservasRealizadas) {
												empleados.remove((Object) reservaRealizada.getId_empleado().getId_empleado());	
												instalaciones.remove((Object) reservaRealizada.getId_instalacion().getId_instalacion());
											}
											// DECIDIR EL EMPLEADO O INSTALACIÓN CON MENOS CARGA DE TRABAJO DEL DÍA
											if (empleados != null && !empleados.isEmpty() && instalaciones != null && !instalaciones.isEmpty()) {
												int menor_empleados = Integer.MAX_VALUE;
												int id_menor_empleados = 0;
												for (Integer id_empleado : empleados) {
													Integer conteo_empleado = service.findReservationsCountByWorker(fecha, id_empleado);
													if (conteo_empleado == null) {
														conteo_empleado = 0;
													}
													if (menor_empleados > conteo_empleado) {
														menor_empleados = conteo_empleado;
														id_menor_empleados = id_empleado;
													}
												}
												Empleado empleado = empleadoService.findById(id_menor_empleados);
												int menor_instalaciones = Integer.MAX_VALUE;
												int id_menor_instalaciones = 0;
												for (Integer id_instalacion : instalaciones) {
													Integer conteo_instalacion = service.findReservationsCountByFacility(fecha, id_instalacion);
													if (conteo_instalacion == null) {
														conteo_instalacion = 0;
													}
													if (menor_instalaciones > conteo_instalacion) {
														menor_instalaciones = conteo_instalacion;
														id_menor_instalaciones = id_instalacion;
													}
												}
												Instalacion instalacion = instalacionService.findById(id_menor_instalaciones);
												reserva.setHora_fin(hora_fin);
												reserva.setId_empleado(empleado);
												reserva.setId_instalacion(instalacion);
												reserva.setId_reserva(null);
												service.save(reserva);
												return new ResponseEntity<>("Reserva registrada.", HttpStatus.CREATED);
											} else {
												return new ResponseEntity<>("Horario lleno.", HttpStatus.CONFLICT);
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

	@GetMapping("/buscar/{id_reserva}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer id_reserva) {
		Reserva reserva = service.findById(id_reserva);
	    if (reserva == null) {
	    	return new ResponseEntity<>("Reserva no encontrada", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(reserva, HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id_reserva}")
	public ResponseEntity<?> editar_PUT(@RequestBody Reserva reserva, @PathVariable Integer id_reserva) {
		Reserva reservaBD = service.findById(id_reserva);
		if (reservaBD != null) {
			if (reserva.getApellidos_cliente() != null && reserva.getApellidos_cliente().length() <= 200) {
				if (reserva.getCorreo_cliente() != null && reserva.getCorreo_cliente().length() <= 300) {
					if (reserva.getEstado() != null) {
						if (reserva.getFecha() != null) {
							if (reserva.getHora() != null) {
								if (!reserva.getFecha().isBefore(LocalDate.now())) {
									if (reserva.getNombres_cliente() != null && reserva.getNombres_cliente().length() <= 200) {
										if (reserva.getTelefono_cliente() != null && reserva.getTelefono_cliente().length() <= 50) {
											if (reserva.getId_promocion() != null) {
												Integer id_promocion = reserva.getId_promocion().getId_promocion();
												if (id_promocion == null || promocionService.findById(id_promocion) == null) {
													return new ResponseEntity<>("Solicitud incorrecta.", HttpStatus.BAD_REQUEST);	
												}
											}
											if (reserva.getId_servicio() != null) {
												Integer id_servicio = reserva.getId_servicio().getId_servicio();
												if (id_servicio == null || servicioService.findById(id_servicio) == null) {
													return new ResponseEntity<>("Solicitud incorrecta.", HttpStatus.BAD_REQUEST);
												}
												LocalDate fecha = reserva.getFecha();
												LocalTime hora = reserva.getHora();
												Short duracion = servicioService.findById(id_servicio).getDuracion();
												LocalTime hora_fin = hora.plusMinutes(duracion);
												// VER SI HAY EMPLEADOS O INSTALACIONES DISPONIBLES EN ESE HORARIO
												if (fecha.isEqual(reservaBD.getFecha()) && !hora.isBefore(reservaBD.getHora()) && !hora_fin.isAfter(reservaBD.getHora_fin())) {
													reserva.setId_empleado(reservaBD.getId_empleado());
													reserva.setId_instalacion(reservaBD.getId_instalacion());
												} else {
													Collection<Reserva> reservasRealizadas;
													reservasRealizadas = service.findReservationsMadeByFechaAndHora(fecha, hora, hora_fin);
													List<Integer> empleados = empleadoService.findAvailableWorkersId();
													List<Integer> instalaciones = instalacionService.findAvailableFacilitiesId();
													for (Reserva reservaRealizada : reservasRealizadas) {
														if (reservaRealizada.getId_reserva() != id_reserva) {
															empleados.remove((Object) reservaRealizada.getId_empleado().getId_empleado());	
															instalaciones.remove((Object) reservaRealizada.getId_instalacion().getId_instalacion());
														}
													}
													// DECIDIR EL EMPLEADO O INSTALACIÓN CON MENOS CARGA DE TRABAJO DEL DÍA
													if (empleados != null && !empleados.isEmpty() && instalaciones != null && !instalaciones.isEmpty()) {
														int menor_empleados = Integer.MAX_VALUE;
														int id_menor_empleados = 0;
														for (Integer id_empleado : empleados) {
															Integer conteo_empleado = service.findReservationsCountByWorker(fecha, id_empleado);
															if (conteo_empleado == null) {
																conteo_empleado = 0;
															} else if (fecha == reservaBD.getFecha() && id_empleado == reservaBD.getId_empleado().getId_empleado()) {
																conteo_empleado--;
															}
															if (menor_empleados > conteo_empleado) {
																menor_empleados = conteo_empleado;
																id_menor_empleados = id_empleado;
															}
														}
														Empleado empleado = empleadoService.findById(id_menor_empleados);
														int menor_instalaciones = Integer.MAX_VALUE;
														int id_menor_instalaciones = 0;
														for (Integer id_instalacion : instalaciones) {
															Integer conteo_instalacion = service.findReservationsCountByFacility(fecha, id_instalacion);
															if (conteo_instalacion == null) {
																conteo_instalacion = 0;
															} else if (fecha == reservaBD.getFecha() && id_instalacion == reservaBD.getId_instalacion().getId_instalacion()) {
																conteo_instalacion--;
															}
															if (menor_instalaciones > conteo_instalacion) {
																menor_instalaciones = conteo_instalacion;
																id_menor_instalaciones = id_instalacion;
															}
														}
														Instalacion instalacion = instalacionService.findById(id_menor_instalaciones);
														reserva.setId_empleado(empleado);
														reserva.setId_instalacion(instalacion);
													} else {
														return new ResponseEntity<>("Horario lleno.", HttpStatus.CONFLICT);
													}
												}
												reserva.setHora_fin(hora_fin);
												reserva.setId_reserva(id_reserva);
												service.save(reserva);
												return new ResponseEntity<>("Reserva editada.", HttpStatus.OK);
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
		return new ResponseEntity<>("Reserva no encontrada", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{id_reserva}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer id_reserva) {
		Reserva reservaBD = service.findById(id_reserva);
		if (reservaBD != null) {		
			service.delete(id_reserva);
			return new ResponseEntity<>("Reserva borrada.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Reserva no encontrada", HttpStatus.NOT_FOUND);
	}

	//
	
	@GetMapping("/listarReservasPasadasPorFecha/{fechaSeleccionada}")
	public ResponseEntity<?> listarReservasPasadasPorFecha_GET(@PathVariable LocalDate fechaSeleccionada) {
		Collection<Reserva> reservas = service.findPastOnesByFecha(fechaSeleccionada);
	    if (reservas.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(reservas, HttpStatus.OK);
	}

	@GetMapping("/listarReservasPasadas/{lote}")
	public ResponseEntity<?> listarReservasPasadas_GET(@PathVariable int lote) {
		if (lote < 0) {
			return new ResponseEntity<>("Solicitud incorrecta.", HttpStatus.BAD_REQUEST);
		}
		Collection<Reserva> reservas = service.findPastReservations(lote);
	    if (reservas.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(reservas, HttpStatus.OK);
	}

	@GetMapping("/listarReservasRecientesPorEmpleado/{id_empleado}")
	public ResponseEntity<?> listarReservasRecientesPorEmpleado_GET(@PathVariable Integer id_empleado) {
		Collection<Reserva> reservas = service.findRecentOnesByEmpleado(id_empleado);
	    if (reservas.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(reservas, HttpStatus.OK);
	}

	@GetMapping("/listarReservasRecientesPorInstalacion/{id_instalacion}")
	public ResponseEntity<?> listarReservasRecientesPorInstalacion_GET(@PathVariable Integer id_instalacion) {
		Collection<Reserva> reservas = service.findRecentOnesByInstalacion(id_instalacion);
	    if (reservas.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(reservas, HttpStatus.OK);
	}

	@GetMapping("/listarReservasRecientes")
	public ResponseEntity<?> listarReservasRecientes_GET() {
		Collection<Reserva> reservas = service.findRecentReservations();
	    if (reservas.isEmpty()) {
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(reservas, HttpStatus.OK);
	}

}
