package com.ejemplo.demo.ControllerWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ejemplo.demo.dataAccess.ParqueaderoRepository;
import com.ejemplo.demo.modelo.Parqueadero;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parqueadero")
public class ParqueaderoRestController {

    @Autowired
    private ParqueaderoRepository parqueaderoRepository;

    @PostMapping
    public Parqueadero addParqueadero(@RequestBody Parqueadero parqueadero) {
        return parqueaderoRepository.save(parqueadero);
    }

    @GetMapping
    public List<Parqueadero> getAllParqueaderos() {
        return parqueaderoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parqueadero> getParqueaderoById(@PathVariable Integer id) {
        Optional<Parqueadero> parqueadero = parqueaderoRepository.findById(id);
        return parqueadero.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parqueadero> updateParqueadero(@PathVariable Integer id, @RequestBody Parqueadero parqueaderoDetails) {
        Optional<Parqueadero> parqueadero = parqueaderoRepository.findById(id);
        if (parqueadero.isPresent()) {
            Parqueadero existingParqueadero = parqueadero.get();
            existingParqueadero.setNombre(parqueaderoDetails.getNombre());
            existingParqueadero.setUbicacion(parqueaderoDetails.getUbicacion());
            existingParqueadero.setCapacidad(parqueaderoDetails.getCapacidad());
            Parqueadero updatedParqueadero = parqueaderoRepository.save(existingParqueadero);
            return ResponseEntity.ok(updatedParqueadero);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParqueadero(@PathVariable Integer id) {
        Optional<Parqueadero> parqueadero = parqueaderoRepository.findById(id);
        if (parqueadero.isPresent()) {
            parqueaderoRepository.delete(parqueadero.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
