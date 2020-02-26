package com.gestamp.proyecto.ventas.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private ReactiveVentaRepository repository;


    @GetMapping()
    private Flux<ResponseEntity<Venta>> getAllVentas() {

        return repository.findAll()

                .map(venta -> ResponseEntity.ok(venta))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    /*
    public Mono<ResponseEntity<Venta>> getVentaById(@PathVariable(value = "id") String id) {
        return repository.findById(id)
                .map(venta -> ResponseEntity.ok(venta))
                .defaultIfEmpty(ResponseEntity.notFound().build());


    @PostMapping()
    private Mono<ResponseEntity<Venta>> newVenta (Venta newVenta) {
        return repository.save(newVenta)


    .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
     public Mono<ResponseEntity<Venta>> updatePersonById(@PathVariable(value = "id") String id,
                    Venta venta) {
        return repository.findById(id)
                .flatMap(existingPerson -> {
                    existingPerson.setName(Venta.getName());
                    return repository.save(existingPerson);
                })
                .map(updatedPerson -> new ResponseEntity<>(updatedPerson, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Venta>> deletePerson(@PathVariable(value = "id") String id) {

        return repository.findById(id)
                .flatMap(user ->
                        repository.delete(user)
                                .then(Mono.just(new ResponseEntity<Venta>(user, HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    */
}
