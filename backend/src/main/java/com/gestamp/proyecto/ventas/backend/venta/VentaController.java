package com.gestamp.proyecto.ventas.backend.venta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "http://localhost:4200/", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class VentaController {
    @Autowired
    private ReactiveVentaRepository repository;

    @GetMapping("first")
    private Flux<Venta> getfirst() {
        System.out.println(this.repository.findAll());
        return this.repository.findAll().limitRequest(20);

        // .map(venta -> ResponseEntity.ok())
        // .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping({"/{id}"})
    public Mono<ResponseEntity<Venta>> getVentaById(@PathVariable(value = "id") String id) {
        return this.repository.findById(id)
                .map(venta -> ResponseEntity.ok(venta))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping()
    private Mono<ResponseEntity<Venta>> newVenta(@RequestBody Venta newVenta) {
        System.out.println(newVenta);
        return this.repository.save(newVenta)
    .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
     public Mono<ResponseEntity<Venta>> updateVentaById(@PathVariable(value = "id") String id,
                 @RequestBody Venta venta) {
        System.out.println(venta);
        System.out.println(id);
        return this.repository.findById(id)
                .flatMap(existingVenta -> {

                    venta.OrderID=existingVenta.OrderID;
                    existingVenta.Region=venta.Region;
                    existingVenta.Country=venta.Country;
                    existingVenta.ItemType=venta.ItemType;
                    existingVenta.OrderDate=venta.OrderDate;
                    existingVenta.OrderPriority=venta.OrderPriority;
                    existingVenta.SalesChannel=venta.SalesChannel;
                    existingVenta.ShipDate=venta.ShipDate;
                    existingVenta.TotalCost=venta.TotalCost;
                    existingVenta.TotalProfit=venta.TotalProfit;
                    existingVenta.TotalRevenue=venta.TotalRevenue;
                    existingVenta.UnitCost=venta.UnitCost;
                    existingVenta.UnitPrice=venta.UnitPrice;
                    existingVenta.UnitsSold=venta.UnitsSold;

                    return this.repository.save(existingVenta);
                })
                .map(updatedVenta -> new ResponseEntity<>(updatedVenta, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Venta>> deleteVenta(@PathVariable("id") String id) {

        return this.repository.findById(id)
                .flatMap(venta ->
                        this.repository.delete(venta)
                                .then(Mono.just(new ResponseEntity<Venta>(venta, HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
