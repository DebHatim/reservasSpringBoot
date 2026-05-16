package com.debboun.reservas.servicios.implementaciones;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.debboun.reservas.dtos.RegistroDto;
import com.debboun.reservas.dtos.ReservaDto;
import com.debboun.reservas.entidades.Habitacion;
import com.debboun.reservas.entidades.Persona;
import com.debboun.reservas.entidades.Reserva;
import com.debboun.reservas.entidades.Usuario;
import com.debboun.reservas.repositorios.HabitacionRepository;
import com.debboun.reservas.repositorios.PersonaRepository;
import com.debboun.reservas.repositorios.ReservaRepository;
import com.debboun.reservas.repositorios.UsuarioRepository;
import com.debboun.reservas.servicios.UsuarioService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Crear un constructor para todos los final

@Service
//Implementación del servicio de usuarios
public class UsuarioServiceImplementacion implements UsuarioService {
	
	private final ReservaRepository reservaRepository;
	private final HabitacionRepository habitacionRepository;
	private final UsuarioRepository usuarioRepository;
	private final PersonaRepository personaRepository;
	private final PasswordEncoder passwordEncoder;
		
	@Override
	public void reservar(ReservaDto reservaDto, String email) {
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		
		Habitacion habitacion = habitacionRepository.findById(reservaDto.habitacionId())
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		
		reservaRepository.save(Reserva.builder().fechaInicio(reservaDto
				.fechaInicio()).fechaFin(reservaDto.fechaFin())
				.habitacion(habitacion).persona(usuario.getPersona()).build());
	}
	
	@Override
	public void eliminarReserva(Long id) {
		reservaRepository.deleteById(id);
	}

	@Override
	public Usuario obtenerUsuario(String email) {
		return usuarioRepository.findByEmail(email).get();
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
