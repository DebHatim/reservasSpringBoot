# Sistema de Gestión de Reservas Hoteleras

[![Java](https://img.shields.io/badge/Java-21-blue)](https://openjdk.org/projects/jdk/21/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-brightgreen)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring%20Security-6.x-brightgreen)](https://spring.io/projects/spring-security)
[![MySQL](https://img.shields.io/badge/MySQL-8-orange)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-lightgrey)](LICENSE)

API REST y aplicación web backend para la gestión integral de hoteles y reservas. Desarrollada con **Java 21**, **Spring Boot 4.0.3** y **Spring Security**, implementa autenticación basada en roles, prevención de reservas duplicadas y una arquitectura limpia orientada a la mantenibilidad y escalabilidad.

> Desarrollado por **Hatim Debboun** como proyecto de portafolio técnico

---

## Índice

- [Arquitectura](#arquitectura)
- [Funcionalidades](#funcionalidades)
- [Stack tecnológico](#stack-tecnológico)
- [Decisiones de diseño](#decisiones-de-diseño)
- [Capturas de pantalla](#capturas-de-pantalla)
- [Instalación y ejecución](#instalación-y-ejecución)
- [Seguridad](#seguridad)

---

## Arquitectura

El proyecto sigue una arquitectura MVC en capas con separación clara de responsabilidades:

```
┌─────────────────────────────────────────┐
│           Capa de Presentación           │
│     Thymeleaf (vistas) + REST API        │
├─────────────────────────────────────────┤
│           Capa de Controladores          │
│    @Controller  /  @RestController       │
├─────────────────────────────────────────┤
│           Capa de Servicios              │
│   Lógica de negocio + validación         │
│   (prevención double-booking)            │
├─────────────────────────────────────────┤
│           Capa de Persistencia           │
│      JPA/Hibernate + Spring Data         │
├─────────────────────────────────────────┤
│              Base de Datos               │
│               MySQL 8                    │
└─────────────────────────────────────────┘
         │ Spring Security filtra
         │ todas las capas
```

**Modelo de datos principal:**
- `Usuario` — autenticación y perfil (`ROLE_USER` / `ROLE_ADMIN`)
- `Hotel` — entidad principal con disponibilidad
- `Reserva` — relación `@ManyToOne` con Usuario y Hotel, con validación de solapamiento de fechas

---

## Funcionalidades

**Usuario registrado:**
- Registro y autenticación con contraseña cifrada (BCrypt)
- Búsqueda y visualización de hoteles disponibles
- Creación, consulta y cancelación de reservas propias
- Gestión de perfil personal

**Administrador:**
- Panel de administración con CRUD completo de hoteles
- Gestión de usuarios y roles
- Visualización de todas las reservas del sistema

**Sistema:**
- Algoritmo de prevención de double-booking — validación de solapamiento de fechas en la capa de servicio
- Protección CSRF activa en todos los formularios
- Bean Validation en todos los formularios de entrada
- DTOs para desacoplar la capa de persistencia de la vista

---

## Stack tecnológico

| Capa | Tecnología |
|------|-----------|
| Lenguaje | Java 21 (LTS) |
| Framework | Spring Boot 4.0.3 |
| Seguridad | Spring Security 6 + BCrypt |
| Persistencia | Spring Data JPA + Hibernate |
| API REST | Spring Data REST |
| Vistas | Thymeleaf + thymeleaf-extras-springsecurity6 |
| Validación | Spring Validation (Bean Validation) |
| Base de datos | MySQL 8 |
| Build | Maven + Lombok |

---

## Decisiones de diseño

**¿Por qué DTOs?**  
Se usan para separar el modelo de persistencia (`@Entity`) de lo que se expone en vistas y endpoints REST. Esto evita exponer campos sensibles (como `password`) y facilita evolucionar el modelo de datos sin romper las interfaces.

**¿Por qué la validación de double-booking está en la capa de servicio y no en la BD?**  
Centralizar la lógica en el servicio permite reutilizarla desde el controlador MVC y desde los endpoints REST sin duplicar código. La validación consulta reservas solapadas con una query JPQL antes de persistir.

**¿Por qué Spring Data REST además de los controladores MVC?**  
Permite exponer los repositorios directamente como endpoints REST HAL para consumo programático, mientras los controladores `@Controller` sirven las vistas Thymeleaf. Dos interfaces para dos tipos de cliente.

---

## Capturas de pantalla

| Pantalla | Vista |
|----------|-------|
| Índice | ![Índice](screenshots/index.png) |
| Vista de hoteles | ![Hoteles](screenshots/hotelview.png) |
| Login | ![Login](screenshots/login.png) |
| Registro | ![Registro](screenshots/register.png) |
| Perfil de usuario | ![Perfil](screenshots/profile.png) |
| Panel admin resumen | ![Admin](screenshots/admin.png) |
| Panel admin usuarios | ![Admin usuarios](screenshots/admin2.png) |
| Panel admin hoteles | ![Admin hoteles](screenshots/admin3.png) |

---

## Instalación y ejecución

**Requisitos:** Java 21, Maven 3.x, MySQL 8

### 1. Crear base de datos

```sql
CREATE DATABASE reservas;
CREATE USER 'usr_reservas'@'localhost' IDENTIFIED BY 'passwordreservas';
GRANT ALL PRIVILEGES ON reservas.* TO 'usr_reservas'@'localhost';
FLUSH PRIVILEGES;
```

### 2. Clonar y ejecutar

```bash
git clone https://github.com/DebHatim/reservasSpringBoot.git
cd reservasSpringBoot

# Windows
mvnw spring-boot:run

# Linux / macOS
chmod +x mvnw && ./mvnw spring-boot:run
```

La aplicación arranca en `http://localhost:8080`

---

## Seguridad

Configuración de Spring Security con separación de zonas pública y privada:

```java
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/signin/**", "/login**", "/hotel/**",
                                 "/perfil/**", "/css/**", "/js/**", "/favicon.ico").permitAll()
                .anyRequest().authenticated())
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true)
                .permitAll())
            .logout(logout -> logout.logoutSuccessUrl("/").permitAll());
        return http.build();
    }
}
```

- Zona pública: index, hoteles, login, registro, assets estáticos
- Zona privada: reservas, perfil, panel de administración
- Contraseñas cifradas con BCryptPasswordEncoder
- Protección CSRF activa por defecto
