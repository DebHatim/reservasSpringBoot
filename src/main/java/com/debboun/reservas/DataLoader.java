package com.debboun.reservas;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.debboun.reservas.entidades.Habitacion;
import com.debboun.reservas.entidades.Hotel;
import com.debboun.reservas.entidades.Persona;
import com.debboun.reservas.entidades.Usuario;
import com.debboun.reservas.entidades.Valoracion;
import com.debboun.reservas.repositorios.HabitacionRepository;
import com.debboun.reservas.repositorios.HotelRepository;
import com.debboun.reservas.repositorios.PersonaRepository;
import com.debboun.reservas.repositorios.UsuarioRepository;
import com.debboun.reservas.repositorios.ValoracionRepository;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private HabitacionRepository habitacionRepository;

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ValoracionRepository valoracionRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		// Lista de imagenes para los hoteles
		List<String> fotosHotel1 = List.of(
				"https://images.unsplash.com/photo-1586611292717-f828b167408c?q=80&w=1074&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
				"https://images.unsplash.com/photo-1598928506311-c55ded91a20c?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
				"https://plus.unsplash.com/premium_photo-1664301231899-5a7b1a621238?q=80&w=1074&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

		List<String> fotosHotel2 = List.of(
				"https://images.unsplash.com/photo-1568084680786-a84f91d1153c?q=80&w=1074&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
				"https://images.unsplash.com/photo-1554995207-c18c203602cb?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
				"https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

		// Creacion de los hoteles usando builder
		Hotel hotel1 = hotelRepository
				.save(Hotel.builder().nombre("Hotel Atenea").direccion("Direccion abc 1 2").fotos(fotosHotel1).build());
		Hotel hotel2 = hotelRepository
				.save(Hotel.builder().nombre("Hotel Perseo").direccion("Direccion def 3 4").fotos(fotosHotel2).build());

		// Creacion de las habitaciones para los hoteles
		Habitacion habitacion1 = Habitacion.builder().capacidad(2).precio(new BigDecimal(12.00)).tamano(new BigDecimal(11.0)).hotel(hotel1).build();
		Habitacion habitacion2 = Habitacion.builder().capacidad(2).precio(new BigDecimal(12.00)).tamano(new BigDecimal(11.00)).hotel(hotel1).build();
		Habitacion habitacion3 = Habitacion.builder().capacidad(3).precio(new BigDecimal(18.00)).tamano(new BigDecimal(14.00)).hotel(hotel1).build();
		Habitacion habitacion4 = Habitacion.builder().capacidad(2).precio(new BigDecimal(12.00)).tamano(new BigDecimal(11.00)).hotel(hotel2).build();
		Habitacion habitacion5 = Habitacion.builder().capacidad(4).precio(new BigDecimal(24.00)).tamano(new BigDecimal(19.00)).hotel(hotel2).build();
		Habitacion habitacion6 = Habitacion.builder().capacidad(2).precio(new BigDecimal(12.00)).tamano(new BigDecimal(11.00)).hotel(hotel2).build();

		habitacionRepository.saveAll(List.of(habitacion1, habitacion2, habitacion3, habitacion4, habitacion5, habitacion6));
		
		// Creacion del usuario admin
		Usuario admin = usuarioRepository.save(Usuario.builder().email("admin@gmail.com").password(passwordEncoder.encode("admin1234")).rol("ROLE_ADMIN").build());
		personaRepository.save(Persona.builder().nombre("ADMIN").apellido("Sistema").telefono("000000000").usuario(admin).build());
	
		Usuario pedro = usuarioRepository.save(Usuario.builder().email("pedro@gmail.com")
				.password(passwordEncoder.encode("admin1234")).rol("ROLE_USER").build());
		Persona personapedro = personaRepository.save(Persona.builder().nombre("Pedro").apellido("Ejemplo").telefono("000000001").usuario(pedro).build());
		
		valoracionRepository.save(Valoracion.builder().estrellas(5).habitacion(habitacion1).autor(personapedro).build());
	}

}