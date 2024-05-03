package com.ejusecase.demo.modelo.model;

import java.util.List;

import com.ejusecase.demo.modelo.dataAccess.RutaRepository;


public class RutaService {
    private final RutaRepository rutaRepository;

    public RutaService(RutaRepository repository) {
        this.rutaRepository = repository;
    }

    public List<Ruta> listarRutas() {
        return rutaRepository.findAll();
    }
}