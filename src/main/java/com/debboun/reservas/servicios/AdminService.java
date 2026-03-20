package com.debboun.reservas.servicios;

import java.util.List;

import com.debboun.reservas.dtos.EditarUsuarioDto;
import com.debboun.reservas.dtos.RegistrarHotelDto;
import com.debboun.reservas.dtos.UsuarioListaDto;
import com.debboun.reservas.entidades.Hotel;

public interface AdminService {
	List<UsuarioListaDto> listarUsuarios();
	List<Hotel> listarHoteles();
	EditarUsuarioDto obtenerUsuario(Long id);
	void guardarUsuario(Long id, EditarUsuarioDto usuario);
	void registrarHotel(RegistrarHotelDto registrarHotelDto);
	void eliminarUsuario(Long id);
	void eliminarHotel(Long id);
}
