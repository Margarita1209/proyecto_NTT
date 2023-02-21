package com.proyecto.ntt.RegistroPaciente.repositories;

import com.proyecto.ntt.RegistroPaciente.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
