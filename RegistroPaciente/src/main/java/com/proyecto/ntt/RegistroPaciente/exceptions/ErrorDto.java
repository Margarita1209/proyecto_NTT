package com.proyecto.ntt.RegistroPaciente.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorDto {
    private String name;
    private String value;
}
