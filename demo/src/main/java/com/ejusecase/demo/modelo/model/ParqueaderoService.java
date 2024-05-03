package com.ejusecase.demo.modelo.model;

import com.ejusecase.demo.modelo.dataAccess.ParqueaderoRepository;

public class ParqueaderoService {
    private final ParqueaderoRepository parqueaderoRepository;

    public ParqueaderoService(ParqueaderoRepository repository) {
        this.parqueaderoRepository = repository;
    }

    public Parqueadero buscarPorNombre(String nombre) {
        return parqueaderoRepository.findByNombre(nombre);
    }
}
