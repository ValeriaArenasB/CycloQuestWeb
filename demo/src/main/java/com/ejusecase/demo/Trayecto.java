package com.ejusecase.demo;
import java.util.List;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Trayecto {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    Date horaInicio;

    Date horaFin;

    Long distancia;

    Long duracion;

    Boolean enProceso;

    @OneToMany(mappedBy = "trayecto")
    List<Ubicacion> ubicaciones;
    

    
}
