package com.debboun.reservas.entidades;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Anotaciones de Lombok
@Data                    // Getters, setters, equals, hashCode, toString
@Builder                 // Patrón Builder

@AllArgsConstructor      // Constructores con y sin argumentos
@NoArgsConstructor

//Anotaciones de JPA
@Entity                  // Entidad
@Table(name = "persona") // Nombre de la tabla
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Identificador
	
	@NotBlank
	private String nombre; // Nombre obligatorio
	
	private String apellido; // Apellido no obligatorio
	
	@NotBlank
	private String telefono; // Telefono obligatorio para contacto
	
	@ToString.Exclude // Excludes para evitar bucles infinitos
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="persona", cascade = CascadeType.ALL)
	private List<Reserva> reservas; // Lista de reservas que tiene esta persona
}
