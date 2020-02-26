package com.gestamp.proyecto.ventas.backend.venta;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Document(collection="Ventas")
public class Venta {
    //Region,Country,Item
    //Type,Sales Channel,Order Priority,Order Date,Order ID,Ship Date,Units
    //Sold,Unit Price,Unit Cost,Total Revenue,Total Cost,Total Profit.

    @NotNull
    @NotBlank
    public String Region;
    @NotNull
    @NotBlank
    public String Country;
    @NotNull
    @NotBlank
    public String ItemType;
    @NotNull
    @NotBlank
    public String SalesChannel;
    @NotNull
    @NotBlank
    public String OrderPriority;
    @NotNull
    @NotBlank
    public Date OrderDate;
    @NotNull
    @NotBlank
    public String OrderId;
    @NotNull
    @NotBlank
    public  Date ShipDate;
    @NotNull
    @NotBlank
    public Integer UnitsSold;
    @NotNull
    @NotBlank
    public Double UnitPrice;
    @NotNull
    @NotBlank
    public Double UnitCost;
    @NotNull
    @NotBlank
    public  Double TotalRevenue;
    @NotNull
    @NotBlank
    public Double TotalCost;
    @NotNull
    @NotBlank
    public Double TotalProfit;


}
