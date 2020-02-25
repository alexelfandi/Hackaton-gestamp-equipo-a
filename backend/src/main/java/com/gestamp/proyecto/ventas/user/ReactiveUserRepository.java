package com.gestamp.proyecto.ventas.user;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveUserRepository extends ReactiveMongoRepository <User, String> {


}
