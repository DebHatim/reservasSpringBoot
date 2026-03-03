package com.debboun.reservas.servicios;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.debboun.reservas.config.UsuarioPrincipal;
import com.debboun.reservas.entidades.Usuario;
import com.debboun.reservas.repositorios.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

	private final UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Buscar el usuario por email usando el repositorio
		Usuario aux = usuarioRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado") );
		// Envio el usuario a la clase principal para verificar
		return new UsuarioPrincipal(aux);
	}
	
	
}
