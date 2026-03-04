package com.debboun.reservas.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Mensajes en cada dato para mostrar si hay errores, confirmPassword para comprobar que las contraseñas coincidan 
public record RegistroDto (
		@NotBlank @Size(min=3, message = "El nombre debe contener al menos 3 caracteres") String nombre,
		@NotBlank @Size(min=3, message = "El apellido debe contener al menos 3 caracteres") String apellido, 
		@NotBlank @Size(min=9, message = "El teléfono debe contener al menos 9 dígitos") String telefono,
		@Email(message = "Formato de email inválido") String email, 
		@Size(min = 8, message = "La contraseña debe contener al menos 8 caracteres") String password,
		@Size(min = 8, message = "La contraseña debe contener al menos 8 caracteres") String confirmPassword ) {

}
