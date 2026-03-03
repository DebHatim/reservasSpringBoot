package com.debboun.reservas.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Anotaciones de Lombok
@Data                    // Getters, setters, equals, hashCode, toString
@Builder                 // Patrón Builder

@AllArgsConstructor      // Constructores con y sin argumentos
@NoArgsConstructor

//Anotaciones de JPA
@Entity                  // Entidad
@Table(name = "usuario") // Nombre de la tabla
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Identificador

	@NotNull
	@Column(unique = true)
	private String email; // correo único por usuario
	
	@NotNull
	@Size(min=8)
	private String password; // contraseña con un mínimo de 8 caracteres

	@NotNull
	private String rol; // ROLE_USER o ROLE_ADMIN

	@OneToOne(mappedBy = "usuario")
	private Persona persona;
}
