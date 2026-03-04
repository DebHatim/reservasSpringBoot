package com.debboun.reservas.controladores;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.debboun.reservas.entidades.Usuario;
import com.debboun.reservas.repositorios.UsuarioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class PerfilController {
	
	private final UsuarioRepository usuarioRepository;
	
	@GetMapping("/perfil")
	public String mostrar(Principal principal, Model modelo) {
		if (principal == null) {
			return "redirect:/login";
		}
		String email = principal.getName();
		Usuario usuario = usuarioRepository.findByEmail(email).get();
		
		modelo.addAttribute("usuario",usuario);
		return "perfil";
	}

}
