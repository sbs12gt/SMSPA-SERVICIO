package pe.spa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.spa.entity.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

}
