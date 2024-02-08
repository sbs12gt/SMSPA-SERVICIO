package pe.spa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import pe.spa.entity.Promocion;
import pe.spa.service.PromocionService;

import java.time.LocalDate;
import java.util.Collection;

@Component
public class PromocionScheduler {

    @Autowired
    private PromocionService service;

    @Scheduled(fixedDelay=86400000)
    public void actualizarEstadoPromociones() {
        LocalDate fechaActual = LocalDate.now();
        Collection<Promocion> promociones = service.findAll();
        
        for (Promocion promocion : promociones) {
            if (promocion.getFecha_fin().isAfter(fechaActual)) {
                promocion.setEstado(false);
                service.update(promocion);
            }
        }
    }

}
