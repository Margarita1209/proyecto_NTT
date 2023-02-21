package com.proyecto.ntt.RegistroPaciente.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="pacientes")//como se llama nuestra base de datos
@Data
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nombre;
    String rut;
    String direccion;
    String email;
    String telefono;
}
