package com.gestamp.proyecto.ventas.backend.venta;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FindAllControllerPageableRepository extends PagingAndSortingRepository<Venta,String> {


}
