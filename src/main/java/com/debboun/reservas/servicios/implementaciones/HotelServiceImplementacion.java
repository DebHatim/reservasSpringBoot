package com.debboun.reservas.servicios.implementaciones;

import java.util.List;

import org.springframework.stereotype.Service;

import com.debboun.reservas.entidades.Hotel;
import com.debboun.reservas.repositorios.HotelRepository;
import com.debboun.reservas.servicios.HotelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Crear un constructor para todos los final

@Service
public class HotelServiceImplementacion implements HotelService {
	
	private final HotelRepository hotelRepository;
	
	@Override
	public Hotel buscarPorId(Long id) {
		return hotelRepository.findById(id).orElse(null);
	}

	@Override
	public List<Hotel> listarHoteles() {
		return (List<Hotel>) hotelRepository.findAll();
	}
	
}
