package com.debboun.reservas.servicios.implementaciones;

import org.springframework.stereotype.Service;

import com.debboun.reservas.dtos.ReservaDto;
import com.debboun.reservas.entidades.Habitacion;
import com.debboun.reservas.entidades.Reserva;
import com.debboun.reservas.entidades.Usuario;
import com.debboun.reservas.repositorios.HabitacionRepository;
import com.debboun.reservas.repositorios.ReservaRepository;
import com.debboun.reservas.repositorios.UsuarioRepository;
import com.debboun.reservas.servicios.UsuarioService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Crear un constructor para todos los final

@Service
public class UsuarioServiceImplementacion implements UsuarioService {
	
	private final ReservaRepository reservaRepository;
	private final HabitacionRepository habitacionRepository;
	private final UsuarioRepository usuarioRepository;
	
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
	
}
