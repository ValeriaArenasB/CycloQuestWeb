package com.ejemplo.demo.modelo;

import org.springframework.stereotype.Service;
import com.ejemplo.demo.dataAccess.ParqueaderoRepository;

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
