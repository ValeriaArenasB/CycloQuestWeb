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
        for(int i = 0; i < rutas.size(); i++){
            System.out.println(rutas.get(i).toString()+"\n");
        }
        return ResponseEntity.ok(rutas);
    }

    @PostMapping()
    public ResponseEntity<Ruta> agregarRuta(@RequestBody Ruta nuevaRuta) {
        Ruta rutaGuardada = rutaRepository.save(nuevaRuta);
        System.out.println(nuevaRuta.toString() + " Añadido\n");
        return ResponseEntity.ok(rutaGuardada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ruta> obtenerPorId(@PathVariable Integer id) {
        Optional<Ruta> ruta = rutaRepository.findById(id);
        System.out.println(ruta.toString() + "\n");
        return ruta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Ruta>> buscarRutas(@RequestParam String nombre) {
        List<Ruta> rutas = rutaRepository.findByNombreContaining(nombre);
        for(int i = 0; i < rutas.size(); i++){
            System.out.println(rutas.get(i).toString()+"\n");
        }
        return ResponseEntity.ok(rutas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ruta> actualizarRuta(@PathVariable Integer id, @RequestBody Ruta nuevaRuta) {
        if (!rutaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        nuevaRuta.setId(id);
        Ruta rutaActualizada = rutaRepository.save(nuevaRuta);
        System.out.println(rutaActualizada.toString() + "\n");
        return ResponseEntity.ok(rutaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRuta(@PathVariable Integer id) {
        if (!rutaRepository.existsById(id)) {
            System.out.println("Ruta a eliminar no encontrada\n");
            return ResponseEntity.notFound().build();
        }
        rutaRepository.deleteById(id);
        System.out.println("Ruta eliminada\n");
        return ResponseEntity.noContent().build();
    }
}
