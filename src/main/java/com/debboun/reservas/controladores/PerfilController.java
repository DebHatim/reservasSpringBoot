package com.debboun.reservas.controladores;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.debboun.reservas.servicios.UsuarioService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller // Clase para mostrar el perfil del usuario
public class PerfilController {
	
	private final UsuarioService usuarioService;
	
	@GetMapping("/perfil") // Método para mostrar todos los datos del usuario
	public String mostrar(Principal principal, Model modelo) {
		if (principal == null) {
			return "redirect:/login";
		}
		
		String email = principal.getName();
		
		modelo.addAttribute("usuario",usuarioService.obtenerUsuario(email));
		return "perfil";
	}

}
