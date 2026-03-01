package com.debboun.reservas.entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "valoracion") // Nombre de la tabla
public class Valoracion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Identificador
	
	@NotNull
	@Min(value = 1)
	@Max(value = 5)
	private int estrellas; // Estrellas como puntuación del hotel
	
	private String comentario; // Comentario sobre esta habitación
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "habitacion_id", nullable = false)
	private Habitacion habitacion; // Habitacion referente a la valoracion
}
