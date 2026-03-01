package com.debboun.reservas.entidades;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "reserva") // Nombre de la tabla
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Identificador
	
	@NotNull
	private LocalDate fechaInicio; // Fecha de inicio y fin de la reserva
	
	@NotNull
	private LocalDate fechaFin;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "habitacion_id", nullable = false)
	private Habitacion habitacion; // Habitacion que se reserva
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id", nullable = false)
	private Persona persona; // Persona que reserva
	
}
