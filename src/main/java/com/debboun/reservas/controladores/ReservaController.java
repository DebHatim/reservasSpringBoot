package com.debboun.reservas.controladores;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.debboun.reservas.dtos.ReservaDto;
import com.debboun.reservas.servicios.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Crear un constructor para todos los final
@Controller
@RequestMapping("/reserva")
public class ReservaController {
	
	private final UsuarioService usuarioService;

	@PostMapping
	public String reservar(@Valid @ModelAttribute("ReservaDto") ReservaDto reservaDto, Principal principal, Model modelo) {
		usuarioService.reservar(reservaDto, principal.getName());
		return "redirect:/perfil"; // redirigir para limpiar el formulario
	}
	
	@PostMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		usuarioService.eliminarReserva(id);
		return "redirect:/perfil"; // actualizar
	}
}
