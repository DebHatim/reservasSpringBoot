package com.debboun.reservas.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record ReservaDto(
		@NotNull LocalDate fechaInicio,
		@NotNull LocalDate fechaFin,
		@NotNull Long habitacionId) {

}
