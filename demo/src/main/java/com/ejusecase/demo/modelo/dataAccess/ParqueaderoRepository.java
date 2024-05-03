package com.ejusecase.demo.modelo.dataAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ejusecase.demo.modelo.model.Parqueadero;

public interface ParqueaderoRepository extends JpaRepository<Parqueadero, Integer> {
    Parqueadero findByNombre(String nombre);
}