package com.example.proyectoIntegrador.service;

import com.example.proyectoIntegrador.persistence.entities.Turno;
import com.example.proyectoIntegrador.persistence.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;

    public Turno registrarTurno(Turno turno){
        return turnoRepository.save(turno);
    }

    public Turno actualizar(Turno turno){
        return turnoRepository.save(turno);
    }

    public Optional<Turno> buscar(Integer id){
        return turnoRepository.findById(id);
    }

    public List<Turno> listar(){
        return turnoRepository.findAll();
    }

    public void eliminar(Integer id){
        turnoRepository.deleteById(id);
    }
}