package com.gestamp.proyecto.ventas.backend.venta;

import org.springframework.beans.factory.annotation.Autowired;
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
    private Flux<Venta> getAllVentas() {

        return repository.findAll();

               // .map(venta -> ResponseEntity.ok())
               // .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping({"/{id}"})
    public Mono<ResponseEntity<Venta>> getVentaById(@PathVariable(value = "id") String id) {
        return repository.findById(id)
                .map(venta -> ResponseEntity.ok(venta))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping()
    private Mono<ResponseEntity<Venta>> newVenta (Venta newVenta) {
        return repository.save(newVenta)


    .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
     public Mono<ResponseEntity<Venta>> updateVentaById(@PathVariable(value = "id") String id,
                    Venta venta) {
        return repository.findById(id)
                .flatMap(existingVenta -> {
                    venta.order_id=existingVenta.order_id;
                    existingVenta.region=venta.region;
                    existingVenta.country=venta.country;
                    existingVenta.item_type=venta.item_type;
                    existingVenta.order_date=venta.order_date;
                    existingVenta.order_priority=venta.order_priority;
                    existingVenta.sales_channel=venta.sales_channel;
                    existingVenta.ship_date=venta.ship_date;
                    existingVenta.total_cost=venta.total_cost;
                    existingVenta.total_profit=venta.total_profit;
                    existingVenta.total_revenue=venta.total_revenue;
                    existingVenta.unit_cost=venta.unit_cost;
                    existingVenta.unit_price=venta.unit_price;
                    existingVenta.units_sold=venta.units_sold;

                    return repository.save(existingVenta);
                })
                .map(updatedVenta -> new ResponseEntity<>(updatedVenta, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Venta>> deleteVenta(@PathVariable(value = "id") String id) {

        return repository.findById(id)
                .flatMap(venta ->
                        repository.delete(venta)
                                .then(Mono.just(new ResponseEntity<Venta>(venta, HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
