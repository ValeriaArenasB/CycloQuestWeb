package com.ejemplo.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ejemplo.demo.modelo.Parqueadero;

@RestController
public class ParqueaderoRestController {
    List<Parqueadero> parqueaderos = new ArrayList<Parqueadero>();

    @GetMapping("/api/parqueaderos")
    public List<Parqueadero> todas(){
        return parqueaderos;
    }

    @PostMapping("/api/parqueaderos")
    public Integer grabar(@RequestBody Parqueadero nueva){
        parqueaderos.add(nueva);
        return parqueaderos.size() - 1;
    }

    @GetMapping("/api/parqueaderos/{id}")
    public Parqueadero parqueaderoXIndice(@PathVariable Integer id){
        return parqueaderos.get(id);
    }

    @PutMapping("/api/parqueaderos/{id}")
    public Integer modificarParqueaderoXIndice(@PathVariable Integer id, @RequestBody Parqueadero nueva){
        parqueaderos.set(id, nueva);
        return 1;
    }

    @DeleteMapping("/api/parqueaderos/{id}")
    public Integer eliminarXIndice(@PathVariable Integer id){
        parqueaderos.remove(parqueaderos.get(id));
        return 0;
    }
}