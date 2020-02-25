package com.gestamp.proyecto.ventas.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Usuarios")
public class User {
    public String id;
    @NotNull
    @NotBlank
    public String nombre;
    @NotBlank
    @NotNull
    public String apellido;
}
