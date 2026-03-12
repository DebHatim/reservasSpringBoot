package com.debboun.reservas.servicios.implementaciones;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.debboun.reservas.dtos.EditarUsuarioDto;
import com.debboun.reservas.dtos.UsuarioListaDto;
import com.debboun.reservas.repositorios.UsuarioRepository;
import com.debboun.reservas.servicios.AdminService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Crear un constructor para todos los final

@Service // Para que spring detecte este servicio
public class AdminServiceImplementacion implements AdminService {

	private final UsuarioRepository usuarioRepository;
	
	@Override
	public List<UsuarioListaDto> listarUsuarios() {
		return StreamSupport.stream(usuarioRepository.findAll().spliterator(), false)
				.map(u -> new UsuarioListaDto
						(u.getId(), u.getPersona().getNombre(), u.getEmail(), u.getRol().toString())).toList();
	}

	@Override
	public EditarUsuarioDto obtenerUsuario(Long id) {
		var u = usuarioRepository.findById(id).get();
		return new EditarUsuarioDto(id, u.getPersona().getNombre(), u.getPersona().getApellido(), u.getPersona().getTelefono(), u.getEmail());
	}

	@Override
	public void guardarUsuario(Long id, EditarUsuarioDto usuario) {
		var u = usuarioRepository.findById(id).get();
		u.getPersona().setNombre(usuario.nombre());
		u.getPersona().setApellido(usuario.apellido());
		u.getPersona().setTelefono(usuario.telefono());
		u.setEmail(usuario.email());
		
		usuarioRepository.save(u);
	}

	@Override
	@Transactional
	public void eliminarUsuario(Long id) {
		try {
	        usuarioRepository.deleteById(id);
	    } catch (Exception e) {
	        System.out.println("ERROR AL ELIMINAR: Probablemente el usuario tiene reservas vinculadas.");
	        e.printStackTrace();
	    }
	}

}
