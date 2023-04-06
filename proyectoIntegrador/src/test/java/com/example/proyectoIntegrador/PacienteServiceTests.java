package com.example.proyectoIntegrador;

import com.example.proyectoIntegrador.persistence.entities.Domicilio;
import com.example.proyectoIntegrador.persistence.entities.Paciente;
import com.example.proyectoIntegrador.service.DomicilioService;
import com.example.proyectoIntegrador.service.PacienteService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTests {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private DomicilioService domicilioService;

    public void cargarDataSet() {
        Domicilio domicilio = new Domicilio("Av Emlio Caraffa", "1807", "Cordoba", "Cordoba");
        Paciente p = pacienteService.guardar(new Paciente("Rodrigo", "Bueno", "7463524", new Date(), domicilio));
        Domicilio domicilio1 = new Domicilio("Gral. Manuel N. Savio", "410", "CABA", "Buenos Aires");
        Paciente p1 = pacienteService.guardar(new Paciente("Martin", "Palermo", "3333334", new Date(), domicilio1));

    }

    @Test
    public void agregarYBuscarPacienteTest() {
        this.cargarDataSet();
        Domicilio domicilio = new Domicilio("Alcorta", "885", "Escobar", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Lucas", "Fernandez", "7658795", new Date(), domicilio));

        Assert.assertNotNull(pacienteService.buscar(p.getId()));
    }

    @Test
    public void traerTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() == 2);
        System.out.println(pacientes);
    }

    @Test
    public void eliminarPacienteTest() {
        pacienteService.eliminar(3);
        Assert.assertTrue(pacienteService.buscar(3).isEmpty());

    }

}