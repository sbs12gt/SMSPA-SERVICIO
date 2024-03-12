package pe.spa.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pe.spa.entity.Servicio;
import pe.spa.service.ServicioService;

@RestController
@RequestMapping("/imagenes")
@CrossOrigin(origins="*")
public class ImagenRestController {

    @Autowired
	private ServicioService servicioService;

    private static final String UPLOAD_DIR = "src/main/resources/images";

    @GetMapping("/{imageName}")
    public ResponseEntity<?> getImage_GET(@PathVariable String imageName) throws IOException {
        String imagePath = "images/" + imageName;
        Resource resource = new ClassPathResource(imagePath);
        if (resource.exists()) {
            String contentType = determineContentType(imageName);
            return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
        } else {
            return new ResponseEntity<>("Imagen (" + imageName + ") no encontrada.", HttpStatus.NOT_FOUND);
        }
    }

    private String determineContentType(String imageName) {
        if (imageName.toLowerCase().endsWith(".jpg") || imageName.toLowerCase().endsWith(".jpeg")) {
            return "image/jpeg";
        } else if (imageName.toLowerCase().endsWith(".png")) {
            return "image/png";
        } else {
            return "application/octet-stream";
        }
    }

    @PostMapping("/upload/{id_servicio}/{imageName}")
    public ResponseEntity<?> uploadImage_POST(@PathVariable Integer id_servicio, @PathVariable String imageName,
    @RequestParam("file") MultipartFile file) {
        Servicio servicio = servicioService.findById(id_servicio);
        if (servicio == null) {
            return new ResponseEntity<>("No se encontró el servicio.", HttpStatus.NOT_FOUND);
        } else if (imageName.length() > 1000) {
            return new ResponseEntity<>("Nombre muy largo.", HttpStatus.BAD_REQUEST);
        } else if (new ClassPathResource("images/" + imageName).exists()) {
            return new ResponseEntity<>("Ya existe otra imagen con ese nombre.", HttpStatus.CONFLICT);
        }
        if (file.isEmpty()) {
            return new ResponseEntity<>("Archivo no enviado.", HttpStatus.BAD_REQUEST);
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR + File.separator + imageName);
            Files.write(path, bytes);
            servicio.setUrl_imagen(imageName);
            servicioService.save(servicio);
            return new ResponseEntity<>("Imagen subida correctamente.", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Problema al subir la imagen.", HttpStatus.CONFLICT);
        }
    }
    
}
