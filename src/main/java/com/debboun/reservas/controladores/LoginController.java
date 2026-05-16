package com.debboun.reservas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 			 // Marcar como controller para que Spring lo detecte
// Clase para controlar el inicio de sesión
public class LoginController {
	
	@GetMapping("/login") // Acceder por /login
	public String index() {
		return "login";
	}

}
