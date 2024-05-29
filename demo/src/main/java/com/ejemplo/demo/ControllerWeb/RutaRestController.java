package com.ejemplo.demo.ControllerWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ejemplo.demo.modelo.Ruta;
import com.ejemplo.demo.dataAccess.RutaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ruta")
public class RutaRestController {

    @Autowired
    private RutaRepository rutaRepository;

    @GetMapping()
    public ResponseEntity<List<Ruta>> obtenerTodas() {
        List<Ruta> rutas = rutaRepository.findAll();
        return ResponseEntity.ok(rutas);
    }

    @PostMapping()
    public ResponseEntity<Ruta> agregarRuta(@RequestBody Ruta nuevaRuta) {
        Ruta rutaGuardada = rutaRepository.save(nuevaRuta);
        return ResponseEntity.ok(rutaGuardada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ruta> obtenerPorId(@PathVariable Integer id) {
        Optional<Ruta> ruta = rutaRepository.findById(id);
        return ruta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ruta> actualizarRuta(@PathVariable Integer id, @RequestBody Ruta nuevaRuta) {
        if (!rutaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        nuevaRuta.setId(id);
        Ruta rutaActualizada = rutaRepository.save(nuevaRuta);
        return ResponseEntity.ok(rutaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRuta(@PathVariable Integer id) {
        if (!rutaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        rutaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
