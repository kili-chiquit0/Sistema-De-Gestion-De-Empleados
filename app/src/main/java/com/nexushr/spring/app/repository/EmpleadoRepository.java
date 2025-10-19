package com.nexushr.spring.app.repository;

import com.nexushr.spring.app.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    
    List<Empleado> findByDepartamento(String departamento);
    
    List<Empleado> findByActivoTrue();
    
    Optional<Empleado> findByEmail(String email);
    
    List<Empleado> findByNombreContainingIgnoreCase(String nombre);
}