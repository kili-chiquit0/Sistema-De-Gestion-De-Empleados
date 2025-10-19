package com.nexushr.spring.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NexusHrApplication {

    public static void main(String[] args) {
        SpringApplication.run(NexusHrApplication.class, args);
        System.out.println("=========================================");
        System.out.println("🚀 NEXUSHR API INICIADA CORRECTAMENTE");
        System.out.println("📍 URL: http://localhost:8080");
        System.out.println("📊 Base de datos: nexushr");
        System.out.println("🎯 Endpoint: http://localhost:8080/api/empleados");
        System.out.println("📦 Package: com.nexushr.spring.app");
        System.out.println("=========================================");
    }
}