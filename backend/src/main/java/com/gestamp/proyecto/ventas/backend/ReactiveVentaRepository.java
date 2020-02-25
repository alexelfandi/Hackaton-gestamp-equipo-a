package com.gestamp.proyecto.ventas.backend;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveVentaRepository extends ReactiveMongoRepository<Venta, String> {

}

