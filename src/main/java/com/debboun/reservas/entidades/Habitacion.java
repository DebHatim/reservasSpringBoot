package com.debboun.reservas.entidades;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Anotaciones de Lombok
@Data                  // Getters, setters, equals, hashCode, toString
@Builder               // Patrón Builder

@AllArgsConstructor    // Constructores con y sin argumentos
@NoArgsConstructor

//Anotaciones de JPA
@Entity                // Entidad
@Table(name = "habitacion") // Nombre de la tabla
public class Habitacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Identificador
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel_id", nullable = false)
	private Hotel hotel; // Hotel propietario de esta habitacion
	
	@NotNull
	private int capacidad; // Capacidad en personas
	
	@NotNull
	@Column(precision = 6, scale = 2) // Permitir solo 6 digitos y 2 decimales
	private BigDecimal tamano; // Tamaño en metros cuadrados
	
	@ElementCollection
	@CollectionTable(name = "habitacion_imagenes", joinColumns = @JoinColumn(name = "habitacion_id"))
	@Column(name = "url")
	private List<String> fotos; // Fotos de la habitación
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reserva> reserva; // Reserva de la habitacion
	
}
