package com.proyecto.ntt.RegistroPaciente.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PacienteCrear {
    String nombre;
    String rut;
    String direccion;
    String email;
    String telefono;
}
