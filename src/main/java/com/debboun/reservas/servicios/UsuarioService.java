package com.debboun.reservas.servicios;

import com.debboun.reservas.dtos.ReservaDto;

public interface UsuarioService {
	void reservar(ReservaDto reservaDto, String email);
}
