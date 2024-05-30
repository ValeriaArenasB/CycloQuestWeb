package com.ejemplo.demo.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ejemplo.demo.modelo.Parqueadero;
import java.util.List;

public interface ParqueaderoRepository extends JpaRepository<Parqueadero, Integer> {
    List<Parqueadero> findByNombreContaining(String nombre);
}
