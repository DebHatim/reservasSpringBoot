package com.debboun.reservas.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegistroDto(@NotBlank String nombre, @NotBlank String apellido, @NotBlank String telefono,
		@Email @NotBlank String email, @Size(min = 8) String password) {

}
