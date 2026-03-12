package com.debboun.reservas.controladores;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.debboun.reservas.servicios.implementaciones.UsuarioServiceImplementacion;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class PerfilController {
	
	private final UsuarioServiceImplementacion usuarioService;
	
	@GetMapping("/perfil")
	public String mostrar(Principal principal, Model modelo) {
		if (principal == null) {
			return "redirect:/login";
		}
		
		String email = principal.getName();
		
		modelo.addAttribute("usuario",usuarioService.obtenerUsuario(email));
		return "perfil";
	}

}
