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

import pe.spa.entity.Popurri;
import pe.spa.service.PopurriService;

@RestController
@RequestMapping("/miscelaneas")
@CrossOrigin(origins="*")
public class PopurriRestController {

    @Autowired
	private PopurriService service;
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Popurri p) {
		service.insert(p);		
		return new ResponseEntity<>("¡Miscelánea registrada!", HttpStatus.CREATED);
	}

    @GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Popurri> p = service.findAll();
		if(p.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer id) {
		Popurri p = service.findById(id);
	    if (p == null) {
	    	return new ResponseEntity<>("¡No existe la miscelánea " + id + "!", HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editar_PUT(@RequestBody Popurri p, @PathVariable Integer id) {
		Popurri bd = service.findById(id);
		if (bd != null) {
            bd.setContenido(p.getContenido());
            bd.setTitulo(p.getTitulo());
			service.update(bd);
			return new ResponseEntity<>("Miscelánea editada!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡No existe la miscelánea " + id + "!", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer id) {
		Popurri bd = service.findById(id);
		if (bd != null) {	
			service.delete(id);
			return new ResponseEntity<>("¡Miscelánea borrada!", HttpStatus.OK);
		}
		return new ResponseEntity<>("¡No existe la miscelánea " + id + "!", HttpStatus.NOT_FOUND);
	}
    
}
