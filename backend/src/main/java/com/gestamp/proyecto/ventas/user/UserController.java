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
    private Flux<User> all() {
        return repository.findAll();
    }
    //private Flux<ResponseEntity<Person>> getAllPersons() {
    /*
        return personRepository.findAll()
                .map(ResponseEntity::ok)
                //.map(persons -> ResponseEntity.ok(persons))
                .defaultIfEmpty(ResponseEntity.notFound().build());
     */

    @GetMapping("{id}")//Mono<ResponseEntity<User>>
    private Mono<User> getById(@PathVariable String id) {
        return repository.findById(id);
    }
   /*
    public Mono<ResponseEntity<Person>> getPersonById(@PathVariable(value = "id") String id) {
        return personRepository.findById(id)
                .map(person -> ResponseEntity.ok(person))
                .defaultIfEmpty(ResponseEntity.notFound().build());
         */

    @PostMapping()//Mono<ResponseEntity<User>>
    private Mono<User> newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }
    /*
    .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());*/

    @PutMapping("/{id}")//Mono<ResponseEntity<User>>
    public Mono<User> modificarUser(@Valid @RequestBody User usuario, @PathVariable String id) {

        return repository.findById(id)
                .flatMap(user1 -> {
                    user1.nombre = usuario.nombre;
                    user1.apellido = usuario.apellido;
                    //Pasas tambien el Id y no es seguro
                    //user1=usuario;
                    return repository.save(usuario);
                });//Si no existe lo crea

    }
    /* public Mono<ResponseEntity<Person>> updatePersonById(@PathVariable(value = "id") String id,
                                                   @Valid @RequestBody Person person) {
        return personRepository.findById(id)
                .flatMap(existingPerson -> {
                    existingPerson.setName(person.getName());
                    return personRepository.save(existingPerson);
                })
                .map(updatedPerson -> new ResponseEntity<>(updatedPerson, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }*/
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<User>> deletePerson(@PathVariable(value = "id") String id) {

        return repository.findById(id)
                .flatMap(user ->
                        repository.delete(user)
                                .then(Mono.just(new ResponseEntity<User>(user, HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}