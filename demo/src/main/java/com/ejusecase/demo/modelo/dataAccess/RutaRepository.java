package com.ejusecase.demo.modelo.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejusecase.demo.modelo.model.Ruta;

public interface RutaRepository extends JpaRepository<Ruta, Integer> {}