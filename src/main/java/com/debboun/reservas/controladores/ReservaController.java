package com.debboun.reservas.controladores;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.debboun.reservas.dtos.ReservaDto;
import com.debboun.reservas.servicios.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Crear un constructor para todos los final
@Controller
public class ReservaController {
	
	private final UsuarioService usuarioService;

	@PostMapping("/reserva")
	public String reservar(@Valid @ModelAttribute("ReservaDto") ReservaDto reservaDto, Principal principal, Model modelo) {
		usuarioService.reservar(reservaDto, principal.getName());
		return "redirect:/perfil"; // redirigir para limpiar el formulario
	}
}
