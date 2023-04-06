package com.example.proyectoIntegrador.service;

import com.example.proyectoIntegrador.persistence.entities.Paciente;
import com.example.proyectoIntegrador.persistence.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente guardar(Paciente p) {
        return pacienteRepository.save(p);
    }

    public Optional<Paciente> buscar(Integer id) {
        return pacienteRepository.findById(id);
    }

    public Paciente actualizar(Paciente p) {
        return pacienteRepository.save(p);
    }

    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    public void eliminar(Integer id) {
        pacienteRepository.deleteById(id);
    }
}
