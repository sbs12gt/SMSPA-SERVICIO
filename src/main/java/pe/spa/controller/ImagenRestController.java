package pe.spa.controller;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imagenes")
@CrossOrigin(origins="*")
public class ImagenRestController {

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
    
}
