package com.debboun.reservas.entidades;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
	@Size(min=3)
	private String nombre; // Nombre obligatorio
	
	@NotBlank
	@Size(min=3)
	private String apellido; // Apellido obligatorio
	
	@NotBlank
	@Size(min=9)
	private String telefono; // Telefono obligatorio para contacto
	
	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@ToString.Exclude // Excludes para evitar bucles infinitos
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="persona", cascade = CascadeType.ALL)
	private List<Reserva> reservas; // Lista de reservas que tiene esta persona
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="autor", cascade = CascadeType.ALL)
	private List<Valoracion> valoraciones; // Lista de valoraciones que ha hecho esta persona
}
