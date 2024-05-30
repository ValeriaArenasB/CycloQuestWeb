package com.ejemplo.demo.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ejemplo.demo.modelo.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    Evento findByNombre(String nombre);
}
