package com.debboun.reservas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.debboun.reservas.servicios.implementaciones.AnonimoServiceImplementacion;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Crear un constructor para todos los final
@Controller 			 // Marcar como controller para que Spring lo detecte
@RequestMapping("/")	 // Ruta raiz
public class IndexController {
	
	private final AnonimoServiceImplementacion anonimoService;
	
	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("hoteles", anonimoService.consultarHoteles());
		return "index";
	}

}
