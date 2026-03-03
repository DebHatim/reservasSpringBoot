package com.debboun.reservas.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.debboun.reservas.entidades.Hotel;

@RepositoryRestResource(path = "hoteles", collectionResourceRel = "hoteles")
public interface HotelRepository extends CrudRepository<Hotel, Long> {

}
