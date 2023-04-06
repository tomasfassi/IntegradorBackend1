package com.example.proyectoIntegrador.persistence.repository;

import com.example.proyectoIntegrador.persistence.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
