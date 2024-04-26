package com.ejusecase.demo;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.ManyToOne;

@Entity
public class Ubicacion {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    Date hora;

    Double longitud;

    Double latitud;

    @ManyToOne
    Trayecto trayecto;
    
}
