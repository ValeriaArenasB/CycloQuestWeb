package com.ejemplo.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.ejemplo.demo.modelo.Evento;

public class EventosRestController {
    List<Evento> eventos = new ArrayList<>();

    @GetMapping("/api/eventos")
    public List<Evento> todas(){
        return eventos;
    }

    @PostMapping("/api/eventos")
    public Integer grabar(@RequestBody Evento nueva){
        eventos.add(nueva);
        return eventos.size() - 1;
    }

    @GetMapping("/api/eventos/{id}")
    public Evento eventoXIndice(@PathVariable Integer id){
        return eventos.get(id);
    }

    @PutMapping("/api/eventos/{id}")
    public Integer modificarParqueaderoXIndice(@PathVariable Integer id, @RequestBody Evento nueva){
        eventos.set(id, nueva);
        return 1;
    }

    @DeleteMapping("/api/eventos/{id}")
    public Integer eliminarXIndice(@PathVariable Integer id){
        eventos.remove(eventos.get(id));
        return 0;
    }
}
