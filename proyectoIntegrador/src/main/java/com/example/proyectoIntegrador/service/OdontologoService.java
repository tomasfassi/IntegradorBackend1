package com.example.proyectoIntegrador.service;

import com.example.proyectoIntegrador.persistence.entities.Odontologo;
import com.example.proyectoIntegrador.persistence.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    private final OdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    public Odontologo actualizar(Odontologo odontologo) { return odontologoRepository.save(odontologo); }

    public void eliminar(Integer id){ odontologoRepository.deleteById(id); }

    public Optional<Odontologo> obtenerPorId(Integer id){ return odontologoRepository.findById(id); }

    public List<Odontologo> obtenerTodos(){ return odontologoRepository.findAll(); }
}
