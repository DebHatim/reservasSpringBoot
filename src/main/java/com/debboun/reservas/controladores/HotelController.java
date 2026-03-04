package com.debboun.reservas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.debboun.reservas.entidades.Hotel;
import com.debboun.reservas.servicios.HotelService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class HotelController {
	
	private final HotelService hotelService;

	@GetMapping("/hotel/{id}")
	public String verHotel(@PathVariable Long id, Model modelo) {
		Hotel hotel = hotelService.buscarPorId(id);
		if (hotel == null) {
			return "redirect:/";
		}
		modelo.addAttribute("hotel", hotel);
		return "hotel";
	}
}
