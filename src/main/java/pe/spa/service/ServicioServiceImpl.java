package pe.spa.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.spa.entity.Promocion;
import pe.spa.entity.Servicio;
import pe.spa.entity.ServicioDTO;
import pe.spa.repository.PromocionRepository;
import pe.spa.repository.ServicioRepository;

@Service
public class ServicioServiceImpl implements ServicioService {

	@Autowired
	private ServicioRepository repository;
	@Autowired
	private PromocionRepository promocionRepository;
	/*
	@Override
	@Transactional
	public void delete(Integer id_servicio) {
		repository.deleteById(id_servicio);
	}
	*/
	@Override
	@Transactional(readOnly=true)
	public Collection<Servicio> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Servicio findById(Integer id_servicio) {
		return repository.findById(id_servicio).orElse(null);
	}

	@Override
	@Transactional
	public void save(Servicio servicio) {
		repository.save(servicio);
	}
	
	//

	@Override
	@Transactional(readOnly=true)
	public Collection<Servicio> findAvailableServices() {
		return repository.findAvailableServices();
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<ServicioDTO> findMiniServicesWithoutPromotions() {
		Collection<Servicio> servicios = repository.findMiniServicesWithoutPromotions();
		Collection<ServicioDTO> serviciosDTO = new ArrayList<>();
		for (Servicio servicio : servicios) {
			Integer id_servicio = servicio.getId_servicio();
			Boolean estado = servicio.getEstado();
    		String nombre = servicio.getNombre();
			ServicioDTO servicioDTO = new ServicioDTO(id_servicio, estado, nombre);
			serviciosDTO.add(servicioDTO);
		}
		return serviciosDTO;
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Servicio> findByCategoria(String categoria) {
		return repository.findByCategoria(categoria);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<ServicioDTO> findMiniServicesByIdPromocion(Integer id_promocion) {
		Collection<Servicio> servicios = repository.findMiniServicesByIdPromocion(id_promocion);
		Collection<ServicioDTO> serviciosDTO = new ArrayList<>();
		for (Servicio servicio : servicios) {
			Integer id_servicio = servicio.getId_servicio();
			Boolean estado = servicio.getEstado();
    		String nombre = servicio.getNombre();
			ServicioDTO servicioDTO = new ServicioDTO(id_servicio, estado, nombre);
			serviciosDTO.add(servicioDTO);
		}
		return serviciosDTO;
	}

	@Override
	@Transactional(readOnly=true)
	public Servicio findByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Servicio> findPopularServices() {
		return repository.findPopularServices();
	}

	@Override
	@Transactional
	public void cleanPromocion(Integer id_servicio) {
		Servicio servicio = repository.findById(id_servicio).orElse(null);
		if (servicio != null) {
			servicio.setPromocion(null);
			repository.save(servicio);
		}
	}

	@Override
	@Transactional
	public void disable(Integer id_servicio) {
		Servicio servicio = repository.findById(id_servicio).orElse(null);
		if (servicio != null) {
			if (!servicio.getEstado()) {
				servicio.setEstado(true);
			} else {
				servicio.setFavorito(false);
				servicio.setEstado(false);
			}
			repository.save(servicio);
		}
	}

	@Override
	@Transactional
	public void savePromocion(Integer id_servicio, Integer id_promocion) {
		Servicio servicio = repository.findById(id_servicio).orElse(null);
		Promocion promocion = promocionRepository.findById(id_promocion).orElse(null);
		if (servicio != null && promocion != null) {
			servicio.setPromocion(promocion);
			repository.save(servicio);
		}
	}

}
