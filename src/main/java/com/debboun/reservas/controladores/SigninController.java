package com.debboun.reservas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.debboun.reservas.dtos.RegistroDto;
import com.debboun.reservas.servicios.AnonimoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Crear un constructor para todos los final
@Controller // Marcar como controller para que Spring lo detecte
public class SigninController {

	private final AnonimoService anonimoService;

	@GetMapping("/signin") // Acceder por /signin
	public String index(Model modelo) {
		modelo.addAttribute("registroDto", new RegistroDto("", "", "", "", "", ""));
		return "signin";
	}

	@PostMapping("/signin") // Envio de datos a /signin
	public String signin(@Valid @ModelAttribute("registroDto") RegistroDto registroDto, BindingResult result, Model modelo) {
		
		if (!registroDto.password().equals(registroDto.confirmPassword())) {
			result.rejectValue("confirmPassword", "error.confirmPassword", "Las contraseñas no coinciden");
		}
		
		if (result.hasErrors()) {
			return "signin";
		}
		
		try {
			anonimoService.registrarUsuario(registroDto);
			modelo.addAttribute("registroDto", new RegistroDto("", "", "", "", "", ""));
			modelo.addAttribute("msg", "Usuario registrado correctamente.");
			return "signin"; // volver a mostrar la vista si todo fue bien
		} catch (Exception e) {
			// Si este correo ya está registrado se captura del error
			if (e.getMessage().contains("Duplicate entry")) {
				modelo.addAttribute("error", "Este correo ya está registrado");
			}
			return "signin"; // volver a mostrar la vista si hubo un error
		}
	}
}
