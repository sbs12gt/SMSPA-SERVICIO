package pe.spa.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.spa.entity.Promocion;
import pe.spa.entity.Servicio;
import pe.spa.entity.TipoPromocion;
import pe.spa.repository.PromocionRepository;
import pe.spa.repository.ServicioRepository;

@Service
public class PromocionServiceImpl implements PromocionService {
	
	@Autowired
	private PromocionRepository repository;
	@Autowired
	private ServicioRepository servicioRepository;
	/*
	@Override
	@Transactional
	public void delete(Integer id_promocion) {
		repository.deleteById(id_promocion);
	}
	*/
	@Override
	@Transactional(readOnly=true)
	public Collection<Promocion> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Promocion findById(Integer id_promocion) {
		return repository.findById(id_promocion).orElse(null);
	}

	@Override
	@Transactional
	public void save(Promocion promocion) {
		repository.save(promocion);
	}
	
	//

	@Override
	@Transactional(readOnly=true)
	public Promocion findApplicablePromotion(Integer id_servicio, LocalDate fechaReserva) {
		Servicio servicio = servicioRepository.findById(id_servicio).orElse(null);
		if (servicio != null) {
			Promocion promocion = servicio.getPromocion();
			if (promocion != null) {
				return repository.findApplicablePromotion(promocion.getId_promocion(), fechaReserva);
			}
		}
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Promocion> findAvailablePromotions() {
		return repository.findAvailablePromotions();
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Promocion> findByTipoPromocion(TipoPromocion tipo) {
		return repository.findByTipoPromocion(tipo.name());
	}

	@Override
	@Transactional(readOnly=true)
	public Promocion findByTitulo(String titulo) {
		return repository.findByTitulo(titulo);
	}

	@Override
	@Transactional
	public void disable(Integer id_promocion) {
		Promocion promocion = repository.findById(id_promocion).orElse(null);
		if (promocion != null) {
			if (!promocion.getEstado()) {
				promocion.setEstado(true);
			} else {
				List<Servicio> servicios = promocion.getItemsServicio();
				if (servicios != null) {
					for (Servicio servicio : servicios) {
						servicio.setPromocion(null);
						servicioRepository.save(servicio);
					}
				}
				promocion.setEstado(false);
			}
			repository.save(promocion);
		}
	}

	@Override
	@Transactional
	public void removeServicios(Integer id_promocion) {
		Promocion promocion = repository.findById(id_promocion).orElse(null);
		if (promocion != null) {
			List<Servicio> servicios = promocion.getItemsServicio();
			if (servicios != null) {
				for (Servicio servicio : servicios) {
					servicio.setPromocion(null);
					servicioRepository.save(servicio);
				}
			}
		}
	}

}
