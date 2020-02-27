package com.gestamp.proyecto.ventas.backend.venta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Ventas")
public class Venta {
    //Region,Country,Item
    //Type,Sales Channel,Order Priority,Order Date,Order ID,Ship Date,Units
    //Sold,Unit Price,Unit Cost,Total Revenue,Total Cost,Total Profit.
    @Id
    private String id;

    @NotNull
    @NotBlank
    @Field("Region")
    public String Region;
    @NotNull
    @NotBlank
    @Field("Country")
    public String Country;
    @NotNull
    @NotBlank
    @Field("ItemType")
    public String ItemType;
    @NotNull
    @NotBlank
    @Field("SalesChannel")
    public String SalesChannel;
    @NotNull
    @NotBlank
    @Field("OrderPriority")
    public String OrderPriority;
    @NotNull
    @NotBlank
    @Field("OrderDate")
    public Date OrderDate;
    @NotNull
    @NotBlank
    @Field("OrderID")
    public Integer OrderID;
    @NotNull
    @NotBlank
    @Field("ShipDate")
    public  Date ShipDate;
    @NotNull
    @NotBlank
    @Field("UnitsSold")
    public Integer UnitsSold;
    @NotNull
    @NotBlank
    @Field("UnitPrice")
    public Double UnitPrice;
    @NotNull
    @NotBlank
    @Field("UnitCost")
    public Double UnitCost;
    @NotNull
    @NotBlank
    @Field("TotalRevenue")
    public  Double TotalRevenue;
    @NotNull
    @NotBlank
    @Field("TotalCost")
    public Double TotalCost;
    @NotNull
    @NotBlank
    @Field("TotalProfit")
    public Double TotalProfit;


}
