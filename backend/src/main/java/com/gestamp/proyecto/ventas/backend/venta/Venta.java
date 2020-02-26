package com.gestamp.proyecto.ventas.backend.venta;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Document(collection="ventas")
public class Venta {
    //Region,Country,Item
    //Type,Sales Channel,Order Priority,Order Date,Order ID,Ship Date,Units
    //Sold,Unit Price,Unit Cost,Total Revenue,Total Cost,Total Profit.

    @NotNull
    @NotBlank
    public String region;
    @NotNull
    @NotBlank
    public String country;
    @NotNull
    @NotBlank
    public String item_type;
    @NotNull
    @NotBlank
    public String sales_channel;
    @NotNull
    @NotBlank
    public String order_priority;
    @NotNull
    @NotBlank
    public Date order_date;
    @NotNull
    @NotBlank
    public String order_id;
    @NotNull
    @NotBlank
    public  Date ship_date;
    @NotNull
    @NotBlank
    public Integer units_sold;
    @NotNull
    @NotBlank
    public Double unit_price;
    @NotNull
    @NotBlank
    public Double unit_cost;
    @NotNull
    @NotBlank
    public  Double total_revenue;
    @NotNull
    @NotBlank
    public Double total_cost;
    @NotNull
    @NotBlank
    public Double total_profit;


}
