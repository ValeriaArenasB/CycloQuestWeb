package com.ejemplo.demo.modelo;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ejemplo.demo.dataAccess.RutaRepository;

@Service
public class RutaService {
    private final RutaRepository rutaRepository;

    public RutaService(RutaRepository repository) {
        this.rutaRepository = repository;
    }

    public List<Ruta> listarRutas() {
        return rutaRepository.findAll();
    }
}