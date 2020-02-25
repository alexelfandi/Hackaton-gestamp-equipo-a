package com.gestamp.proyecto.ventas.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="ventas")
public class Venta {
    //Region,Country,Item
    //Type,Sales Channel,Order Priority,Order Date,Order ID,Ship Date,Units
    //Sold,Unit Price,Unit Cost,Total Revenue,Total Cost,Total Profit.

    @NotNull
    @NotBlank
    public String region;


}
