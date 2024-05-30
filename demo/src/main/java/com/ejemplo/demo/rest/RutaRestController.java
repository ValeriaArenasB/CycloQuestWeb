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
import com.ejemplo.demo.modelo.Ruta;

@RestController
public class RutaRestController {

    List<Ruta> rutas = new ArrayList<Ruta>();

    @GetMapping("/api/ejemplo")
    public List<Ruta> todas(){
        return rutas;
    }

    @PostMapping("/api/ejemplo")
    public Integer grabar(@RequestBody Ruta nueva){
        rutas.add(nueva);
        return rutas.size() - 1;
    }

    @GetMapping("/api/ejemplo/{id}")
    public Ruta rutaXIndice(@PathVariable Integer id){
        return rutas.get(id);
    }

    @PutMapping("/api/ejemplo/{id}")
    public Integer modificarRutaXIndice(@PathVariable Integer id, @RequestBody Ruta nueva){
        rutas.set(id, nueva);
        return 1;
    }
    @DeleteMapping("/api/ejemplo/{id}")
    public Integer eliminarToo(@PathVariable Integer id){
        rutas.remove(rutas.get(id));
        return 0;
    }
}
