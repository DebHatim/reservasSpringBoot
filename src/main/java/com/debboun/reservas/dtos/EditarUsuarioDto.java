package com.debboun.reservas.dtos;

// DTO para transportar datos al editar datos de usuario
public record EditarUsuarioDto(Long id, String nombre, String apellido, String telefono, String email) {

}
