package com.ejusecase.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplo.demo.dataAccess.RutaRepository;
import com.ejemplo.demo.modelo.Ruta;
import com.ejemplo.demo.logica.RutaService;


@SpringBootTest
class RutaServiceTests {

    @Autowired
    private RutaService rutaService;

    @Autowired
    private RutaRepository rutaRepository;

    @Test
    @Transactional
    void testAgregarYListarRutas() {
        try {
            // Crear y guardar una ruta
            Ruta ruta = new Ruta();
            ruta.setNombre("Ruta de Test");
            ruta.setDescripcion("Descripción de Test");

            ruta = rutaRepository.save(ruta);
            assertNotNull(ruta.getId(), "La ruta no se guardó correctamente");

            // Listar todas las rutas
            List<Ruta> rutas = rutaService.listarRutas();
            assertFalse(rutas.isEmpty(), "La lista de rutas está vacía");
            assertTrue(rutas.stream().anyMatch(r -> "Ruta de Test".equals(r.getNombre())),
                       "La ruta de test no se encuentra en la lista");

        } catch (Exception e) {
            fail("No debería lanzar una excepción", e);
        }
    }
}
