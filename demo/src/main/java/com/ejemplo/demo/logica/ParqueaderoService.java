package com.ejemplo.demo.logica;

import org.springframework.stereotype.Service;
import com.ejemplo.demo.dataAccess.ParqueaderoRepository;
import com.ejemplo.demo.modelo.Parqueadero;

@Service
public class ParqueaderoService {
    private final ParqueaderoRepository parqueaderoRepository;

    public ParqueaderoService(ParqueaderoRepository repository) {
        this.parqueaderoRepository = repository;
    }

    public Parqueadero buscarPorNombre(String nombre) {
        return parqueaderoRepository.findByNombre(nombre);
    }
}
