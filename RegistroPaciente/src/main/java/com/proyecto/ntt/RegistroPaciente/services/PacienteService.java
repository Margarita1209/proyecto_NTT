package com.proyecto.ntt.RegistroPaciente.services;

import com.proyecto.ntt.RegistroPaciente.dtos.PacienteCrear;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;

public interface PacienteService {

    public ResponseEntity<?> crearPaciente(PacienteCrear data);

    public ResponseEntity<?> consultaTodo();

    public ResponseEntity<?> borrar(Long id) throws JSONException;

}
