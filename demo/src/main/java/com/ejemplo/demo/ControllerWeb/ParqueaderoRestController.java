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
        System.out.println("Parqueadero: " + parqueadero.toString() + " agregado\n");
        return parqueaderoRepository.save(parqueadero);
    }

    @GetMapping
    public List<Parqueadero> getAllParqueaderos() {
        List<Parqueadero> parqueaderos = parqueaderoRepository.findAll();
        for(int i = 0; i < parqueaderos.size() ; i++){
            System.out.println(parqueaderos.toString() +"\n");
        }
        return parqueaderos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parqueadero> getParqueaderoById(@PathVariable Integer id) {
        Optional<Parqueadero> parqueadero = parqueaderoRepository.findById(id);
        System.out.println(parqueadero.toString() + "\n");
        return parqueadero.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Parqueadero>> buscarParqueaderos(@RequestParam String nombre) {
        List<Parqueadero> parqueaderos = parqueaderoRepository.findByNombreContaining(nombre);
        for(int i = 0; i < parqueaderos.size(); i++){
            System.out.println(parqueaderos.get(i) + "\n");
        }
        return ResponseEntity.ok(parqueaderos);
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
            System.out.println("Parqueadero actualizado\n");
            return ResponseEntity.ok(updatedParqueadero);
        } else {
            System.out.println("Parqueadero a actualizar no encontrado\n");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParqueadero(@PathVariable Integer id) {
        Optional<Parqueadero> parqueadero = parqueaderoRepository.findById(id);
        if (parqueadero.isPresent()) {
            parqueaderoRepository.delete(parqueadero.get());
            System.out.println("Parqueadero a eliminado\n");
            return ResponseEntity.noContent().build();
        } else {
            System.out.println("Parqueadero a eliminar no encontrado\n");
            return ResponseEntity.notFound().build();
        }
    }
}
