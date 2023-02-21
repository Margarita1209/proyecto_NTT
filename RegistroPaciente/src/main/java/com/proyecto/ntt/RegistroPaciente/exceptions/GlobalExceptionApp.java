package com.proyecto.ntt.RegistroPaciente.exceptions;

public class GlobalExceptionApp extends Exception{
    private final int responseCode;

    public GlobalExceptionApp(int responseCode, String mensaje) {

        super(mensaje);
        this.responseCode = responseCode;
    }
}
