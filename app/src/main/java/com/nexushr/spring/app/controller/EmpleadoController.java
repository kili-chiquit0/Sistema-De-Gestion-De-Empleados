package com.nexushr.spring.app.controller;

import com.nexushr.spring.app.model.Empleado;
import com.nexushr.spring.app.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        if (empleado.isPresent()) {
            return ResponseEntity.ok(empleado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
        try {
            if (empleadoRepository.findByEmail(empleado.getEmail()).isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            
            Empleado nuevoEmpleado = empleadoRepository.save(empleado);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEmpleado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleadoDetails) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        
        if (empleadoOptional.isPresent()) {
            Empleado empleado = empleadoOptional.get();
            
            empleado.setNombre(empleadoDetails.getNombre());
            empleado.setApellido(empleadoDetails.getApellido());
            empleado.setEmail(empleadoDetails.getEmail());
            empleado.setDepartamento(empleadoDetails.getDepartamento());
            empleado.setSalario(empleadoDetails.getSalario());
            empleado.setFechaContratacion(empleadoDetails.getFechaContratacion());
            empleado.setActivo(empleadoDetails.getActivo());
            
            Empleado updatedEmpleado = empleadoRepository.save(empleado);
            return ResponseEntity.ok(updatedEmpleado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/departamento/{departamento}")
    public List<Empleado> getEmpleadosByDepartamento(@PathVariable String departamento) {
        return empleadoRepository.findByDepartamento(departamento);
    }

    @GetMapping("/activos")
    public List<Empleado> getEmpleadosActivos() {
        return empleadoRepository.findByActivoTrue();
    }

    @GetMapping("/buscar")
    public List<Empleado> searchEmpleados(@RequestParam String nombre) {
        return empleadoRepository.findByNombreContainingIgnoreCase(nombre);
    }
}