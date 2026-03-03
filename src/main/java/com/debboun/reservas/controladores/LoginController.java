package com.debboun.reservas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller 			 // Marcar como controller para que Spring lo detecte
public class LoginController {
	
	@GetMapping("/login") // Acceder por /login
	public String index() {
		return "login";
	}

}
