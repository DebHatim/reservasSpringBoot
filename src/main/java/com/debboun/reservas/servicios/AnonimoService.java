package com.debboun.reservas.servicios;

import java.util.Optional;

import com.debboun.reservas.entidades.Hotel;
import com.debboun.reservas.entidades.Persona;

public interface AnonimoService {
	Iterable<Hotel> consultarHoteles();
	Optional<Persona> autenticar(Persona persona);
}
