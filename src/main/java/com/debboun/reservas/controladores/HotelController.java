package com.debboun.reservas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.debboun.reservas.dtos.MostrarHotelDto;
import com.debboun.reservas.servicios.HotelService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller // Clase para controlar las acciones en la vista de hoteles
public class HotelController {

	private final HotelService hotelService;

	@GetMapping("/hotel/{id}")
	public String verHotel(@PathVariable Long id, Model modelo) {
		MostrarHotelDto hotel;
		try {
			hotel = hotelService.buscarPorId(id);
		} catch (RuntimeException e) {
			return "redirect:/";
		}
		modelo.addAttribute("hotel", hotel);
		return "hotel";
	}
}

