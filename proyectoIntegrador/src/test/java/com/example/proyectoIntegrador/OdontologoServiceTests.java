package com.example.proyectoIntegrador;

import com.example.proyectoIntegrador.persistence.entities.Odontologo;
import com.example.proyectoIntegrador.service.OdontologoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTests {
    @Autowired
    private OdontologoService odontologoService;


    public void cargarDataSet() {
        this.odontologoService.registrarOdontologo(new Odontologo("Jose", "Ramirez", 6543276));


    }

    @Test
    public void agregarOdontologo() {
        this.cargarDataSet();
        Odontologo odontologo = odontologoService.registrarOdontologo(new Odontologo("Diego", "Paredes", 9996521));
        Assert.assertTrue(odontologo.getId() != null);

    }

    @Test
    public void traerTodos() {
        List<Odontologo> odontologos = odontologoService.obtenerTodos();
        Assert.assertTrue(!odontologos.isEmpty());
        Assert.assertTrue(odontologos.size() == 1);
        System.out.println(odontologos);
    }

    @Test
    public void eliminarOdontologoTest() {
        odontologoService.eliminar(1);
        Assert.assertTrue(odontologoService.obtenerPorId(1).isEmpty());

    }

}
