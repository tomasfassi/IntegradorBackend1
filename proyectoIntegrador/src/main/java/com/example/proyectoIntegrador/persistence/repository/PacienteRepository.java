package com.example.proyectoIntegrador.persistence.repository;

import com.example.proyectoIntegrador.persistence.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
