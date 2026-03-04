package com.debboun.reservas.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.debboun.reservas.entidades.Valoracion;

@RepositoryRestResource(path = "valoraciones", collectionResourceRel = "valoraciones")
public interface ValoracionRepository extends CrudRepository<Valoracion, Long> {

}
