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

import pe.spa.entity.Empleado;
import pe.spa.service.EmpleadoService;

@RestController
@RequestMapping("/empleados")
@CrossOrigin(origins="*")
public class EmpleadoRestController {

	@Autowired
	private EmpleadoService service;
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Empleado empleado) {
		service.insert(empleado);		
		return new ResponseEntity<>("¡Empleado registrado!", HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Empleado> empleados = service.findAll();
		if(empleados.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id_empleado}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer id_empleado) {
		Empleado empleado = service.findById(id_empleado);
	    if (empleado == null) {
	    	return new ResponseEntity<>("¡No existe el empleado " + id_empleado + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(empleado, HttpStatus.OK);
	}

	@PutMapping("/editar/{id_empleado}")
	public ResponseEntity<?> editar_PUT(@RequestBody Empleado empleado, @PathVariable Integer id_empleado) {
		Empleado empleadoBD = service.findById(id_empleado);
		if (empleadoBD != null) {
			empleadoBD.setApellidos(empleado.getApellidos());
			empleadoBD.setEstado(empleado.getEstado());
			empleadoBD.setNombres(empleado.getNombres());
			empleadoBD.setUrl_foto(empleado.getUrl_foto());
			empleadoBD.setDescripcion(empleado.getDescripcion());
			empleadoBD.setCorreo(empleado.getCorreo());
			empleadoBD.setTelefono(empleado.getTelefono());
			service.update(empleadoBD);
			return new ResponseEntity<>("¡Empleado editado!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡No existe el empleado " + id_empleado + "!", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{id_empleado}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer id_empleado) {
		Empleado empleadoBD = service.findById(id_empleado);
		if (empleadoBD != null) {		
			service.delete(id_empleado);
			return new ResponseEntity<>("¡Empleado borrado!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡No existe el empleado " + id_empleado + "!", HttpStatus.NOT_FOUND);
	}

	//
	
	@GetMapping("/listarEmpleadosDisponibles")
	public ResponseEntity<?> listarEmpleadosDisponibles_GET() {
		Collection<Empleado> empleados = service.findAvailableWorkers();
		if(empleados.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}

}
