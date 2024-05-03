package com.ejusecase.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplo.demo.dataAccess.*;
import com.ejemplo.demo.modelo.Parqueadero;

@SpringBootTest
public class ParqueaderoTest {

    @Autowired
    ParqueaderoRepository parqueaderos;

    @Test
    public void buscarObjetivoQueNoExiste() {

        try {

            Optional<Parqueadero> o = Optional.ofNullable(parqueaderos.findByNombre(null));
            
            assertFalse(o.isPresent(), "No debería encontrar ningun objeto");

        } catch (Exception e) { 
            fail("genero exepcion y no debería");
        }

    }

    @Test
    public void grabarObjetivo() {

        try {

            Parqueadero o = new Parqueadero();
            o.setCapacidad(null);
            o.setId(null);
            o.setNombre("ejemplo nombre");
            o.setUbicacion("ejemplo ubicacion");

            o = parqueaderos.save(o);

            Optional<Parqueadero> otro = Optional.ofNullable(parqueaderos.findByNombre(o.getNombre()));

            if(otro.isPresent()) {
                Parqueadero otroParqueadero = otro.get();

                assertEquals(o.getUbicacion(), otroParqueadero.getUbicacion(), "No son iguales");

            }

        } catch (Exception e) {
            fail("genero exepcion y no debería");
        }
        

    }



}
