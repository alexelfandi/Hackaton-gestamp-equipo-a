package com.gestamp.proyecto.ventas.backend.venta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/page")
@CrossOrigin(origins = "http://localhost:4200/", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})

public class FindAllControllerPageable {
 @Autowired
 private FindAllControllerPageableRepository repository;
    @GetMapping()
    private Mono<Page<Venta>> getAllVentas(@RequestParam(name="page", defaultValue="0")Integer page,
                                           @RequestParam(name="size", defaultValue = "20") Integer size) {
        return Mono.just(this.repository.findAll(PageRequest.of(page,size))) ;

        // .map(venta -> ResponseEntity.ok())
        // .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
