![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8-orange)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

# 🏨 Sistema de Reservas de Hotel - reservasSpringBoot - 87% completado

Repositorio de un sistema web para la gestión de reservas de hoteles, desarrollado con **Spring Boot**, siguiendo el patrón de diseño **MVC** (Modelo-Vista-Controlador), **Thymeleaf** para el front-end y **MySQL** como persistencia de datos.

> **Nota:** Proyecto desarrollado completamente por **Hatim Debboun** como parte de un portafolio profesional de desarrollo Backend con Java.

---

## 🧠 Funcionalidades Principales

- **Catálogo de Hoteles:** Visualización de hoteles y sus habitaciones disponibles.

- **Gestión de Usuarios:** Registro e inicio de sesión integrados.

- **Reservas:** Sistema que impide reservar habitaciones si ya están ocupadas en las fechas seleccionadas.

- **Valoraciones:** Sistema de valoraciones y comentarios escritos por los usuarios para cada habitación.

- **Modelo de Datos Robusto:** Implementación de relaciones complejas en JPA:

  - `Usuario` ↔ `Persona`: Relación @OneToOne para gestión de perfiles

  - `Hotel` ↔ `Habitación`: Relación @OneToMany

  - `Habitacion` ↔ `Reserva` ↔ `Persona`: Gestión de estancia y ocupantes

  - `Habitacion` ↔ `Valoracion`: Histórico de feedback de clientes

---

## 🛠 Tecnologías utilizadas

- **Java 21** (LTS)

- **Spring Boot 3.x**

- **Spring Data JPA** (Hibernate)

- **Spring Security** (Autenticación y Autorización basada en roles)

- **Thymeleaf** (Motor de plantillas dinámico)

- **MySQL** (Base de datos relacional)

- **Lombok** (Reducción de código boilerplate)

- **Spring Validation** (Bean Validation para formularios)

---

## 🔐 Seguridad

- Autenticación con Spring Security, personalizado en UserDetailsService

- Encriptación de contraseñas con BCrypt usando BCryptPasswordEncoder

- Control de acceso por roles (ROLE_USER / ROLE_ADMIN)

- Protección CSRF y defensa contra ataques SQL injection

---

## 🚀 Configuración y Ejecución

- Requisitos Previos: Java 21, Maven 3.x., Servidor MySQL.

**1. Crear la base de datos y el usuario con los siguientes parámetros:** ( configurados en **application.properties** )

- CREATE DATABASE reservas;

- CREATE USER 'usr_reservas'@'localhost' IDENTIFIED BY 'passwordreservas';

- GRANT ALL PRIVILEGES ON reservas.* TO 'usr_reservas'@'localhost';

- FLUSH PRIVILEGES;

**2. Clonar y acceder**

- git clone https://github.com/DebHatim/reservasSpringBoot.git

- cd reservasSpringBoot

**3. Ejecución:**

- Para Windows: mvnw spring-boot:run

- Para Linux:

- chmod +x mvnw
- ./mvnw spring-boot:run
