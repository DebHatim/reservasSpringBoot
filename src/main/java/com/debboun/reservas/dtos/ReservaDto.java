package com.debboun.reservas.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

//DTO para transportar datos al reservar una habitacion
public record ReservaDto(
		@NotNull LocalDate fechaInicio,
		@NotNull LocalDate fechaFin,
		@NotNull Long habitacionId) {

}
