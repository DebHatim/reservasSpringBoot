![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8-orange)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

# 🏨 Sistema de Reservas de Hotel - reservasSpringBoot - 30% completado

Repositorio de un sistema web para la gestión de reservas de hoteles, desarrollado con **Spring Boot**, siguiendo el patrón de diseño **MVC** (Modelo-Vista-Controlador), **Thymeleaf** para el front-end y **MySQL** como persistencia de datos.

> **Nota:** Proyecto desarrollado completamente por **Hatim Debboun** como parte de un portafolio profesional de desarrollo Backend con Java.

---

## 🧠 Funcionalidades Principales

- **Catálogo de Hoteles:** Visualización de hoteles y sus habitaciones disponibles.
- **Gestión de Usuarios:** Registro e inicio de sesión integrados.
- **Reservas:** Sistema que impide reservar habitaciones si ya están ocupadas en las fechas seleccionadas.
- **Valoraciones:** Sistema de valoraciones y comentarios escritos por los usuarios para cada habitación.
- **Modelo de Datos Completo:** Relaciones @OneToMany y @ManyToOne entre:
  - `Hotel` ↔ `Habitacion`
  - `Habitacion` ↔ `Reserva` ↔ `Persona`
  - `Habitacion` ↔ `Valoracion`
  - `Habitacion` ↔ `FotoHabitacion`

---

## 🛠 Tecnologías utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA** (Hibernate)
- **Spring Security** (Autenticación y Autorización)
- **Thymeleaf** (Motor de plantillas)
- **MySQL Driver** (Conectividad a BD)
- **Lombok** (Reducción de código boilerplate)
- **Validation** (Bean Validation para formularios)

---

## 🔐 Seguridad

- Autenticación con Spring Security
- Encriptación de contraseñas con BCrypt
- Control de acceso por roles (USER / ADMIN)
- Protección CSRF

---

## 🚀 Configuración y Ejecución

- Requisitos Previos: Java 21 instalado, Maven 3.x., Servidor MySQL en ejecución.

**1. Crear la base de datos y el usuario con los siguientes parámetros:** ( configurados en **application.properties** )

- CREATE DATABASE reservas;
- CREATE USER 'usr_reservas'@'localhost' IDENTIFIED BY 'passwordreservas';
- GRANT ALL PRIVILEGES ON reservas.* TO 'usr_reservas'@'localhost';
- FLUSH PRIVILEGES;

**2. Ejecutar los siguientes comandos**

- git clone https://github.com/DebHatim/reservasSpringBoot.git
- cd reservasSpringBoot

**3. Para ejecutar en Windows:**

- mvnw spring-boot:run

**4. Para ejecutar en Linux**

- chmod +x mvnw
- ./mvnw spring-boot:run
