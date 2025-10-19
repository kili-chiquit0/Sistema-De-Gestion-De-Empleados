-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS gestion_empleados;
USE gestion_empleados;

-- Crear tabla de empleados
CREATE TABLE empleados (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    departamento VARCHAR(100) NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    fecha_contratacion DATE NOT NULL,
    activo BOOLEAN DEFAULT true
);

-- Insertar datos de ejemplo
INSERT INTO empleados (nombre, apellido, email, departamento, salario, fecha_contratacion, activo) VALUES
('Juan', 'Pérez', 'juan.perez@empresa.com', 'TI', 50000.00, '2023-01-15', true),
('María', 'Gómez', 'maria.gomez@empresa.com', 'Recursos Humanos', 45000.00, '2022-03-20', true),
('Carlos', 'López', 'carlos.lopez@empresa.com', 'Ventas', 48000.00, '2023-06-10', true),
('Ana', 'Martínez', 'ana.martinez@empresa.com', 'Marketing', 42000.00, '2021-11-05', true);