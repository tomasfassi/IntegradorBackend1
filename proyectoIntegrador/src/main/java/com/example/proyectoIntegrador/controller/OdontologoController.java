package com.example.proyectoIntegrador.controller;

import com.example.proyectoIntegrador.persistence.entities.Odontologo;
import com.example.proyectoIntegrador.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;

    @GetMapping("/all")
    public ResponseEntity<List<Odontologo>> obtenerTodos() { return ResponseEntity.ok(odontologoService.obtenerTodos()); }

    @PostMapping("/crear")
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(odontologoService.registrarOdontologo(odontologo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> obtenerPorId(@PathVariable Integer id) {
        Odontologo odontologo = odontologoService.obtenerPorId(id).orElse(null);

        return ResponseEntity.ok(odontologo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (odontologoService.obtenerPorId(id).isPresent()) {
            odontologoService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @PutMapping()
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) {
        ResponseEntity<Odontologo> response = null;

        if (odontologo.getId() != null && odontologoService.obtenerPorId(odontologo.getId()).isPresent())
            response = ResponseEntity.ok(odontologoService.actualizar(odontologo));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
}