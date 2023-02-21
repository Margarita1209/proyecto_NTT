package com.proyecto.ntt.RegistroPaciente.services.Impl;

import com.proyecto.ntt.RegistroPaciente.dtos.PacienteCrear;
import com.proyecto.ntt.RegistroPaciente.entities.Paciente;
import com.proyecto.ntt.RegistroPaciente.validate.Common;
import com.proyecto.ntt.RegistroPaciente.repositories.PacienteRepository;
import com.proyecto.ntt.RegistroPaciente.services.PacienteService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteServiceImpl implements PacienteService {
    private final PacienteRepository repository;

    public PacienteServiceImpl(PacienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<?> crearPaciente(PacienteCrear data) {
        try {

            String error = "";

            if (data.getEmail().isEmpty()) {
                error = error + " - El email no puede ir vacío. "+"\n";
            } else if (!data.getEmail().contains("@") || !data.getEmail().contains(".")) {
                error = error + " - El email no es valido.";
            }

            if (data.getTelefono().isEmpty()) {
                error = error + " - El telefono no puede ir vacío."
                        ;
            }

            Common com = new Common();
            boolean validaRut = com.validaRut(data.getRut());
            if (validaRut == false) {
                error = error + " - El rut no es valido."+"\n";
            }

            JSONObject item = new JSONObject();

            if (error != "") {
                item.put("estado", "info");
                item.put("mensaje", error);

                return ResponseEntity.status(HttpStatus.OK).body(item.toString());
            }

            Paciente paciente = new Paciente();
            paciente.setNombre(data.getNombre());
            paciente.setRut(data.getRut());
            paciente.setDireccion(data.getDireccion());
            paciente.setTelefono(data.getTelefono());
            paciente.setEmail(data.getEmail());

            Paciente pacienteRegistrado = repository.save(paciente);

            if (pacienteRegistrado.getId() > 0) {

                item.put("estado", "ok");
                item.put("mensaje", "Paciente registrado correctamente.");

                return ResponseEntity.status(HttpStatus.OK).body(item.toString());

            } else if (pacienteRegistrado.getRut() == paciente.getRut()) {
                item.put("estado", "info");
                item.put("mensaje", "No se pudo registrar el paciente ya se encuentra registrado.");

            } else {
                item.put("estado", "info");
                item.put("mensaje", "No se pudo registrar el paciente, intente mas tarde.");

                return ResponseEntity.status(HttpStatus.OK).body(item.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("upss error");
        }
        return ResponseEntity.status(HttpStatus.OK).body(data);

    }
    @Override
    public ResponseEntity<?> consultaTodo() {
        try {
            List<Paciente> paciente = repository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(paciente);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("upss error al consultar los datos");
        }

    }

    @Override
    public ResponseEntity<?> borrar(Long id) throws JSONException {
        try {
            repository.deleteById(id);
            JSONObject item = new JSONObject();
            item.put("estado", "ok");
            item.put("mensaje","Eliminado correctamente");

            return ResponseEntity.status(HttpStatus.OK).body(item.toString());

        }
        catch (Exception e) {

            JSONObject item = new JSONObject();
            item.put("estado", "error");
            item.put("mensaje","Error al eliminar al paciente.");

            return ResponseEntity.status(HttpStatus.OK).body(item.toString());
        }

    }

}
