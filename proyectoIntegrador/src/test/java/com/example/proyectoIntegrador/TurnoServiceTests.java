package com.example.proyectoIntegrador;

import com.example.proyectoIntegrador.persistence.entities.Domicilio;
import com.example.proyectoIntegrador.persistence.entities.Odontologo;
import com.example.proyectoIntegrador.persistence.entities.Paciente;
import com.example.proyectoIntegrador.persistence.entities.Turno;
import com.example.proyectoIntegrador.service.OdontologoService;
import com.example.proyectoIntegrador.service.PacienteService;
import com.example.proyectoIntegrador.service.TurnoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnoServiceTests {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;

    public void cargarDataSet() {
        Domicilio domicilio = new Domicilio("Av Emlio Caraffa", "1807", "Cordoba", "Cordoba");
        Paciente p = pacienteService.guardar(new Paciente("Rodrigo", "Bueno", "7463524", new Date(), domicilio));
        this.odontologoService.registrarOdontologo(new Odontologo("Jose", "Ramirez", 6543276));
    }
    @Test
    public void altaTurnoTest(){
        this.cargarDataSet();
        turnoService.registrarTurno(new Turno(pacienteService.buscar(1).get(),odontologoService.obtenerPorId(1).get(),new Date()));
        Assert.assertNotNull(turnoService.buscar(1));
    }

    @Test
    public void eliminarTurnoTest(){
        turnoService.eliminar(1);
        Assert.assertFalse(turnoService.buscar(1).isPresent());
    }

    @Test
    public void buscarTurnoTest(){
        Assert.assertNotNull(turnoService.buscar(1));
    }
}
