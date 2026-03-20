package com.debboun.reservas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.debboun.reservas.dtos.EditarUsuarioDto;
import com.debboun.reservas.dtos.RegistrarHotelDto;
import com.debboun.reservas.servicios.AdminService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Crear un constructor para todos los final
@Controller // Marcar como controller para que Spring lo detecte
@RequestMapping("/admin") // Ruta raiz
public class AdminController {

	private final AdminService adminService;

	@GetMapping({"","/"})
	public String mostrar() {
		return "admin";
	}
	
	@GetMapping({"/usuarios","/usuarios/"})
	public String listarUsuarios(Model modelo) {
		modelo.addAttribute("usuarios", adminService.listarUsuarios());
		return "usuarios";
	}
	
	@GetMapping({"/hoteles","/hoteles/"})
	public String listarHoteles(Model modelo) {
		modelo.addAttribute("hoteles", adminService.listarHoteles());
		return "hoteles";
	}
	
	@GetMapping({"/hoteles/crear","/hoteles/crear/"})
	public String litarFormHotel(Model modelo) {
		modelo.addAttribute("hotelDto", new RegistrarHotelDto("", "", ""));
		return "registrarhotel";
	}
	
	// Métodos para insertar / guardar
	
	@PostMapping("/hoteles/crear")
	public String registrarHotel(@ModelAttribute("hotelDto") RegistrarHotelDto hotelDto) {
		adminService.registrarHotel(hotelDto);
		return "redirect:/admin/hoteles";
	}
	
	@GetMapping("/usuarios/editar/{id}")
	public String editarUsuario(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("usuario", adminService.obtenerUsuario(id));
		return "editarusuario";
	}

	@PostMapping("/usuarios/editar/{id}")
	public String guardarUsuario(@PathVariable Long id, @ModelAttribute("usuario") EditarUsuarioDto usuario) {
		adminService.guardarUsuario(id, usuario);
		return "redirect:/admin/usuarios";
	}
	
	// Métodos para eliminar
	
	@PostMapping("/usuarios/eliminar/{id}")
	public String eliminarUsuario(@PathVariable Long id) {
		adminService.eliminarUsuario(id);
		return "redirect:/admin/usuarios";
	}

	@PostMapping("/hoteles/eliminar/{id}")
	public String eliminarHotel(@PathVariable Long id) {
		adminService.eliminarHotel(id);
		return "redirect:/admin/hoteles";
	}
}
