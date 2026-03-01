package com.debboun.reservas.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Anotaciones de Lombok
@Data                  // Getters, setters, equals, hashCode, toString
@Builder               // Patrón Builder

@AllArgsConstructor    // Constructores con y sin argumentos
@NoArgsConstructor

//Anotaciones de JPA
@Entity                // Entidad
@Table(name = "fotohabitacion") // Nombre de la tabla
public class FotoHabitacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Identificador
	
	@NotBlank
	private String url;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "habitacion_id", nullable = false)
	private Habitacion habitacion; // Habitacion referente a esta foto
}
