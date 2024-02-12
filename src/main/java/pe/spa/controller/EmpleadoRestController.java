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

import pe.spa.entity.Empleado;
import pe.spa.service.EmpleadoService;

@RestController
@RequestMapping("/empleados")
@CrossOrigin(origins="*")
public class EmpleadoRestController {

	@Autowired
	private EmpleadoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Empleado> empleados = service.findAll();
		if(empleados.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Empleado empleado) {
		if (empleado.getApellidos() != null && empleado.getApellidos().length() <= 200) {
			if (empleado.getCorreo() != null && empleado.getCorreo().length() <= 300) {
				if (empleado.getDescripcion() == null || empleado.getDescripcion().length() <= 2000) {
					if (empleado.getNombres() != null && empleado.getNombres().length() <= 200) {
						if (empleado.getTelefono() != null && empleado.getTelefono().length() <= 50) {
							if (empleado.getUrl_foto() == null || empleado.getUrl_foto().length() <= 1000) {
								if (service.findByCorreo(empleado.getCorreo()) == null) {
									if (service.findByTelefono(empleado.getTelefono()) == null) {
										empleado.setEstado(false);
										empleado.setId_empleado(null);
										service.save(empleado);
										return new ResponseEntity<>("Empleado registrado.", HttpStatus.CREATED);
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

	@GetMapping("/buscar/{id_empleado}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer id_empleado) {
		Empleado empleado = service.findById(id_empleado);
	    if (empleado == null) {
	    	return new ResponseEntity<>("Empleado no encontrado.", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(empleado, HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id_empleado}")
	public ResponseEntity<?> editar_PUT(@RequestBody Empleado empleado, @PathVariable Integer id_empleado) {
		Empleado empleadoBD = service.findById(id_empleado);
		if (empleadoBD != null) {
			if (empleado.getApellidos() != null && empleado.getApellidos().length() <= 200) {
				if (empleado.getCorreo() != null && empleado.getCorreo().length() <= 300) {
					if (empleado.getDescripcion() == null || empleado.getDescripcion().length() <= 2000) {
						if (empleado.getNombres() != null && empleado.getNombres().length() <= 200) {
							if (empleado.getTelefono() != null && empleado.getTelefono().length() <= 50) {
								if (empleado.getUrl_foto() == null || empleado.getUrl_foto().length() <= 1000) {
									Empleado empleadoDelCorreo = service.findByCorreo(empleado.getCorreo());
									if (empleadoDelCorreo == null || empleadoDelCorreo.getId_empleado() == id_empleado) {
										Empleado empleadoDelTelefono = service.findByTelefono(empleado.getTelefono());
										if (empleadoDelTelefono == null || empleadoDelTelefono.getId_empleado() == id_empleado) {
											empleado.setEstado(empleadoBD.getEstado());
											empleado.setId_empleado(id_empleado);
											service.save(empleado);
											return new ResponseEntity<>("Empleado editado.", HttpStatus.OK);
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
		return new ResponseEntity<>("Empleado no encontrado.", HttpStatus.NOT_FOUND);
	}
	/*
	@DeleteMapping("/borrar/{id_empleado}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer id_empleado) {
		Empleado empleado = service.findById(id_empleado);
		if (empleado != null) {		
			service.delete(id_empleado);
			return new ResponseEntity<>("Empleado borrado.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Empleado no encontrado.", HttpStatus.NOT_FOUND);
	}
	*/
	//
	
	@GetMapping("/listarEmpleadosDisponibles")
	public ResponseEntity<?> listarEmpleadosDisponibles_GET() {
		Collection<Empleado> empleados = service.findAvailableWorkers();
		if(empleados.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}

	@PutMapping("/inhabilitar/{id_empleado}")
	public ResponseEntity<?> inhabilitar_PUT(@PathVariable Integer id_empleado) {
		Empleado empleado = service.findById(id_empleado);
		if (empleado != null) {		
			service.disable(id_empleado);
			return new ResponseEntity<>("Empleado inhabilitado/habilitado.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Empleado no encontrado.", HttpStatus.NOT_FOUND);
	}

}
