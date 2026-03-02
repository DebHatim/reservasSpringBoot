package com.debboun.reservas.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Anotaciones de Lombok
@Data                  // Getters, setters, equals, hashCode, toString
@Builder               // Patrón Builder

@AllArgsConstructor    // Constructores con y sin argumentos
@NoArgsConstructor

// Anotaciones de JPA
@Entity                // Entidad
@Table(name = "hotel") // Nombre de la tabla
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Identificador
	
	@NotEmpty
	private String nombre; // Nombre del hotel
	
	@NotEmpty
	private String direccion; // Direccion del hotel
	
	private int puntuacion; // Puntuación en 5 estrellas del hotel
	
	@ElementCollection
	@CollectionTable(name = "hotel_imagenes", joinColumns = @JoinColumn(name = "hotel_id"))
	@Column(name = "url")
	private List<String> fotos; // Fotos del hotel
	
	@ToString.Exclude // Excludes para evitar bucles infinitos
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="hotel", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Habitacion> habitaciones; // Lista de habitaciones que tiene el hotel
	
}
