package com.debboun.reservas.servicios.implementaciones;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.debboun.reservas.dtos.RegistroDto;
import com.debboun.reservas.entidades.Hotel;
import com.debboun.reservas.entidades.Persona;
import com.debboun.reservas.entidades.Usuario;
import com.debboun.reservas.repositorios.HotelRepository;
import com.debboun.reservas.repositorios.PersonaRepository;
import com.debboun.reservas.repositorios.UsuarioRepository;
import com.debboun.reservas.servicios.AnonimoService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Crear un constructor para todos los final

@Service
public class AnonimoServiceImplementacion implements AnonimoService {

	private final HotelRepository hotelRepository;
	private final PersonaRepository personaRepository;
	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public Iterable<Hotel> consultarHoteles() {
		return hotelRepository.findAll();
	}
	
	@Override
	@Transactional // Para asegurar que funciona todo
	public void registrarUsuario(RegistroDto registroDto) {
		String contraseñaEncriptada = passwordEncoder.encode(registroDto.password());
		
		Usuario aux = usuarioRepository.save(Usuario.builder().email(registroDto.email())
				.password(contraseñaEncriptada).rol("ROLE_USER").build());
		
		personaRepository.save(Persona.builder().nombre(registroDto.nombre())
				.apellido(registroDto.apellido()).telefono(registroDto.telefono())
				.usuario(aux).build());
	}

}
