package com.debboun.reservas.servicios;

import com.debboun.reservas.dtos.RegistroDto;
import com.debboun.reservas.entidades.Hotel;

public interface AnonimoService {
	Iterable<Hotel> consultarHoteles(); // Usuario anonimo ve los hoteles
	void registrarUsuario(RegistroDto registroDto); // Usuario anonimo se registra
}
