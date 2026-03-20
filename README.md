# 🏨 Sistema de Reservas de Hotel - Java & Spring Boot

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8-orange)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

Aplicación Backend robusta desarrollada con **Java 21** y **Spring Boot 3.x**. El proyecto sigue una arquitectura **MVC** limpia, enfocada en la escalabilidad y la seguridad.

> **Logro destacado:** Calificación de **10/10** en especialización técnica (210h).

> **Nota:** Proyecto desarrollado completamente por **Hatim Debboun** como parte de un portafolio profesional de desarrollo Backend con Java.

---

## 🚀 Capacidades Técnicas e Implementación

- **Gestión de Datos:** Modelado avanzado con **JPA/Hibernate** (Relaciones @OneToMany, @OneToOne) y optimización de consultas.

- **Seguridad:** Autenticación y Autorización basada en roles con **Spring Security** y encriptación BCrypt.

- **Lógica de Negocio:** Algoritmo de validación de disponibilidad para evitar el "double-booking" (reservas duplicadas).

- **Arquitectura Limpia:** Implementación de **DTOs** para separar la persistencia de la vista y **Bean Validation** para integridad de datos.

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

- **Control de Acceso:** Diferenciación de permisos para `ROLE_USER` y `ROLE_ADMIN`.
- **Protección:** Configuración contra ataques CSRF y SQL Injection.
- **Manejo de contraseñas:** Hashing con `BCryptPasswordEncoder`.

---

## ⚙️ Configuración y Ejecución

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
