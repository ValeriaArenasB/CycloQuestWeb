package com.ejemplo.demo.ControllerWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ejemplo.demo.modelo.Evento;
import com.ejemplo.demo.dataAccess.EventoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evento")
public class EventoRestController {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping()
    public ResponseEntity<List<Evento>> obtenerTodos() {
        List<Evento> eventos = eventoRepository.findAll();
        return ResponseEntity.ok(eventos);
    }

    @PostMapping()
    public ResponseEntity<Evento> agregarEvento(@RequestBody Evento evento) {
        Evento nuevoEvento = eventoRepository.save(evento);
        return ResponseEntity.ok(nuevoEvento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> obtenerPorId(@PathVariable Integer id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        return evento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> actualizarEvento(@PathVariable Integer id, @RequestBody Evento evento) {
        if (!eventoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        evento.setId(id);
        Evento eventoActualizado = eventoRepository.save(evento);
        return ResponseEntity.ok(eventoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvento(@PathVariable Integer id) {
        if (!eventoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        eventoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
