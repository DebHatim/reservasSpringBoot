package com.debboun.reservas.servicios.implementaciones;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.debboun.reservas.entidades.Hotel;
import com.debboun.reservas.entidades.Persona;
import com.debboun.reservas.repositorios.HotelRepository;
import com.debboun.reservas.servicios.AnonimoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Crear un constructor para todos los final

@Service
public class AnonimoServiceImplementacion implements AnonimoService {

	private final HotelRepository hotelRepository;
	
	@Override
	public Iterable<Hotel> consultarHoteles() {
		return hotelRepository.findAll();
	}

	@Override
	public Optional<Persona> autenticar(Persona persona) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
