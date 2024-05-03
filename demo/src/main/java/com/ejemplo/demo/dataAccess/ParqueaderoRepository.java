package com.ejemplo.demo.dataAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.demo.modelo.Parqueadero;

@Repository
public interface ParqueaderoRepository extends JpaRepository<Parqueadero, Integer> {
    Parqueadero findByNombre(String nombre);
}