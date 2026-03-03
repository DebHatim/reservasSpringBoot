package com.debboun.reservas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.debboun.reservas.dtos.RegistroDto;
import com.debboun.reservas.servicios.implementaciones.AnonimoServiceImplementacion;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Crear un constructor para todos los final
@Controller 			 // Marcar como controller para que Spring lo detecte
public class SigninController {

	private final AnonimoServiceImplementacion anonimoService;
	
	@GetMapping("/signin") // Acceder por /signin
	public String index(Model modelo) {
		modelo.addAttribute("registroDto", new RegistroDto("","","","",""));
		return "signin";
	}
	
	@PostMapping("/signin") // Envio de datos a /signin
	public String signin(@ModelAttribute("registroDto") RegistroDto registroDto) {
		anonimoService.registrarUsuario(registroDto);
		return "redirect:/login"; // redirigir si fue todo bien
	}
}
