package com.debboun.reservas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.debboun.reservas.dtos.EditarHotelDto;
import com.debboun.reservas.dtos.EditarUsuarioDto;
import com.debboun.reservas.dtos.RegistrarHotelDto;
import com.debboun.reservas.servicios.AdminService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Crear un constructor para todos los final
@Controller // Marcar como controller para que Spring lo detecte
@RequestMapping("/admin") // Ruta raiz
public class AdminController {

	private final AdminService adminService;

	@GetMapping({"","/"}) // Método para mostrar el panel de admin
	public String mostrar() {
		return "admin";
	}
	
	@GetMapping({"/usuarios","/usuarios/"}) // Método para mostrar la lista de usuarios en el sistema
	public String listarUsuarios(Model modelo) {
		modelo.addAttribute("usuarios", adminService.listarUsuarios());
		return "usuarios";
	}
	
	@GetMapping({"/hoteles","/hoteles/"}) // Método para mostrar la lista de hoteles en el sistema
	public String listarHoteles(Model modelo) {
		modelo.addAttribute("hoteles", adminService.listarHoteles());
		return "adminhoteles";
	}
	
	@GetMapping({"/hoteles/crear","/hoteles/crear/"}) // Método para mostrar el formulario de registro de hoteles
	public String listarFormHotel(Model modelo) {
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
	
	@GetMapping("/hoteles/editar/{id}")
	public String editarHotel(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("hotel", adminService.obtenerHotel(id));
		return "editarhotel";
	}
	
	@PostMapping("/hoteles/editar/{id}")
	public String guardarHotel(@PathVariable Long id, @ModelAttribute("hotel") EditarHotelDto hotel) {
		adminService.guardarHotel(id, hotel);
		return "redirect:/admin/hoteles";
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
