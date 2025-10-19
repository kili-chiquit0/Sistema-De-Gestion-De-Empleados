package com.nexushr.spring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    // Ruta principal
    @GetMapping("/")
    public String showHome() {
        return "empleados"; // Carga templates/empleados.html
    }

    // También permite acceder desde /empleados
    @GetMapping("/empleados")
    public String showEmpleados() {
        return "empleados";
    }
}
