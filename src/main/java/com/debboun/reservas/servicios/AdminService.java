package com.debboun.reservas.servicios;

import java.util.List;

import com.debboun.reservas.dtos.EditarUsuarioDto;
import com.debboun.reservas.dtos.UsuarioListaDto;

public interface AdminService {
	List<UsuarioListaDto> listarUsuarios();
	EditarUsuarioDto obtenerUsuario(Long id);
	void guardarUsuario(Long id, EditarUsuarioDto usuario);
	void eliminarUsuario(Long id);
}
