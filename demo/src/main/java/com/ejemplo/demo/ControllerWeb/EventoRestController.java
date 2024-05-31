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
        for(int i = 0; i < eventos.size(); i++){
            System.out.println(eventos.get(i).toString() + "\n");
        }
        return ResponseEntity.ok(eventos);
    }

    @PostMapping()
    public ResponseEntity<Evento> agregarEvento(@RequestBody Evento evento) {
        Evento nuevoEvento = eventoRepository.save(evento);
        System.out.println(evento.toString() + "\n");
        return ResponseEntity.ok(nuevoEvento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> obtenerPorId(@PathVariable Integer id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        System.out.println(evento.toString() + "\n");
        return evento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> actualizarEvento(@PathVariable Integer id, @RequestBody Evento evento) {
        if (!eventoRepository.existsById(id)) {
            System.out.println("Evento a modificar no encontrado\n");
            return ResponseEntity.notFound().build();
        }
        evento.setId(id);
        Evento eventoActualizado = eventoRepository.save(evento);
        System.out.println("Evento actualizado\n");
        return ResponseEntity.ok(eventoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvento(@PathVariable Integer id) {
        if (!eventoRepository.existsById(id)) {
            System.out.println("Evento a eliminar no encontrado\n");
            return ResponseEntity.notFound().build();
        }
        eventoRepository.deleteById(id);
        System.out.println("Evento eliminado\n");
        return ResponseEntity.noContent().build();
    }
}
