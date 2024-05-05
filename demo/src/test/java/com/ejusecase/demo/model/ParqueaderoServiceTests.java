package com.ejusecase.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplo.demo.dataAccess.ParqueaderoRepository;
import com.ejemplo.demo.modelo.Parqueadero;

@SpringBootTest
class ParqueaderoServiceTests {

    @Autowired
    private ParqueaderoRepository parqueaderoRepository;

    @Test
    @Transactional
    void testGuardarYBuscarParqueadero() {
        try {
            // Crear un nuevo parqueadero
            Parqueadero nuevo = new Parqueadero();
            nuevo.setNombre("Parqueadero Test");
            nuevo.setCapacidad(100);
            nuevo.setUbicacion("Test Location");


            // Buscar el parqueadero guardado
            Optional<Parqueadero> encontrado = parqueaderoRepository.findById(nuevo.getId());
            assertTrue(encontrado.isPresent(), "No se encontró el parqueadero");
            assertEquals("Parqueadero Test", encontrado.get().getNombre());

        } catch (Exception e) {
            fail("No debería lanzar una excepción", e);
        }
    }
}
