package com.ejusecase.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplo.demo.dataAccess.EventoRepository;
import com.ejemplo.demo.modelo.Evento;

@SpringBootTest
class EventoServiceTests {

    @Autowired
    private EventoRepository eventoRepository;

    @Test
    @Transactional
    void testRegistrarYBuscarEvento() {
        try {
            // Crear un nuevo evento
            Evento nuevoEvento = new Evento();
            nuevoEvento.setNombre("Evento Ciclismo");
            nuevoEvento.setDescripcion("Un evento para entusiastas del ciclismo");
            nuevoEvento.setUbicacion("Parque Central");
            nuevoEvento.setFecha(new Date());  // Utiliza la fecha actual para el test

            // Guardar el evento en la base de datos
            nuevoEvento = eventoRepository.save(nuevoEvento);
            assertNotNull(nuevoEvento.getId(), "El evento no se guardó correctamente");

            // Buscar el evento guardado
            Evento encontrado = eventoRepository.findById(nuevoEvento.getId()).orElse(null);
            assertNotNull(encontrado, "No se encontró el evento");
            assertEquals("Evento Ciclismo", encontrado.getNombre(), "El nombre del evento no coincide");
            assertEquals("Un evento para entusiastas del ciclismo", encontrado.getDescripcion(), "La descripción del evento no coincide");

        } catch (Exception e) {
            fail("No debería lanzar una excepción", e);
        }
    }
}
