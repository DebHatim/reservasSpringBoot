package com.debboun.reservas.servicios;

import java.util.List;

import com.debboun.reservas.entidades.Hotel;

public interface HotelService {
	Hotel buscarPorId(Long id);
	List<Hotel> listarHoteles();
}
