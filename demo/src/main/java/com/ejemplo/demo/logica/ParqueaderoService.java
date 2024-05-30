package com.ejemplo.demo.logica;

import java.util.List;

import org.springframework.stereotype.Service;
import com.ejemplo.demo.dataAccess.ParqueaderoRepository;
import com.ejemplo.demo.modelo.Parqueadero;

@Service
public class ParqueaderoService {
    private final ParqueaderoRepository parqueaderoRepository;

    public ParqueaderoService(ParqueaderoRepository repository) {
        this.parqueaderoRepository = repository;
    }

    public List<Parqueadero> buscarPorNombre(String nombre) {
        return parqueaderoRepository.findByNombreContaining(nombre);
    }
}
