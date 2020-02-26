package com.gestamp.proyecto.ventas.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ReactiveUserRepository repository;


    @GetMapping()//Flux<ResponseEntity<User>>
    private Flux<ResponseEntity<User>> getAllPersons() {

        return repository.findAll()
                .map(users -> ResponseEntity.ok(users))
                .defaultIfEmpty(ResponseEntity.notFound().build());

    /*
    @GetMapping("{id}")
    public Mono<ResponseEntity<User>> getPersonById(@PathVariable(value = "id") String id) {
        return repository.findById(id)
                .map(person -> ResponseEntity.ok(person))
                .defaultIfEmpty(ResponseEntity.notFound().build());


    @PostMapping()//Mono<ResponseEntity<User>>
    private Mono<User> newUser(@RequestBody User newUser) {
        return repository.save(newUser)
    .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());}

    @PutMapping("/{id}")

     public Mono<ResponseEntity<User>> updateUserById(@PathVariable(value = "id") String id, @Valid @RequestBody User user) {
        return repository.findById(id)
                .flatMap(existingPerson -> {
                    existingPerson.setName(.getName());
                    return repository.save(existingPerson);
                })
                .map(updatedPerson -> new ResponseEntity<>(updatedPerson, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<User>> deletePerson(@PathVariable(value = "id") String id) {

        return repository.findById(id)
                .flatMap(user ->
                        repository.delete(user)
                                .then(Mono.just(new ResponseEntity<User>(user, HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    */
    }
}