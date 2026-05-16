package com.debboun.reservas.dtos;

// DTO para mostrar datos de un hotel en especifico
public record HotelResumenDto(Long id, String nombre, String direccion, double puntuacion, String fotoPrincipal) {

}
