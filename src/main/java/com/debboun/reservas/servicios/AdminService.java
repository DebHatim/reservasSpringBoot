package com.debboun.reservas.servicios;

import java.util.List;

import com.debboun.reservas.dtos.EditarHotelDto;
import com.debboun.reservas.dtos.EditarUsuarioDto;
import com.debboun.reservas.dtos.RegistrarHotelDto;
import com.debboun.reservas.dtos.UsuarioListaDto;
import com.debboun.reservas.entidades.Hotel;

public interface AdminService {
	List<UsuarioListaDto> listarUsuarios();
	List<Hotel> listarHoteles();
	EditarUsuarioDto obtenerUsuario(Long id);
	EditarHotelDto obtenerHotel(Long id);
	void guardarUsuario(Long id, EditarUsuarioDto usuario);
	void guardarHotel(Long id, EditarHotelDto hotel);
	void registrarHotel(RegistrarHotelDto registrarHotelDto);
	void eliminarUsuario(Long id);
	void eliminarHotel(Long id);
}
