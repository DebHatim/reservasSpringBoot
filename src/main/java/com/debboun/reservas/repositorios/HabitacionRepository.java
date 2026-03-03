package com.debboun.reservas.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.debboun.reservas.entidades.Habitacion;

@RepositoryRestResource(path = "habitaciones", collectionResourceRel = "habitaciones")
public interface HabitacionRepository extends CrudRepository<Habitacion, Long> {

}
