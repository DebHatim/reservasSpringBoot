package com.debboun.reservas.servicios;

import java.util.List;

import com.debboun.reservas.dtos.HotelResumenDto;
import com.debboun.reservas.dtos.MostrarHotelDto;

public interface HotelService {
	MostrarHotelDto buscarPorId(Long id);
	List<HotelResumenDto> listarHoteles();
}
