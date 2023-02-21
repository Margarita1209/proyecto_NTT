package com.proyecto.ntt.RegistroPaciente.exceptions.personalizadas;

import com.proyecto.ntt.RegistroPaciente.exceptions.GlobalExceptionApp;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class NoRegistraPacienteException extends GlobalExceptionApp {
    public NoRegistraPacienteException(String mensaje) {
        super(HttpStatus.BAD_REQUEST.value(), mensaje);
    }
}
