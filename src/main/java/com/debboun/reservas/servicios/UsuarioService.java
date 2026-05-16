package com.debboun.reservas.servicios;

import com.debboun.reservas.dtos.RegistroDto;
import com.debboun.reservas.dtos.ReservaDto;
import com.debboun.reservas.entidades.Usuario;

// Servicio listando todo lo que puede hacer un usuario del sistema
public interface UsuarioService {
	void registrarUsuario(RegistroDto registroDto);
	Usuario obtenerUsuario(String email);
	void reservar(ReservaDto reservaDto, String email);
	void eliminarReserva(Long id);
}
