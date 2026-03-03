package com.debboun.reservas.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.debboun.reservas.entidades.Persona;

@RepositoryRestResource(path = "personas", collectionResourceRel = "personas")
public interface PersonaRepository extends CrudRepository<Persona, Long> {

}
