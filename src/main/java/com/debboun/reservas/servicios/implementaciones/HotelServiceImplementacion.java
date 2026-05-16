package com.debboun.reservas.servicios.implementaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.debboun.reservas.dtos.HotelResumenDto;
import com.debboun.reservas.dtos.MostrarHotelDto;
import com.debboun.reservas.entidades.Hotel;
import com.debboun.reservas.repositorios.HotelRepository;
import com.debboun.reservas.servicios.HotelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Crear un constructor para todos los final

@Service
// Implementación del servicio de usuarios anonimos
public class HotelServiceImplementacion implements HotelService {
	
	private final HotelRepository hotelRepository;
	
	@Override
	public MostrarHotelDto buscarPorId(Long id) {
		Hotel aux = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel no encontrado"));
		return new MostrarHotelDto(
				aux.getNombre(), 
				aux.getDireccion(), 
				aux.getMediaPuntuacion(), 
				aux.getFotos(), 
				aux.getHabitaciones(), 
				aux.getValoraciones());
	}

	@Override
	public List<HotelResumenDto> listarHoteles() {
		List<Hotel> hoteles = (List<Hotel>) hotelRepository.findAll();
		List<HotelResumenDto> dtos = new ArrayList<>();
		
		for (Hotel h : hoteles) {
			HotelResumenDto dto = new HotelResumenDto(h.getId(), h.getNombre(), h.getDireccion(), h.getMediaPuntuacion(), h.getFotos().get(0));
			dtos.add(dto);
		}
		
		return dtos;
	}
	
}
