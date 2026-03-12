package com.debboun.reservas.servicios;

import com.debboun.reservas.dtos.ReservaDto;
import com.debboun.reservas.entidades.Usuario;

public interface UsuarioService {
	Usuario obtenerUsuario(String email);
	void reservar(ReservaDto reservaDto, String email);
}
