package com.debboun.reservas.dtos;

import java.util.List;

import com.debboun.reservas.entidades.Habitacion;
import com.debboun.reservas.entidades.Valoracion;

public record MostrarHotelDto(String nombre, String direccion, double puntuacion, 
		List<String> fotos, List<Habitacion> habitaciones, List<Valoracion> valoraciones) {

}
