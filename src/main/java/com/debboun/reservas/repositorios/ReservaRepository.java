package com.debboun.reservas.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.debboun.reservas.entidades.Reserva;

@RepositoryRestResource(path = "reservas", collectionResourceRel = "reservas")
public interface ReservaRepository extends CrudRepository<Reserva, Long>{

}
